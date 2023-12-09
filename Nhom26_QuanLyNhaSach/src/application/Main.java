package application;


//import java.util.Properties;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;

import gui.splashScreen;

public class Main {
	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(splashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(splashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(splashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(splashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new splashScreen().setVisible(true);
            }
        });
	}

//	public static void sendEmail(String email, String messageTo) {
//		Properties props = new Properties();
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.port", 587);
//
//		// get Session
//		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication("nhom26nhasachtrithuc@gmail.com", "nhom26nstt");
//			}
//		});
//
//		// compose message
//		try {
//			MimeMessage message = new MimeMessage(session);
//			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
//			message.setSubject("Testing Subject");
//			message.setText(messageTo);
//
//			// send message
//			Transport.send(message);
//
//			System.out.println("Message sent successfully");
//		} catch (MessagingException e) {
//			throw new RuntimeException(e);
//		}
//
//	}

}