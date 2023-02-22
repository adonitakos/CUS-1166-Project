
/* Project: Vehicle Vortex
* Class: OwnerPage.java 
* Author: Summer Snyder, Antonios Takos, Teuta Elezaj, Christian Felix, Tahir Buksh, Jayden Kuprel
* Date: February 19th, 2023 
* This program creates the owner page, where users who have selected "Owner"
* will be able to enter details and submit their car for use.
*/ 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


class OwnerWindow extends JFrame implements ActionListener {

// Intializing variables
    JPanel ownerPage;
    JLabel ownerID, make, model, licensePlate, residencyTime;
    final JTextField ownerIDText, makeText, modelText, licensePlateText,residencyTimeText;
    JButton submit;

// ---------------------------------------------------------------------------------
// This method creates the GUI for the OwnerWindow
    OwnerWindow() {
// Assigning variables values
        ownerID = new JLabel();
        ownerID.setText("Owner ID");
        ownerIDText = new JTextField(10);
        ownerID.setForeground(Color.WHITE);
        ownerIDText.add(ownerID);
        ownerIDText.setBackground(new Color(217, 217, 217));
        ownerIDText.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(86, 53, 158)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

            residencyTime = new JLabel();
            residencyTime.setText("Residency Time");
            residencyTimeText = new JTextField(10);
            residencyTime.setForeground(Color.WHITE);
            residencyTimeText.add(residencyTime);
            residencyTime.setBackground(new Color(217, 217, 217));
            residencyTime.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        make = new JLabel();
        make.setText("Make");
        makeText = new JTextField(15);
        makeText.add(make);
        make.setForeground(Color.WHITE);
        makeText.setBackground(new Color(217, 217, 217));
        makeText.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(86, 53, 158)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        model = new JLabel();
        model.setText("Model");
        modelText = new JTextField(15);
        modelText.add(model);
        model.setForeground(Color.WHITE);
        modelText.setBackground(new Color(217, 217, 217));
        modelText.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(86, 53, 158)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        licensePlate = new JLabel();
        licensePlate.setText("License Plate");
        licensePlateText = new JTextField(15);
        licensePlate.add(ownerID);
        licensePlate.setForeground(Color.WHITE);
        licensePlate.setBackground(new Color(217, 217, 217));
        licensePlate.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(86, 53, 158)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

            submit = new JButton("Submit");
            submit.setBounds(110, 270, 100, 34);
            submit.setBackground(new Color(217, 217, 217));
            submit.setForeground(new Color(86, 53, 158));
            submit.setFont(new Font("Inter", Font.BOLD, 16));


    // Creating new panel 
        ownerPage = new JPanel(new GridLayout(15, 1));
        ownerPage.setBackground(new Color(86, 53, 158));
        JLabel welcome = new JLabel("Welcome to the owner page. Please enter the following information, leaving no fields blank.");
    // Sets the Welcome string to White text
        welcome.setForeground(Color.WHITE);
    // Adding variables to panel
        ownerPage.add(welcome);
        ownerPage.add(ownerID);
        ownerPage.add(ownerIDText);
        ownerPage.add(make);
        ownerPage.add(makeText);
        ownerPage.add(model);
        ownerPage.add(modelText);
        ownerPage.add(licensePlate);
        ownerPage.add(licensePlateText);
        ownerPage.add(residencyTime);
        ownerPage.add(residencyTimeText);
        ownerPage.add(submit);
        add(ownerPage, BorderLayout.CENTER);
        // creating action listener for the submit button
        submit.addActionListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Car Submission");
        setSize(1000,3000);  
    } // <--- OwnerWindow() constructor ends here

// ---------------------------------------------------------------------------------
// Creating action listener method
    public void actionPerformed(ActionEvent e) {
    // Store user input as string variables
        String ownerIDInfo = ownerIDText.getText();
        String ownerMake = makeText.getText();
        String ownerModel = modelText.getText();
        String ownerLicensePlate = licensePlateText.getText();
        String ownerResidencyTime = residencyTimeText.getText();

    // Get the current timestamp when the user submits this form
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    // Write the user-provided credentials and timestamp to a file called userInfo.txt, making it so that this information is not overwritten when the program terminates and it is stored in a new line with each submission
        try {
            FileWriter writer = new FileWriter("ownerInfo.txt", true); // true parameter to append to file
            
            writer.write(ownerIDInfo + ":" + ownerMake + ":" + ownerModel + ":" + ownerLicensePlate + ":" + timestamp + "\n");
            writer.close();
            System.out.println("User info successfully saved to file!");

            // success message
            System.out.println("Thank you. Your car has been submitted.");
        } 
    // Error message
        catch (IOException ex) {
            System.out.println("Error writing user info to file.");
        }
    } // <--- actionPerformed() method ends here
} // <--- OwnerWindow{} class ends here

class OwnerPage {
    public static void main(String[] args) {
        try {
            OwnerWindow form = new OwnerWindow();
            form.setSize(400,300);
            form.setVisible(true);
        }   
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    } // <--- main() method ends here
} // <--- ownerPage{} class ends here
