package pl.edu.agh.soa.lab7.zad1;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class Publisher {
    @EJB
    private TopicService topicService;

    private String topicName;
    private String message;

    public void addTopic() {
        System.out.println("works...");
        topicService.save(topicName);
    }

    public void sendMessage(String topic) {
        topicService.sendMessage(topic, message);
    }

    public List<String> getTopics() {
        return topicService.findAll();
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
