/*  Project: Vehicle Vortex
*   Class: Signup.java 
*   Author: Summer Snyder, Antonios Takos, Teuta Elezaj, Christian Felix, Tahir Buksh, Jayden Kuprel
*   Date: April 16th, 2023 
*   This program creates a signup page, where users are able to enter their credentials,
*   where they will gain access to Vehicle Vortex.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

class CreateSignupForm extends JFrame implements ActionListener {
    // Initializing Java Swing Variables
    JButton submit, back;
    JPanel signupPanel, buttonPanel;
    JLabel logoLabel, userLabel, passwordLabel, infoLabel;
    final JTextField userField, passwordField;
    VCC vcc = VCC.getInstance();

// ---------------------------------------------------------------------------------
// This method creates the GUI for the sign up form
CreateSignupForm() throws IOException {
    // Assigning JSwing variables values & styling

    // Logo Label
    BufferedImage myPicture = ImageIO.read(new File("logo.png"));
    logoLabel = new JLabel(new ImageIcon(myPicture));
    logoLabel.setBounds(27, -30, 309, 218);

    // Info Label
    infoLabel = new JLabel();
    infoLabel.setText("<html><center>Thanks for choosing Vehicle Vortex! To sign up, please enter your desired username and password."
   + " Each field must be at least 5 characters long, and your password must contain at least one special character.</center></html>");
    infoLabel.setBounds(20, 160, 320, 60);
    infoLabel.setForeground(Color.WHITE);
    infoLabel.setFont(new Font("Inter", Font.PLAIN, 12));

    // User Label
    userLabel = new JLabel();
    userLabel.setText("Username");
    userLabel.setBounds(54, 230, 100, 16);
    userLabel.setForeground(Color.WHITE);
    userLabel.setFont(new Font("Inter", Font.BOLD, 16));

    // User Field
    userField = new JTextField(15);
    userField.setBounds(47, 258, 249, 38);
    userField.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(86, 53, 158)),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));

    // Password Label
    passwordLabel = new JLabel();
    passwordLabel.setText("Password");
    passwordLabel.setBounds(54, 310, 100, 16);
    passwordLabel.setForeground(Color.WHITE);
    passwordLabel.setFont(new Font("Inter", Font.BOLD, 16));

    // Password Field
    passwordField = new JPasswordField(15);
    passwordField.setBounds(47, 338, 249, 38);
    passwordField.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(86, 53, 158)),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));

    // Submit Button
    submit = new JButton("Submit");
    submit.setBounds(125, 390, 100, 34);
    submit.setBackground(new Color(217, 217, 217));
    submit.setForeground(new Color(86, 53, 158));
    submit.setFont(new Font("Inter", Font.BOLD, 16));

    // Back Button
    back = new JButton("Back");
    back.setBackground(new Color(217, 217, 217));
    back.setForeground(new Color(86, 53, 158));
    back.setFont(new Font("Inter", Font.BOLD, 16));

    // Creating main panel
    signupPanel = new JPanel();
    signupPanel.setBackground(new Color(86, 53, 158));
    // Setting layout as null so that we can set the bounds for variables
    signupPanel.setLayout(null);

    // Adding variables to SignUp Panel
    signupPanel.add(logoLabel);
    signupPanel.add(infoLabel);
    signupPanel.add(userLabel);
    signupPanel.add(userField);
    signupPanel.add(passwordLabel);
    signupPanel.add(passwordField);
    signupPanel.add(submit);
    add(signupPanel, BorderLayout.CENTER);

    // Creating Button Panel
    buttonPanel = new JPanel();
    // Adding button to panel
    buttonPanel.add(back);
    add(buttonPanel, BorderLayout.SOUTH);

    // Creating action listener for the buttons
    submit.addActionListener(this);
    back.addActionListener(this);

    // Setting title, size, and visibility
    setTitle("Sign Up Form");
    signupPanel.setPreferredSize(new Dimension(350, 440));
    setVisible(true);
    pack();
}

    // ---------------------------------------------------------------------------------
    // Action listener method for the submit button
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();

        if (obj == submit) {
            // Assigning the information that will be inputted by the user as string
            // variables
            String userValue = userField.getText();
            String passValue = passwordField.getText();

            // validating username and password based on rules - username must be greater
            // than 5, and password must be at least 5 characters and contain one special
            // character.
            if (userValue.length() <= 5) {
                System.out.println("ERROR: Username must be greater than 5 characters long.");
                return;
            }
            if (!passValue.matches("^(?=.*[!@#$%^&*(),.?\":{}|<>]).{5,}$")) {
                System.out.println(
                        "ERROR: Password must be at least 5 characters long and contain at least one special character.");
                return;
            }

            // Write the user-provided credentials to a file
            int userID = User.generateUniqueUserID();
            User user = new User(userID, userValue, passValue);
            try {
                vcc.addUser(user);
            }
            catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // Open option page once user signs up
            OptionPage page = new OptionPage(user);

            // dispose of sign up page once credentials are valid
            dispose();
            // try {
            //     FileWriter writer = new FileWriter("Credentials.txt", true);
            //     LocalDateTime timestamp = LocalDateTime.now();

            //     writer.write("Username: " + userValue + " | Password: " + passValue + " | Timestamp: "
            //             + timestamp.toString() + System.lineSeparator()); // add newline character
            //     writer.close();
            //     System.out.println("Credentials successfully saved to file!");

            //     // Show the option page if credentials are in line with rules
            //     OptionPage page = new OptionPage();
            //     page.setVisible(true);

            //     // dispose of sign up page once credentials are valid
            //     dispose();
            // } catch (IOException e) {
            //     System.out.println("Error writing credentials to file.");
            // }
        } // <--- if(obj==submit) statment ends here
        else if (obj == back) {
            dispose();
        }
    } // <--- actionPerformed() method ends here
} // <--- CreateSignupForm{} class ends here

class Signup {
    public static void main(String[] args) {
        System.out.println("\n========= Signup =========\n");
    } // <--- main() method ends here
} // <--- Signup{} class ends here
