package util;


import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class Email{
    public static void enviarEmail(String to, String subject, String content){
        try{
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "boot001.unmsm@gmail.com");
            props.setProperty("mail.smtp.auth", "true");
            System.out.println("Se establecieron las propiedades del correo");
            Session session = Session.getDefaultInstance(props, null);
            // session.setDebug(true);
            System.out.println("Se inicio sesion");
            // Se compone la parte del texto
            BodyPart texto = new MimeBodyPart();
            texto.setText(content);
            System.out.println("Se instancio la parte texto del email");
            // Se compone el adjunto

            // Una MultiParte para agrupar texto e imagen.
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            System.out.println("Se compacto las partes");
          
            // Se compone el correo, dando to, from, subject y el
            // contenido.
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("boot001.unmsm@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setContent(multiParte);
            System.out.println("Se agregaron las partes al email");
            // Se envia el correo.
            Transport t = session.getTransport("smtp");
            t.connect("boot001.unmsm@gmail.com", "123gdewey");
            t.sendMessage(message, message.getAllRecipients());
            t.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "El correo no se puedo enviar");
            
        }
    }
    
    
}
