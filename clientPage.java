import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

class clientWindow extends JFrame implements ActionListener {
// Intitializing variables
    JLabel clientID, duration, deadline;
    final JTextField clientIDText, durationText, deadlineText;
    JButton submit;
    JPanel clientPage;

    clientWindow() {
    // Assigning variables values
        clientID = new JLabel();
        clientID.setText("Client ID");
        clientIDText = new JTextField(15);
        duration = new JLabel();
        duration.setText("Job Duration");
        durationText = new JTextField(15);
        deadline = new JLabel();
        deadline.setText("Job Deadline");
        deadlineText = new JTextField(15);
        submit = new JButton("Submit");

    // Creating a new panel
        clientPage = new JPanel(new GridLayout(8, 1));
        JLabel welcome = new JLabel("Welcome to the client page. Please enter the following information, leaving no fields blank.");

    // Adding variables to the panel
        clientPage.add(welcome);
        clientPage.add(clientID);
        clientPage.add(clientIDText);
        clientPage.add(duration);
        clientPage.add(durationText);
        clientPage.add(deadline);
        clientPage.add(deadlineText);
        clientPage.add(submit);
        add(clientPage, BorderLayout.CENTER);
    // Creating action listener for the submit button
        submit.addActionListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Job Submission");
        setSize(1000, 4000);   
    } // <--- clientWindows() constructor ends here

// Action Listener method
    public void actionPerformed(ActionEvent e) {
    // Assigning the information that will be inputted by the user as string variables
        String clientIDInfo = clientIDText.getText();
        String clientDuration = durationText.getText();
        String clientDeadline = deadlineText.getText();

    // IF all the information entered equals one, it will tell the user their job has been submitted
        if (clientIDInfo.equals(1) && clientDuration.equals(1) && clientDeadline.equals(1)) {
            System.out.println("Thank you. Your job has been submitted.");
        }
    // ELSE, it will have them try again
        else {
            System.out.println("There has been an error submitting your job. Please try again.");
        }
    } // <--- actionPerformed() method ends here
} // <--- clientWindow{} class ends here

class clientPage {
    public static void main(String[] args) {
        try {
            clientWindow form = new clientWindow();
            form.setSize(300,100);
            form.setVisible(true);
        }

        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    } // <--- main() method ends here
    
} // <--- clientPage{} class ends here