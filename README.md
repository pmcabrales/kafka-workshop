# Challenge 1

Hands on producing to Kafka topic

## Step 1

Create the topic we are going to produce to:
> kafka-topics --zookeeper localhost:2181 --topic shopping-list-no-schema --create --partitions 3 --replication-factor 1

## Step 2

We provide a basic API to add items to a shopping list:
http://localhost:8443/swagger-ui.html#/

Complete the TODO's to write a full functional producer.