package pl.edu.agh.soa.lab7.zad2;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.faces.bean.ManagedBean;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
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

    @EJB
    private FirmService firmService;

    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("Received: " + textMessage.getText());
            firmService.save(textMessage.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getFirms() {
        return firmService.findAll();
    }
}
