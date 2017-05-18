package pl.edu.agh.soa.lab7.zad1.subscriber;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.jms.*;

@ManagedBean
public class Subscriber {

    private String name;

    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory cf;

    @Resource(mappedName = "java:/jms/topic/lab7-zad1-topic")
    private Topic jmsTopic;

    public void registerSubscriber() throws Exception{
        System.out.println("Registering consumer: " + name);

        Connection connection = cf.createConnection();

        connection
                .createSession(false, Session.AUTO_ACKNOWLEDGE)
                .createConsumer(jmsTopic)
                .setMessageListener(new CustomMessageListener(name));

        connection.start();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
