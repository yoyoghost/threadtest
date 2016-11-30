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

public class MessageSendReceiveAndReply
{
    public static void main(String[] args) throws Exception
    {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");
        Connection conn = factory.createConnection();
        conn.start();
        final Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
        Queue sendQueue = new ActiveMQQueue("sendqueue");

        Queue replyQueue = new ActiveMQQueue("replyqueue");
        
        Message message = session.createTextMessage("andy");
        message.setJMSReplyTo(replyQueue);
        
        MessageProducer mp = session.createProducer(sendQueue);
        mp.send(message);
        
        MessageConsumer mc1 = session.createConsumer(sendQueue);
        mc1.setMessageListener(new MessageListener()
        {
            
            @Override
            public void onMessage(Message arg0)
            {
                //创建producer
                try
                {
                    System.out.println(((TextMessage)arg0).getText());
                    MessageProducer mp1 = session.createProducer(arg0.getJMSReplyTo());
                    mp1.send(session.createTextMessage("hello andy~~~"));
                }
                catch (JMSException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
        });
        
        MessageConsumer mc2 = session.createConsumer(replyQueue);
        mc2.setMessageListener(new MessageListener()
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
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
        });
    }
}
