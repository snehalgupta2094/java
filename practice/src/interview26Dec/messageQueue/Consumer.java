package interview26Dec.messageQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer{
 int consumerId;
 public int getConsumerId() {
  return consumerId;
 }

 public void setConsumerId(int consumerId) {
  this.consumerId = consumerId;
 }

 public String consume(Topic topic){
  BlockingQueue queue =  topic.getTopic();
  if (queue.size()>0) {
   String message=(String) queue.peek();
   System.out.println("Message consumed by consumer id: "+consumerId);
  return message;
  }
  return "";
 }
}
