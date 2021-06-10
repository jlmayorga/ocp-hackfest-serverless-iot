import json
import os
import random
from random import randint
from time import sleep

import paho.mqtt.client as mqtt

broker_url = os.getenv("BROKER_URL", "localhost")
broker_port = int(os.getenv("BROKER_PORT", "1883"))
pod_name = os.getenv("HOSTNAME", default="POD123")
topic_name = "iot/"

client = mqtt.Client(pod_name)
print("Connecting")
client.connect(broker_url, broker_port)
print("Connected")

try:
    while True:
        print("Sending payload")
        temperature = random.randrange(0, 40)
        humidity = random.randrange(20, 60)
        payload = {"device": pod_name, "temp": temperature, "humidity": humidity}
        payload_json = json.dumps(payload)
        print(f'Payload: {payload_json}')
        client.publish(topic_name, payload_json)
        sleep(randint(100, 500)/1000)
except:
    client.disconnect()
