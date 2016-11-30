package mq;

import javax.jms.Connection;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class DeliveryModeReceiveTest
{
    public static void main(String[] args) throws Exception
    {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");
        Connection conn = factory.createConnection();
        conn.start();
        Queue queue = new ActiveMQQueue("queue");
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageConsumer mc = session.createConsumer(queue);
        System.out.println(((TextMessage)mc.receive()).getText());
    }
}
