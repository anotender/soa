package pl.edu.agh.soa.lab7.zad1.subscriber;

import javax.annotation.Resource;
import javax.jms.*;

public class Subscriber {

    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory cf;

    @Resource(mappedName = "java:/jms/topic/lab7-zad1-topic")
    private Topic jmsTopic;

    public void registerSubscriber(String name) {
        Connection con = null;
        try {
            con = cf.createConnection();
            Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(jmsTopic);

            consumer.setMessageListener(m -> {
                MapMessage mapMessage = (MapMessage) m;
                try {
                    String topic = mapMessage.getString("topic");
                    String message = mapMessage.getString("message");

                    System.out.println("Received by " + name + ": " + topic + " -> " + message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            con.start();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (JMSException ignored) {
                }
            }
        }
    }
}
