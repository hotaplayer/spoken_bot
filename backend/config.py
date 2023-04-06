

settings = {
    "openai_api_key": "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",
    "redis":{
        "ip":"localhost",
        "port": 6379,
        "db":0
    },
    "kafka":{
        "brokers":["localhost:9092"],
    }
}

class Config(dict):
    def __init__(self, d):
        super().__init__(d)

config = Config(settings)
