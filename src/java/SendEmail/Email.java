package SendEmail;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


/**
 *
 * @author Thursday
 */
public class Email {
    
    
    
    public void sendEmail(String memo, String to){
    
         Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", "equilibrium.intertrade@gmail.com");
        props.put("mail.smtp.password","elauserpaswd1");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress("equilibrium.intertrade@gmail.com"));
            InternetAddress toAddress = new InternetAddress();

            // To get the array of addresses
            
           toAddress = new InternetAddress(to);
           message.addRecipient(Message.RecipientType.TO, toAddress);
            

            message.setSubject("Disciplinary Memo");
            message.setText("You got a memo");
            Transport transport = session.getTransport("smtp");
            transport.connect(host,"equilibrium.intertrade@gmail.com", "elauserpaswd1");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
    
    
    
    
}
        
       
    
   
        
        
    
    
    
    

