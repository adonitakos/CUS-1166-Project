
/*  Project: Vehicle Vortex
*   Class: Signup.java 
*   Author: Summer Snyder, Antonios Takos, Teuta Elezaj, Christian Felix, Tahir Buksh, Jayden Kuprel
*   Date: February 19th, 2023 
*   This program creates a signup page, where users are able to enter their credentials,
*   where they will gain access to Vehicle Vortex.
*/ 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.time.LocalDateTime;
import java.awt.event.ActionListener;
import java.io.*;

class CreateSignupForm extends JFrame implements ActionListener {
// Initializing Java Swing Variables
    JButton submit, back;
    JPanel signupPanel, buttonPanel;
    JLabel signupLabel, userLabel, passwordLabel, infoLabel;
    final JTextField userField, passwordField;

// ---------------------------------------------------------------------------------
// This method creates the GUI for the sign up form
CreateSignupForm() {
    // Assigning JSwing variables values & styling

    // sign up Label
    signupLabel = new JLabel();
    signupLabel.setText("Sign Up");
    signupLabel.setForeground(Color.WHITE);
    signupLabel.setFont(new Font("Inter", Font.BOLD, 23));
    Dimension size = signupLabel.getPreferredSize();
    signupLabel.setBounds(130, 30, size.width, size.height);

    // Info Label
    infoLabel = new JLabel();
    infoLabel.setText("<html><center>Thanks for choosing Vehicle Vortex! To sign up, please enter your desired username and password. Each field must be at least 5 characters long, and your password must contain at least one special character.</center></html>");
    infoLabel.setFont(new Font("Inter", Font.PLAIN, 15));
    infoLabel.setBounds(20, 80, 320, 60);
    infoLabel.setForeground(Color.WHITE);
    infoLabel.setFont(new Font("Inter", Font.PLAIN, 12));

    // User Label
    userLabel = new JLabel();
    userLabel.setText("Username");
    userLabel.setBounds(44, 170, 100, 16);
    userLabel.setForeground(Color.WHITE);
    userLabel.setFont(new Font("Inter", Font.BOLD, 16));

    // User Field
    userField = new JTextField(15);
    userField.setBounds(37, 198, 249, 38);
    userField.setBackground(new Color(217, 217, 217));
    userField.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(86, 53, 158)),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));

    // Password Label
    passwordLabel = new JLabel();
    passwordLabel.setText("Password");
    passwordLabel.setBounds(44, 250, 100, 16);
    passwordLabel.setForeground(Color.WHITE);
    passwordLabel.setFont(new Font("Inter", Font.BOLD, 16));

    // Password Field
    passwordField = new JPasswordField(15);
    passwordField.setBounds(37, 278, 249, 38);
    passwordField.setBackground(new Color(217, 217, 217));
    passwordField.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(86, 53, 158)),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));

    // Submit
    submit = new JButton("Submit");
    submit.setBounds(125, 350, 100, 34);
    submit.setBackground(new Color(217, 217, 217));
    submit.setForeground(new Color(86, 53, 158));
    submit.setFont(new Font("Inter", Font.BOLD, 16));

    // Back
    back = new JButton("Back");
    back.setBounds(110, 350, 100, 34);
    back.setBackground(new Color(217, 217, 217));
    back.setForeground(new Color(86, 53, 158));
    back.setFont(new Font("Inter", Font.BOLD, 16));

    // Creating a new Panel
    JPanel signupPanel = new JPanel();
    // signupPanel.setPreferredSize(new Dimension(700, 700));
    signupPanel.setBackground(new Color(86, 53, 158));
    signupPanel.setLayout(null);

    // Adding variables to
    signupPanel.add(signupLabel);
    signupPanel.add(infoLabel);
    signupPanel.add(userLabel);
    signupPanel.add(userField);
    signupPanel.add(passwordLabel);
    signupPanel.add(passwordField);
    signupPanel.add(submit);
    add(signupPanel, BorderLayout.CENTER);

    buttonPanel = new JPanel();
      buttonPanel.add(back);
      add(buttonPanel, BorderLayout.SOUTH);

    // Creating action listener for the submit button
    submit.addActionListener(this);
    back.addActionListener(this);
    setTitle("Sign up Form");
    // setPreferredSize(new Dimension(800, 200));
    signupPanel.setPreferredSize(new Dimension(600, 700));
    pack();
}

// ---------------------------------------------------------------------------------
// Action listener method for the submit button
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();

        if (obj == submit) {
        // Assigning the information that will be inputted by the user as string variables
            String userValue = userField.getText();
            String passValue = passwordField.getText();

            // validating username and password based on rules - username must be greater than 5, and password must be at least 5 characters and contain one special character.
            if (userValue.length() <= 5) {
                System.out.println("ERROR: Username must be greater than 5 characters long.");
                return;
            }
            if (!passValue.matches("^(?=.*[!@#$%^&*(),.?\":{}|<>]).{5,}$")) {
                System.out.println("ERROR: Password must be at least 5 characters long and contain at least one special character.");
                return;
            }

            // Write the user-provided credentials to a file
            try {
                FileWriter writer = new FileWriter("Credentials.txt", true);
                LocalDateTime timestamp = LocalDateTime.now();
                
                writer.write("Username: " + userValue + " | Password: " + passValue + " | Timestamp: " + timestamp.toString() + System.lineSeparator()); // add newline character
                writer.close();
                System.out.println("Credentials successfully saved to file!");

                // Show the option page if credentials are in line with rules
                OptionPage page = new OptionPage();
                page.setVisible(true);

                // dispose of sign up page once credentials are valid
                dispose();
            } catch (IOException e) {
                System.out.println("Error writing credentials to file.");
            }
        } // <--- if(obj==submit) statment ends here

        else if (obj == back) {
            dispose();
            CreateLoginForm form = new CreateLoginForm();
            form.setSize(323, 393);
            form.setVisible(true);
        }
    } // <--- actionPerformed() method ends here
} // <--- CreateSignupForm{} class ends here

class Signup {
    public static void main(String[] args) {
        System.out.println("\n========= Signup =========\n");
        try {
            CreateSignupForm form = new CreateSignupForm();
            // form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            form.setSize(355, 490);
            form.setVisible(true);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    } // <--- main() method ends here
} // <--- Signup{} class ends here


