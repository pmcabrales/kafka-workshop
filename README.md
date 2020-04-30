# Challenge 4

Finally we are going to configure a JDBC Source Connector

## Step 1
Create the topic we are going to source to (source connect) and consume from (java consumer):
> kafka-topics --zookeeper localhost:2181 --topic jdbc-shopping-list --create --partitions 3 --replication-factor 1

## Step 2
To configure Source Connect you have to access Landoop Kafka UI

In this case we need to add a JDBC Source Connector:

![connectors_source_jdbc](connectors_source_jdbc.png?raw=true "PoC Structure") 

After that you have to paste this configuration [ (link to source_postgreSQL.properties)](connect/source_postgreSQL.properties) to start the source connector.

## Step 3
Change the code to consume the new topic we have created in step 1.

Now you have finished the workshop. Congratulations!



