# 从mq接收训练请求，并进行处理，所得结果存入本地

import kafka_service
import whisper
import numpy
import redis_service
import binascii
model = whisper.load_model("medium")

if __name__ == '__main__':
    while True:
        # 读取任务
        msg = kafka_service.read_new_audio_fid_msg()
        fid = msg.value()
        # 从redis里提取音频原文
        audio = redis_service.get(fid)
        audio_blob = binascii.unhexlify(audio['blob'])
        # 选择model进行训练
        result = model.transcribe(numpy.frombuffer(audio_blob, dtype=numpy.uint8))
        prompt = result["text"]
        # 插入到数据库中
        redis_service.prompt(fid, prompt)
        # 通知chat_processor去生成文本
        kafka_service.pub_prompt(fid, prompt)