
/*  Project: Vehicle Vortex
*   Class: CarPage.java 
*   Author: Summer Snyder, Antonios Takos, Teuta Elezaj, Christian Felix, Tahir Buksh, Jayden Kuprel
*   Date: February 19th, 2023 
*   This program creates the car page, where users who have selected "Owner"
*   will be able to enter details and submit their car for use.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Cars extends JFrame implements ActionListener {

    // Intializing variables
    private JPanel carPage;
    private JLabel carMakeLabel, carModelLabel, carLicensePlateLabel, carResidencyTimeLabel;
    private final JTextField carMakeField, carModelField, carLicensePlateField, carResidencyTimeField;
    JButton submit;

    // ---------------------------------------------------------------------------------
    // This method creates the GUI for the Cars Window
    Cars() {
        // Assigning variables values
        // License Plate
        carLicensePlateLabel = new JLabel();
        carLicensePlateLabel.setText("License Plate");
        carLicensePlateField = new JTextField(15);
        carLicensePlateLabel.setForeground(Color.WHITE);
        carLicensePlateLabel.setBackground(new Color(217, 217, 217));
        carLicensePlateLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        carLicensePlateField.setBackground(new Color(217, 217, 217));
        carLicensePlateField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Make
        carMakeLabel = new JLabel();
        carMakeLabel.setText("Make");
        carMakeField = new JTextField(15);
        carMakeField.add(carMakeLabel);
        carMakeLabel.setForeground(Color.WHITE);
        carMakeField.setBackground(new Color(217, 217, 217));
        carMakeField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Model
        carModelLabel = new JLabel();
        carModelLabel.setText("Model");
        carModelField = new JTextField(15);
        carModelField.add(carModelLabel);
        carModelLabel.setForeground(Color.WHITE);
        carModelField.setBackground(new Color(217, 217, 217));
        carModelField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Residency Time
        carResidencyTimeLabel = new JLabel();
        carResidencyTimeLabel.setText("Residency Time");
        carResidencyTimeField = new JTextField(10);
        carResidencyTimeLabel.setForeground(Color.WHITE);
        carResidencyTimeLabel.setBackground(new Color(217, 217, 217));
        carResidencyTimeLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        carResidencyTimeField.setBackground(new Color(217, 217, 217));
        carResidencyTimeField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Submit
        submit = new JButton("Submit");
        submit.setBounds(110, 310, 100, 34);
        submit.setBackground(new Color(217, 217, 217));
        submit.setForeground(new Color(86, 53, 158));
        submit.setFont(new Font("Inter", Font.BOLD, 16));

        // Creating new panel
        carPage = new JPanel(new GridLayout(15, 1));
        carPage.setBackground(new Color(86, 53, 158));
        JLabel welcome = new JLabel(
                "Welcome to the car page. Please enter the following information, leaving no fields blank.");
        // Sets the Welcome string to White text
        welcome.setForeground(Color.WHITE);

        // Adding variables to panel
        carPage.add(welcome);
        carPage.add(carLicensePlateLabel);
        carPage.add(carLicensePlateField);
        carPage.add(carMakeLabel);
        carPage.add(carMakeField);
        carPage.add(carModelLabel);
        carPage.add(carModelField);
        carPage.add(carResidencyTimeLabel);
        carPage.add(carResidencyTimeField);
        carPage.add(submit);

        add(carPage, BorderLayout.CENTER);
        // creating action listener for the submit button
        submit.addActionListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Car Submission");
        setSize(1000, 3000);
    } // <--- Cars() constructor ends here

    // ---------------------------------------------------------------------------------
    // Creating action listener method
    public void actionPerformed(ActionEvent e) {
        // Store user input as string variables
        int ownerID = User.generateUniqueUserID();
        String carMake = carMakeField.getText();
        String carModel = carModelField.getText();
        String carLicensePlate = carLicensePlateField.getText();
        String carResidencyTime = carResidencyTimeField.getText();

        // Get the current timestamp when the user submits this form
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        // Write the user-provided credentials and timestamp to a file called
        // userInfo.txt, making it so that this information is not overwritten when the
        // program terminates and it is stored in a new line with each submission
        try {
            FileWriter writer = new FileWriter("carInfo.txt", true); // true parameter to append to file

            writer.write("Owner ID: " + ownerID + " | Car Make: " + carMake + " | Car Model: " + carModel
                    + " | License Plate: " + carLicensePlate + " | Residency Time: " + carResidencyTime
                    + " | Timestamp: " + timestamp + "\n");
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

class CarPage {
    public static void main(String[] args) {
        try {
            Cars form = new Cars();
            form.setSize(400, 300);
            form.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    } // <--- main() method ends here
} // <--- CarPage{} class ends here
