# Kafka for beginners workshop

### Goal

The main goal of this workshop is to learn the basics of Kafka from the scratch. At the end of this workshop you'll know the following:

* The  Apache Kafka Ecosystem Architecture

* The Kafka Core Concepts: Topics, Partitions, Brokers, Replicas, Producers, Consumers, and more!

* Launch your own Kafka cluster

* Learn and Practice using the Kafka Command Line Interface (CLI)

* Code Producer and Consumers using the Java API 

* Overview of Advanced API Kafka Connect

### Requirements

Good knowledge of Java. Docker basics.

It's mandatory to have installed the next tools before the workshop beginning (Don't hesitate to contact the organizers if you have any problem):

* Java 8 SDK https://www.oracle.com/technetwork/es/java/javase/downloads/index.html
* Docker https://docs.docker.com/get-docker/
* Postman https://www.postman.com/
* Preferred DB Manager. I suggest DBeaver https://dbeaver.io/download/
* GIT
* Preferred IDE. We will use IntelliJ Community but Eclipse is Ok

### About us

* Alejandro Quesada (alejandro.quesada@kairosds.com) 

* Pedro Martínez (pmcabrales@gmail.com) Software Engineer that has been working with Java technologies for the last 10 years.

### What are we going to do?

![workshop_structure](workshop_structure.png?raw=true "Workshop Structure") 

First of all we are mounting a docker image in our localhost with all the necessary Kafka tools. We have selected an image from Landoop that includes a Kafka cluster, Zookeeper, Schema registry, some Connectors, a Kafka user interface and some more tools.

With our Kafka cluster working we are going to play along with the CLI. The goal of this section is to create a topic and send/receive messages to/from it.

After that it's time to code! We'll build a very basic Spring application that exposes an API to create messages using Producer API.

Later on, in order to consume the messages produced in the previous section, we will use the Consumer API to implement a receiver.

To end we are going to persist messages from the topic in a DB using Kafka Sink Connect and retrieve them after into another topic using Source Connect.


### Let's start
#### Challenge 0 - Concepts and configuration

Checkout code from brach [challenge-0](https://github.com/pmcabrales/kafka-workshop/blob/challenge-0/README.md)

#### Challenge 1 - Producer

Checkout code from brach [challenge-1](https://github.com/pmcabrales/kafka-workshop/blob/challenge-1/README.md)

#### Challenge 2 - Consumer

Checkout code from brach [challenge-2](https://github.com/pmcabrales/kafka-workshop/blob/challenge-2/README.md)

#### Challenge 3 - DB Sink

Checkout code from brach [challenge-3](https://github.com/pmcabrales/kafka-workshop/blob/challenge-3/README.md)

#### Challenge 4 - DB Source

Checkout code from brach [challenge-4](https://github.com/pmcabrales/kafka-workshop/blob/challenge-4/README.md)