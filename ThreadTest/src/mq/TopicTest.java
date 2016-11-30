package mq;

import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;

public class TopicTest
{
    public static void main(String[] args)
        throws Exception
    {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");
        
        Connection conn = factory.createConnection();
        
        conn.start();
        
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
        Topic topic = new ActiveMQTopic("testTopic");
        
        MessageConsumer mc1 = session.createConsumer(topic);
        
        mc1.setMessageListener(new MessageListener()
        {
            @Override
            public void onMessage(Message arg0)
            {
                try
                {
                    System.out.println("mc1 has recieved message :" + ((TextMessage)arg0).getText());
                }
                catch (JMSException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        
        MessageConsumer mc2 = session.createConsumer(topic);
        
        mc2.setMessageListener(new MessageListener()
        {
            @Override
            public void onMessage(Message arg0)
            {
                try
                {
                    System.out.println("mc2 has recieved message :" + ((TextMessage)arg0).getText());
                }
                catch (JMSException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        
        MessageProducer mp = session.createProducer(topic);
        
        for(int i = 0 ; i < 10 ; i++){
            mp.send(session.createTextMessage("hello jms~"+i));   
        }
        
    }
}
