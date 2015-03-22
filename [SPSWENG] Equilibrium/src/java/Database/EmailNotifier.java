/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;


import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailNotifier {

    private static EmailNotifier emailInstance = new EmailNotifier();
    private final String username;
    private final String password;
    private final String from;
    private String to;
    private Properties props;
    private Session session;
    private Database db;

    private EmailNotifier() {
        from = "equilibrium.intertrade@gmail.com";
        username = "equilibrium.intertrade";
        password = "elauserpaswd1"; // change if necessary
        db = Database.getInstance();
        props = System.getProperties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    public static EmailNotifier getInstance() {
        return emailInstance;
    }

    public void sendLeaveRequest(int empEntryNum, String leaveType, Date startDate, Date endDate) {
        System.out.println("EMP NUM = " + empEntryNum);
        
        int manEntryNum = db.getManager(empEntryNum);
        to = db.getEmailAddress(manEntryNum);
        
        System.out.println("MANAGER NUM = " + manEntryNum + "\nEMAIL = " + to);
        String manName = db.getFirstName(manEntryNum);
        String empName = db.getFirstName(empEntryNum) + " " + db.getLastName(empEntryNum);
        int empID = db.getIDNumber(empEntryNum);

        //get date details
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        int startYear = cal.get(Calendar.YEAR);
        int startMonth = cal.get(Calendar.MONTH) + 1;
        int startDay = cal.get(Calendar.DAY_OF_MONTH);
        
        cal.setTime(endDate);
        int endYear = cal.get(Calendar.YEAR);
        int endMonth = cal.get(Calendar.MONTH) + 1;
        int endDay = cal.get(Calendar.DAY_OF_MONTH);
        
        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("[LEAVE REQUEST] An employee has submitted a leave request");

            // Now set the actual message
            message.setText("Hi " + manName + ","
                    + "\n\nYour employee, " + empName + ", with the ID Number, " + empID + ", has submitted a leave request with the following details: \n"
                    + "\n- Leave Type: " + leaveType + "\n"
                    + "- Start Date: " + startMonth + " - " + startDay + " - " + startYear + "\n"
                    + "- End Date: " + endMonth + " - " + endDay + " - " + endYear + "\n");

            // Send message
            Transport transport = session.getTransport("smtps");
            transport.connect("smtp.gmail.com", username, password);
            transport.send(message);
            transport.close();
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
