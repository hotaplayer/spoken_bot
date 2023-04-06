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
        "req_text" : "",
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

def updateReqText(fid, req_text):
    r.hset(fid, "req_text", req_text)