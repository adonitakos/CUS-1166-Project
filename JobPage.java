
/* Project: Vehicle Vortex
* Class: JobPage.java
* Author: Summer Snyder, Antonios Takos, Teuta Elezaj, Christian Felix, Tahir Buksh, Jayden Kuprel
* This program creates a job page, where users who have selected "Job" will
* be able to enter details and submit the job they would like completed.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.net.*;
import java.io.*;

class Jobs extends JFrame implements ActionListener {
    // Initializing variables
    private JLabel jobIDLabel, jobDurationLabel, jobDeadlineLabel, jobDescriptionLabel;
    private final JTextField jobIDField, jobDurationField, jobDeadlineField, jobDescriptionField;
    private JButton submit, jobCompletion, back;
    private JPanel jobPage;
    private Socket socket;
    VCC vcc = VCC.getInstance();

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    // ---------------------------------------------------------------------------------
    // This method creates the GUI for the JobWindow
    Jobs() {
        // Assigning variables values
        // JobID
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

        // Duration
        jobDurationLabel = new JLabel();
        jobDurationLabel.setText("Job Duration (in hours):");
        jobDurationField = new JTextField(15);
        jobDurationField.add(jobDurationLabel);
        jobDurationLabel.setForeground(Color.WHITE);
        jobDurationLabel.setFont(new Font("Inter", Font.BOLD, 16));
        jobDurationLabel.setBackground(new Color(217, 217, 217));
        jobDurationLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Deadline
        jobDeadlineLabel = new JLabel();
        jobDeadlineLabel.setText("Job Deadline (mm/dd/yyyy):");
        jobDeadlineField = new JTextField(15);
        jobDeadlineField.add(jobDeadlineLabel);
        jobDeadlineLabel.setForeground(Color.WHITE);
        jobDeadlineLabel.setFont(new Font("Inter", Font.BOLD, 16));
        jobDeadlineLabel.setBackground(new Color(217, 217, 217));
        jobDeadlineLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Description
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

        // jobCompletion
        jobCompletion = new JButton("Completion Time");
        jobCompletion.setBounds(110, 270, 100, 34);
        jobCompletion.setBackground(new Color(217, 217, 217));
        jobCompletion.setForeground(new Color(86, 53, 158));
        jobCompletion.setFont(new Font("Inter", Font.BOLD, 16));

        // Submit
        submit = new JButton("Submit");
        submit.setBounds(110, 270, 100, 34);
        submit.setBackground(new Color(217, 217, 217));
        submit.setForeground(new Color(86, 53, 158));
        submit.setFont(new Font("Inter", Font.BOLD, 16));

        // Back Button
        back = new JButton("Back");
        back.setBounds(110, 270, 100, 34);
        back.setBackground(new Color(217, 217, 217));
        back.setForeground(new Color(86, 53, 158));
        back.setFont(new Font("Inter", Font.BOLD, 16));

        // Creating a new panel
        jobPage = new JPanel(new GridLayout(5, 2));
        jobPage.setBackground(new Color(86, 53, 158));
        JLabel welcome = new JLabel(
                "Welcome to the Job page. Please enter the following information, leaving no fields blank.");

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

        // Adding buttons to the panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submit);
        buttonPanel.add(jobCompletion);
        buttonPanel.add(back);
        add(buttonPanel, BorderLayout.SOUTH);

        // Creating action listener for the buttons
        submit.addActionListener(this);
        jobCompletion.addActionListener(this);
        back.addActionListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Job Submission");
        setSize(400, 250);
    } // <--- Jobs() constructor ends here

    // ---------------------------------------------------------------------------------
    // Action Listener method
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == submit) {
            // Assigning the information that will be inputted by the user as string
            // variables
            int jobID = Integer.parseInt(jobIDField.getText());
            int jobDuration = Integer.parseInt(jobDurationField.getText());
            String jobDeadline = jobDeadlineField.getText();
            String jobDescription = jobDescriptionField.getText();

            Job job = new Job(jobID, jobDuration, jobDeadline, jobDescription);

            try {

                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                OutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                ObjectOutputStream OOS = new ObjectOutputStream(outputStream);

                System.out.println("Sending job to VCC...");

                // server sends the message to client
                OOS.writeObject(job);

                if (inputStream.readBoolean()) {
                    vcc.addJob(job);
                    System.out.println("Job submission has been approved by VCC. Writing to file...");
                } else {
                    System.out.println("Job submission has been denied by VCC.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            // Clearing text fields once user submits to prepare for next input
            jobIDField.setText("");
            jobDurationField.setText("");
            jobDeadlineField.setText("");
            jobDescriptionField.setText("");

            JobConfirmation form = new JobConfirmation(job);
            form.setVisible(true);
            form.setSize(800, 300);

        } else if (obj == jobCompletion) {
            LinkedList<Job> jobs = vcc.getAllJobs();
            Job job = jobs.getLast();
            System.out.print("The completion time is: " + job.getCompletionTime() + " hours.");
        }

        else if (obj == back) {

            // if back button was clicked, reopen OptionPage
            OptionPage page = new OptionPage();
            page.setVisible(true);

            // if back button was clicked, close current panel
            dispose();
        } else {
            System.out.println("Error.");

        } // <--- actionPerformed() method ends here
    } // <--- Jobs{} class ends here

    class JobPage {
        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        System.out.println("----------*** Attempting Job Owner Connection to Server ***--------");
                        Socket socket = new Socket("localhost", 9806);
                        Jobs form = new Jobs();
                        form.setSocket(socket);
                        form.setVisible(true);
                        form.setSize(400, 300);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
            });
        } // <--- main() method ends here
    }
} // <--- JobPage{} class ends here
