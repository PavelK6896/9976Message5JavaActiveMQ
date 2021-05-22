package app.web.pavelk.message5.component;


import app.web.pavelk.message5.dto.Email;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class Listener {

    @JmsListener(destination = "inbound.queue")
    public void receiveMessage1(Object object) throws JMSException {
        if (object instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) object;
            System.out.println(textMessage.getText());
        }
    }

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage2(Email email) {
        System.out.println("Received <" + email + ">");
    }


    @JmsListener(destination = "in.three")
    @SendTo("out.three")
    public String receiveMessage3(Object object) throws JMSException {
        if (object instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) object;
            System.out.println("in.three " + textMessage.getText());
        }
        return "it's ok";
    }

    @JmsListener(destination = "out.three")
    public void receiveMessage4(Object object) throws JMSException {
        if (object instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) object;
            System.out.println("out.three " + textMessage.getText());
        }
    }

}