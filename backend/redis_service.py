from config import config
import redis
import binascii
import id_service
redis_config = config.get('redis')

r = redis.Redis(host=redis_config.get('host'), port=redis_config.get('port'), db=redis_config.get('db'))


def save(audio_blob)->str:
    fid = id_service.next_id()
    audio_data = {
        "blob": binascii.hexlify(audio_blob).decode(),
        "prompt" : "",
        "resp_text": ""
    }
    r.hmset(fid, audio_data)
    r.expire(fid, 3600) # one hour
    print(f'{fid} saved')
    return fid

def get(fid)->dict:
    if r.exists(fid):
        audio_data = r.hgetall(fid)
        return audio_data
    else:
        return None

def updatePrompt(fid, prompt):
    r.hset(fid, "prompt", prompt)

def updatePromptResponse(fid, response):
    r.hset(fid, "resp_text", response)