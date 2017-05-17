package pl.edu.agh.soa.lab7.zad1.publisher;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;
import java.util.*;

@Stateless
public class TopicServiceImpl implements TopicService {

    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory cf;

    @Resource(mappedName = "java:/jms/topic/lab7-zad1-topic")
    private Topic jmsTopic;

    private Map<String, Set<String>> topics = new HashMap<>();

    public void save(String topic) {
        topics.put(topic, new HashSet<>());
    }

    public List<String> findAll() {
        return new LinkedList<>(topics.keySet());
    }

    public void sendMessage(String topic, String message) throws JMSException {
        Connection con = null;
        try {
            con = cf.createConnection();
            Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer publisher = session.createProducer(jmsTopic);

            con.start();

            MapMessage mapMessage = session.createMapMessage();
            mapMessage.setString("topic", topic);
            mapMessage.setString("message", message);

            publisher.send(mapMessage);
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
