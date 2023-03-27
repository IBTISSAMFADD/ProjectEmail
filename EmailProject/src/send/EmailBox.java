package send;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailBox extends JFrame {

    private JTextArea messageArea;

    public EmailBox() {
        setTitle("Email Client");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        messageArea = new JTextArea();
        add(new JScrollPane(messageArea));

        String host = "imap.gmail.com"; // Le nom d'hôte du serveur IMAP
        String username = "ibtissamfaddouli45@gmail.com"; // Votre nom d'utilisateur de messagerie électronique
        String password = "jwyjdpknyligwuhf"; // Votre mot de passe de messagerie électronique

        try {
            Properties props = new Properties();
            props.put("mail.imap.host", host);
            props.put("mail.imap.port", "993");
            props.put("mail.imap.starttls.enable", "true");
            Session session = Session.getDefaultInstance(props);

            Store store = session.getStore("imaps");
            store.connect(host, username, password);

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            if (inbox.getMessageCount() == 0) {
                messageArea.append("La boîte de réception est vide.");
            } else {
                Message[] messages = inbox.getMessages();
                for (int i = 0; i < messages.length; i++) {
                    messageArea.append("From: " + messages[i].getFrom()[0] + "\n");
                    messageArea.append("Subject: " + messages[i].getSubject() + "\n");
                    messageArea.append("Sent Date: " + messages[i].getSentDate() + "\n");
                    messageArea.append("Message: " + messages[i].getContent() + "\n\n");
                }
            }

            inbox.close(false);
            store.close();
        } catch (MessagingException ex) {
            messageArea.append("Erreur lors de la connexion : " + ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
      EmailBox client = new EmailBox();
        client.setVisible(true);
    }
}

