/*  Project: Vehicle Vortex
*   Class: Login.java 
*   Author: Summer Snyder, Antonios Takos, Teuta Elezaj, Christian Felix, Tahir Buksh, Jayden Kuprel
*   Date: February 19th, 2023 
*   This program creates a login page, where users are able to enter their credentials,
*   where they will gain access to Vehicle Vortex.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.io.*;

class CreateLoginForm extends JFrame implements ActionListener {
    // Initializing Java Swing Variables
    JButton submit, signUpButton;
    JPanel loginPanel;
    JLabel loginLabel, userLabel, passwordLabel, signUpLabel;
    final JTextField userField, passwordField;

    // ---------------------------------------------------------------------------------
    // This method creates the GUI for the Login form
    CreateLoginForm() {

        // Assigning JSwing variables values & styling

        // Login Label
        loginLabel = new JLabel();
        loginLabel.setText("Login Form");
        loginLabel.setBounds(115, 30, 100, 40);
        loginLabel.setForeground(Color.WHITE);
        loginLabel.setFont(new Font("Inter", Font.BOLD, 30));
        Dimension size = loginLabel.getPreferredSize();
        loginLabel.setBounds(100, 30, size.width, size.height);

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
        passwordLabel.setBounds(44, 180, 100, 16);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Inter", Font.BOLD, 16));

        // Password Field
        passwordField = new JPasswordField(15);
        passwordField.setBounds(37, 208, 249, 38);
        passwordField.setBackground(new Color(217, 217, 217));
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Sign Up Label
        signUpLabel = new JLabel();
        signUpLabel.setText("Don't have an account?");
        signUpLabel.setBounds(18, 340, 500, 16);
        signUpLabel.setForeground(Color.WHITE);
        signUpLabel.setFont(new Font("Inter", Font.BOLD, 16));

        // Submit
        submit = new JButton("Submit");
        submit.setBounds(110, 280, 100, 34);
        submit.setBackground(new Color(217, 217, 217));
        submit.setForeground(new Color(86, 53, 158));
        submit.setFont(new Font("Inter", Font.BOLD, 16));

        // Sign Up Button
        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(220, 330, 100, 34);
        signUpButton.setBackground(new Color(217, 217, 217));
        signUpButton.setForeground(new Color(86, 53, 158));
        signUpButton.setFont(new Font("Inter", Font.BOLD, 16));

        // Creating a new Panel
        loginPanel = new JPanel();
        loginPanel.setBackground(new Color(86, 53, 158));
        loginPanel.setLayout(null);

        // Adding variables to loginPanel
        loginPanel.add(loginLabel);
        loginPanel.add(userLabel);
        loginPanel.add(userField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(submit);
        loginPanel.add(signUpLabel);
        loginPanel.add(signUpButton);
        add(loginPanel, BorderLayout.CENTER);

        // Creating action listener for the buttons
        submit.addActionListener(this);
        signUpButton.addActionListener(this);
        setTitle("Login Form");
        setSize(323, 393); // Set the size of the frame

    } // <--- CreateLoginForm() constructor ends here

    // ---------------------------------------------------------------------------------
    // Action listener method for the submit button
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();

        if (obj == submit) {
            // Assigning the information that will be inputted by the user as string
            // variables
            String userValue = userField.getText();
            String passValue = passwordField.getText();

            String adminUsername = "admin1";
            String adminPassword = "password123!";

            // --- Admin user login ---
            if (userValue.equals(adminUsername) && passValue.equals(adminPassword)) {
                // Show a success message if credentials are valid
                JOptionPane.showMessageDialog(this, "Admin Login successful!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);

                // Open the "AdminPage.java" page
                OptionPage optionPage = new OptionPage();
                optionPage.setVisible(true);
                this.dispose(); // Close the current login page
            } // <--- if(admin) statement ends here

            // --- Regular user login ---
            // Read the existing credentials from the file
            List<String> credentials = new ArrayList<>();
            try {
                BufferedReader reader = new BufferedReader(new FileReader("Credentials.txt"));
                String line;
                while ((line = reader.readLine()) != null) {
                    credentials.add(line);
                }
                reader.close();
            } catch (IOException e) {
                System.out.println("Error reading credentials from file.");
            } // <--- catch() block ends here

            // Check if the inputted credentials match any of the existing credentials
            boolean found = false;
            for (String credential : credentials) {
                String[] parts = credential.split("\\|");
                String username = parts[0].trim().substring(10);
                String password = parts[1].trim().substring(10);
                if (username.equals(userValue) && password.equals(passValue)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                // Show a success message if credentials are valid
                JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Open the "options.java" page
                OptionPage optionPage = new OptionPage();
                optionPage.setVisible(true);
                this.dispose(); // Close the current login page
            } else {
                // Display an error message if credentials are invalid
                JOptionPane.showMessageDialog(this, "Invalid username or password.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (obj == signUpButton) {
            dispose();
            CreateSignupForm form = new CreateSignupForm();
            form.setSize(350, 450);
            form.setVisible(true);
        }
    }
}

class Login {
    public static void main(String[] args) {
        System.out.println("\n========= Login =========\n");
        try {
            CreateLoginForm form = new CreateLoginForm();
            // form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            form.setSize(323, 393);
            form.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    } // <--- main() method ends here
}// <--- Login{} class ends here