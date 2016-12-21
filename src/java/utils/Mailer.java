package utils;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {

    public static void send(String address, String subject, String msg) {

        final String user = "hieuvt.clone.1@gmail.com";//change accordingly
        final String pass = "123321@@";

//1st step)Set properties and Get the session object	
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");//change accordingly
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });
//2nd step)compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
            message.setFrom(new InternetAddress(user));
            //Send an email to multiple recipients
            message.addRecipients(Message.RecipientType.TO, address);
            message.setSubject(subject);
            message.setText(msg);

//3rd step)send message
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws AddressException {
        Mailer mailer = new Mailer();;
        mailer.send("vutronghieu.04012203@gmail.com", "Đây là chủ đề tin nhắn", "đây là tin nhắn");
    }
}
