/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mail;
import java.sql.Connection;
  import java.util.Properties;
 import java.sql.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
/**
 *
 * @author ABIRAMI
 */


 
public class Mailit { 
      
    public void SendMailto(String digit,String usernam){
       
        String toname=null;
    		final String username = "anbuinfo123@gmail.com";
		final String password = "anbuinfo123@";                
                try{
                   Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/watermark","root","root");
        PreparedStatement ps5=con.prepareStatement("select * from register where username='"+usernam+"'");
         ResultSet rs5=ps5.executeQuery();
         if(rs5.next()){
             ps5=con.prepareStatement("update register set otp='"+digit+"' where username='"+usernam+"'");
             ps5.executeUpdate();
          toname=rs5.getString("mail"); 
         }
                }catch(Exception ew){
                    JOptionPane.showMessageDialog(null,ew);   
                }
                
 JOptionPane.showMessageDialog(null,toname+"    "+digit);   
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
                props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
                    
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("kumaraa.well@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(toname));
			message.setSubject("Hai");
			message.setText("your otp code is "+digit);
 
			Transport.send(message);
                        
 
			System.out.println("Done");
                        
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
                      
		}    
	}

    
    
    
    
	public static void main(String[] args) {
 
		final String username = "kumaraa.well@gmail.com";
		final String password = "th1nkd1ff5r5nt";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("kumaraa.well@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("kumaraa.well@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}  

