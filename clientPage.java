import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
class clientWindow extends JFrame implements ActionListener {
// intitializing variables
JLabel clientID, duration, deadline;
final JTextField clientIDText, durationText, deadlineText;
JButton submit;
JPanel clientPage;

    clientWindow() {
        // assigning variables values
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

        // creating a new panel
        clientPage = new JPanel(new GridLayout(8, 1));
        JLabel welcome = new JLabel("Welcome to the client page. Please enter the following information, leaving no fields blank.");

        // adding variables to the panel
        clientPage.add(welcome);
        clientPage.add(clientID);
        clientPage.add(clientIDText);
        clientPage.add(duration);
        clientPage.add(durationText);
        clientPage.add(deadline);
        clientPage.add(deadlineText);
        clientPage.add(submit);
        add(clientPage, BorderLayout.CENTER);
        // creating action listener for the submit button
        submit.addActionListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Job Submission");
        setSize(1000, 4000);   
    }
    // action listener method
    public void actionPerformed(ActionEvent e) {
        // assigning the information that will be inputted by the user as string variables
        String clientIDInfo = clientIDText.getText();
        String clientDuration = durationText.getText();
        String clientDeadline = deadlineText.getText();

        // if all the information entered equals one, it will tell the user their job has been submitted
        if (clientIDInfo.equals(1) && clientDuration.equals(1) && clientDeadline.equals(1)) {
            System.out.println("Thank you. Your job has been submitted.");
        }
        // else, it will have them try again
        else {
            System.out.println("There has been an error submitting your job. Please try again.");
        }
    }
}

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
    }
}