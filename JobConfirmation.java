/* Project: Vehicle Vortex
*  Class: JobConfirmation.java
*  Author: Summer Snyder, Antonios Takos, Teuta Elezaj, Christian Felix, Tahir Buksh, Jayden Kuprel
*  Date: April 16th, 2023 
*  This program creates a job confirmation pop up.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JobConfirmation extends JFrame implements ActionListener {
    // Initializing variables
    private JPanel titlePanel, confirmationPanel, buttonPanel;
    private JLabel thankYouLabel, jobCompletionLabel, jobIDLabel, jobDeadlineLabel, jobDurationLabel, jobDescriptionLabel;
    private JButton close;

    // ------------------------------------------
    // This method creates the GUI for the JobConfirmation
    JobConfirmation(Job job) {

        // Assigning variables values
        // Thank You Label
        thankYouLabel = new JLabel("Thank you. Your job has been submitted.", SwingConstants.CENTER);
        thankYouLabel.setForeground(Color.WHITE);
        thankYouLabel.setFont(new Font("Inter", Font.BOLD, 22));
        thankYouLabel.setBackground(new Color(217, 217, 217));

        // JobID Label
        jobIDLabel = new JLabel("<html><b><u>Job ID:</u></b> " + job.getJobID() + "</html>", SwingConstants.CENTER);
        jobIDLabel.setForeground(Color.WHITE);
        jobIDLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        jobIDLabel.setBackground(new Color(217, 217, 217));

        // Job Duration Label
        jobDurationLabel = new JLabel("<html><b><u>Job Duration:</b></u> " + job.getJobDuration() + " hours.</html>", SwingConstants.CENTER);
        jobDurationLabel.setForeground(Color.WHITE);
        jobDurationLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        jobDurationLabel.setBackground(new Color(217, 217, 217));

        // Job Deadline Label
        jobDeadlineLabel = new JLabel("<html><b><u>Job Deadline:</b></u> " + job.getJobDeadline() + "</html>", SwingConstants.CENTER);
        jobDeadlineLabel.setForeground(Color.WHITE);
        jobDeadlineLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        jobDeadlineLabel.setBackground(new Color(217, 217, 217));

        // Job Description Label
        jobDescriptionLabel = new JLabel("<html><b><u>Job Description:</b></u> " + job.getJobDescription() + "</html>", SwingConstants.CENTER);
        jobDescriptionLabel.setForeground(Color.WHITE);
        jobDescriptionLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        jobDescriptionLabel.setBackground(new Color(217, 217, 217));

        // Job Completion Label
        jobCompletionLabel = new JLabel("<html><b><u>Job Completion Time:</b></u> " + job.getCompletionTime() + " hours.</html>", SwingConstants.CENTER);
        jobCompletionLabel.setForeground(Color.WHITE);
        jobCompletionLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        jobCompletionLabel.setBackground(new Color(217, 217, 217));

        // Close Button
        close = new JButton("Close");
        close.setBounds(110, 270, 100, 34);
        close.setBackground(new Color(217, 217, 217));
        close.setForeground(new Color(86, 53, 158));
        close.setFont(new Font("Inter", Font.BOLD, 16));

        // Creating title panel
        titlePanel = new JPanel();
        titlePanel.setBackground(new Color(86, 53, 158));
        // Adding variables to the title panel
        titlePanel.add(thankYouLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Creating confirmation panel
        confirmationPanel = new JPanel(new GridLayout(5, 1));
        confirmationPanel.setBackground(new Color(86, 53, 158));

        // Adding variables to the confirmation panel
        confirmationPanel.add(jobIDLabel);
        confirmationPanel.add(jobCompletionLabel);
        confirmationPanel.add(jobDurationLabel);
        confirmationPanel.add(jobDeadlineLabel);
        confirmationPanel.add(jobDescriptionLabel);

        add(confirmationPanel, BorderLayout.CENTER);

        // Creating button panel
        buttonPanel = new JPanel();
        // Adding buttons to panel
        buttonPanel.add(close);
        add(buttonPanel, BorderLayout.SOUTH);

        // Creating action listener for the buttons
        close.addActionListener(this);

        // Setting title, size, and visibility
        setTitle("Confirmation");
        setSize(500, 350);
        setVisible(true);
    } // <--- Confirmation() constructor ends here

    // --------------------------------------------
    // Action Listener method
    public void actionPerformed(ActionEvent e) {
        dispose();
    } // <--- actionPerformed() method ends here
} // <--- JobConfirmation{} class ends here
