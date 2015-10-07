package se.su.dsv.bivsim.pages.Case3.Case3EditingPages.Case3EdittingCommon;

/**
 * Created by kib on 7/7/15.
 */

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class MailClient
{
    public void sendMail(String mailServer, String from, String to,
                         String subject, String messageBody
                         ) throws
            MessagingException {
// Setup mail server
        Properties props = System.getProperties();
        props.put("mail.smtp.host", mailServer);
// Get a mail session
        Session session = Session.getDefaultInstance(props, null);
// Define a new mail message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
// Create a message part to represent the body text
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(messageBody);
//use a MimeMultipart as we need to handle the file attachments
        Multipart multipart = new MimeMultipart();
//add the message body to the mime message
        multipart.addBodyPart(messageBodyPart);
// add any file attachments to the message
// Put all message parts in the message
        message.setContent(multipart);
// Send the message
        Transport.send(message);
    }

}