import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

class CreateLoginForm extends JFrame implements ActionListener {
// Initializing Variables
    JButton submit;
    JPanel LoginPanel;
    JLabel userLabel, passwordLabel;
    final JTextField userField, passwordField;

// Creating the GUI for the Login form
    CreateLoginForm() {

    // Assigning variables values
        userLabel = new JLabel();
        userLabel.setText("Username");
        userField = new JTextField(15);
        passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordField = new JPasswordField(15);
        submit = new JButton("Submit");

    // Creating a new Panel
        LoginPanel = new JPanel(new GridLayout(3, 1));

    // Adding variables to Panel
        LoginPanel.add(userLabel);
        LoginPanel.add(userField);
        LoginPanel.add(passwordLabel);
        LoginPanel.add(passwordField);
        LoginPanel.add(submit);
        add(LoginPanel, BorderLayout.CENTER);

    // Creating action listener for the submit button
        submit.addActionListener(this);
        setTitle("Login Form");

    } // <--- CreateLoginForm() constructor ends here

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

    // write the user-provided credentials to a file
    try {
        FileWriter writer = new FileWriter("/Users/teutaelazaj/Desktop/1166/project/Vehicle-Vortex/Credentials.txt", true);

        
        // may need to adjust file path, can be replaced with this instead
        // File credentialsFile = new File("Credentials.txt");
        // FileWriter writer = new FileWriter(credentialsFile);
        
        writer.write(userValue + ":" + passValue + System.lineSeparator()); // add newline character
        writer.close();
        System.out.println("Credentials successfully saved to file!");

        // Show the option page if credentials are in line with rules
        optionPage page = new optionPage();
        page.setVisible(true);
    } catch (IOException e) {
        System.out.println("Error writing credentials to file.");
    }
} // <--- actionPerformed() method ends here




    // public void actionPerformed(ActionEvent ae) {
    // // Assigning the information that will be inputted by the user as string variables
    //     String userValue = userField.getText();
    //     String passValue = passwordField.getText();

    // // ! --- [Temporary solution to what will later be Firebase Authentication] --- !
    // // IF the user inputs the username and password as 1, it will bring the user to the optionPage 
    //     if (userValue.equals("1") && passValue.equals("1")) {
    //         optionPage page = new optionPage();
    //         page.setVisible(true);
    //     }
    // // ELSE, it will tell them it is the wrong user and pass and it will have them try again
    //     else {
    //         System.out.println("Wrong username and Password!");
    //     }
    // } // <--- actionPerformed() method ends here

} // <--- CreateLoginForm{} class ends here

class Login {

    public static void main(String[] args) {

        try {
            CreateLoginForm form = new CreateLoginForm();
            form.setSize(300,100);
            form.setVisible(true);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    } // <--- main() method ends here

} // <--- Login{} class ends here