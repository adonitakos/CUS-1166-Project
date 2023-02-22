
/* Project: Vehicle Vortex
* Class: OptionPage.java
* Author: Summer Snyder, Antonios Takos, Teuta Elezaj, Christian Felix, Tahir Buksh, Jayden Kuprel
* Date: February 19th, 2023 
* This program creates an option page, where users will be able to decide
* if they would like to submit a car or a job.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class OptionPage extends JFrame implements ActionListener {
   // Initializing Java Swing Variables
   JPanel clientUser;
   JButton owner;
   JButton client;

   final JTextField welcomeLabelText, ownerText, clientTextField,clientUserTextField;

   // ---------------------------------------------------------------------------------
   // This method creates the GUI for the optionPage
   OptionPage() {
      // Assigning JSwing variables values & styling

      // Welcome Label
      JLabel welcomeLabel = new JLabel("Welcome to Vehicle Vortex. Would you like to submit a Car or a Job?");
      welcomeLabel.setForeground(Color.WHITE);
      welcomeLabel.setFont(new Font("Inter", Font.PLAIN, 20));
      welcomeLabelText = new JTextField(15);
      welcomeLabelText.add(welcomeLabel);
      welcomeLabel.setForeground(Color.WHITE);
      welcomeLabel.setFont(new Font("Inter", Font.BOLD, 30));
      welcomeLabel.setBackground(new Color(217, 217, 217));
      welcomeLabel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(86, 53, 158)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

      // Owner button
      owner = new JButton("Car");
      owner.setBackground(new Color(217, 217, 217));
      owner.setForeground(new Color(86, 53, 158));
      owner.setFont(new Font("Inter", Font.BOLD, 20));
      ownerText = new JTextField(15);
      ownerText.add(owner);
      ownerText.setBackground(new Color(217, 217, 217));
      ownerText.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(86, 53, 158)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

      // Client button
      client = new JButton("Job");
      client.setBackground(new Color(217, 217, 217));
      client.setForeground(new Color(86, 53, 158));
      client.setFont(new Font("Inter", Font.BOLD, 20));
      clientTextField = new JTextField(15);
      clientTextField.add(client);
      clientTextField.setBackground(new Color(217, 217, 217));
      clientTextField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(86, 53, 158)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

      // Adoni's NOTE: Make these buttons on different rows, make them bigger (at
      // least wider), and make any adjustments you feel are right

      // Creating new panel
      clientUser = new JPanel();
      clientUser.setBackground(new Color(86, 53, 158));
      client.setLayout(null);
      clientUserTextField = new JTextField(15);
      clientUserTextField.add(clientUser);
      clientUserTextField.setBackground(new Color(217, 217, 217));
      clientUserTextField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(86, 53, 158)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

      // Adding variables to the panel
      clientUser.add(welcomeLabel);
      clientUser.add(owner);
      clientUser.add(client);
      add(clientUser, BorderLayout.CENTER);

      // Creating action listeners for the two buttons
      owner.addActionListener(this);
      client.addActionListener(this);

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("Welcome");
      setSize(1000, 800);
   } // <--- optionPage() constructor ends here

   // ---------------------------------------------------------------------------------
   // Action Listener method
   public void actionPerformed(ActionEvent e) {
      // Finding the source of the action and assigning it to an object variable
      Object obj = e.getSource();

      // IF the "car" button was pressed, it will take them to the ownerPage
      if (obj == owner) {
         OwnerWindow ownerPage = new OwnerWindow();
         ownerPage.setVisible(true);
         ownerPage.setSize(700,500);
      }
      // IF the "job" button was pressed, it will take them to the clientPage
      else if (obj == client) {
         ClientWindow clientWindow = new ClientWindow();
         clientWindow.setVisible(true);
         clientWindow.setSize(700,500);
      } else {
         System.out.println("error");
      }
   } // <--- actionPerformed() method ends here

} // <--- OptionPage{} class ends here
