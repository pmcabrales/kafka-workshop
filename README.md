# Challenge 0

Let's play with Kafka

## Step 1 - Start Kafka cluster

Start the kafka cluster and the postgreSQL. Go to docker-compose directory and execute the command:

> docker-compose up -d

## Step 2 - CLI

From the terminal open a bash inside the Docker image:

> docker run --rm -it -v "$(pwd)":/workshop --net=host landoop/fast-data-dev:2.3.1 bash

Now it's time to play with topics:

* List topics
> kafka-topics --zookeeper localhost:2181 --list
* Create topics
> kafka-topics --zookeeper localhost:2181 --topic kafka-workshop-topic --create --partitions 3 --replication-factor 1
* Delete topics
> kafka-topics --zookeeper localhost:2181 --topic kafka-workshop-topic --delete
* Describe topic
> kafka-topics --zookeeper localhost:2181 --topic kafka-workshop-topic --describe
* Producing
> kafka-console-producer --broker-list localhost:9092 --topic kafka-workshop-topic 
* Consuming
> kafka-console-consumer --bootstrap-server localhost:9092 --topic kafka-workshop-topic --from-beginning