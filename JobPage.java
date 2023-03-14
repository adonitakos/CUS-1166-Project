
/* Project: Vehicle Vortex
* Class: JobPage.java
* Author: Summer Snyder, Antonios Takos, Teuta Elezaj, Christian Felix, Tahir Buksh, Jayden Kuprel
* Date: February 19th, 2023 
* This program creates a job page, where users who have selected "Job" will
* be able to enter details and submit the job they would like completed.
*/

import javax.swing.*;
import javax.xml.namespace.QName;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

class Jobs extends JFrame implements ActionListener {
    // Initializing variables
    private JLabel jobIDLabel, jobDurationLabel, jobDeadlineLabel, jobDescriptionLabel;
    private final JTextField jobIDField, jobDurationField, jobDeadlineField, jobDescriptionField;
    private JButton submit;
    private JPanel jobPage;

    // ---------------------------------------------------------------------------------
    // This method creates the GUI for the JobWindow
    Jobs() {
        // Assigning variables values

        jobIDLabel = new JLabel();
        jobIDLabel.setText("Job ID:");
        jobIDField = new JTextField(15);
        jobIDField.add(jobIDLabel);
        jobIDLabel.setForeground(Color.WHITE);
        jobIDLabel.setFont(new Font("Inter", Font.BOLD, 16));
        jobIDLabel.setBackground(new Color(217, 217, 217));
        jobIDLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        jobDurationLabel = new JLabel();
        jobDurationLabel.setText("Job Duration:");
        jobDurationField = new JTextField(15);
        jobDurationField.add(jobDurationLabel);
        jobDurationLabel.setForeground(Color.WHITE);
        jobDurationLabel.setFont(new Font("Inter", Font.BOLD, 16));
        jobDurationLabel.setBackground(new Color(217, 217, 217));
        jobDurationLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        jobDeadlineLabel = new JLabel();
        jobDeadlineLabel.setText("Job Deadline:");
        jobDeadlineField = new JTextField(15);
        jobDeadlineField.add(jobDeadlineLabel);
        jobDeadlineLabel.setForeground(Color.WHITE);
        jobDeadlineLabel.setFont(new Font("Inter", Font.BOLD, 16));
        jobDeadlineLabel.setBackground(new Color(217, 217, 217));
        jobDeadlineLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        jobDescriptionLabel = new JLabel();
        jobDescriptionLabel.setText("Please describe the job:");
        jobDescriptionField = new JTextField(15);
        jobDescriptionLabel.setBounds(44, 100, 100, 16);
        jobDescriptionLabel.setForeground(Color.WHITE);
        jobDescriptionLabel.setFont(new Font("Inter", Font.BOLD, 16));
        jobDescriptionLabel.setBackground(new Color(217, 217, 217));
        jobDescriptionLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        submit = new JButton("Submit");
        submit.setBounds(110, 270, 100, 34);
        submit.setBackground(new Color(217, 217, 217));
        submit.setForeground(new Color(86, 53, 158));
        submit.setFont(new Font("Inter", Font.BOLD, 16));

        // Creating a new panel
        jobPage = new JPanel(new GridLayout(5, 2));
        jobPage.setBackground(new Color(86, 53, 158));
        JLabel welcome = new JLabel(
                "Welcome to the job page. Please enter the following information, leaving no fields blank.");

                welcome.setForeground(Color.WHITE);
        // Adding variables to the panel
        jobPage.add(welcome);
        jobPage.add(new JLabel(""));
        jobPage.add(jobIDLabel);
        jobPage.add(jobIDField);
        jobPage.add(jobDurationLabel);
        jobPage.add(jobDurationField);
        jobPage.add(jobDeadlineLabel);
        jobPage.add(jobDeadlineField);
        jobPage.add(jobDescriptionLabel);
        jobPage.add(jobDescriptionField);

        add(jobPage, BorderLayout.CENTER);

        // Adding submit button to the panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submit);
        add(buttonPanel, BorderLayout.SOUTH);

        // Creating action listener for the submit button
        submit.addActionListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Job Submission");
        setSize(400, 250);
    } // <--- Jobs() constructor ends here

    // ---------------------------------------------------------------------------------
    // Action Listener method
    public void actionPerformed(ActionEvent e) {
        // Assigning the information that will be inputted by the user as string
        // variables
        int jobID = Integer.parseInt(jobIDField.getText());
        String jobDuration = jobDurationField.getText();
        String jobDeadline = jobDeadlineField.getText();
        String jobDescription = jobDescriptionField.getText();

        // getting current timestamp of when user submits form
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        // write user inputted credentials and timestamp to a text file called
        // jobInfo.txt
        try {
            FileWriter writer = new FileWriter("jobInfo.txt", true); // true parameter to append to file

            writer.write("Job ID: " + jobID + " | Job Duration: " + jobDuration + " | Job Deadline: " + jobDeadline + " | Job Description: " + jobDescription + " | Timestamp: "
                    + timestamp + "\n");
            writer.close();
            System.out.println("Job info successfully saved to file!");

            // confirmation message if successful
            System.out.println("Thank you. Your job has been submitted.");
        }
        // or error message if unsuccessful
        catch (IOException ex) {
            System.out.println("Error writing job info to file.");
        }
    } // <--- actionPerformed() method ends here
} // <--- Jobs{} class ends here

class JobPage {
    public static void main(String[] args) {
        try {
            Jobs form = new Jobs();
            form.setVisible(true);
            form.setSize(400, 300);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    } // <--- main() method ends here
} // <--- JobPage{} class ends here
