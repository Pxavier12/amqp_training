package fr.lernejo.chat;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Launcher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Launcher.class);
        RabbitTemplate sender = app.getBean(RabbitTemplate.class);
        String message="";
        Scanner sc = new Scanner(System.in);
        while (!message.contentEquals("q")){
            System.out.println("Input a message, we will send it for you (type q for quitting): ");
            message = sc.nextLine();
            if (!message.contentEquals("q")){
                sender.convertAndSend("chat_messages", message);
            }else{
                System.out.println("Thanks for coming");
                app.stop();
            }
        }
    }
}
