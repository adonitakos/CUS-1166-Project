import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RejectionPopUp extends JFrame implements ActionListener {
    JPanel mainPanel, buttonPanel;
    JLabel rejectionLabel;
    JButton close;

    // ------------------------------------------
    // This constructor creates the GUI for the car rejection pop-up
    RejectionPopUp(Car car) {

        // Rejection Label
        rejectionLabel = new JLabel("I'm sorry, your car has been rejected by the VCC.", SwingConstants.CENTER);
        rejectionLabel.setForeground(Color.WHITE);
        rejectionLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        rejectionLabel.setBackground(new Color(217, 217, 217));

        // Close Button
        close = new JButton("Close");
        close.setBounds(110, 270, 100, 34);
        close.setBackground(new Color(217, 217, 217));
        close.setForeground(new Color(86, 53, 158));
        close.setFont(new Font("Inter", Font.BOLD, 16));

        // Main panel for rejection label
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(86, 53, 158));
        mainPanel.add(rejectionLabel);
        add(mainPanel, BorderLayout.CENTER);

         // Creating button panel
         buttonPanel = new JPanel();
         // Adding buttons to panel
         buttonPanel.add(close);
         add(buttonPanel, BorderLayout.SOUTH);

        // Creating action listener for the buttons
        close.addActionListener(this);

        // Setting title, size, and visibility
        setTitle("Car Rejection");
        setSize(500, 350);
        setVisible(true);
    } // <--- RejectionPopUp(Car car) constructor ends here

    // ------------------------------------------
    // This constructor creates the GUI for the job rejection pop-up
    RejectionPopUp(Job job) {

        // Rejection label
        rejectionLabel = new JLabel("I'm sorry, your job has been rejected by the VCC.", SwingConstants.CENTER);
        rejectionLabel.setForeground(Color.WHITE);
        rejectionLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        rejectionLabel.setBackground(new Color(217, 217, 217));

        // Close Button
        close = new JButton("Close");
        close.setBounds(110, 270, 100, 34);
        close.setBackground(new Color(217, 217, 217));
        close.setForeground(new Color(86, 53, 158));
        close.setFont(new Font("Inter", Font.BOLD, 16));

        // Main panel for rejection label
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(86, 53, 158));
        mainPanel.add(rejectionLabel);
        add(mainPanel, BorderLayout.CENTER);

         // Creating button panel
         buttonPanel = new JPanel();
         // Adding buttons to panel
         buttonPanel.add(close);
         add(buttonPanel, BorderLayout.SOUTH);

        // Creating action listener for the buttons
        close.addActionListener(this);

        // Setting title, size, and visibility
        setTitle("Job Rejection");
        setSize(500, 350);
        setVisible(true);
    } // <--- RejectionPopUp() constructor ends here

    // ------------------------------------------
    // Action listener method
    public void actionPerformed(ActionEvent e) {
        // disposes of pop-up once the close button is pressed.
        dispose();
    } // <--- actionPerformed() method ends here

} // <--- RejectionPopUp{} class ends here