package pl.edu.agh.soa.lab7.zad1;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Stateless
public class TopicServiceImpl implements TopicService {

    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory cf;

    @Resource(mappedName = "java:/jms/queue/lab7-zad1-queue")
    private Queue queue;

    private Map<String, List<String>> topics = new HashMap<>();

    public void save(String topic) {
        topics.put(topic, new LinkedList<>());
    }

    public List<String> findAll() {
        return new LinkedList<>(topics.keySet());
    }

    public void sendMessage(String topic, String message) throws JMSException {
        Connection con = null;
        try {
            con = cf.createConnection();
            Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer publisher = session.createProducer(queue);

            con.start();

            MapMessage mapMessage = session.createMapMessage();
            mapMessage.setString("topic", topic);
            mapMessage.setString("message", message);
            mapMessage.setObject("subscribers", topics.get(topic));

            publisher.send(mapMessage);
        } catch (Exception ignored) {
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
