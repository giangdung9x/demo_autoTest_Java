package EmailConfig;

import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmailUtil {

    public static void sendEmail(Email email) {
        Properties props = new Properties();
        props.put("mail.smtp.host", email.getHost());
        props.put("mail.smtp.socketFactory.port", email.getPort());
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", email.getPort());

        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email.getUsername(), email.getPassword());
                    }
                });
        try {
            Message message = new MimeMessage(session);
            InternetAddress[] recipients = new InternetAddress[email.getRecipients().length];
            for (int i = 0; i < email.getRecipients().length; i++) {
                recipients[i] = new InternetAddress(email.getRecipients()[i]);
            }
            message.setRecipients(Message.RecipientType.TO, recipients);
            message.setFrom(new InternetAddress(email.getFrom()));

            message.setSubject(subject);
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(emailContent, "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

            Transport.send(message);

            System.out.println("=====Email Sent=====");

        } catch (MessagingException e) {

            throw new RuntimeException(e);
        }
    }

    private static String subject = "Test Report";
    private static String emailContent = "<p>Dear SHOWSLINGER project members,</p>\n" +
            "<p>Automation Team is sending the execution report of project ShowSlinger, version <b>version_build</b>.</p>\n" +
            "<p>Build result: <b>build_result</b></p>\n" +
            "<p>Report Links: <a href=\"https://a8d2-27-72-144-248.ngrok-free.app/index.html\">Allure Report Link</a></p>\n" +
            "<p><i>(This is an automated release email after execution. Please contact Automation Team if you need further information!)</i></p>";
}

