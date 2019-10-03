package com.cvonline.cvonline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class CvonlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(CvonlineApplication.class, args);
        System.out.println("Loading is complete...");
    }

//    public void send() {
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setTo("wehijin@gmail.com");
//        msg.setSubject("testing");
//        msg.setText("halo");
//        javaMailSender.send(msg);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("sending");
//        try {
//            send();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("done");
//    }
}
