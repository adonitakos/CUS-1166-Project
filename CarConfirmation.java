import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CarConfirmation extends JFrame implements ActionListener {
    // Initializing variables
    private JPanel titlePanel, confirmationPanel, buttonPanel;
    private JLabel thankYouLabel, carLicensePlateLabel, carIDLabel, carMakeLabel, carModelLabel, carResidencyTimeLabel;
    private JButton close;

    // ------------------------------------------
    // This method creates the GUI for the JobConfirmation
    CarConfirmation(Car car) {

        // Assigning variables values
        // Thank you label
        thankYouLabel = new JLabel("Thank you. Your car has been submitted.", SwingConstants.CENTER);
        thankYouLabel.setForeground(Color.WHITE);
        thankYouLabel.setFont(new Font("Inter", Font.BOLD, 22));
        thankYouLabel.setBackground(new Color(217, 217, 217));

        // JobID label
        carIDLabel = new JLabel("<html><b><u>Car ID:</u></b> " + car.getCarID() + "</html>", SwingConstants.CENTER);
        carIDLabel.setForeground(Color.WHITE);
        carIDLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        carIDLabel.setBackground(new Color(217, 217, 217));

        // Job Duration Label
        carLicensePlateLabel = new JLabel("<html><b><u>License Plate:</b></u> " + car.getCarLicensePlate() + " hours.</html>", SwingConstants.CENTER);
        carLicensePlateLabel.setForeground(Color.WHITE);
        carLicensePlateLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        carLicensePlateLabel.setBackground(new Color(217, 217, 217));

        // Job Deadline Label
        carMakeLabel = new JLabel("<html><b><u>Make:</b></u> " + car.getCarMake() + "</html>", SwingConstants.CENTER);
        carMakeLabel.setForeground(Color.WHITE);
        carMakeLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        carMakeLabel.setBackground(new Color(217, 217, 217));

        // Job Description Label
        carModelLabel = new JLabel("<html><b><u>Model:</b></u> " + car.getCarModel() + "</html>", SwingConstants.CENTER);
        carModelLabel.setForeground(Color.WHITE);
        carModelLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        carModelLabel.setBackground(new Color(217, 217, 217));

        // Job Completion Label
        carResidencyTimeLabel = new JLabel("<html><b><u>Residency Time:</b></u> " + car.getCarResidencyTime() + " hours.</html>", SwingConstants.CENTER);
        carResidencyTimeLabel.setForeground(Color.WHITE);
        carResidencyTimeLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        carResidencyTimeLabel.setBackground(new Color(217, 217, 217));

        // Close Button
        close = new JButton("Close");
        close.setBounds(110, 270, 100, 34);
        close.setBackground(new Color(217, 217, 217));
        close.setForeground(new Color(86, 53, 158));
        close.setFont(new Font("Inter", Font.BOLD, 16));

        // Creating title panel
        titlePanel = new JPanel();
        titlePanel.setBackground(new Color(86, 53, 158));
        titlePanel.add(thankYouLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Creating confirmation panel
        confirmationPanel = new JPanel(new GridLayout(5, 1));
        confirmationPanel.setBackground(new Color(86, 53, 158));

        // Adding variables to the panel
        confirmationPanel.add(carIDLabel);
        confirmationPanel.add(carLicensePlateLabel);
        confirmationPanel.add(carMakeLabel);
        confirmationPanel.add(carModelLabel);
        confirmationPanel.add(carResidencyTimeLabel);

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
