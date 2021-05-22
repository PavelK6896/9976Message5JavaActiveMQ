package app.web.pavelk.message5.service;

import app.web.pavelk.message5.component.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class MainService implements CommandLineRunner {

    private Scanner scanner = new Scanner(System.in);
    private final Producer producer;

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            TimeUnit.MILLISECONDS.sleep(500);
            String next = scanner.next();

            if (next.equals("1")) {
                producer.sendMessage("inbound.queue", "sj-df");
            } else if (next.equals("2")) {
                producer.sendMessage2("mailbox", "sp-dfsdfs");
            } else if (next.equals("3")) {
                producer.sendMessage3("in.three", "=ddd");
            } else if (next.equals("4")) {

            } else if (next.equals("0")) {
                break;
            }
        }
    }

}
