import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RejectionPopUp extends JFrame implements ActionListener {
    JPanel mainPanel, buttonPanel;
    JLabel rejectionLabel;
    JButton close;

    RejectionPopUp(Car car) {

        // Rejection label
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

        setTitle("Car Rejection");
        setSize(500, 350);
        setVisible(true);
    }

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

        setTitle("Job Rejection");
        setSize(500, 350);
        setVisible(true);
    }

    

    public void actionPerformed(ActionEvent e) {
        dispose();
    } // <--- actionPerformed() method ends here

}
