# Challenge 3

Now we are going to configure a JDBC Sink Connector. 

## Step 1
Create an Avro object. Should be something like this:

```
{
  "type": "record",
  "name": "AvroItem",
  "namespace": "com.kairos.kafka.workshop.avro",
  "fields": [
    {
      "name": "id",
      "type": "long"
    },
    {
      "name": "name",
      "type": "string"
    },
    {
      "name": "quantity",
      "type": "int"
    },
    {
      "name": "updateTimestamp",
      "type": "long",
      "logicalType": "timestamp-millis"
    }
  ]
}
```

## Step 2
Create the topic we are going to source to (source connect) and consume from (java consumer):
> kafka-topics --zookeeper localhost:2181 --topic jdbc-shopping-list --create --partitions 3 --replication-factor 1

## Step 3
Modify our producer code to send the new Avro instead a String.

## Step 4
To configure Sink Connector you have to access Landoop Kafka UI at http://localhost:3030.

Once there, access to connectors section:

![connectors_step1](connectors_step1.png?raw=true "PoC Structure") 

Select "New", and you should see many available connectors. For this case we are going to use a JDBC Sink Connector:

![connectors_sink_jdbc](connectors_sink_jdbc.png?raw=true "PoC Structure") 

After that you have to paste this configuration [(link to sink_postgreSQL.properties)](connect/sink_postgreSQL.properties) to start the sink connector.

That's all, automatically your database will start receiving data from the topic.


