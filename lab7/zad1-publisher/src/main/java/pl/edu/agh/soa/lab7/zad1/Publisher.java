package pl.edu.agh.soa.lab7.zad1;

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

    public void addTopic() {
        try {
            topicService.save(newTopicName);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String topic) {
        try {
            topicService.sendMessage(topic, message);
        } catch (JMSException e) {
            e.printStackTrace();
        }
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
}
