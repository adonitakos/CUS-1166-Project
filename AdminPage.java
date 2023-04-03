import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.time.LocalDateTime;
import java.util.*;
import java.net.*;
import java.awt.event.ActionListener;
import java.io.*;

class CreateAdminForm extends JFrame implements ActionListener {

    // Initializing variables
    private JPanel adminPage, jobRequest, carRequest;
    private JLabel jobIDLabel, jobDurationLabel, jobDeadlineLabel, jobDescriptionLabel, confirmationLabel, ownerIDLabel, carMakeLabel, carModelLabel, carLicensePlateLabel, carResidencyTimeLabel;
    private JButton back, carByID, jobByID, allCars, allJobs, jobsQueue, completeJobs, checkpointer, accept, reject;

    // Instantiate the VCC class in the Admin class
    VCC vcc = VCC.getInstance();

    CreateAdminForm(Job job) {

        // confirmationLabel
                
        confirmationLabel = new JLabel("Please review the submitted job and decide whether to accept or reject the addition of this job to the file.", SwingConstants.CENTER);
        confirmationLabel.setForeground(Color.WHITE);
        confirmationLabel.setFont(new Font("Inter", Font.BOLD, 16));
        confirmationLabel.setBackground(new Color(217, 217, 217));
        confirmationLabel.setBorder(BorderFactory.createCompoundBorder(
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
        
        accept = new JButton("Accept");
        accept.setBounds(110, 310, 100, 34);
        accept.setBackground(new Color(217, 217, 217));
        accept.setForeground(new Color(86, 53, 158));
        accept.setFont(new Font("Inter", Font.BOLD, 16));

        // reject
        reject = new JButton("Reject");
        reject.setBounds(110, 310, 100, 34);
        reject.setBackground(new Color(217, 217, 217));
        reject.setForeground(new Color(86, 53, 158));
        reject.setFont(new Font("Inter", Font.BOLD, 16));

        // Adding buttons to the panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(accept);
        buttonPanel.add(reject);
        add(buttonPanel, BorderLayout.CENTER);

        // creating action listener for the buttons
        accept.addActionListener(this);
        reject.addActionListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Job Request");
        setSize(1000, 3000);

    }

    CreateAdminForm(Car car) {//, carMakeLabel, carModelLabel, carLicensePlateLabel, carResidencyTimeLabel

        // confirmationLabel
                
        confirmationLabel = new JLabel("Please review the submitted car and decide whether to accept or reject the addition of this job to the file.", SwingConstants.CENTER);
        confirmationLabel.setForeground(Color.WHITE);
        confirmationLabel.setFont(new Font("Inter", Font.BOLD, 16));
        confirmationLabel.setBackground(new Color(217, 217, 217));
        confirmationLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Owner ID label
        ownerIDLabel = new JLabel("Owner ID: " + car.getJobID(), SwingConstants.CENTER);
        ownerIDLabel.setForeground(Color.WHITE);
        ownerIDLabel.setFont(new Font("Inter", Font.BOLD, 16));
        ownerIDLabel.setBackground(new Color(217, 217, 217));
        ownerIDLabel.setBorder(BorderFactory.createCompoundBorder(
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
        // accept

        accept = new JButton("Accept");
        accept.setBounds(110, 310, 100, 34);
        accept.setBackground(new Color(217, 217, 217));
        accept.setForeground(new Color(86, 53, 158));
        accept.setFont(new Font("Inter", Font.BOLD, 16));

        // reject
        reject = new JButton("Reject");
        reject.setBounds(110, 310, 100, 34);
        reject.setBackground(new Color(217, 217, 217));
        reject.setForeground(new Color(86, 53, 158));
        reject.setFont(new Font("Inter", Font.BOLD, 16));

        // Adding buttons to the panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(accept);
        buttonPanel.add(reject);
        add(buttonPanel, BorderLayout.CENTER);

        // creating action listener for the buttons
        accept.addActionListener(this);
        reject.addActionListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Car Request");
        setSize(1000, 3000);

    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == accept) {

        } else if (obj == reject) {

        } else if (obj == back) {

        } else if (obj == carByID) {

        } else if (obj == jobByID) {

        } else if (obj == allCars) {

        } else if (obj == allJobs) {

        } else if (obj == jobsQueue) {

        } else if (obj == completeJobs) {

        } else if (obj == checkpointer) {

        } else {
            System.out.println("Error.");
        }
    }

    CreateAdminForm() {

        jobByID = new JButton("Job By ID");
        jobByID.setBounds(110, 310, 100, 34);
        jobByID.setBackground(new Color(217, 217, 217));
        jobByID.setForeground(new Color(86, 53, 158));
        jobByID.setFont(new Font("Inter", Font.BOLD, 16));

        // carByID
        carByID = new JButton("Car By ID");
        carByID.setBounds(110, 310, 100, 34);
        carByID.setBackground(new Color(217, 217, 217));
        carByID.setForeground(new Color(86, 53, 158));
        carByID.setFont(new Font("Inter", Font.BOLD, 16));

        // completeJobs
        completeJobs = new JButton("Complete Jobs");
        completeJobs.setBounds(110, 310, 100, 34);
        completeJobs.setBackground(new Color(217, 217, 217));
        completeJobs.setForeground(new Color(86, 53, 158));
        completeJobs.setFont(new Font("Inter", Font.BOLD, 16));

        // jobsQueue
        jobsQueue = new JButton("Job Queue");
        jobsQueue.setBounds(110, 310, 100, 34);
        jobsQueue.setBackground(new Color(217, 217, 217));
        jobsQueue.setForeground(new Color(86, 53, 158));
        jobsQueue.setFont(new Font("Inter", Font.BOLD, 16));

        // allJobs
        allJobs = new JButton("All Jobs");
        allJobs.setBounds(110, 310, 100, 34);
        allJobs.setBackground(new Color(217, 217, 217));
        allJobs.setForeground(new Color(86, 53, 158));
        allJobs.setFont(new Font("Inter", Font.BOLD, 16));

        // allCars
        allCars = new JButton("All Cars");
        allCars.setBounds(110, 310, 100, 34);
        allCars.setBackground(new Color(217, 217, 217));
        allCars.setForeground(new Color(86, 53, 158));
        allCars.setFont(new Font("Inter", Font.BOLD, 16));

        // checkpointer
        checkpointer = new JButton("Checkpoint");
        checkpointer.setBounds(110, 310, 100, 34);
        checkpointer.setBackground(new Color(217, 217, 217));
        checkpointer.setForeground(new Color(86, 53, 158));
        checkpointer.setFont(new Font("Inter", Font.BOLD, 16));

        // Back
        back = new JButton("Back");
        back.setBounds(110, 310, 100, 34);
        back.setBackground(new Color(217, 217, 217));
        back.setForeground(new Color(86, 53, 158));
        back.setFont(new Font("Inter", Font.BOLD, 16));

        // Creating new panel
        adminPage = new JPanel(new GridLayout(15, 1));
        adminPage.setBackground(new Color(86, 53, 158));
        JLabel welcome = new JLabel(
                "Welcome to the car page. Please enter the following information, leaving no fields blank.");
        // Sets the Welcome string to White text
        welcome.setForeground(Color.WHITE);

        // Adding buttons to the panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(back);
        add(buttonPanel, BorderLayout.SOUTH);

        adminPage.add(welcome);
        // admin.add(allCarsLabel);
        // admin.add(allJobsLabel);
        // admin.add(completeJobsLabel);
        // admin.add(incompleteJobsLabel);
        // admin.add(carByIdLabel);
        // admin.add(carByIdField);
        // admin.add(jobByIdLabel);
        // admin.add(jobByIdField);

        add(adminPage, BorderLayout.CENTER);

        // Creating the action listener for the buttons

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Admin Entry");
        setSize(1000, 3000);

    } // <--- CreateAdminForm() constructor ends here

    // } // <--- actionPerformed() method ends here

} // <--- CreateAdminForm{} class ends here

class Admin {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5056);
        CreateAdminForm form = new CreateAdminForm();
        form.setSize(800, 800);
        form.setVisible(true);
        while (true) {
            Socket s = null;
            try {
                // socket object to receive incoming client requests
                s = ss.accept();

                System.out.println("A new client is connected...");

                // obtaining input and out streams
                DataInputStream DIS = new DataInputStream(s.getInputStream());
                DataOutputStream DOS = new DataOutputStream(s.getOutputStream());

                System.out.println("Assigning new thread for this client");

                // create a new thread object
                Thread t = new ClientHandler(s, DIS, DOS);

                t.start();
            } catch (Exception ex) {
                s.close();
                ex.printStackTrace();
            }
        } // <--- main() method ends here

    }
} // <--- Admin{} class ends here