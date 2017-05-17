package pl.edu.agh.soa.lab7.zad1.subscriber;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by matnow on 5/17/17.
 */
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

            System.out.println("Received by " + name + ": " + topic + " -> " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
