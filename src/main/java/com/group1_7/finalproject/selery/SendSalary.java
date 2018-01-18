package com.group1_7.finalproject.selery;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendSalary {
    Session session = getSession();

    public void email() {
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("XXXXXXXX@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("XXXXXXXX@gmail.com"));
            message.setSubject("Salary");
            message.setText("Salary");

            Transport transport = session.getTransport();
            transport.connect("XXXXXXXX@gmail.com", "XXXXXXXX");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private Session getSession() {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.debug", "true");
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.starttls.enable", "true");
        return Session.getDefaultInstance(properties);
    }
}
