package com.kairos.kafka.workshop.controller.service;


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.kafka.test.rule.KafkaEmbedded;
//import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.test.context.junit4.SpringRunner;

//TODO: Arreglar error al levantar el zookeeper del KafkaEmbedded.
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemService {

    /*
    @Autowired
    private ProducerFactory producerFactory;

    @Autowired
    private Consumer consumer;

    @Autowired
    private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;


    @ClassRule
    public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, "avro.t");

    @Before
    public void setUp() throws Exception {
        // wait until the partitions are assigned
        for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry
                .getListenerContainers()) {
            ContainerTestUtils.waitForAssignment(messageListenerContainer,
                    embeddedKafka.getPartitionsPerTopic());
        }
    }

    @Test
    public void testReceiver() throws Exception {
        Entry entry = new Entry();
        entry.setAuthorName("John Doe");
        entry.setAuthorNick("Johny");
        entry.setId(1);
        entry.setSummary("summary");
        entry.setText("text");
        entry.setTitle("title");

        Producer producer = producerFactory.findProducer(ProducerType.EntryProducer);
        producer.send(entry);

        Map<String, Entry> result = consumer.getEntriesFromKafka();
    }
    */

}
