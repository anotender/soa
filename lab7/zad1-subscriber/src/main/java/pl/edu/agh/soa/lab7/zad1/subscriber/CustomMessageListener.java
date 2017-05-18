package pl.edu.agh.soa.lab7.zad1.subscriber;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.Arrays;

public class CustomMessageListener implements MessageListener {

    private String name;

    public CustomMessageListener(String name) {
        this.name = name;
    }

    @Override
    public void onMessage(Message m) {
        MapMessage mapMessage = (MapMessage) m;
        try {
            String topic = mapMessage.getString("topic");
            String message = mapMessage.getString("message");
            String subscribers = mapMessage.getString("subscribers");

            boolean shouldReceiveMessage = isEmpty(subscribers) || Arrays
                    .stream(subscribers.split(","))
                    .anyMatch(s -> s.equals(name));

            if (shouldReceiveMessage) {
                System.out.println("Received by " + name + ": " + topic + " -> " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isEmpty(String s) {
        return s == null || s.trim().length() == 0;
    }
}
