package pl.edu.agh.soa.lab7.zad1.publisher;

import javax.ejb.Local;
import javax.jms.JMSException;
import java.util.List;

@Local
public interface TopicService {

    void save(String topic);

    List<String> findAll();

    void sendMessage(String topic, String message) throws JMSException;

}
