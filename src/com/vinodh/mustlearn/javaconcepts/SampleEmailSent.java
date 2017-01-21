package com.vinodh.mustlearn.javaconcepts;

import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Session --> Compose --> Sent Email
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
public class SampleEmailSent {

	public static void main(String[] args) throws AddressException, MessagingException {

		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", 465);
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.port", 465);
		javax.mail.Session session = Session.getDefaultInstance(properties, new Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication("Username@gmail.com", "pwd");
			}

		});
		javax.mail.internet.MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("vinodhTest@learningJava.com"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("toAddressEmail@gmail.com"));
		message.setRecipient(Message.RecipientType.CC, new InternetAddress("CCAddressEmail@gmail.com"));
		message.setSubject("Hello This is vinodh");
		message.setText("Yo ! Bro , What's up");
		message.setContent("<a href='https://www.google.com' > Jaffa </a>", "text/html");
		javax.mail.Transport.send(message);

		System.out.println("Message sent successfully");
	}

}
