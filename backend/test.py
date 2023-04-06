from snowflake import SnowflakeGenerator

gen = SnowflakeGenerator(0)
print(next(gen))
#
# openai.api_key = config.get("openai_api_key")
#
# def test():
#     with open("tmp/ui.wav", "rb") as f:
#         transcript = openai.Audio.transcribe("whisper-1", f)
#         print(transcript)
#
#
# if __name__ == "__main__":
#     test()