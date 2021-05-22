package app.web.pavelk.message5.component;


import app.web.pavelk.message5.dto.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Producer {

    private final JmsTemplate jmsTemplate;

    public void sendMessage(String queue, String message) {
        jmsTemplate.send(queue, l -> l.createTextMessage(message));
    }

    public void sendMessage2(String queue, String message) {
        jmsTemplate.convertAndSend(queue, new Email("info@example.com", message));
    }

    public void sendMessage3(String queue, String message) {
        jmsTemplate.convertAndSend(queue, message);
    }

}

