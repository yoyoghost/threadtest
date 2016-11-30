package mq;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class DeliveryModeSendTest
{
    public static void main(String[] args) throws Exception
    {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");
        Connection conn = factory.createConnection();
        conn.start();
        Queue queue = new ActiveMQQueue("queue");
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer mp = session.createProducer(queue);
        mp.setDeliveryMode(DeliveryMode.PERSISTENT);
        mp.send(session.createTextMessage("this is a PERSISTENT message~~"));
        mp.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        mp.send(session.createTextMessage("this is a NON_PERSISTENT message~~"));
    }
}
