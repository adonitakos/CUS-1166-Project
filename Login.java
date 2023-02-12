import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.awt.event.ActionListener;
    class CreateLoginForm extends JFrame implements ActionListener {

        // initializing variables
        JButton submit;
        JPanel newPanel;
        JLabel userLabel, passwordLabel;
        final JTextField textField1, textField2;

        CreateLoginForm() {

            // assigning variables values
            userLabel = new JLabel();
            userLabel.setText("Username");
            textField1 = new JTextField(15);
            passwordLabel = new JLabel();
            passwordLabel.setText("Password");
            textField2 = new JPasswordField(15);
            submit = new JButton("Submit");

            // creating a new panel
            newPanel = new JPanel(new GridLayout(3, 1));
            // adding variables to panel
            newPanel.add(userLabel);
            newPanel.add(textField1);
            newPanel.add(passwordLabel);
            newPanel.add(textField2);
            newPanel.add(submit);
            add(newPanel, BorderLayout.CENTER);

            // creating action listener for the submit button
            submit.addActionListener(this);
            setTitle("Login Form");
        }

        // action listener class for the submit button
        public void actionPerformed(ActionEvent ae) {
        // assigning the information that will be inputted by the user as string variables
        String userValue = textField1.getText();
        String passValue = textField2.getText();

        // if the user inputs the username and password as 1, it will bring the user to the optionPage
        if (userValue.equals("1") && passValue.equals("1")) {
            optionPage page = new optionPage();
            page.setVisible(true);
        }
        // else, it will tell them it is the wrong user and pass and it will have them try again
        else {
            System.out.println("Wrong username and pass.");
        }
        }
    }
class Login {
    public static void main(String[] args) {
        try {
            CreateLoginForm form = new CreateLoginForm();
            form.setSize(300,100);
            form.setVisible(true);
        }

        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}