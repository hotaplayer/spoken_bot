import os.path

from flask import Flask, request, jsonify
from flask_cors import CORS
import time
import redis_service as r

app = Flask(__name__)
CORS(app)




# 音频文件保存到redis
@app.route('/api/audio', methods=['POST'])
def handle_audio():
        # Process the audio data here
    audio_data = request.files['audio'].read()
    fid = r.save(audio_data)
    # save to redis


    # notify whisper trainer

    response = {
        "code":0,
        "msg":None,
        "data":fid
    }
    return jsonify(response)

# 取得gpt文本响应结果
@app.route('/api/text', methods=['POST'])
def read_response():
    fid = request.json['fid']
    result = r.get(fid)
    if not result:
        response = {
            "code": 1,
            "msg": 'fid不存在',
            "data": None
        }
    else:
        response = {
            "code":0,
            "msg":'',
            "data":result["text"]
        }
    return jsonify(response)


if __name__ == '__main__':
    app.run(port=8080)