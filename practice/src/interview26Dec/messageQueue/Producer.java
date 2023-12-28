package interview26Dec.messageQueue;

import java.util.concurrent.BlockingQueue;

public class Producer{
    int producerId;
    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

    public void publish(String message, Topic topic) throws InterruptedException {
        BlockingQueue queue =  topic.getTopic();
        System.out.println("Printing topic id: "+topic.getTopicId());
        System.out.println("Topic current size: "+queue.size()+" capacity of topic: "+topic.capacity);
        if (queue.size()<topic.capacity){
            System.out.println("Printing published message: "+queue.size());
            queue.add(message);
            System.out.println("Topic size after adding: "+queue.size());
        }
    }
}
