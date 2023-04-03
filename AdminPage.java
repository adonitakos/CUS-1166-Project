import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.io.*;

class CreateAdminForm extends JFrame implements ActionListener {
    // initializing variables
    private JPanel admin, buttonPanel;
    private JLabel AllCarsLabel, AllJobsLabel, CompleteJobsLabel, IncompleteJobsLabel, carByIdLabel, jobByIdLabel;
    private JTextField AllCarsField, AllJobsField, AllJobsPlateField, CompleteJobsField, IncompleteJobsField, CarModelField, CarMakeField, carByIdField, CarLicensePlateField, CarResidencyTimeField, jobByIdField;
    private JButton close, submit, back;
    // instantiates the VCC class in the admin class
    VCC vcc = VCC.getInstance();


    // show car table
    // admin credentials are going to be hardcoded
    // admin gui will display admin methods
    // must be printed in the terminal and in the pop-up
    // get an instance of the vcc

    CreateAdminForm() {

        CarMakeField = new JTextField(15);
        CarModelField = new JTextField(15);

        carByIdLabel = new JLabel("Enter car ID:");
        carByIdField = new JTextField(15);
        jobByIdLabel = new JLabel("Enter job ID:");
        jobByIdField = new JTextField(15);

        // All Cars Description Label
        AllCarsLabel = new JLabel();
        AllCarsLabel.setText("All Cars");
        AllCarsField = new JTextField(15);
        admin.add(AllCarsLabel);
        AllCarsLabel.setForeground(Color.WHITE);
        AllCarsField.setBackground(new Color(217, 217, 217));
        AllCarsField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        AllCarsField.setBackground(new Color(217, 217, 217));
        AllCarsField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Complete Description Label
        CompleteJobsLabel = new JLabel("Thank you. Your job has been submitted.", SwingConstants.CENTER);
        CompleteJobsLabel.setForeground(Color.WHITE);
        CompleteJobsLabel.setFont(new Font("Inter", Font.BOLD, 16));
        CompleteJobsLabel.setBackground(new Color(217, 217, 217));
        CompleteJobsLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        CompleteJobsField = new JTextField(15);
        CompleteJobsField.setBackground(new Color(217, 217


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class CreateAdminForm extends JFrame implements ActionListener {

    // initializing variables
    private JPanel admin, buttonPanel;
    private JLabel allCarsLabel, allJobsLabel, completeJobsLabel, incompleteJobsLabel, carByIdLabel, jobByIdLabel;
    private JTextField allCarsField, allJobsField, allJobsPlateField, completeJobsField, incompleteJobsField, carModelField, carMakeField, carByIdField, carLicensePlateField, carResidencyTimeField, jobByIdField;
    private JButton close, submit, back;
    // instantiate the VCC class in the admin class
    VCC vcc = VCC.getInstance();

    CreateAdminForm() {

        carMakeField = new JTextField(15);
        carModelField = new JTextField(15);

        carByIdLabel = new JLabel("Enter car ID:");
        carByIdField = new JTextField(15);
        jobByIdLabel = new JLabel("Enter job ID:");
        jobByIdField = new JTextField(15);

        // All Cars Description Label
        allCarsLabel = new JLabel();
        allCarsLabel.setText("All Cars");
        allCarsField = new JTextField(15);
        allCarsLabel.setForeground(Color.WHITE);
        allCarsField.setBackground(new Color(217, 217, 217));
        allCarsField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        allCarsLabel.setForeground(Color.WHITE);
        allCarsLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Complete Jobs Description Label
        completeJobsLabel = new JLabel("Thank you. Your job has been submitted.", SwingConstants.CENTER);
        completeJobsLabel.setForeground(Color.WHITE);
        completeJobsLabel.setFont(new Font("Inter", Font.BOLD, 16));
        completeJobsLabel.setBackground(new Color(217, 217, 217));
        completeJobsLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        completeJobsField = new JTextField(15);
        completeJobsField.setBackground(new Color(217, 217, 217));
        completeJobsField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Incomplete Jobs Description Label
        incompleteJobsLabel = new JLabel("Incomplete Jobs", SwingConstants.CENTER);
        incompleteJobsLabel.setForeground(Color.WHITE);
        incompleteJobsLabel.setFont(new Font("Inter", Font.BOLD, 16));
        incompleteJobsLabel.setBackground(new Color(217, 217, 217));
        incompleteJobsLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        incompleteJobsField = new JTextField(15);
        incompleteJobsField.setBackground(new Color(217, 217, 217));
        incompleteJobsField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53,158)

            // All jobs Description Label
            AllJobsLabel = new JLabel();
            AllJobsLabel.setText("All Cars");
            AllJobsField = new JTextField(15);
            AllJobsField.add(AllCarsLabel);
            AllJobsLabel.setForeground(Color.WHITE);
            AllJobsField.setBackground(new Color(217, 217, 217));
            AllJobsLabel.setText("All Cars");
            AllJobsLabel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(86, 53, 158)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
            AllJobsField.setBackground(new Color(217, 217, 217));
            AllJobsField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(86, 53, 158)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
    
        // Creating new panel
            admin = new JPanel(new GridLayout(15, 1));
            admin.setBackground(new Color(86, 53, 158));
            JLabel welcome = new JLabel("Welcome to the Admin page. Please enter your credentials, leaving no fields blank.");
    
        // Sets the Welcome string to White text
            welcome.setForeground(Color.WHITE);
            admin.add(welcome);
            admin.add(AllCarsLabel);
            admin.add(AllCarsField);
            admin.add(AllJobsLabel);
            admin.add(AllJobsPlateField);
            admin.add(CompleteJobsLabel);
            admin.add(CarMakeField);
            admin.add(IncompleteJobsLabel);
            admin.add(CarModelField);
            admin.add(carByIdLabel);
            admin.add(carByIdField);
            admin.add(jobByIdLabel);
            admin.add(jobByIdField);
            admin.add(submit);
            admin.add(back);
            add(admin,BorderLayout.CENTER);
    
            submit = new JButton("Submit");
            back = new JButton("Back");
            buttonPanel = new JPanel();
            buttonPanel.add(back);
            submit.addActionListener(this);
    
    
            // Adding buttons to the panel
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(close);
            add(buttonPanel, BorderLayout.SOUTH);
    
            // creating the action listener for the buttons
            close.addActionListener(this);
    
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setTitle("Admin Entry");
            setSize(1000,3000);
    
        } // <--- CreateAdminForm() constructor ends here
    
        // Action performer class has to be corrected
    
        public void actionPerformed(ActionEvent e) {
    
            Object obj = e.getSource();
    
            if (obj == close) {
                // Store user input as string variables
                int AllCarLabel = Integer.parseInt(AllCarsField.getText());
                String AllJobsLabel = AllJobsField.getText();
                String CompleteJobsLabel= CarModelField.getText();
                String carLicensePlate = CarLicensePlateField.getText();
                String carResidencyTime = CarResidencyTimeField.getText();
    
                Admin admin = new admin(AllCars, AllJobs,CompleteJobs, IncompleteJobs,carById,jobById);
                vcc.addAdmin(admin);
    
                // Clearing text fields once user submits to prepare for next input
                AllCarsField.setText("");
                AllJobsField.setText("");
                CompleteJobsField.setText("");
                IncompleteJobsField.setText("");
                carByIdField.setText("");
                jobByIdField.setText("");
            } 
            else {
                System.out.println("Error.");
            } // <--- else-statement ends here
    
        } // <--- actionPerformed() method ends here
    
    } // <--- CreateAdminForm{} class ends here
    
    class Admin {
        public static void main(String[] args) {
            System.out.println("\n========= Admin =========\n");
            try {
                CreateAdminForm form = new CreateAdminForm();
                // form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                form.setSize(323, 393);
                form.setVisible(true);
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } // <--- main() method ends here
    
    } // <--- Admin{} class ends here

