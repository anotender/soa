package pl.edu.agh.soa.projekt.pas.service.detector;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;

@Stateless
public class NotificationHandler {
    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory cf;

    @Resource(mappedName = "java:/jms/topic/illegal-state-topic")
    private Topic topic;

    public void notifyUsers(long parkingPlaceId) {
        Connection con = null;
        try {
            con = cf.createConnection();
            Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer publisher = session.createProducer(topic);

            con.start();

            Message message = session.createMessage();
            message.setLongProperty("parkingPlaceId", parkingPlaceId);

            publisher.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
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
