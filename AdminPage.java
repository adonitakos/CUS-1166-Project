import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.net.*;
import java.awt.event.ActionListener;
import java.io.*;

class CreateAdminForm extends JFrame implements ActionListener {

    // Initializing variables
    private JPanel adminPage, jobRequest, carRequest, buttonPanel;
    private JLabel jobIDLabel, jobDurationLabel, jobDeadlineLabel, jobDescriptionLabel, confirmationLabel, ownerIDLabel,
            carMakeLabel, carModelLabel, carLicensePlateLabel, carResidencyTimeLabel;
    private JButton back, carByID, jobByID, allCars, allJobs, jobsQueue, completeJobs, checkpointer, accept, reject;
    private DataOutputStream outputStream;
    // Instantiate the VCC class in the Admin class
    VCC vcc = VCC.getInstance();

    CreateAdminForm(Job job, Socket socket, DataInputStream inputStream, DataOutputStream outputStream) {

        this.outputStream = outputStream;

        // ConfirmationLabel

        confirmationLabel = new JLabel(
                "Please review the submitted job and decide whether to accept or reject the addition of this job to the file.",
                SwingConstants.CENTER);
        confirmationLabel.setForeground(Color.WHITE);
        confirmationLabel.setFont(new Font("Inter", Font.BOLD, 16));
        confirmationLabel.setBackground(new Color(217, 217, 217));
        confirmationLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // JobID label
        jobIDLabel = new JLabel("ID: " + job.getJobID(), SwingConstants.CENTER);
        jobIDLabel.setForeground(Color.WHITE);
        jobIDLabel.setFont(new Font("Inter", Font.BOLD, 16));
        jobIDLabel.setBackground(new Color(217, 217, 217));
        jobIDLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Job Duration Label
        jobDurationLabel = new JLabel("Duration: " + job.getJobDuration(), SwingConstants.CENTER);
        jobDurationLabel.setForeground(Color.WHITE);
        jobDurationLabel.setFont(new Font("Inter", Font.BOLD, 16));
        jobDurationLabel.setBackground(new Color(217, 217, 217));
        jobDurationLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Job Deadline Label
        jobDeadlineLabel = new JLabel("Deadline: " + job.getJobDeadline(), SwingConstants.CENTER);
        jobDeadlineLabel.setForeground(Color.WHITE);
        jobDeadlineLabel.setFont(new Font("Inter", Font.BOLD, 16));
        jobDeadlineLabel.setBackground(new Color(217, 217, 217));
        jobDeadlineLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Job Description Label
        jobDescriptionLabel = new JLabel("Description: " + job.getJobDescription(), SwingConstants.CENTER);
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

        // Creating confirmation panel
        jobRequest = new JPanel(new GridLayout(5, 2));
        jobRequest.setBackground(new Color(86, 53, 158));

        // Adding variables to the panel
        jobRequest.add(confirmationLabel);
        jobRequest.add(jobIDLabel);
        jobRequest.add(jobDurationLabel);
        jobRequest.add(jobDeadlineLabel);
        jobRequest.add(jobDescriptionLabel);
        add(jobRequest, BorderLayout.CENTER);

        // Adding buttons to the panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(86, 53, 158));
        buttonPanel.add(accept);
        buttonPanel.add(reject);
        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setBackground(new Color(86, 53, 158));

        // creating action listener for the buttons
        accept.addActionListener(this);
        reject.addActionListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Job Request");
        setSize(1000, 3000);
        setVisible(true);

    } // <--- CreateAdminForm(Jib job) constructor

    CreateAdminForm(Car car, Socket socket, DataInputStream inputStream, DataOutputStream outputStream) {

        this.outputStream = outputStream;

        // Creating confirmation panel
        carRequest = new JPanel(new GridLayout(5, 2));
        carRequest.setBackground(new Color(86, 53, 158));

        // confirmationLabel

        confirmationLabel = new JLabel(
                "Please review the submitted car and decide whether to accept or reject the addition of this job to the file.",
                SwingConstants.CENTER);
        confirmationLabel.setForeground(Color.WHITE);
        confirmationLabel.setFont(new Font("Inter", Font.BOLD, 16));
        confirmationLabel.setBackground(new Color(217, 217, 217));
        confirmationLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Owner ID label
        ownerIDLabel = new JLabel("Owner ID: " + /*car.getOwnerID()*/ SwingConstants.CENTER);
        ownerIDLabel.setForeground(Color.WHITE);
        ownerIDLabel.setFont(new Font("Inter", Font.BOLD, 16));
        ownerIDLabel.setBackground(new Color(217, 217, 217));
        ownerIDLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // carMakeLabel
        carMakeLabel = new JLabel("Make: " + car.getCarMake(), SwingConstants.CENTER);
        carMakeLabel.setForeground(Color.WHITE);
        carMakeLabel.setFont(new Font("Inter", Font.BOLD, 16));
        carMakeLabel.setBackground(new Color(217, 217, 217));
        carMakeLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // carModelLabel
        carModelLabel = new JLabel("Model: " + car.getCarModel(), SwingConstants.CENTER);
        carModelLabel.setForeground(Color.WHITE);
        carModelLabel.setFont(new Font("Inter", Font.BOLD, 16));
        carModelLabel.setBackground(new Color(217, 217, 217));
        carModelLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // carLicensePlateLabel
        carLicensePlateLabel = new JLabel("License Plate: " + car.getCarLicensePlate(), SwingConstants.CENTER);
        carLicensePlateLabel.setForeground(Color.WHITE);
        carLicensePlateLabel.setFont(new Font("Inter", Font.BOLD, 16));
        carLicensePlateLabel.setBackground(new Color(217, 217, 217));
        carLicensePlateLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // carResidencyTimeLabel
        carResidencyTimeLabel = new JLabel("Residency Time: " + car.getCarResidencyTime(), SwingConstants.CENTER);
        carResidencyTimeLabel.setForeground(Color.WHITE);
        carResidencyTimeLabel.setFont(new Font("Inter", Font.BOLD, 16));
        carResidencyTimeLabel.setBackground(new Color(217, 217, 217));
        carResidencyTimeLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(86, 53, 158)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Adding variables to the panel
        carRequest.add(confirmationLabel);
        carRequest.add(ownerIDLabel);
        carRequest.add(carMakeLabel);
        carRequest.add(carModelLabel);
        carRequest.add(carLicensePlateLabel);
        carRequest.add(carResidencyTimeLabel);

        add(carRequest, BorderLayout.CENTER);

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
        buttonPanel = new JPanel();
        buttonPanel.add(accept);
        buttonPanel.add(reject);
        add(buttonPanel, BorderLayout.CENTER);

        // creating action listener for the buttons
        accept.addActionListener(this);
        reject.addActionListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Car Request");
        setSize(1000, 3000);

    } // <--- CreateAdminForm(Car car) constructor

    public void actionPerformed(ActionEvent e) {

        Object obj = e.getSource();

        if (obj == accept) {
            try {
                outputStream.writeBoolean(true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (obj == reject) {
            try {
                outputStream.writeBoolean(false);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (obj == back) {
            dispose();
            Login.main(null);
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
    } // <--- actionPerformed() method ends here

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
                "Welcome to the admin page. Please select what data you would like to retrieve.");
        // Sets the Welcome string to White text
        welcome.setForeground(Color.WHITE);

        adminPage.add(welcome);
        add(adminPage, BorderLayout.NORTH);
        // Adding buttons to the panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(86, 53, 158));
        buttonPanel.add(jobByID);
        buttonPanel.add(carByID);
        buttonPanel.add(completeJobs);
        buttonPanel.add(jobsQueue);
        buttonPanel.add(allJobs);
        buttonPanel.add(allCars);
        buttonPanel.add(checkpointer);
        buttonPanel.add(back);
        add(buttonPanel, BorderLayout.CENTER);

        // Creating the action listener for the buttons

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Admin");
        setSize(1000, 3000);
        setVisible(true);

    } // <--- CreateAdminForm() constructor ends here

    public void log(String message) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    start();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    public static void start() throws IOException {
        ServerSocket ss = new ServerSocket(9806);
        System.out.println("Waiting for connections...");
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
        }
    } // <--- CreateAdminForm{} class ends here
}

class Admin {
    public static void main(String[] args) throws IOException {
        System.out.println("Admin connected...");
        CreateAdminForm form = new CreateAdminForm();
        form.setSize(800, 800);
        form.setVisible(true);
        
        form.log("Server started...");
        // <--- while() loop ends here

    }

    // <--- main() method ends here
} // <--- Admin{} class ends here