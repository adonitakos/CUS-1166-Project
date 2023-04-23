/* Project: Vehicle Vortex
*  Class: AdminPage.java
*  Author: Summer Snyder, Antonios Takos, Teuta Elezaj, Christian Felix, Tahir Buksh, Jayden Kuprel
*  Date: April 16th, 2023 
*  This program creates the admin page, where the admin is able to accept/decline/view jobs.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.net.*;
import java.sql.SQLException;
import java.util.*;
import java.awt.event.ActionListener;
import java.io.*;

class CreateAdminForm extends JFrame implements ActionListener {

    // Initializing variables
    private JPanel welcomePanel, confirmationPanel, jobRequest, carRequest, buttonPanel, backPanel;
    private JLabel welcome, infoLabel, jobIDLabel, jobDurationLabel, jobDeadlineLabel, jobDescriptionLabel, confirmationLabel, carIDLabel,
            carMakeLabel, carModelLabel, carLicensePlateLabel, carResidencyTimeLabel;
    private JButton back, carByID, jobByID, allCars, allJobs, jobsQueue, completeJobs, checkpointer, accept, reject;
    private DataOutputStream outputStream;
    // Instantiate the VCC class in the Admin class
    VCC vcc = VCC.getInstance();

    // ---------------------------------------------------------------------------------
    // This constructor creates the GUI for the job review pop up
    CreateAdminForm(Job job, Socket socket, DataInputStream inputStream, DataOutputStream outputStream) {

        this.outputStream = outputStream;

        // Confirmation Label
        confirmationLabel = new JLabel("Please review the submitted job:", SwingConstants.CENTER);
        confirmationLabel.setForeground(Color.WHITE);
        confirmationLabel.setFont(new Font("Inter", Font.BOLD, 16));
        confirmationLabel.setBackground(new Color(217, 217, 217));

        // JobID Label
        jobIDLabel = new JLabel("<html><b><u>Job ID:</b></u> " + job.getJobID() + "</html>", SwingConstants.CENTER);
        jobIDLabel.setForeground(Color.WHITE);
        jobIDLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        jobIDLabel.setBackground(new Color(217, 217, 217));

        // Job Duration Label
        jobDurationLabel = new JLabel("<html><u><b>Duration:</u></b> " + job.getJobDuration() + " hours</html>", SwingConstants.CENTER);
        jobDurationLabel.setForeground(Color.WHITE);
        jobDurationLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        jobDurationLabel.setBackground(new Color(217, 217, 217));

        // Job Deadline Label
        jobDeadlineLabel = new JLabel("<html><u><b>Deadline:</u></b> " + job.getJobDeadline() + "</html>", SwingConstants.CENTER);
        jobDeadlineLabel.setForeground(Color.WHITE);
        jobDeadlineLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        jobDeadlineLabel.setBackground(new Color(217, 217, 217));

        // Job Description Label
        jobDescriptionLabel = new JLabel("<html><b><u>Description:</u></b> " + job.getJobDescription() +"</html>", SwingConstants.CENTER);
        jobDescriptionLabel.setForeground(Color.WHITE);
        jobDescriptionLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        jobDescriptionLabel.setBackground(new Color(217, 217, 217));
    
        // Accept Button
        accept = new JButton("Accept");
        accept.setBounds(110, 310, 100, 34);
        accept.setBackground(new Color(217, 217, 217));
        accept.setForeground(new Color(86, 53, 158));
        accept.setFont(new Font("Inter", Font.BOLD, 16));

        // Reject Button
        reject = new JButton("Reject");
        reject.setBounds(110, 310, 100, 34);
        reject.setBackground(new Color(217, 217, 217));
        reject.setForeground(new Color(86, 53, 158));
        reject.setFont(new Font("Inter", Font.BOLD, 16));
        
        // Creating title panel
        confirmationPanel = new JPanel();
        confirmationPanel.add(confirmationLabel);
        confirmationPanel.setBackground(new Color(86, 53, 158));
        add(confirmationPanel, BorderLayout.NORTH);

        // Creating main panel
        jobRequest = new JPanel(new GridLayout(4, 2));
        jobRequest.setBackground(new Color(86, 53, 158));

        // Adding variables to the panel
        jobRequest.add(jobIDLabel);
        jobRequest.add(jobDurationLabel);
        jobRequest.add(jobDeadlineLabel);
        jobRequest.add(jobDescriptionLabel);
        add(jobRequest, BorderLayout.CENTER);

        // Adding buttons to the panel
        buttonPanel = new JPanel();
        buttonPanel.add(accept);
        buttonPanel.add(reject);
        add(buttonPanel, BorderLayout.SOUTH);

        // Creating action listener for the buttons
        accept.addActionListener(this);
        reject.addActionListener(this);

        // Setting title, size, and visibility
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Job Request");
        setSize(400, 425);
        setVisible(true);

    } // <--- CreateAdminForm(Job job) constructor

    // ---------------------------------------------------------------------------------

    // This constructor creates the GUI for the car REVIEW pop up
    CreateAdminForm(Car car, Socket socket, DataInputStream inputStream, DataOutputStream outputStream) {

        this.outputStream = outputStream;

        // Confirmation Label
        confirmationLabel = new JLabel(
                "Please review the submitted car:",
                SwingConstants.CENTER);
        confirmationLabel.setForeground(Color.WHITE);
        confirmationLabel.setFont(new Font("Inter", Font.BOLD, 16));
        confirmationLabel.setBackground(new Color(217, 217, 217));

        // Car ID label (will eventually have same ID as user)
        carIDLabel = new JLabel("<html><b><u>Car ID:</b></u> " + car.getCarID() + "</html>", SwingConstants.CENTER);
        carIDLabel.setForeground(Color.WHITE);
        carIDLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        carIDLabel.setBackground(new Color(217, 217, 217));

        // Car Make Label
        carMakeLabel = new JLabel("<html><b><u>Make:</b></u> " + car.getCarMake() + "</html>", SwingConstants.CENTER);
        carMakeLabel.setForeground(Color.WHITE);
        carMakeLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        carMakeLabel.setBackground(new Color(217, 217, 217));

        // Car Model Label
        carModelLabel = new JLabel("<html><b><u>Model:</b></u> " + car.getCarModel() + "</html>", SwingConstants.CENTER);
        carModelLabel.setForeground(Color.WHITE);
        carModelLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        carModelLabel.setBackground(new Color(217, 217, 217));

        // Car License Plate Label
        carLicensePlateLabel = new JLabel("<html><b><u>License Plate:</b></u> " + car.getCarLicensePlate() + "</html>", SwingConstants.CENTER);
        carLicensePlateLabel.setForeground(Color.WHITE);
        carLicensePlateLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        carLicensePlateLabel.setBackground(new Color(217, 217, 217));

        // Car Residency Time Label
        carResidencyTimeLabel = new JLabel("<html><b><u>Residency Time:</b></u> " + car.getCarResidencyTime() + " hours</html>", SwingConstants.CENTER);
        carResidencyTimeLabel.setForeground(Color.WHITE);
        carResidencyTimeLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        carResidencyTimeLabel.setBackground(new Color(217, 217, 217));

        // Accept Button
        accept = new JButton("Accept");
        accept.setBounds(110, 310, 100, 34);
        accept.setBackground(new Color(217, 217, 217));
        accept.setForeground(new Color(86, 53, 158));
        accept.setFont(new Font("Inter", Font.BOLD, 16));

        // Reject Button
        reject = new JButton("Reject");
        reject.setBounds(110, 310, 100, 34);
        reject.setBackground(new Color(217, 217, 217));
        reject.setForeground(new Color(86, 53, 158));
        reject.setFont(new Font("Inter", Font.BOLD, 16));

        // Creating title panel
        confirmationPanel = new JPanel();
        confirmationPanel.add(confirmationLabel);
        confirmationPanel.setBackground(new Color(86, 53, 158));
        add(confirmationPanel, BorderLayout.NORTH);

        // Creating main panel
        carRequest = new JPanel(new GridLayout(5, 2));
        carRequest.setBackground(new Color(86, 53, 158));

        // Adding variables to the panel
        carRequest.add(carIDLabel);
        carRequest.add(carMakeLabel);
        carRequest.add(carModelLabel);
        carRequest.add(carLicensePlateLabel);
        carRequest.add(carResidencyTimeLabel);
        add(carRequest, BorderLayout.CENTER);

        // Creating button panel
        buttonPanel = new JPanel();
        // Adding buttons to panel
        buttonPanel.add(accept);
        buttonPanel.add(reject);
        add(buttonPanel, BorderLayout.SOUTH);

        // Creating action listener for the buttons
        accept.addActionListener(this);
        reject.addActionListener(this);

        // Setting the title, size, and visibility
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Car Request");
        setSize(400, 275);
        setVisible(true);

    } // <--- CreateAdminForm(Car car) constructor

    // ---------------------------------------------------------------------------------
    // Action Listener method
    public void actionPerformed(ActionEvent e) {

        // Storing the ActionEvent as an Object
        Object obj = e.getSource();

        if (obj == accept) {
            try {
                outputStream.writeBoolean(true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            dispose();
        } else if (obj == reject) {
            try {
                outputStream.writeBoolean(false);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            dispose();
        } else if (obj == back) {
            dispose();
            Login.main(null);
        } else if (obj == carByID) {
        //    PopUp form = new PopUp(car);

        } else if (obj == jobByID) {
        //    PopUp form = new PopUp(job);

        } else if (obj == allCars) {
            LinkedList<Car> cars;
            try {
                cars = vcc.getAllCars();
                System.out.println(cars);
                PopUp popUp = new PopUp(cars);
                JPanel popUpPanel = new JPanel();
                popUpPanel.add(popUp);
                popUpPanel.setBackground(new Color(86, 53, 158));
                setSize(500, 500);
                setVisible(true);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } else if (obj == allJobs) {
            LinkedList <Job> jobs;
            try {
                jobs = vcc.getAllJobs();
                System.out.println(jobs);
                PopUp popUp = new PopUp(jobs, false);
                JPanel popUpPanel = new JPanel();
                popUpPanel.add(popUp);
                popUpPanel.setBackground(new Color(86, 53, 158));
                setSize(500, 600);
                setVisible(true);
            }
            catch(ClassNotFoundException error) {
                error.printStackTrace();
            }   
            catch(SQLException error) {
                error.printStackTrace();
            }
        } else if (obj == jobsQueue) {
         //   PopUp form = new PopUp(jobsQueue);
        } else if (obj == completeJobs) {
        //    PopUp form = new PopUp(allJobs);

        } else if (obj == checkpointer) {
        //    PopUp form = new PopUp(Cars, allJobs);

        } else {
            System.out.println("Error.");
        }
    } // <--- actionPerformed() method ends here

    CreateAdminForm(User user) {

        // JobByID Button
        jobByID = new JButton("Job By ID");
        jobByID.setBackground(new Color(217, 217, 217));
        jobByID.setForeground(new Color(86, 53, 158));
        jobByID.setFont(new Font("Inter", Font.BOLD, 16));

        // carByID Button
        carByID = new JButton("Car By ID");
        carByID.setBackground(new Color(217, 217, 217));
        carByID.setForeground(new Color(86, 53, 158));
        carByID.setFont(new Font("Inter", Font.BOLD, 16));

        // completeJobs Button
        completeJobs = new JButton("Complete Jobs");
        completeJobs.setBackground(new Color(217, 217, 217));
        completeJobs.setForeground(new Color(86, 53, 158));
        completeJobs.setFont(new Font("Inter", Font.BOLD, 16));

        // jobsQueue Button
        jobsQueue = new JButton("Job Queue");
        jobsQueue.setBackground(new Color(217, 217, 217));
        jobsQueue.setForeground(new Color(86, 53, 158));
        jobsQueue.setFont(new Font("Inter", Font.BOLD, 16));

        // allJobs Button
        allJobs = new JButton("All Jobs");
        allJobs.setBackground(new Color(217, 217, 217));
        allJobs.setForeground(new Color(86, 53, 158));
        allJobs.setFont(new Font("Inter", Font.BOLD, 16));

        // allCars Button
        allCars = new JButton("All Cars");
        allCars.setBackground(new Color(217, 217, 217));
        allCars.setForeground(new Color(86, 53, 158));
        allCars.setFont(new Font("Inter", Font.BOLD, 16));

        // Checkpointer Button
        checkpointer = new JButton("Checkpoint");
        checkpointer.setBackground(new Color(217, 217, 217));
        checkpointer.setForeground(new Color(86, 53, 158));
        checkpointer.setFont(new Font("Inter", Font.BOLD, 16));

        // Back Button
        back = new JButton("Back");
        back.setBackground(new Color(217, 217, 217));
        back.setForeground(new Color(86, 53, 158));
        back.setFont(new Font("Inter", Font.BOLD, 16));

         // Welcome Label
         welcome = new JLabel("Welcome to the Admin Page.", SwingConstants.CENTER);
         // Sets the Welcome string to White text
         welcome.setForeground(Color.WHITE);
         welcome.setFont(new Font("Inter", Font.BOLD, 26));

         // Info Label
         infoLabel = new JLabel("Please select which data you would like to retrieve.", SwingConstants.CENTER);
         infoLabel.setForeground(Color.WHITE);
         infoLabel.setFont(new Font("Inter", Font.PLAIN, 12));

        // Creating welcome panel
        welcomePanel = new JPanel(new GridLayout(2,1));
        welcomePanel.setBackground(new Color(86, 53, 158));
        // Adding variables to the panel
        welcomePanel.add(welcome);
        welcomePanel.add(infoLabel);
        add(welcomePanel, BorderLayout.NORTH);

        // Creating button panel
        buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(86, 53, 158));
        // Adding buttons to the panel
        buttonPanel.add(jobByID);
        buttonPanel.add(carByID);
        buttonPanel.add(completeJobs);
        buttonPanel.add(jobsQueue);
        buttonPanel.add(allJobs);
        buttonPanel.add(allCars);
        buttonPanel.add(checkpointer);
        add(buttonPanel, BorderLayout.CENTER);

        // Creating the back panel
        backPanel = new JPanel();
        backPanel.add(back);
        add(backPanel, BorderLayout.SOUTH);

        // Creating action listeners for the buttons
        jobByID.addActionListener(this);
        carByID.addActionListener(this);
        completeJobs.addActionListener(this);
        jobsQueue.addActionListener(this);
        allJobs.addActionListener(this);
        allCars.addActionListener(this);
        checkpointer.addActionListener(this);
        back.addActionListener(this);

        // Setting the title, size, and visibility
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Admin");
        setSize(675, 350);
        setVisible(true);

    } // <--- CreateAdminForm(User user) constructor ends here

} // <--- CreateAdminForm{} class ends here

class Admin extends Thread {

    private User user;

    public Admin(User user) {
        this.user = user;
    }

    public void run() {
        System.out.println("Admin connected...");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CreateAdminForm form = new CreateAdminForm(user);
                form.setSize(800, 800);
                form.setVisible(true);
            }
        });
        ServerSocket ss;
        try {
            ss = new ServerSocket(9806);
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
            } // <--- while(true) loop ends here
        } // <--- try{} block ends here
        catch (Exception e) {
            e.printStackTrace();
        }  // <--- catch{} block ends here

    } // <--- run() method ends here

} // <--- CreateAdminForm{} class ends here