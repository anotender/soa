package pl.edu.agh.soa.lab7.zad2;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.faces.bean.ManagedBean;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.LinkedList;
import java.util.List;

@ManagedBean
@MessageDriven(
        name = "Receiver",
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/lab7-zad1-queue")
        }
)
public class Receiver implements MessageListener {

    private List<String> firms = new LinkedList<>();

    public Receiver() {
        System.out.println("new Receiver()");
        firms.add("name1");
        firms.add("name2");
    }

    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            firms.add(textMessage.getText());
            System.out.println("Received: " + textMessage.getText());
            System.out.println(firms.size());
            firms.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getFirms() {
        return firms;
    }

    public void setFirms(List<String> firms) {
        this.firms = firms;
    }
}
