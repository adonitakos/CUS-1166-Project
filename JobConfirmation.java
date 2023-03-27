import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JobConfirmation extends JFrame implements ActionListener {
    // Initializing variables
    private JPanel confirmation, buttonPanel;
    private JLabel thankYouLabel, jobCompletionLabel, jobIDLabel, jobDeadlineLabel, jobDurationLabel, jobDescriptionLabel;
    private JButton close;

    /** need to fix so that user info gets printed **/
    // ------------------------------------------
    // This method creates the GUI for the JobConfirmation
    JobConfirmation(Job job) {

        // Assigning variables values
        // Thank you label
        thankYouLabel = new JLabel("Thank you. Your job has been submitted.", SwingConstants.CENTER);
        thankYouLabel.setForeground(Color.WHITE);
        thankYouLabel.setFont(new Font("Inter", Font.BOLD, 16));
        thankYouLabel.setBackground(new Color(217, 217, 217));
        thankYouLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // JobID label
        jobIDLabel = new JLabel("Job ID: " + job.getJobID(), SwingConstants.CENTER);
        jobIDLabel.setForeground(Color.WHITE);
        jobIDLabel.setFont(new Font("Inter", Font.BOLD, 16));
        jobIDLabel.setBackground(new Color(217, 217, 217));
        jobIDLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Job Duration Label
        jobDurationLabel = new JLabel("Job Duration: " + job.getJobDuration(), SwingConstants.CENTER);
        jobDurationLabel.setForeground(Color.WHITE);
        jobDurationLabel.setFont(new Font("Inter", Font.BOLD, 16));
        jobDurationLabel.setBackground(new Color(217, 217, 217));
        jobDurationLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Job Deadline Label
        jobDeadlineLabel = new JLabel("Job Deadline: " + job.getJobDeadline(), SwingConstants.CENTER);
        jobDeadlineLabel.setForeground(Color.WHITE);
        jobDeadlineLabel.setFont(new Font("Inter", Font.BOLD, 16));
        jobDeadlineLabel.setBackground(new Color(217, 217, 217));
        jobDeadlineLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Job Description Label
        jobDescriptionLabel = new JLabel("Job Description: " + job.getJobDescription(), SwingConstants.CENTER);
        jobDescriptionLabel.setForeground(Color.WHITE);
        jobDescriptionLabel.setFont(new Font("Inter", Font.BOLD, 16));
        jobDescriptionLabel.setBackground(new Color(217, 217, 217));
        jobDescriptionLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Job Completion Label
        jobCompletionLabel = new JLabel("Your job completion time is " + job.getCompletionTime() + " hours.", SwingConstants.CENTER);
        jobCompletionLabel.setForeground(Color.WHITE);
        jobCompletionLabel.setFont(new Font("Inter", Font.BOLD, 16));
        jobCompletionLabel.setBackground(new Color(217, 217, 217));
        jobCompletionLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Close button
        close = new JButton("Close");
        close.setBounds(110, 270, 100, 34);
        close.setBackground(new Color(217, 217, 217));
        close.setForeground(new Color(86, 53, 158));
        close.setFont(new Font("Inter", Font.BOLD, 16));

        // Creating confirmation panel
        confirmation = new JPanel(new GridLayout(5, 2));
        confirmation.setBackground(new Color(86, 53, 158));

        // Adding variables to the panel
        confirmation.add(thankYouLabel);
        confirmation.add(jobCompletionLabel);
        confirmation.add(jobIDLabel);
        confirmation.add(jobDurationLabel);
        confirmation.add(jobDeadlineLabel);
        confirmation.add(jobDescriptionLabel);

        add(confirmation, BorderLayout.CENTER);

        // Adding buttons to the panel
        buttonPanel = new JPanel();
        buttonPanel.add(close);
        add(buttonPanel, BorderLayout.SOUTH);

        // Creating action listener for the close button
        close.addActionListener(this);

        setTitle("Confirmation");
        setSize(400, 250);
    } // <--- Confirmation() constructor ends here

    // --------------------------------------------
    // Action Listener method
    public void actionPerformed(ActionEvent e) {
        dispose();
    } // <--- actionPerformed() method ends here

} // <--- JobConfirmation{} class ends here
