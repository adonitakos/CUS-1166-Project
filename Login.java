
/* Project: Vehicle Vortex
* Class: Login.java 
* Author: Summer Snyder, Antonios Takos, Teuta Elezaj, Christian Felix, Tahir Buksh, Jayden Kuprel
* Date: February 19th, 2023 
* This program creates a login page, where users are able to enter their credentials,
* where they will gain access to Vehicle Vortex.
*/ 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

class CreateLoginForm extends JFrame implements ActionListener {
// Initializing Java Swing Variables
    JLabel banner;
    JButton submit;
    JPanel loginPanel;
    JLabel userLabel, passwordLabel;
    final JTextField userField, passwordField;

// ---------------------------------------------------------------------------------
// This method creates the GUI for the Login form
    CreateLoginForm() {

    // Assigning JSwing variables values & styling

        // Banner
        banner = new JLabel();
        banner.setText("Login");
        banner.setBounds(115, 30, 100, 40);
        banner.setForeground(Color.WHITE);
        banner.setFont(new Font("Inter", Font.BOLD, 30));

        // User Label
        userLabel = new JLabel();
        userLabel.setText("Username");
        userLabel.setBounds(44, 100, 100, 16);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Inter", Font.BOLD, 16));

        // User Field
        userField = new JTextField(15);
        userField.setBounds(37, 128, 249, 38);
        userField.setBackground(new Color(217, 217, 217));
        userField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(86, 53, 158)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Password Label
        passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordLabel.setBounds(44, 170, 100, 16);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Inter", Font.BOLD, 16));

        // Password Field
        passwordField = new JPasswordField(15);
        passwordField.setBounds(37, 198, 249, 38);
        passwordField.setBackground(new Color(217, 217, 217));
        passwordField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(86, 53, 158)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Submit
        submit = new JButton("Submit");
        submit.setBounds(110, 270, 100, 34);
        submit.setBackground(new Color(217, 217, 217));
        submit.setForeground(new Color(86, 53, 158));
        submit.setFont(new Font("Inter", Font.BOLD, 16));
        

    // Creating a new Panel
        loginPanel = new JPanel();
        loginPanel.setBackground(new Color(86, 53, 158));
        loginPanel.setLayout(null);

    // Adding variables to 
        loginPanel.add(banner);
        loginPanel.add(userLabel);
        loginPanel.add(userField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(submit);
        add(loginPanel, BorderLayout.CENTER);

    // Creating action listener for the submit button
        submit.addActionListener(this);
        setTitle("Login Form");

    } // <--- CreateLoginForm() constructor ends here

// ---------------------------------------------------------------------------------
// Action listener method for the submit button
    public void actionPerformed(ActionEvent ae) {
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
            
            writer.write(userValue + ":" + passValue + ":" + timestamp.toString() + System.lineSeparator()); // add newline character
            writer.close();
            System.out.println("Credentials successfully saved to file!");

            // Show the option page if credentials are in line with rules
            OptionPage page = new OptionPage();
            page.setVisible(true);
        } catch (IOException e) {
            System.out.println("Error writing credentials to file.");
        }
    } // <--- actionPerformed() method ends here
} // <--- CreateLoginForm{} class ends here

class Login {
    public static void main(String[] args) {
        System.out.println("\n========= Login =========\n");
        try {
            CreateLoginForm form = new CreateLoginForm();
            // form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            form.setSize(323, 393);
            form.setVisible(true);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    } // <--- main() method ends here
} // <--- Login{} class ends here