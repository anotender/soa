package pl.edu.agh.soa.lab7.zad2;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.jms.*;

@ManagedBean
public class FirmRegister {

    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory cf;

    @Resource(mappedName = "java:/jms/queue/lab7-zad1-queue")
    private Queue queue;

    private String name;

    public void register() {
        Connection con = null;
        try {
            con = cf.createConnection();
            Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer publisher = session.createProducer(queue);

            con.start();

            TextMessage message = session.createTextMessage(name);
            publisher.send(message);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
