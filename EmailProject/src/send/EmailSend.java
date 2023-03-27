package send;

import java.awt.EventQueue;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
import java.awt.Color;

public class EmailSend extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFromEmail;
	private JTextField txtSubject;
	private JTextField txtToEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailSend frame = new EmailSend();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmailSend() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 610);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Send Email");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(65, 105, 225));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(151)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 811, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel_1 = new JLabel("To");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_1 = new JLabel("From");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Subject");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Message");
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		txtFromEmail = new JTextField();
		txtFromEmail.setText("ibtissamfaddouli1@gmail.com");
		txtFromEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		txtFromEmail.setColumns(10);
		
		txtSubject = new JTextField();
		txtSubject.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSubject.setColumns(10);
		
		txtToEmail = new JTextField();
		txtToEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		txtToEmail.setColumns(10);
		
		final JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("send");
		btnNewButton.addActionListener(new ActionListener() {
		
			    public void actionPerformed(ActionEvent e) {
			    	
			    try {
	
			        String toEmail = txtToEmail.getText();
			        final String fromEmail = txtFromEmail.getText();
			        final String fromEmailPassword = "Azerty123@@@";
			        Properties properties = new Properties();
			        properties.put("mail.smtp.auth", "true");
			        properties.put("mail.smtp.starttls.enable", "true");
			        properties.put("mail.smtp.host", "smtp.gmail.com");
			        properties.put("mail.smtp.password", "vhjwvgazjctshxbj");
			        properties.put("mail.smtp.port", "587");
			        
			      /*  properties.put("mail.smtp.user","username"); 
			        properties.put("mail.smtp.host", "smtp.gmail.com"); 
			        properties.put("mail.smtp.port", "25"); 
			        properties.put("mail.debug", "true"); 
			        properties.put("mail.smtp.auth", "true"); 
			        properties.put("mail.smtp.starttls.enable","true"); 
			        properties.put("mail.smtp.EnableSSL.enable","true");*/

			        
			        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			            protected PasswordAuthentication getPasswordAuthentication() {
			                return new PasswordAuthentication(fromEmail, fromEmailPassword);
			            }
			        });
			 
			            MimeMessage message = new MimeMessage(session);
			            message.setFrom(new InternetAddress(fromEmail));
			            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			            String subject = "Test email subject"; // set the subject here
			            message.setSubject(subject);
			            message.setText(textArea.getText()); // assuming 'textArea' is the name of the JTextArea object
			            Transport.send(message);
			            JOptionPane.showMessageDialog(null,"Sent");
			        } catch(Exception ex) {
			            System.out.println("Error sending email: " + ex.getMessage());
			        }
		                } 
			});

		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 765, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtFromEmail, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtToEmail, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtSubject, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(341)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtToEmail, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(51)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtFromEmail, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtSubject, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	
	}}

