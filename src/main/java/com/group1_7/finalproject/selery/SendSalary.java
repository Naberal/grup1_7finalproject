package com.group1_7.finalproject.selery;

import com.group1_7.finalproject.model.Salary;
import com.group1_7.finalproject.model.Worker;
import com.group1_7.finalproject.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendSalary {
    @Autowired
    WorkerRepository workerRepository;
    Session session = getSession();
    public void mailing() throws AddressException {
        for (Worker worker:workerRepository.findAll()) {
            Address address=new InternetAddress(worker.getEmail());
            List<Salary> salary=worker.getSalary();
            for (Salary salary1:salary){
                if (salary1.getDate().equals(LocalDate.now())){
                    String text="your salary on:"+salary1.getDate()+"is"+salary1.getSalary();
                    email(text,address);
                }
            }
        }


    }


    private void email(String text, Address address) {
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("XXXXXXXX@gmail.com"));//my email
            message.addRecipient(Message.RecipientType.TO, address);
            message.setSubject("Salary");
            message.setText(text);

            send(message);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private void send(MimeMessage message) throws MessagingException {
        Transport transport = session.getTransport();
        transport.connect("XXXXXXXX@gmail.com", "XXXXXXXX");// my
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
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
