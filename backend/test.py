import base64

with open('ui.wav', 'rb') as f:
    file_content = f.read()
    encoded_content = base64.b64encode(file_content).decode('utf-8')
    print(encoded_content)

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