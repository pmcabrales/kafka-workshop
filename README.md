# Kafka for begginers workshop

### Goal

The main goal of this PoC is to learn how does Kafka works and use it to implement the communication between two applications.

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

* Pedro Martinez (pedro.martinez@kairosds.com) Software Engineer that has been working with Java technologies for the last 10 years.

### What are we going to do?

![workshop_structure](workshop_structure.png?raw=true "Workshop Structure") 

First of all we are going to mount in our localhost a docker image with all the necessary Kafka tools. We have selected an image from Landoop that includes a Kafka cluster, Zookeeper, Schema registry, some Connectors, a Kafka user interface and some more tools.

With our Kafka cluster working we are going to play along with the CLI. We are going to create a topic and send/receive messages to/from it.

After that we are going to build a very basic Spring application that exposes an API to create messages using Producer API.

Later on we are going to use the Consumer API to implement a receiver for the messages created in the previous step.

To end we are going to persist messages from the topic in a DB using Kafka Sink Connect and retrieve them after into another topic using Source Connect.


### Let's start
#### Challenge 0 - Concepts and configuration

Checkout code from brach challenge-0

To start the kafka cluster and the two DDBB go to docker-compose directory and execute the command:

> docker-compose up -d

#### Challenge 1 - Producer

Checkout code from brach challenge-1

#### Challenge 2 - Consumer

Checkout code from brach challenge-2

#### Challenge 3 - DB Sink

Checkout code from brach challenge-3

To configure Sink Connect you have to access Landoop Kafka UI at http://localhost:3030
Once there access to connectors section:

![connectors_step1](images/connectors_step1.png?raw=true "PoC Structure") 

Select "New" and you should see many available connectors. For this case we are going to use a JDBC Sink Connector:

![connectors_sink_jdbc](images/connectors_sink_jdbc.png?raw=true "PoC Structure") 

After that you have to paste this configuration [(link to sink_postgreSQL.properties)](connect/sink_postgreSQL.properties) to start the sink connector.

That's all, automatically your database will start receiving data from the topic.

#### Challenge 4 - DB Source

Checkout code from brach challenge-4

To configure Source Connect you have to access Landoop Kafka UI like in [Challenge 3 - DB Sink](#Challenge 3 - DB Sink)

In this case we need to add a JDBC Source Connector:

![connectors_source_jdbc](images/connectors_source_jdbc.png?raw=true "PoC Structure") 

After that you have to paste this configuration [ (link to source_postgreSQL.properties)](connect/source_postgreSQL.properties) to start the source connector.
