package com.cabir.notificationservice;


import com.cabir.communicationservice.message.TicketNotification;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import javax.mail.*;

@EnableBinding(Sink.class)
public class NotificationDistributionService {

    @StreamListener(Sink.INPUT)
    public void onNotification(TicketNotification ticketNotification){
        System.out.println("———————————————————————————————————————————");
        System.out.println("Notification Send to Services");
        System.out.println("Notification -> " + ticketNotification.toString());
        System.out.println("———————————————————————————————————————————");




        Thread messageThread = new Thread(new Runnable() {
            @Override
            public void run() {
                MailServerConfigurator mailSender = new MailServerConfigurator("cabir_ticket_service@outlook.com","cbr123!8H");

                try {
                    mailSender.sendEmail(ticketNotification.getAccountEmail(),ticketNotification.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        messageThread.start();
    }




    // Todo: Stream Listener & Sink Binding Equivalent
    /*@Bean
    Consumer<TicketNotification> log() {
        return str -> {
            System.out.println(str);
        };
    }*/
}