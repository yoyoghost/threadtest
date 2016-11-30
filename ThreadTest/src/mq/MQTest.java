package mq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class MQTest
{
    public static void main(String[] args) throws JMSException
    {
        ConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");
        
        Queue queue = new ActiveMQQueue("testQueue");
        
        Connection conn = factory.createConnection();
        
        conn.start();
        
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
        Message message = session.createTextMessage("Hello JMS!");
        
        MessageProducer mp =  session.createProducer(queue);
        
        mp.send(message);
        
        MessageConsumer mc =  session.createConsumer(queue);
        
        mc.setMessageListener(new MessageListener()
        {
            @Override
            public void onMessage(Message arg0)
            {
                try
                {
                    System.out.println(((TextMessage)arg0).getText());
                }
                catch (JMSException e)
                {
                    e.printStackTrace();
                }
                
            }
        });
        //System.out.println(((TextMessage)mc.receive()).getText());
    }
}
