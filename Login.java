/*  Project: Vehicle Vortex
*   Class: Login.java 
*   Author: Antonios Takos, Summer Snyder, Teuta Elezaj, Christian Felix, Tahir Buksh, Jayden Kuprel
*   Date: April 16th, 2023
*   This program creates a login page, where users are able to enter their credentials,
*   where they will gain access to certain parts of Vehicle Vortex, depending on their user type.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

class CreateLoginForm extends JFrame implements ActionListener {
    // Initializing Java Swing Variables
    JButton signInButton, signUpButton;
    JPanel loginPanel;
    JLabel logoLabel, userLabel, passwordLabel, signUpLabel;
    final JTextField userField, passwordField;
    VCC vcc = VCC.getInstance();

    // ---------------------------------------------------------------------------------
    // This constructor method creates the GUI for the Login form
    CreateLoginForm() throws IOException {

        // Assigning Java Swing variables' values & styling

        // Logo Label
        BufferedImage myPicture = ImageIO.read(new File("logo.png"));
        logoLabel = new JLabel(new ImageIcon(myPicture));
        logoLabel.setBounds(27, -20, 309, 218);

        // User Label
        userLabel = new JLabel();
        userLabel.setText("Username");
        userLabel.setBounds(54, 180, 100, 16);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Inter", Font.BOLD, 16));

        // User Field
        userField = new JTextField(15);
        userField.setBounds(47, 208, 249, 38);
        userField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Password Label
        passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordLabel.setBounds(54, 260, 100, 16);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Inter", Font.BOLD, 16));

        // Password Field
        passwordField = new JPasswordField(15);
        passwordField.setBounds(47, 288, 249, 38);
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Sign Up Label
        signUpLabel = new JLabel();
        signUpLabel.setText("Don't have an account?");
        signUpLabel.setBounds(18, 400, 500, 16);
        signUpLabel.setForeground(Color.WHITE);
        signUpLabel.setFont(new Font("Inter", Font.BOLD, 16));

        // Sign Up Button
        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(220, 390, 100, 34);
        signUpButton.setBackground(new Color(217, 217, 217));
        signUpButton.setForeground(new Color(86, 53, 158));
        signUpButton.setFont(new Font("Inter", Font.BOLD, 16));

        // SignIn Button
        signInButton = new JButton("Sign In");
        signInButton.setBounds(125, 340, 100, 34);
        signInButton.setBackground(new Color(217, 217, 217));
        signInButton.setForeground(new Color(86, 53, 158));
        signInButton.setFont(new Font("Inter", Font.BOLD, 16));

        // Creating a new panel
        loginPanel = new JPanel();
        loginPanel.setBackground(new Color(86, 53, 158));
        // Setting layout as null so that we can set the bounds for variables
        loginPanel.setLayout(null);

        // Adding variables to loginPanel
        loginPanel.add(logoLabel);
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

        // Setting title, size, and visibility
        setTitle("Login Form");
        setSize(350, 470);
        setVisible(true);

    } // <--- CreateLoginForm() constructor ends here

    // ---------------------------------------------------------------------------------
    // Action listener method for the signInButton button
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == signInButton) {
            // Assigning the information that will be inputted by the user as string
            // variables
            String userValue = userField.getText();
            String passValue = passwordField.getText();

            try {
                User user = vcc.getUser(userValue, passValue);
                vcc.addLogin(user);

                // --- Admin user login ---
                if (user.getType().equals("Admin")) {
                    System.out.println("admin login");
                    // Show a success message if credentials are valid
                    JOptionPane.showMessageDialog(this, "Admin Login successful!", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    // dispose();
                    // Open the "AdminPage.java" page
                    // try {
                    // Admin.main(new String []{});
                    // } catch (IOException ex) {
                    // ex.printStackTrace();
                    // }
                    Admin adm = new Admin(user);
                    adm.start();
                    this.dispose();
                } // <--- if(admin) statement ends here

                // --- Regular user login ---
                else if (user.getType().equals("User")) {
                    // Show a success message if credentials are valid
                    JOptionPane.showMessageDialog(this, "Login successful!", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    // Open the "options.java" page
                    System.out.println(user.getUserID());
                    OptionPage optionPage = new OptionPage(user);

                    // Clearing text fields once user submits to prepare for next input
                    userField.setText("");
                    passwordField.setText("");
                }
            }
            catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } // <--- if(obj==signInButton) statement ends here

        else if (obj == signUpButton) {
            try {
                CreateSignupForm form = new CreateSignupForm();
            }
            catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    } // <--- actionPerformed() event method ends here
} // <--- CreateLoginForm{} class ends here

class Login {
    public static void main(String[] args) {
        System.out.println("\n========= Login =========\n");
        try {
            CreateLoginForm form = new CreateLoginForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    } // <--- main() method ends here
}// <--- Login{} class ends here