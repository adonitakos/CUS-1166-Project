import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.io.*;

class CreateAdminForm extends JFrame { // implements ActionListener

    // Initializing variables
    private JPanel admin, buttonPanel;
    // private JLabel allCarsLabel, allJobsLabel, completeJobsLabel,
    // incompleteJobsLabel, carByIdLabel, jobByIdLabel;
    private JTextField carByIdField, jobByIdField;
    private JButton back;

    // Instantiate the VCC class in the Admin class
    VCC vcc = VCC.getInstance();

    CreateAdminForm() {
        // carByIdLabel = new JLabel("Enter car ID:");
        // carByIdField = new JTextField(15);

        // jobByIdLabel = new JLabel("Enter job ID:");
        // jobByIdField = new JTextField(15);

        // All Cars Description Label
        // allCarsLabel = new JLabel();
        // allCarsLabel.setText("All Cars");
        // allCarsLabel.setForeground(Color.WHITE);
        // allCarsLabel.setForeground(Color.WHITE);
        // allCarsLabel.setBorder(BorderFactory.createCompoundBorder(
        // BorderFactory.createLineBorder(new Color(86, 53, 158)),
        // BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // // Complete Jobs Description Label
        // completeJobsLabel = new JLabel("Thank you. Your job has been submitted.",
        // SwingConstants.CENTER);
        // completeJobsLabel.setForeground(Color.WHITE);
        // completeJobsLabel.setFont(new Font("Inter", Font.BOLD, 16));
        // completeJobsLabel.setBackground(new Color(217, 217, 217));
        // completeJobsLabel.setBorder(BorderFactory.createCompoundBorder(
        // BorderFactory.createLineBorder(new Color(86, 53, 158)),
        // BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // // Incomplete Jobs Description Label
        // incompleteJobsLabel = new JLabel("Incomplete Jobs", SwingConstants.CENTER);
        // incompleteJobsLabel.setForeground(Color.WHITE);
        // incompleteJobsLabel.setFont(new Font("Inter", Font.BOLD, 16));
        // incompleteJobsLabel.setBackground(new Color(217, 217, 217));
        // incompleteJobsLabel.setBorder(BorderFactory.createCompoundBorder(
        // BorderFactory.createLineBorder(new Color(86, 53, 158)),
        // BorderFactory.createEmptyBorder(10, 10, 10, 10))); // <-- Add empty border as
        // second argument

        // // All jobs Description Label
        // allJobsLabel = new JLabel();
        // allJobsLabel.setText("all Cars");
        // allJobsLabel.setForeground(Color.WHITE);
        // allJobsLabel.setText("all Cars");
        // allJobsLabel.setBorder(BorderFactory.createCompoundBorder(
        // BorderFactory.createLineBorder(new Color(86, 53, 158)),
        // BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Creating new panel
        admin = new JPanel(new GridLayout(15, 1));
        admin.setBackground(new Color(86, 53, 158));
        JLabel welcome = new JLabel(
                "Welcome to the Admin page. Please enter your credentials, leaving no fields blank.");

        // Sets the Welcome string to White text
        welcome.setForeground(Color.WHITE);

        // Back Button
        back = new JButton("Back");
        back.setBounds(110, 270, 100, 34);
        back.setBackground(new Color(217, 217, 217));
        back.setForeground(new Color(86, 53, 158));
        back.setFont(new Font("Inter", Font.BOLD, 16));

        // Adding buttons to the panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(back);
        add(buttonPanel, BorderLayout.SOUTH);

        admin.add(welcome);
        // admin.add(allCarsLabel);
        // admin.add(allJobsLabel);
        // admin.add(completeJobsLabel);
        // admin.add(incompleteJobsLabel);
        // admin.add(carByIdLabel);
        // admin.add(carByIdField);
        // admin.add(jobByIdLabel);
        // admin.add(jobByIdField);

        add(admin, BorderLayout.CENTER);

 

        // Creating the action listener for the buttons

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Admin Entry");
        setSize(1000, 3000);

    } // <--- CreateAdminForm() constructor ends here

    // Action performer class has to be corrected

    // public void actionPerformed(ActionEvent e) {

    // Object obj = e.getSource();

    // } // <--- actionPerformed() method ends here

} // <--- CreateAdminForm{} class ends here

class Admin {
    public static void main(String[] args) {
        System.out.println("\n========= Admin =========\n");
        try {
            CreateAdminForm form = new CreateAdminForm();
            // form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            form.setSize(800, 800);
            form.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    } // <--- main() method ends here

} // <--- Admin{} class ends here