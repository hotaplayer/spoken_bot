# 从mq接收训练请求，并进行处理，所得结果存入本地

import kafka_service
import whisper
import numpy
import redis_service

model = whisper.load_model("medium")

if __name__ == '__main__':
    while True:
        # 读取任务
        fid = kafka_service.read_new_audio_fid()
        # 从redis里提取音频原文
        audio = redis_service.get(fid)
        audio_blob = audio['blob']
        # 选择model进行训练

        result = model.transcribe(numpy.frombuffer(audio_blob, dtype=numpy.uint8))
        req_text = result["text"]
        # 插入到数据库中
        redis_service.updateReqText(fid, req_text)