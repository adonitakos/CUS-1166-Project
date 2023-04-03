/*  Project: Vehicle Vortex
*   Class: Login.java 
*   Author: Antonios Takos, Summer Snyder, Teuta Elezaj, Christian Felix, Tahir Buksh, Jayden Kuprel
*   This program creates a login page, where users are able to enter their credentials,
*   where they will gain access to certain parts of Vehicle Vortex, depending on their user type.
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
    JButton signInButton, signUpButton;
    JPanel loginPanel;
    JLabel loginLabel, userLabel, passwordLabel, signUpLabel;
    final JTextField userField, passwordField;

    // This constructor method creates the GUI for the Login form
    CreateLoginForm() {

    // Assigning Java Swing variables' values & styling

        // Login Label
        loginLabel = new JLabel();
        loginLabel.setText("Login");
        loginLabel.setBounds(115, 30, 100, 40);
        loginLabel.setForeground(Color.WHITE);
        loginLabel.setFont(new Font("Inter", Font.BOLD, 30));
        Dimension size = loginLabel.getPreferredSize();
        loginLabel.setBounds(100, 30, size.width, size.height);

        // User label
        userLabel = new JLabel();
        userLabel.setText("Username");
        userLabel.setBounds(44, 100, 100, 16);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Inter", Font.BOLD, 16));
        // User field
        userField = new JTextField(15);
        userField.setBounds(37, 128, 249, 38);
        userField.setBackground(new Color(217, 217, 217));
        userField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Password label
        passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordLabel.setBounds(44, 180, 100, 16);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Inter", Font.BOLD, 16));
        // Password field
        passwordField = new JPasswordField(15);
        passwordField.setBounds(37, 208, 249, 38);
        passwordField.setBackground(new Color(217, 217, 217));
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Sign Up label
        signUpLabel = new JLabel();
        signUpLabel.setText("Don't have an account?");
        signUpLabel.setBounds(18, 340, 500, 16);
        signUpLabel.setForeground(Color.WHITE);
        signUpLabel.setFont(new Font("Inter", Font.BOLD, 16));

        // Sign Up button
        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(220, 330, 100, 34);
        signUpButton.setBackground(new Color(217, 217, 217));
        signUpButton.setForeground(new Color(86, 53, 158));
        signUpButton.setFont(new Font("Inter", Font.BOLD, 16));

        // Submit button
        signInButton = new JButton("Sign In");
        signInButton.setBounds(110, 280, 100, 34);
        signInButton.setBackground(new Color(217, 217, 217));
        signInButton.setForeground(new Color(86, 53, 158));
        signInButton.setFont(new Font("Inter", Font.BOLD, 16));
        
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
        loginPanel.add(signInButton);
        loginPanel.add(signUpLabel);
        loginPanel.add(signUpButton);
        add(loginPanel, BorderLayout.CENTER);

    // Creating action listener for the buttons
        signInButton.addActionListener(this);
        signUpButton.addActionListener(this);
        setTitle("Login Form");
        setSize(323, 393); // Set the size of the frame

    } // <--- CreateLoginForm() constructor ends here


// ---------------------------------------------------------------------------------
    // Action listener method for the signInButton button
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();

        if (obj == signInButton) {
        // Assigning the information that will be inputted by the user as string variables
            String userValue = userField.getText();
            String passValue = passwordField.getText();

            String adminUsername = "admin1";
            String adminPassword = "password123!";
            String adminUsername = "admin1";
            String adminPassword = "password123!";

        // --- Admin user login ---
            if (userValue.equals(adminUsername) && passValue.equals(adminPassword)) {
                // Show a success message if credentials are valid
                JOptionPane.showMessageDialog(this, "Admin Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Open the "AdminPage.java" page
                OptionPage optionPage = new OptionPage();
                optionPage.setVisible(true);
                this.dispose(); // Close the current login page
            } // <--- if(admin) statement ends here
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
            } // <--- for(credential) loop ends here
                
            if (found) {
                // Show a success message if credentials are valid
                JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                // Open the "options.java" page
                OptionPage optionPage = new OptionPage();
                optionPage.setVisible(true);
                this.dispose(); // Close the current login page
            }
            else {
                // Display an error message if credentials are invalid
                JOptionPane.showMessageDialog(this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } // <--- if(obj==signInButton) statement ends here

        else if (obj == signUpButton) {
            dispose();
            CreateSignupForm form = new CreateSignupForm();
            form.setSize(350, 450);
            form.setVisible(true);
        }

    } // <--- actionPerformed() event method ends here

} // <--- CreateLoginForm{} class ends here

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