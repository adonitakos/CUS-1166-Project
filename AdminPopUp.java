import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.net.*;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.event.ActionListener;
import java.io.*;

class PopUp extends JFrame implements ActionListener {

    // Initializing Variables
    private JPanel mainPanel, buttonPanel;
    private JLabel infoLabel;
    private JButton close;

    PopUp(Car car, Socket socket, DataInputStream inputStream, DataOutputStream outputStream) {

            // Info Label
            infoLabel = new JLabel("This is the carByID pop up panel.", SwingConstants.CENTER);
            infoLabel.setForeground(Color.WHITE);
            infoLabel.setFont(new Font("Inter", Font.BOLD, 16));
            infoLabel.setBackground(new Color(217, 217, 217));

            // Creating the main panel
            mainPanel = new JPanel();
            mainPanel.setBackground(new Color(86, 53, 158));
            // Adding variables to the main panel
            mainPanel.add(infoLabel);
            add(mainPanel, BorderLayout.CENTER);

            // Close Button
            close = new JButton("Close");
            close.setBounds(110, 310, 100, 34);
            close.setBackground(new Color(217, 217, 217));
            close.setForeground(new Color(86, 53, 158));
            close.setFont(new Font("Inter", Font.BOLD, 16));

            // Creating the button panel
            buttonPanel = new JPanel();
            // Adding buttons to panel
            buttonPanel.add(close);
            add(buttonPanel, BorderLayout.SOUTH);

            // Action Listener
            close.addActionListener(this);

            // Setting title, size, and visibility
            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("Admin - Car By ID");
            setSize(400, 275);
            setVisible(true);

    } // <--- PopUp(Car car) constructor

    PopUp(Job job, Socket socket, DataInputStream inputStream, DataOutputStream outputStream) {

        // Info Label
        infoLabel = new JLabel("This is the jobByID pop up panel.", SwingConstants.CENTER);
        infoLabel.setForeground(Color.WHITE);
        infoLabel.setFont(new Font("Inter", Font.BOLD, 16));
        infoLabel.setBackground(new Color(217, 217, 217));

        // Creating the main panel
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(86, 53, 158));
        // Adding variables to the main panel
        mainPanel.add(infoLabel);
        add(mainPanel, BorderLayout.CENTER);

        // Close Button
        close = new JButton("Close");
        close.setBounds(110, 310, 100, 34);
        close.setBackground(new Color(217, 217, 217));
        close.setForeground(new Color(86, 53, 158));
        close.setFont(new Font("Inter", Font.BOLD, 16));

        // Creating the button panel
        buttonPanel = new JPanel();
        // Adding buttons to panel
        buttonPanel.add(close);
        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listener
        close.addActionListener(this);

        // Setting title, size, and visibility
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admin - Job By ID");
        setSize(400, 275);
        setVisible(true);

    } // <--- PopUp(Job job) constructor

    PopUp(LinkedList<Job> allJobs) {

        // Info Label
        infoLabel = new JLabel("This is the Completed Jobs pop up panel.", SwingConstants.CENTER);
        infoLabel.setForeground(Color.WHITE);
        infoLabel.setFont(new Font("Inter", Font.BOLD, 16));
        infoLabel.setBackground(new Color(217, 217, 217));

        // Creating the main panel
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(86, 53, 158));
        // Adding variables to the main panel
        mainPanel.add(infoLabel);
        add(mainPanel, BorderLayout.CENTER);

        // Close Button
        close = new JButton("Close");
        close.setBounds(110, 310, 100, 34);
        close.setBackground(new Color(217, 217, 217));
        close.setForeground(new Color(86, 53, 158));
        close.setFont(new Font("Inter", Font.BOLD, 16));

        // Creating the button panel
        buttonPanel = new JPanel();
        // Adding buttons to panel
        buttonPanel.add(close);
        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listener
        close.addActionListener(this);

        // Setting title, size, and visibility
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admin - Completed Jobs");
        setSize(400, 275);
        setVisible(true);

    } // <--- PopUp(Job job) constructor

    PopUp(Queue<Job> jobsQueue) {

        // Info Label
        infoLabel = new JLabel("This is the Jobs Queue pop up panel.", SwingConstants.CENTER);
        infoLabel.setForeground(Color.WHITE);
        infoLabel.setFont(new Font("Inter", Font.BOLD, 16));
        infoLabel.setBackground(new Color(217, 217, 217));

        // Creating the main panel
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(86, 53, 158));
        // Adding variables to the main panel
        mainPanel.add(infoLabel);
        add(mainPanel, BorderLayout.CENTER);

        // Close Buttton
        close = new JButton("Close");
        close.setBounds(110, 310, 100, 34);
        close.setBackground(new Color(217, 217, 217));
        close.setForeground(new Color(86, 53, 158));
        close.setFont(new Font("Inter", Font.BOLD, 16));

        // Creating the button panel
        buttonPanel = new JPanel();
        // Adding buttons to panel
        buttonPanel.add(close);
        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listener
        close.addActionListener(this);

        // Setting title, size, and visibility
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admin - Jobs Queue");
        setSize(400, 275);
        setVisible(true);

    } // <--- PopUp(Queue<Job> jobsQueue) constructor

    PopUp(LinkedList<Job> allJobs) {

        // Info Label
        infoLabel = new JLabel("This is the All Jobs pop up panel.", SwingConstants.CENTER);
        infoLabel.setForeground(Color.WHITE);
        infoLabel.setFont(new Font("Inter", Font.BOLD, 16));
        infoLabel.setBackground(new Color(217, 217, 217));

        // Creating the main panel
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(86, 53, 158));
        // Adding variables to the main panel
        mainPanel.add(infoLabel);
        add(mainPanel, BorderLayout.CENTER);

        // Close Button
        close = new JButton("Close");
        close.setBounds(110, 310, 100, 34);
        close.setBackground(new Color(217, 217, 217));
        close.setForeground(new Color(86, 53, 158));
        close.setFont(new Font("Inter", Font.BOLD, 16));

        // Creating the button panel
        buttonPanel = new JPanel();
        // Adding buttons to panel
        buttonPanel.add(close);
        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listener
        close.addActionListener(this);

        // Setting title, size, and visibility
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admin - All Jobs");
        setSize(400, 275);
        setVisible(true);

    } // <--- PopUp(Linked List<Job> allJobs) constructor

    PopUp(LinkedList<Car> Cars) {

        // Info Label
        infoLabel = new JLabel("This is the All Cars pop up panel.", SwingConstants.CENTER);
        infoLabel.setForeground(Color.WHITE);
        infoLabel.setFont(new Font("Inter", Font.BOLD, 16));
        infoLabel.setBackground(new Color(217, 217, 217));

        // Creating the main panel
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(86, 53, 158));
        // Adding variables to the main panel
        mainPanel.add(infoLabel);
        add(mainPanel, BorderLayout.CENTER);

        // Close button
        close = new JButton("Close");
        close.setBounds(110, 310, 100, 34);
        close.setBackground(new Color(217, 217, 217));
        close.setForeground(new Color(86, 53, 158));
        close.setFont(new Font("Inter", Font.BOLD, 16));

        // Creating the button panel
        buttonPanel = new JPanel();
        // Adding buttons to panel
        buttonPanel.add(close);
        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listener
        close.addActionListener(this);

        // Setting title, size, and visibility
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admin - All Cars");
        setSize(400, 275);
        setVisible(true);

    } // <--- PopUp(Linked List<Car> Cars) constructor

    PopUp(LinkedList<Car> Cars, LinkedList<Job> allJobs) {

        // Info Label
        infoLabel = new JLabel("This is the Checkpoint pop up panel.", SwingConstants.CENTER);
        infoLabel.setForeground(Color.WHITE);
        infoLabel.setFont(new Font("Inter", Font.BOLD, 16));
        infoLabel.setBackground(new Color(217, 217, 217));

        // Creating the main panel
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(86, 53, 158));
        // Adding variables to the main panel
        mainPanel.add(infoLabel);
        add(mainPanel, BorderLayout.CENTER);

        // Close Button
        close = new JButton("Close");
        close.setBounds(110, 310, 100, 34);
        close.setBackground(new Color(217, 217, 217));
        close.setForeground(new Color(86, 53, 158));
        close.setFont(new Font("Inter", Font.BOLD, 16));

        // Creating the button panel
        buttonPanel = new JPanel();
        // Adding buttons to panel
        buttonPanel.add(close);
        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listener
        close.addActionListener(this);

        // Setting title, size, and visibility
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admin - Checkpoint");
        setSize(400, 275);
        setVisible(true);

    } // <--- PopUp(Cars, allJobs) constructor
    
    public void actionPerformed(ActionEvent e) {
        dispose();
    }  // <--- actionPerformed() method ends here
} // <--- AdminPopup{} class ends here