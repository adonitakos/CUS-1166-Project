import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

class ownerWindow extends JFrame implements ActionListener {
    
// Intializing variables
    JPanel ownerPage;
    JLabel ownerID, make, model, licensePlate;
    final JTextField ownerIDText, makeText, modelText, licensePlateText;
    JButton submit;

    ownerWindow() {
    // Assigning variables values
        ownerID = new JLabel();
        ownerID.setText("Owner ID");
        ownerIDText = new JTextField(15);
        make = new JLabel();
        make.setText("Make");
        makeText = new JTextField(15);
        model = new JLabel();
        model.setText("Model");
        modelText = new JTextField(15);
        licensePlate = new JLabel();
        licensePlate.setText("License Plate");
        licensePlateText = new JTextField(15);
        submit = new JButton("Submit");

    // Creating new panel
        ownerPage = new JPanel(new GridLayout(15, 1));
        JLabel welcome = new JLabel("Welcome to the owner page. Please enter the following information, leaving no fields blank.");
    // Adding variables to panel
        ownerPage.add(welcome);
        ownerPage.add(ownerID);
        ownerPage.add(ownerIDText);
        ownerPage.add(make);
        ownerPage.add(makeText);
        ownerPage.add(model);
        ownerPage.add(modelText);
        ownerPage.add(licensePlate);
        ownerPage.add(licensePlateText);
        ownerPage.add(submit);
        add(ownerPage, BorderLayout.CENTER);
        // creating action listener for the submit button
        submit.addActionListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Car Submission");
        setSize(1000,3000);  
    } // <--- ownerPage() constructor ends here

// Creating action listener method
    public void actionPerformed(ActionEvent e) {
        // assigning the information that will be inputted by the user as string variables
        String ownerIDInfo = ownerIDText.getText();
        String ownerMake = makeText.getText();
        String ownerModel = modelText.getText();
        String ownerLicensePlate = licensePlateText.getText();

        // if all the info inputted equals 1, it will tell the user their car has been submitted
        if (ownerIDInfo.equals(1) && ownerMake.equals(1) && ownerModel.equals(1) && ownerLicensePlate.equals(1)) {
            System.out.println("Thank you. Your car has been submitted.");
        }
        // else, it will give an error message and let the user try again
        else {
            System.out.println("There has been an error submitting your car. Please try again.");
        }
    } // <--- actionPerformed() method ends here

} // <--- ownerWindows{} class ends here

class ownerPage {
    public static void main(String[] args) {
        try {
            ownerWindow form = new ownerWindow();
            form.setSize(300,100);
            form.setVisible(true);
        }

        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    } // <--- main() method ends here
} // <--- ownerPage{} class ends here