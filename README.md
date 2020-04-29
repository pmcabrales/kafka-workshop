# Challenge 1

Hands on producing to Kafka topic

## Step 1

Create the topic we are going to produce to:
> kafka-topics --zookeeper localhost:2181 --topic shopping-list-no-schema --create --partitions 3 --replication-factor 1

