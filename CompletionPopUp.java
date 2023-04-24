import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CompletionPopUp extends JFrame implements ActionListener {

    JPanel mainPanel, buttonPanel;
    JLabel completionTimeLabel;
    JButton close;

    CompletionPopUp(Job job) {

        // Rejection label
        completionTimeLabel = new JLabel("Your completion time is " + job.getCompletionTime() + " hours.", SwingConstants.CENTER);
        completionTimeLabel.setForeground(Color.WHITE);
        completionTimeLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        completionTimeLabel.setBackground(new Color(217, 217, 217));

        // Close Button
        close = new JButton("Close");
        close.setBounds(110, 270, 100, 34);
        close.setBackground(new Color(217, 217, 217));
        close.setForeground(new Color(86, 53, 158));
        close.setFont(new Font("Inter", Font.BOLD, 16));

        // Main panel for rejection label
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(86, 53, 158));
        mainPanel.add(completionTimeLabel);
        add(mainPanel, BorderLayout.CENTER);

         // Creating button panel
         buttonPanel = new JPanel();
         // Adding buttons to panel
         buttonPanel.add(close);
         add(buttonPanel, BorderLayout.SOUTH);

        // Creating action listener for the buttons
        close.addActionListener(this);

        // Setting title, size, and visibility
        setTitle("Completion Time");
        setSize(320, 100);
        setVisible(true);
    } // <--- RejectionPopUp() constructor ends here

    // ------------------------------------------
    // Action listener method
    public void actionPerformed(ActionEvent e) {
        // disposes of pop-up once the close button is pressed.
        dispose();
    } // <--- actionPerformed() method ends here

} // <--- CompletionPopUp{} class ends here
