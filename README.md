### Proof of Concept Kafka

#### Goal

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

This Spring application exposes an API to create blog entries and comments.

It has a Kafka Producer to send new and edited entries to a Kafka topic and comments to another different topic.

It also has a Kafka Consumer that retrieves entries and comments from its topics.

#### Configuration

To start the kafka cluster and the two DDBB go to docker-compose directory and execute the command:

docker-compose up -d

###### Sink to PostgreSQL

To configure Sink Connect you have to access Landoop Kafka UI at http://localhost:3030
Once there access to connectors section:

![connectors_step1](images/connectors_step1.png?raw=true "PoC Structure") 

Select "New" and you should see many available connectors. For this case we are going to use a JDBC Sink Connector:

![connectors_sink_jdbc](images/connectors_sink_jdbc.png?raw=true "PoC Structure") 

After that you have to paste this configuration [(link to sink_postgreSQL.properties)](connect/sink_postgreSQL.properties) to start the sink connector.

That's all, automatically your database will start receiving data from the topic.

###### Source to PostgreSQL

To configure Source Connect you have to access Landoop Kafka UI like in [Sink to PostgreSQL](#Sink to PostgreSQL)

In this case we need to add a JDBC Source Connector:

![connectors_source_jdbc](images/connectors_source_jdbc.png?raw=true "PoC Structure") 

After that you have to paste this configuration [ (link to source_postgreSQL.properties)](connect/source_postgreSQL.properties) to start the source connector.

