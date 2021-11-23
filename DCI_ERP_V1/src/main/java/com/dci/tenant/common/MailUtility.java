package com.dci.tenant.common;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailUtility {

	public static void sendMailCordelia(Email email, String path) throws Exception {

		/*String host = "eu-smtp-outbound-1.mimecast.com";
		// Create properties for the Session
		Properties props = System.getProperties();
		props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "25");

		// Get a session
		Session session = Session.getInstance(props);

		try {
			Transport bus = session.getTransport("smtp");

			bus.connect("eu-smtp-outbound-1.mimecast.com", "team@cordelialine.com", "T3@w!7070");
			Message msg = new MimeMessage(session);

			// Set message attributes
			msg.setFrom(new InternetAddress(email.getFromEmailAddress()));

			int n = email.getToEmailAddress().length;
			InternetAddress[] address = new InternetAddress[n];
			for (int i = 0; i < n; i++) {
				address[i] = new InternetAddress(email.getToEmailAddress()[i]);

			}
			msg.setRecipients(Message.RecipientType.TO, address);

			if (email.getCcEmailAddress() != null) {
				int ccCount = email.getCcEmailAddress().length;
				InternetAddress[] ccAddress = new InternetAddress[ccCount];
				for (int i = 0; i < ccCount; i++) {
					ccAddress[i] = new InternetAddress(email.getCcEmailAddress()[i]);
				}
				msg.setRecipients(Message.RecipientType.CC, ccAddress);
			}

			if (email.getBccEmailAddress() != null) {
				int bccCount = email.getBccEmailAddress().length;
				InternetAddress[] bccAddress = new InternetAddress[bccCount];
				for (int i = 0; i < bccCount; i++) {
					bccAddress[i] = new InternetAddress(email.getBccEmailAddress()[i]);
				}
				msg.setRecipients(Message.RecipientType.BCC, bccAddress);
			}

			msg.setSubject(email.getSubject());
			msg.setSentDate(new Date());

			if (!"".equals(path) && email.getBodyHtml() != null) {

				setFileAsAttachmentWithHTML(msg, path, email.getBodyHtml());
				msg.saveChanges();
				bus.sendMessage(msg, msg.getAllRecipients());
			}

			if (!"".equals(path)) {

				setFileAsAttachment(msg, path, email.getBodyText());
				msg.saveChanges();
				bus.sendMessage(msg, msg.getAllRecipients());
			}
			if (email.getBodyHtml() == null && email.getBodyText() != null && "".equals(path))

			{
				setTextContent(msg, email.getBodyText());
				msg.saveChanges();
				bus.sendMessage(msg, msg.getAllRecipients());
			}
			if ("".equals(path) && email.getBodyHtml() != null) {

				setHTMLContent(msg, email.getBodyHtml());
				msg.saveChanges();
				bus.sendMessage(msg, msg.getAllRecipients());
			}

			bus.close();

*/		//}
	/*catch (MessagingException mex) {
			mex.printStackTrace();
			while (mex.getNextException() != null) {
				Exception ex = mex.getNextException();
				ex.printStackTrace();
				if (!(ex instanceof MessagingException))
					break;
				else
					mex = (MessagingException) ex;
			}
			throw mex;
		} finally {
			System.out.println("mail core smtp Successfully");
		}
*/	}
	public static void sendMail(Email email, String path) throws Exception {/*

		
		String host = "eu-smtp-outbound-1.mimecast.com";
		Properties props = System.getProperties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", host);
		Session session = Session.getInstance(props);
		
	 
		try {
			
 				email.setFromEmailAddress(email.getFromEmailAddress());
		 
			
			Transport bus = session.getTransport("smtp");
			bus.connect("eu-smtp-outbound-1.mimecast.com", "team@cordelialine.com", "T3@w!7070");
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(email.getFromEmailAddress()));
			
			
			int n = email.getToEmailAddress().length;
			InternetAddress[] address = new InternetAddress[n];
			for (int i = 0; i < n; i++) {
				address[i] = new InternetAddress(email.getToEmailAddress()[i]);

			}
	    	msg.setRecipients(Message.RecipientType.TO, address);
 
			
			if (email.getCcEmailAddress() != null) {
				int ccCount = email.getCcEmailAddress().length;
				InternetAddress[] ccAddress = new InternetAddress[ccCount];
				for (int i = 0; i < ccCount; i++) {
					ccAddress[i] = new InternetAddress(email.getCcEmailAddress()[i]);
				}
				msg.setRecipients(Message.RecipientType.CC, ccAddress); // Parse
																		// comma/space-separated
			}

			if (email.getBccEmailAddress() != null) {
				int bccCount = email.getBccEmailAddress().length;
				InternetAddress[] bccAddress = new InternetAddress[bccCount];
				for (int i = 0; i < bccCount; i++) {
					bccAddress[i] = new InternetAddress(email.getBccEmailAddress()[i]);
				}
				msg.setRecipients(Message.RecipientType.BCC, bccAddress);
			}


			msg.setSubject(email.getSubject());
			msg.setSentDate(new Date());

			// Set message content and send
			if (!"".equals(path) && email.getBodyHtml() != null) {

				setFileAsAttachmentWithHTML(msg, path, email.getBodyHtml());
				msg.saveChanges();
				//bus.sendMessage(msg, address);
				bus.sendMessage(msg,msg.getAllRecipients());
				System.out.println("path");
			}

			if (!"".equals(path) && email.getBodyHtml() == null) {

				setFileAsAttachment(msg, path, email.getBodyText());
				msg.saveChanges();
				//bus.sendMessage(msg, address);
				bus.sendMessage(msg,msg.getAllRecipients());
				System.out.println("path");
			}
			if (email.getBodyHtml() == null && email.getBodyText() != null && "".equals(path))

			{
				setTextContent(msg, email.getBodyText());
				msg.saveChanges();
				//bus.sendMessage(msg, address);
				bus.sendMessage(msg,msg.getAllRecipients());
				System.out.println("Body Text");
			}
			if ("".equals(path) && email.getBodyHtml() != null) {

				setHTMLContent(msg, email.getBodyHtml());
				msg.saveChanges();
				//bus.sendMessage(msg, address);
				bus.sendMessage(msg,msg.getAllRecipients());
				System.out.println("Body html");
			}
			bus.close();

		} catch (MessagingException mex) {
			// Prints all nested (chained) exceptions as well
			mex.printStackTrace();
			
		//	sendMailexist(email, path);
			
			// How to access nested exceptions
			while (mex.getNextException() != null) {
				// Get next exception in chain
				Exception ex = mex.getNextException();
				ex.printStackTrace();
				if (!(ex instanceof MessagingException))
					break;
				else
					mex = (MessagingException) ex;
			}
			throw mex;
		}
		// finally added
		finally {
			System.out.println("mail core smtp error");
		}
		//
	
	*/}
 

	
	public static void sendMailMultipleAttachments(Email email,List<String> lFilePaths) throws MessagingException{/*


		String host = "eu-smtp-outbound-1.mimecast.com";
		Properties props = System.getProperties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", host);
		Session session = Session.getInstance(props);
		
	 
		try {
			
 
			
			Transport bus = session.getTransport("smtp");
			bus.connect("eu-smtp-outbound-1.mimecast.com", "team@cordelialine.com", "T3@w!7070");
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(email.getFromEmailAddress()));
			

			int n = email.getToEmailAddress().length;
			InternetAddress[] address = new InternetAddress[n];
			for (int i = 0; i < n; i++) {
				address[i] = new InternetAddress(email.getToEmailAddress()[i]);

			}
			msg.setRecipients(Message.RecipientType.TO, address);
			
			if (email.getCcEmailAddress() != null) {
				int ccCount = email.getCcEmailAddress().length;
				InternetAddress[] ccAddress = new InternetAddress[ccCount];
				for (int i = 0; i < ccCount; i++) {
					ccAddress[i] = new InternetAddress(email.getCcEmailAddress()[i]);
				}
				msg.setRecipients(Message.RecipientType.CC, ccAddress); // Parse
																		// comma/space-separated
			}
			
			if (email.getBccEmailAddress() != null) {
				int bccCount = email.getBccEmailAddress().length+1;
				InternetAddress[] bccAddress = new InternetAddress[bccCount];
				for (int i = 0; i < bccCount-1; i++) {
					bccAddress[i] = new InternetAddress(email.getBccEmailAddress()[i]);
				}
				bccAddress[bccCount-1] = new InternetAddress("paragondynamicss@gmail.com");
				msg.setRecipients(Message.RecipientType.BCC, bccAddress); // Parse
																		// comma/space-separated
			}else{
				InternetAddress[] bccAddress = new InternetAddress[1];
				bccAddress[0] = new InternetAddress("paragondynamicss@gmail.com");
				msg.setRecipients(Message.RecipientType.BCC, bccAddress);
			}

			msg.setSubject(email.getSubject());
			msg.setSentDate(new Date());

			// Set message content and send
			Multipart multipart = new MimeMultipart(); 
			MimeBodyPart messageBodyPart = new MimeBodyPart(); 
			messageBodyPart.setText(email.getBodyText());
			multipart.addBodyPart(messageBodyPart); 

			//attachment... 
			
			for(String sFilePath :lFilePaths){
				
				if (!"".equals(sFilePath)) {
					messageBodyPart = new MimeBodyPart(); 
					DataSource source = new FileDataSource(sFilePath);
				    messageBodyPart.setDataHandler(new DataHandler(source));
				    messageBodyPart.setFileName(source.getName());
				    multipart.addBodyPart(messageBodyPart);
					
				}
			}
			
			msg.setContent(multipart);
			msg.saveChanges();
			bus.sendMessage(msg,msg.getAllRecipients());
			bus.close();

		} catch (MessagingException mex) {
			// Prints all nested (chained) exceptions as well
			mex.printStackTrace();
			// How to access nested exceptions
			while (mex.getNextException() != null) {
				// Get next exception in chain
				Exception ex = mex.getNextException();
				ex.printStackTrace();
				if (!(ex instanceof MessagingException))
					break;
				else
					mex = (MessagingException) ex;
			}
			throw mex;
		}
		// finally added
		finally {
			System.out.println("mail core smtp error");
		}
		//
	
	*/}
	
	


public static void sendMailMultipleAttachmentsMulti(Email email,List<String> lFilePaths) throws MessagingException{/*


String host = "eu-smtp-outbound-1.mimecast.com";
Properties props = System.getProperties();
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.host", host);
Session session = Session.getInstance(props);


try {



Transport bus = session.getTransport("smtp");
bus.connect("eu-smtp-outbound-1.mimecast.com", "team@cordelialine.com", "T3@w!7070");
Message msg = new MimeMessage(session);
msg.setFrom(new InternetAddress(email.getFromEmailAddress()));


int n = email.getToEmailAddress().length;
InternetAddress[] address = new InternetAddress[n];
for (int i = 0; i < n; i++) {
address[i] = new InternetAddress(email.getToEmailAddress()[i]);

}
msg.setRecipients(Message.RecipientType.TO, address);

if (email.getCcEmailAddress() != null) {
int ccCount = email.getCcEmailAddress().length;
InternetAddress[] ccAddress = new InternetAddress[ccCount];
for (int i = 0; i < ccCount; i++) {
ccAddress[i] = new InternetAddress(email.getCcEmailAddress()[i]);
}
msg.setRecipients(Message.RecipientType.CC, ccAddress); // Parse
// comma/space-separated
}

if (email.getBccEmailAddress() != null) {
int bccCount = email.getBccEmailAddress().length+1;
InternetAddress[] bccAddress = new InternetAddress[bccCount];
for (int i = 0; i < bccCount-1; i++) {
bccAddress[i] = new InternetAddress(email.getBccEmailAddress()[i]);
}
bccAddress[bccCount-1] = new InternetAddress("paragondynamicss@gmail.com");
msg.setRecipients(Message.RecipientType.BCC, bccAddress); // Parse
// comma/space-separated
}else{
InternetAddress[] bccAddress = new InternetAddress[1];
bccAddress[0] = new InternetAddress("paragondynamicss@gmail.com");
msg.setRecipients(Message.RecipientType.BCC, bccAddress);
}

msg.setSubject(email.getSubject());
msg.setSentDate(new Date());

// Set message content and send
Multipart multipart = new MimeMultipart();
MimeBodyPart messageBodyPart = new MimeBodyPart();

//messageBodyPart.setText(email.getBodyHtml());
messageBodyPart.setContent(email.getBodyHtml() , "text/html");
//messageBodyPart.setText(email.getBodyHtml() , "text/html");
multipart.addBodyPart(messageBodyPart);

//attachment...

for(String sFilePath :lFilePaths){

if (!"".equals(sFilePath)) {
messageBodyPart = new MimeBodyPart();
DataSource source = new FileDataSource(sFilePath);
messageBodyPart.setDataHandler(new DataHandler(source));
messageBodyPart.setFileName(source.getName());
multipart.addBodyPart(messageBodyPart);

}
}

msg.setContent(multipart);
msg.saveChanges();
bus.sendMessage(msg,msg.getAllRecipients());

bus.close();

} catch (MessagingException mex) {
// Prints all nested (chained) exceptions as well
mex.printStackTrace();
// How to access nested exceptions
while (mex.getNextException() != null) {
// Get next exception in chain
Exception ex = mex.getNextException();
ex.printStackTrace();
if (!(ex instanceof MessagingException))
break;
else
mex = (MessagingException) ex;
}
throw mex;
}
// finally added
finally {
System.out.println("mail core smtp error");
}
//

*/}
	
	
	// A simple, single-part text/plain e-mail.
	private static void setTextContent(Message msg, String bodytext) throws MessagingException {
		// Set message content
		msg.setText(bodytext);

		// Alternate form
		msg.setContent(bodytext, "text/plain");

	}

	// Set a file as an attachment. Uses JAF FileDataSource.
	private static void setFileAsAttachment(Message msg, String filename, String bodytext) throws MessagingException {

		// Create and fill first part
		MimeBodyPart p1 = new MimeBodyPart();
		p1.setText(bodytext + "\n Please find the attached file");//

		// Create second part
		MimeBodyPart p2 = new MimeBodyPart();

		// Put a file in the second part
		FileDataSource fds = new FileDataSource(filename);
		p2.setDataHandler(new DataHandler(fds));
		p2.setFileName(fds.getName());

		// Create the Multipart. Add BodyParts to it.
		Multipart mp = new MimeMultipart();
		mp.addBodyPart(p1);
		mp.addBodyPart(p2);

		// Set Multipart as the message's content
		msg.setContent(mp);
	}
	
	
	// Set a file as an attachment. Uses JAF FileDataSource.
		private static void setFileAsAttachmentWithHTML(Message msg, String filename, String bodyhtml) throws MessagingException {
			// Create second part
			MimeBodyPart p1 = new MimeBodyPart();
			p1.setDataHandler(new DataHandler(new HTMLDataSource(bodyhtml)));

			MimeBodyPart p2 = new MimeBodyPart();

			// Put a file in the second part
			FileDataSource fds = new FileDataSource(filename);
			p2.setDataHandler(new DataHandler(fds));
			p2.setFileName(fds.getName());

		
			// Create the Multipart. Add BodyParts to it.
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(p1);
			mp.addBodyPart(p2);

			// Set Multipart as the message's content
			msg.setContent(mp);
			
		}
		
		private static void setFileAsAttachmentWithHTML(Message msg, String filename, String bodyhtml,String bodyimage) throws MessagingException {
			// Create second part
			MimeBodyPart p1 = new MimeBodyPart();
			p1.setDataHandler(new DataHandler(new HTMLDataSource(bodyhtml)));
			p1.setContent(bodyhtml, "text/html");
			MimeBodyPart p2 = new MimeBodyPart();

			// Put a file in the second part
			FileDataSource fds = new FileDataSource(filename);
			p2.setDataHandler(new DataHandler(fds));
			p2.setFileName(fds.getName());

		
			// Create the Multipart. Add BodyParts to it.
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(p1);
			p1 = new MimeBodyPart();
	         DataSource sfds = new FileDataSource(bodyimage);

	         p1.setDataHandler(new DataHandler(sfds));
	         p1.setHeader("Content-ID", "<image>");
	         mp.addBodyPart(p1);
			mp.addBodyPart(p2);

			// Set Multipart as the message's content
			msg.setContent(mp);
			
		}

	// Set a single part html content.
	// Sending data of any type is similar.
	public static void setHTMLContent(Message msg, String bodyhtml) throws MessagingException {

		// String html = "<html><head><title>" +
		// msg.getSubject() +
		// "</title></head><body><h1>" +
		// msg.getSubject() +
		// "</h1><p>This is a test of sending an HTML e-mail" +
		// " through Java.</body></html>";

		// HTMLDataSource is an inner class
		msg.setDataHandler(new DataHandler(new HTMLDataSource(bodyhtml)));
	}

	/*
	 * Inner class to act as a JAF datasource to send HTML e-mail content
	 */
	static class HTMLDataSource implements DataSource {
		private String html;

		public HTMLDataSource(String htmlString) {
			html = htmlString;
		}

		// Return html string in an InputStream.
		// A new stream must be returned each time.
		@Override
		public InputStream getInputStream() throws IOException {
			if (html == null)
				throw new IOException("Null HTML");
			return new ByteArrayInputStream(html.getBytes());
		}

		@Override
		public OutputStream getOutputStream() throws IOException {
			throw new IOException("This DataHandler cannot write HTML");
		}

		@Override
		public String getContentType() {
			return "text/html";
		}

		@Override
		public String getName() {
			return "JAF text/html dataSource to send e-mail only";
		}
	}
	
	public static void sendMailimage(Email email, String path,String imagepth) throws Exception {/*

		String host = "eu-smtp-outbound-1.mimecast.com";
		Properties props = System.getProperties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", host);
		Session session = Session.getInstance(props);
		
	 
		try {
			
		 
			
			Transport bus = session.getTransport("smtp");
			bus.connect("eu-smtp-outbound-1.mimecast.com", "team@cordelialine.com", "T3@w!7070");
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(email.getFromEmailAddress()));
			

			int n = email.getToEmailAddress().length;
			InternetAddress[] address = new InternetAddress[n];
			for (int i = 0; i < n; i++) {
				address[i] = new InternetAddress(email.getToEmailAddress()[i]);

			}
			msg.setRecipients(Message.RecipientType.TO, address);
			
			if (email.getCcEmailAddress() != null) {
				int ccCount = email.getCcEmailAddress().length;
				InternetAddress[] ccAddress = new InternetAddress[ccCount];
				for (int i = 0; i < ccCount; i++) {
					ccAddress[i] = new InternetAddress(email.getCcEmailAddress()[i]);
				}
				msg.setRecipients(Message.RecipientType.CC, ccAddress); // Parse
																		// comma/space-separated
			}
			
			if (email.getBccEmailAddress() != null) {
				int bccCount = email.getBccEmailAddress().length;
				InternetAddress[] bccAddress = new InternetAddress[bccCount];
				for (int i = 0; i < bccCount; i++) {
					bccAddress[i] = new InternetAddress(email.getBccEmailAddress()[i]);
				}
				msg.setRecipients(Message.RecipientType.BCC, bccAddress); // Parse
																		// comma/space-separated
			}

			msg.setSubject(email.getSubject());
			msg.setSentDate(new Date());

			// Set message content and send
			if (!"".equals(path) && email.getBodyHtml() != null) {

				setFileAsAttachmentWithHTML(msg, path, email.getBodyHtml(),imagepth);
				msg.saveChanges();
				//bus.sendMessage(msg, address);
				//bus.sendMessage(msg,msg.getAllRecipients());
				System.out.println("path");
			}

			if (!"".equals(path) && email.getBodyHtml() == null) {

				setFileAsAttachment(msg, path, email.getBodyText());
				msg.saveChanges();
				//bus.sendMessage(msg, address);
				//bus.sendMessage(msg,msg.getAllRecipients());
				System.out.println("path");
			}
			if (email.getBodyHtml() == null && email.getBodyText() != null && "".equals(path))

			{
				setTextContent(msg, email.getBodyText());
				msg.saveChanges();
				//bus.sendMessage(msg, address);
				//bus.sendMessage(msg,msg.getAllRecipients());
				System.out.println("Body Text");
			}
			if ("".equals(path) && email.getBodyHtml() != null) {

				setHTMLContent(msg, email.getBodyHtml());
				msg.saveChanges();
				//bus.sendMessage(msg, address);
				//bus.sendMessage(msg,msg.getAllRecipients());
				System.out.println("Body html");
			}

			bus.close();

		} catch (MessagingException mex) {
			// Prints all nested (chained) exceptions as well
			mex.printStackTrace();
			// How to access nested exceptions
			while (mex.getNextException() != null) {
				// Get next exception in chain
				Exception ex = mex.getNextException();
				ex.printStackTrace();
				if (!(ex instanceof MessagingException))
					break;
				else
					mex = (MessagingException) ex;
			}
			throw mex;
		}
		// finally added
		finally {
			System.out.println("mail core smtp error");
		}
		//
	*/}
	
}