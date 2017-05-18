package pl.edu.agh.soa.lab7.zad1.publisher;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.jms.JMSException;
import java.util.List;

@ManagedBean
public class Publisher {
    @EJB
    private TopicService topicService;

    private String newTopicName;
    private String message;
    private String subscribers;

    public void addTopic() {
        topicService.save(newTopicName);
    }

    public void sendMessage(String topic) throws JMSException {
        topicService.sendMessage(topic, message, subscribers);
    }

    public List<String> getTopics() {
        return topicService.findAll();
    }

    public String getNewTopicName() {
        return newTopicName;
    }

    public void setNewTopicName(String newTopicName) {
        this.newTopicName = newTopicName;
    }

    public TopicService getTopicService() {
        return topicService;
    }

    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(String subscribers) {
        this.subscribers = subscribers;
    }
}
