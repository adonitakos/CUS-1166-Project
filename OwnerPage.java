
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


class Cars extends JFrame implements ActionListener {

// Intializing variables
    JPanel ownerPage;
    JLabel ownerID, carMake, carModel, carLicensePlate, carResidencyTime;
    final JTextField ownerIDText, carMakeText, carModelText, carLicensePlateText, carResidencyTimeText;
    JButton submit;

// ---------------------------------------------------------------------------------
// This method creates the GUI for the OwnerWindow
    Cars() {
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

            carResidencyTime = new JLabel();
            carResidencyTime.setText("Residency Time");
            carResidencyTimeText = new JTextField(10);
            carResidencyTime.setForeground(Color.WHITE);
            carResidencyTimeText.add(carResidencyTime);
            carResidencyTime.setBackground(new Color(217, 217, 217));
            carResidencyTime.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        carMake = new JLabel();
        carMake.setText("Make");
        carMakeText = new JTextField(15);
        carMakeText.add(carMake);
        carMake.setForeground(Color.WHITE);
        carMakeText.setBackground(new Color(217, 217, 217));
        carMakeText.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(86, 53, 158)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        carModel = new JLabel();
        carModel.setText("Model");
        carModelText = new JTextField(15);
        carModelText.add(carModel);
        carModel.setForeground(Color.WHITE);
        carModelText.setBackground(new Color(217, 217, 217));
        carModelText.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(86, 53, 158)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        carLicensePlate = new JLabel();
        carLicensePlate.setText("License Plate");
        carLicensePlateText = new JTextField(15);
        carLicensePlate.add(ownerID);
        carLicensePlate.setForeground(Color.WHITE);
        carLicensePlate.setBackground(new Color(217, 217, 217));
        carLicensePlate.setBorder(BorderFactory.createCompoundBorder(
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
        ownerPage.add(carMake);
        ownerPage.add(carMakeText);
        ownerPage.add(carModel);
        ownerPage.add(carModelText);
        ownerPage.add(carLicensePlate);
        ownerPage.add(carLicensePlateText);
        ownerPage.add(carResidencyTime);
        ownerPage.add(carResidencyTimeText);
        ownerPage.add(submit);
        add(ownerPage, BorderLayout.CENTER);
        // creating action listener for the submit button
        submit.addActionListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Car Submission");
        setSize(1000,3000);  
    } // <--- Cars() constructor ends here

// ---------------------------------------------------------------------------------
// Creating action listener method
    public void actionPerformed(ActionEvent e) {
    // Store user input as string variables
        int ownerID = Integer.parseInt(ownerIDText.getText());
        String carMake = carMakeText.getText();
        String carModel = carModelText.getText();
        String carLicensePlate = carLicensePlateText.getText();
        String carResidencyTime = carResidencyTimeText.getText();

    // Get the current timestamp when the user submits this form
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    // Write the user-provided credentials and timestamp to a file called userInfo.txt, making it so that this information is not overwritten when the program terminates and it is stored in a new line with each submission
        try {
            FileWriter writer = new FileWriter("ownerInfo.txt", true); // true parameter to append to file
            
            writer.write("Owner ID: " + ownerID + " | Car Make: " + carMake + " | Car Model: " + carModel + " | License Plate: " + carLicensePlate + " | Residency Time: " + carResidencyTime + " | Timestamp: " + timestamp + "\n");
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
} // <--- Cars{} class ends here

class OwnerPage {
    public static void main(String[] args) {
        try {
            Cars form = new Cars();
            form.setSize(400,300);
            form.setVisible(true);
        }   
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    } // <--- main() method ends here
} // <--- OwnerPage{} class ends here
