package com.edsolstice.educationportal.utility;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.edsolstice.educationportal.exception.EDSExceptionErrorCode;
import com.edsolstice.educationportal.exception.EDSExceptionMessage;
import com.edsolstice.educationportal.exception.EDSOperationException;
import com.sun.mail.util.MailSSLSocketFactory;



public class MailUtility {

	final static String username = "edsolstice.admin@edsolstice.com";
	final static String password = "edsolstice@admin";

	public static void isValidEmailAddress(String email) throws Exception {

		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			throw new EDSOperationException(EDSExceptionErrorCode.INVALIDINPUTS, EDSExceptionMessage.INVALIDEMAIL);
		}
	}
	
	
	/**
	 * @param email
	 * @param activationCode
	 * @throws GeneralSecurityException
	 */
	public static void sendActivationEmail(String email , String activationCode) throws GeneralSecurityException {

		Session session = getSession();
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			message.setSubject("EDSolstice user activation code");
			message.setText("Dear User,"
					+ "\n\n Please use this activation code to activate your account : "+activationCode
					+ "\n\n Thanks " );

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}


	private static Session getSession() throws GeneralSecurityException {

		MailSSLSocketFactory socketFactory= new MailSSLSocketFactory();
		socketFactory.setTrustAllHosts(true);

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.transport.protocol", "stmp");
		props.put("mail.smtp.starttls.enable", "false");
		props.put("mail.smtp.host", "mail.edsolstice.com");
		props.put("mail.smtp.port", "25");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		return session;

	}

}
