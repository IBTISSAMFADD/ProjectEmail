package send;


import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class menu extends JFrame {

    public menu() {
        // Définir la taille de la fenêtre
        setSize(427, 203);

        // Définir le titre de la fenêtre
        setTitle("Application de messagerie");

        // Ajouter les composants à la fenêtre
        JPanel panel = 
        		new JPanel();
        panel.setBackground(new Color(65, 105, 225));
        panel.setPreferredSize(new Dimension(400, 150));
        panel.setFont(new Font("Arial", Font.BOLD, 12));
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 100, 30);
        panel.setLayout(flowLayout);

        JButton envoyer = new JButton("Envoyer");
        envoyer.setPreferredSize(new Dimension(200, 30));
        envoyer.setFont(new Font("Arial", Font.BOLD, 12));
        envoyer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	EmailSend formulaire = new EmailSend();
                formulaire.setVisible(true);
                // Fermer la fenêtre actuelle
                dispose();
            
            }
        });
        panel.add(envoyer);

        getContentPane().add(panel, BorderLayout.CENTER);
        
                
                JButton boiteReception = new JButton("Boîte de réception");
                boiteReception.setPreferredSize(new Dimension(200, 30));
                boiteReception.setFont(new Font("Arial", Font.BOLD, 12));
                
                   boiteReception.addActionListener(new ActionListener() {
                       public void actionPerformed(ActionEvent e) {
                       	EmailBox formulaire = new EmailBox();
                           formulaire.setVisible(true);
                           // Fermer la fenêtre actuelle
                           dispose();
                       }
                   });
                   
                           
                           panel.add(boiteReception);

        // Afficher la fenêtre
        setVisible(true);

        // Fermer l'application lorsque la fenêtre est fermée
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new menu();
    }
}
