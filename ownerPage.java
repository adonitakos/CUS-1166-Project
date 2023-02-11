import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
class ownerWindow extends JFrame implements ActionListener {

JPanel ownerPage;
JLabel ownerID, make, model, licensePlate;
final JTextField ownerIDText, makeText, modelText, licensePlateText;
JButton submit;

    ownerWindow() {
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

       
        ownerPage = new JPanel(new GridLayout(15, 1));
        JLabel welcome = new JLabel("Welcome to the owner page. Please enter the following information, leaving no fields blank.");
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

        submit.addActionListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Car Submission");
        setSize(1000,5000);  

    }

    public void actionPerformed(ActionEvent e) {
        String ownerIDInfo = ownerIDText.getText();
        String ownerMake = makeText.getText();
        String ownerModel = modelText.getText();
        String ownerLicensePlate = licensePlateText.getText();

        if (ownerIDInfo.equals(1) && ownerMake.equals(1) && ownerModel.equals(1) && ownerLicensePlate.equals(1)) {
            System.out.println("Thank you. Your car has been submitted.");
        }
        else {
            System.out.println("There has been an error submitting your car. Please try again.");
        }

        
    }
}
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
    }

}





