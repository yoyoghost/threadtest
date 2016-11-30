package mq;

import javax.jms.Connection;
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

public class QueueTest
{
    public static void main(String[] args)
        throws Exception
    {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");
        
        Connection con = factory.createConnection();
        
        con.start();
        
        Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
        Queue queue = new ActiveMQQueue("myqueue");
        
        MessageConsumer mc1 = session.createConsumer(queue);
        
        mc1.setMessageListener(new MessageListener()
        {
            
            @Override
            public void onMessage(Message arg0)
            {
                try
                {
                    System.out.println("mc1 has recieved message:" + ((TextMessage)arg0).getText());
                }
                catch (JMSException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        
        MessageConsumer mc2 = session.createConsumer(queue);
        
        mc2.setMessageListener(new MessageListener()
        {
            
            @Override
            public void onMessage(Message arg0)
            {
                try
                {
                    System.out.println("mc2 has recieved message:" + ((TextMessage)arg0).getText());
                }
                catch (JMSException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        
        
        MessageProducer mp = session.createProducer(queue);
        for(int i = 0 ; i < 10 ;i++ )
        {
            mp.send(session.createTextMessage("hello~"+i));
        }
    }
}
