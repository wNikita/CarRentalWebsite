package com.narola.carrental.common;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmailService {

    private String senderEmail = "waghaskarnikita@gmail.com";
    private String senderPassword = "cukanystwehdirao";

    private Properties getProperties() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.ssl.enable", true);
        properties.put("mail.smtp.auth", true);
        return properties;
    }

    public void sendMail(String toMailId, String subject, String content) {

        Session session = Session.getInstance(getProperties(), new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(senderEmail, senderPassword);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMailId));
            message.setSubject(subject);
            message.setContent(content, "text/html");
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            System.out.println("Error sending email: " + e.getMessage());
        }
    }

    public void sendMail(List<String> emailList, String subject, String content) {
        Session session = Session.getInstance(getProperties(), new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(senderEmail, senderPassword);
            }
        });
        try {
            List<InternetAddress> internetAddressList = new ArrayList<>(emailList.size());
            for (String mail : emailList) {
                internetAddressList.add(new InternetAddress(mail));
            }
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO,
                    internetAddressList.toArray(new InternetAddress[emailList.size()]));
            message.setSubject(subject);
            message.setText(content);
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            System.out.println("Error sending email: " + e.getMessage());
        }
    }
}






