package com.wwi318.YourParty.Email;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Mailer {

	public static void registrationMail(String to, String name) {

		send(to, "Wilkommen bei YourParty",
				"Hallo " + name + ", <br> Wir freuen uns dich in unsere YourParty-Familie willkommen zu heißen");
	}

	public static void bookingMail(String to, String owner, String location, String date, String msg, String from) {
		
		send(to, "Neue Buchungsanfrage",
				"Hallo " + owner + ", <br> Ihr Location" + location + "hat eine neue Buchungsanfrage für den" + date + 
				". <br> Der Mieter hat folgende Nachricht hinterlassen:" + msg + "<br> Sie können die Anfrage an " + to + "beantworten");
	}
	
	private static void send(String to, String sub, String msg) {
		// Get properties object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("yourpartylocations@gmail.com", "Your99Party!");
			}
		});
		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setText(msg);
			// send message
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
