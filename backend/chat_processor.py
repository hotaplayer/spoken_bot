# 从mq接收训练请求，并进行处理，所得结果存入本地

import kafka_service
import whisper
import numpy
import redis_service
import openai
from config import config

openai.api_key = config.get("openai_api_key")

if __name__ == '__main__':
    while True:
        # 读取任务
        msg = kafka_service.read_prompt_msg()
        fid = msg.key()
        prompt = msg.value()
        # 访问openai，获取结果
        # 选择model进行训练
        result = openai.Completion.create(model="gpt-3.5-turbo", prompt=prompt, temperature=0, max_tokens=7)
        # 插入到数据库中
        redis_service.updatePromptResponse(fid, result)