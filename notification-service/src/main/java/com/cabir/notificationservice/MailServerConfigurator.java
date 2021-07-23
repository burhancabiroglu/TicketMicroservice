package com.cabir.notificationservice;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class MailServerConfigurator {
    private final Properties prop;
    private final String email;
    private final String password;
    private Session session;
    public MailServerConfigurator(String email,String password){
        prop = new Properties();
        prop.put("mail.smtp.host", "smtp-mail.outlook.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.starttls.enable","true");
        prop.put("mail.smtp.auth", "true");

        this.email = email;
        this.password = password;
        session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });

    }

    public void sendEmail(String toSend,String msgStr) throws Exception{
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(this.email));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(toSend));
        message.setSubject("Cabir Ticket Cloud");


        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msgStr, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }
}
