
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

class OptionPage extends JFrame implements ActionListener {
   // Initializing Java Swing Variables
   private JPanel clientUser;
   private JButton owner;
   private JButton job;
   private JButton back;

   final JTextField welcomeLabelText, ownerText, jobTextField, jobUserTextField, backText;

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

      // Job button
      job = new JButton("Job");
      job.setBackground(new Color(217, 217, 217));
      job.setForeground(new Color(86, 53, 158));
      job.setFont(new Font("Inter", Font.BOLD, 20));
      jobTextField = new JTextField(15);
      jobTextField.add(job);
      jobTextField.setBackground(new Color(217, 217, 217));
      jobTextField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(86, 53, 158)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

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
      job.setLayout(null);
      jobUserTextField = new JTextField(15);
      jobUserTextField.add(clientUser);
      jobUserTextField.setBackground(new Color(217, 217, 217));
      jobUserTextField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(86, 53, 158)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

      // Adding variables to the panel
      clientUser.add(welcomeLabel);
      clientUser.add(owner);
      clientUser.add(job);
      clientUser.add(back);
      add(clientUser, BorderLayout.CENTER);

      // Creating action listeners for the two buttons
      owner.addActionListener(this);
      job.addActionListener(this);
      back.addActionListener(this);

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("Welcome");
      setSize(1000, 800);
   } // <--- optionPage() constructor ends here

   // ---------------------------------------------------------------------------------
   // Action Listener method
   public void actionPerformed(ActionEvent e) {
      // Finding the source of the action and assigning it to an object variable
      Object obj = e.getSource();

      // IF the "car" button was pressed, it will take them to the carPage
      if (obj == owner) {
         dispose();
         Cars carPage = new Cars();
         carPage.setVisible(true);
         carPage.setSize(700,500);
      }
      // IF the "job" button was pressed, it will take them to the jobPage
      else if (obj == job) {
         dispose();
         Jobs jobWindow = new Jobs();
         jobWindow.setVisible(true);
         jobWindow.setSize(700,500);
      } 
      else if (obj == back) {
         dispose();
         CreateLoginForm form = new CreateLoginForm();
         form.setSize(323, 393);
         form.setVisible(true);
      }
      else {
         System.out.println("error");
      }
   } // <--- actionPerformed() method ends here

} // <--- OptionPage{} class ends here
