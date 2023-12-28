package interview26Dec.messageQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Topic {
    List<Integer> subscribedConsumers;
    int capacity;
    BlockingQueue<String> topic;
    int topicId;

    Topic(int capacity){
        this.capacity=capacity;
        topic=new ArrayBlockingQueue(capacity);
        subscribedConsumers=new ArrayList<>();
    }
    public void subscribe(int consumerId){
        subscribedConsumers.add(consumerId);
    }
    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }
    public BlockingQueue getTopic() {
        return topic;
    }

}

