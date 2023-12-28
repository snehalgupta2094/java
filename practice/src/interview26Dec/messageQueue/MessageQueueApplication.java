package interview26Dec.messageQueue;

import java.util.ArrayList;
import java.util.List;

public class MessageQueueApplication {

    public static Producer createProducer(int producerId){
        Producer producer=new Producer();
        producer.setProducerId(producerId);
        return producer;
    }
    public static Consumer createConsumer(int consumerId){
        Consumer consumer=new Consumer();
        consumer.setConsumerId(consumerId);
        return consumer;
    }
    public static Topic createTopic(int topicId){
        Topic topic=new Topic(10);
        topic.setTopicId(topicId);
        return topic;
    }

    public static void main(String[] args) throws InterruptedException {
        //Create topics
        List<Topic> topicList=new ArrayList<>();
        for(int i=0;i<10;i++){
            Topic topic=createTopic(i);
            topicList.add(topic);
        }

        //Create producers
        List<Producer> producerList=new ArrayList<>();
        for(int i=0;i<5;i++){
            Producer producer=createProducer(i);
            producerList.add(producer);
        }

        //Create consumers
        List<Consumer> consumerList=new ArrayList<>();
        for (int i=0;i<5;i++){
            Consumer consumer=createConsumer(i);
            consumerList.add(consumer);
        }

        //Subscribe to topics==consumer0 and consumer1 subscribed to topic3
        Consumer consumer0=consumerList.get(0);
        Consumer consumer1=consumerList.get(1);
        Topic topic3=topicList.get(3);
        topic3.subscribe(consumer0.getConsumerId());
        topic3.subscribe(consumer1.getConsumerId());

        //Produce message==producer0 produces message to topic3
        Producer producer0=producerList.get(0);
        String producedMessage="Hello from producer0";
        producer0.publish(producedMessage,topic3);

        //Consume message==consumer0 and consumer1 consumes message from topic3
        String consumedMessage1=consumer0.consume(topic3);
        String consumedMessage2=consumer1.consume(topic3);
        System.out.println("Message consumed by consumer0: "+consumedMessage1);
        System.out.println("Message consumed by consumer1: "+consumedMessage2);
    }
}
