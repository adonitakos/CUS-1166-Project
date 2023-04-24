import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.net.*;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;


class CarTableModel extends AbstractTableModel {
    private String[] columnNames = {"ID", "License Plate", "OwnerID", "Make", "Model", "Time", "In-Use?", "Current JobID"};
    private LinkedList<Car> data;

    public CarTableModel(LinkedList<Car> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        Car car = data.get(row);
        switch (col) {
            case 0:
                return car.getCarID();
            case 1:
                return car.getCarLicensePlate();
            case 2:
                return car.getOwnerID();
            case 3:
                return car.getCarMake();
            case 4:
                return car.getCarModel();
            case 5:
                return car.getCarResidencyTime();
            case 6:
                return car.getStatus();
            case 7:
                return car.getJobID();
            default:
                return null;
        } // <--- switch(col) statment ends here
    } // <--- getValueAt() method ends here

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

} // <--- CarTableModel{} class ends here

class JobTableModel extends AbstractTableModel {
    private String[] columnNames = {"ID", "Duration", "Deadline", "Status", "Redundancy", "Completion Time", "Description",  "Job Owner ID", "Cars Using Num"};
    private LinkedList<Job> data;

    public JobTableModel(LinkedList<Job> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        Job job = data.get(row);
        switch (col) {
            case 0:
                return job.getJobID();
            case 1:
                return job.getJobDuration();
            case 2:
                return job.getJobDeadline();
            case 3:
                return job.getStatus();
            case 4:
                return job.getRedundancy();
            case 5:
                return job.getCompletionTime();
            case 6:
                return job.getJobDescription();
            case 7:
                return job.getOwnerID();
            case 8:
                return job.getCurrentCarNum();
            default:
                return null;
        } // <--- switch() case ends here
        
    } // <--- getValueAt() method ends here

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }   

} // <--- JobTableModel{} class ends here

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

    PopUp(LinkedList<Job> allJobs, boolean isCompleted) {

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

        // Jobs table
        JobTableModel jobTableModel = new JobTableModel(allJobs);
        JTable table = new JTable(jobTableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        mainPanel.add(table);

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
        setSize(800, 275);
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


    PopUp(LinkedList<Car> cars) {

        // Info Label
        infoLabel = new JLabel("This is the Cars pop up panel.", SwingConstants.CENTER);
        infoLabel.setForeground(Color.WHITE);
        infoLabel.setFont(new Font("Inter", Font.BOLD, 16));
        infoLabel.setBackground(new Color(217, 217, 217));

        // Creating the main panel
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(86, 53, 158));
        // Adding variables to the main panel
        mainPanel.add(infoLabel);
        add(mainPanel, BorderLayout.CENTER);

        // Cars table
        CarTableModel carTableModel = new CarTableModel(cars);
        JTable table = new JTable(carTableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        mainPanel.add(table);

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
        setSize(800, 275);
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