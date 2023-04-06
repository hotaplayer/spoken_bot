import confluent_kafka
from config import config
AUDIO_PUB_TOPIC = "audio_topic"
PROMPT_PUB_TOPIC = "prompt_topic"

kafka_config = config.get('kafka')
__producer = confluent_kafka.Producer(bootstrap_servers=kafka_config.get('brokers'))
__audio_consumer = confluent_kafka.Consumer(
    {'bootstrap.servers':','.join(kafka_config.get('brokers')) ,
     'group.id': 'audio_group',
     'auto.offset.reset': 'earliest'})
__audio_consumer.subscribe([AUDIO_PUB_TOPIC])

__prompt_consumer = confluent_kafka.Consumer(
    {'bootstrap.servers':','.join(kafka_config.get('brokers')) ,
     'group.id': 'chatreq_group',
     'auto.offset.reset': 'earliest'})
__prompt_consumer.subscribe([PROMPT_PUB_TOPIC])

def pub_new_audio(fid):
    __producer.produce(AUDIO_PUB_TOPIC, key=fid, value=fid, callback=_delivery_report);
    __producer.flush()

def pub_prompt(fid, prompt):
    __producer.produce(PROMPT_PUB_TOPIC, key=fid, value=prompt, callback=_delivery_report);
    __producer.flush()

def _delivery_report(err, msg):
    if err is not None:
        print('Message delivery failed: {}'.format(err))
    else:
        print('Message delivered to {} [{}]'.format(msg.topic(), msg.partition()))


def read_new_audio_fid_msg():
    while True:
        msg = __audio_consumer.poll(float('inf'))
        if msg is None:
            continue
        if msg.error():
            print('Error while receiving message: {}'.format(msg.error()))
            return None
        else:
            print('Received message: key={}, value={}'.format(msg.key(), msg.value()))
            return msg

def read_prompt_msg():
    while True:
        msg = __prompt_consumer.poll(float('inf'))
        if msg is None:
            continue
        if msg.error():
            print('Error while receiving message: {}'.format(msg.error()))
            return None
        else:
            print('Received message: key={}, value={}'.format(msg.key(), msg.value()))
            return msg

