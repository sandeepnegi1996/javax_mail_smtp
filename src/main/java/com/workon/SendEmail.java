package com.workon;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
   public static void main(String[] args) {
      
      String to = "To Email Address";

      // Put sender’s address
      String from = "Senders Email Address";
      
      final String username = "yourUsername";
      final String password = "Your Password";

      
      //If you are in a corporate environment 
      //you can ask the admin or your team
      String host = "Put your SMTP Server host name";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      //Disabling the TLS
    //  props.put("mail.smtp.starttls.enable", "true"); 
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "25");   //checkout the portnumber you are using your SMTP

      // Get the Session object.
      Session session = Session.getInstance(props,
    	         new javax.mail.Authenticator() {
    	            protected PasswordAuthentication getPasswordAuthentication() {
    	               return new PasswordAuthentication(username, password);
    	    }
    	         });

      try {
    // Create a default MimeMessage object.
    Message message = new MimeMessage(session);
 
    // Set From: header field 
    message.setFrom(new InternetAddress(from));
 
    // Set To: header field
    message.setRecipients(Message.RecipientType.TO,
               InternetAddress.parse(to));
 
    // Set Subject: header field
    message.setSubject("Regarding the Report of the Generic and the Regression Testing ");
 
    // Put the content of your message
    message.setText("Kindly Check the Report of Testing in Attachment ");

    // Send message
    Transport.send(message);

    System.out.println("Sent message successfully...........");

      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }
}