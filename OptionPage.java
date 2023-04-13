
/* Project: Vehicle Vortex
*  Class: OptionPage.java
*  Author: Summer Snyder, Antonios Takos, Teuta Elezaj, Christian Felix, Tahir Buksh, Jayden Kuprel
*  Date: February 19th, 2023 
*  This program creates an option page, where users will be able to decide
*  if they would like to submit a car or a job.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

class OptionPage extends JFrame implements ActionListener {
   // Initializing Java Swing Variables
   private JPanel clientUser, buttonPanel;
   private JButton back;
   String[] options = { "", "Car", "Job" };
   private final JComboBox<String> optionBox = new JComboBox<String>(options);
   private JLabel aboutLabel;
   final JTextField welcomeLabelText, jobUserTextField, backText;
   private User user;

   public void setUser(User user) {
      this.user = user;
   }

   // ---------------------------------------------------------------------------------
   // This method creates the GUI for the optionPage
   OptionPage(User user) {
      // Assigning JSwing variables values & styling
      setUser(user);
      // Welcome Label
      JLabel welcomeLabel = new JLabel("Welcome to Vehicle Vortex.");
      welcomeLabel.setForeground(Color.WHITE);
      welcomeLabel.setFont(new Font("Inter", Font.PLAIN, 20));
      welcomeLabelText = new JTextField(15);
      welcomeLabelText.add(welcomeLabel);
      welcomeLabel.setForeground(Color.WHITE);
      welcomeLabel.setFont(new Font("Inter", Font.BOLD, 20));
      welcomeLabel.setBackground(new Color(217, 217, 217));
      welcomeLabel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(86, 53, 158)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

      // About Label
      aboutLabel = new JLabel();
      aboutLabel.setText(
            "<html>Vehicle Vortex is an application where car users and job users are able to connect in real time.<br/>Please select from the drop down menu:</html>");
      aboutLabel.setForeground(Color.WHITE);
      aboutLabel.setFont(new Font("Inter", Font.ITALIC, 12));

      // Option Box
      optionBox.setBackground(new Color(217, 217, 217));
      optionBox.setForeground(new Color(86, 53, 158));
      optionBox.setFont(new Font("Inter", Font.BOLD, 15));

      // Back button
      back = new JButton("Back");
      back.setBackground(new Color(217, 217, 217));
      back.setForeground(new Color(86, 53, 158));
      back.setFont(new Font("Inter", Font.BOLD, 20));
      backText = new JTextField(15);
      backText.add(back);
      backText.setBackground(new Color(217, 217, 217));
      backText.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(86, 53, 158)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

      // Adoni's NOTE: Make these buttons on different rows, make them bigger (at
      // least wider), and make any adjustments you feel are right

      // Creating new panel
      clientUser = new JPanel();
      clientUser.setBackground(new Color(86, 53, 158));
      jobUserTextField = new JTextField(15);
      jobUserTextField.add(clientUser);
      jobUserTextField.setBackground(new Color(217, 217, 217));
      jobUserTextField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(86, 53, 158)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

      // Adding variables to the panel
      clientUser.add(welcomeLabel);
      clientUser.add(aboutLabel);
      clientUser.add(optionBox);
      add(clientUser, BorderLayout.CENTER);

      // Button Panel
      buttonPanel = new JPanel();
      buttonPanel.add(back);
      add(buttonPanel, BorderLayout.SOUTH);

      // Creating action listeners for the two buttons
      back.addActionListener(this);
      optionBox.addActionListener(this);

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("Welcome");
      setSize(750, 500);
   } // <--- optionPage() constructor ends here

   // ---------------------------------------------------------------------------------
   // Action Listener method
   public void actionPerformed(ActionEvent e) {
      // Finding the source of the action and assigning it to an object variable
      Object obj = e.getSource();
      if (obj == optionBox) {
         // IF the "car" button was pressed, it will take them to the carPage
         if (optionBox.getSelectedItem().equals("Car")) {
            // dispose();
            CarPage page = new CarPage();
            page.start(user);
         }
         // IF the "job" button was pressed, it will take them to the jobPage
         else if (optionBox.getSelectedItem().equals("Job")) {
            // dispose();
            JobPage page = new JobPage();
            page.start(user);
         }
         // else if (optionBox.getSelectedItem().equals("Admin")) {
         // System.out.println("Congrats. You have chosen admin.");
         // }
      } else if (obj == back) {
         dispose();
         Login.main(null);
      } else {
         System.out.println("error");
      }
   } // <--- actionPerformed() method ends here

} // <--- OptionPage{} class ends here
