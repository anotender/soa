package pl.edu.agh.soa.lab7.zad1;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;
import java.util.LinkedList;
import java.util.List;

@Stateless
public class TopicServiceImpl implements TopicService {

    @Resource(mappedName = "java:/ConnectionFactory")
    private TopicConnectionFactory cf;

    @Resource(mappedName = "java:/jms/topic/lab7-zad1-topic")
    private Topic topic;

    private List<String> topics = new LinkedList<String>();

    public void save(String topic) {
        topics.add(topic);
    }

    public List<String> findAll() {
        return topics;
    }

    public void sendMessage(String topic, String message) throws JMSException {
        System.out.println("sending " + message + " to " + topic);

        TopicConnection topicConnection = cf.createTopicConnection();
        TopicSession topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

//        TopicPublisher topicPublisher = topicSession.createPublisher()
    }
}
