package com.zz.test.jms.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MessageConsumer implements MessageListener {
 
 
 
    public void onMessage(Message message) {
 
        try
 
       {
           System.out.println("GetResult:=="+((TextMessage) message).getText());
 
       }
 
       catch (JMSException e)
 
       {
    	   e.printStackTrace() ;
       }
 
    }
 
}
