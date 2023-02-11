import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.awt.event.ActionListener;
    class CreateLoginForm extends JFrame implements ActionListener {
        JButton b1;
        JPanel newPanel;
        JLabel userLabel, passwordLabel;
        final JTextField textField1, textField2;

        CreateLoginForm() {
            userLabel = new JLabel();
            userLabel.setText("Username");
            textField1 = new JTextField(15);
            passwordLabel = new JLabel();
            passwordLabel.setText("Password");
            textField2 = new JPasswordField(15);
            b1 = new JButton("Submit");

            newPanel = new JPanel(new GridLayout(3, 1));
            newPanel.add(userLabel);
            newPanel.add(textField1);
            newPanel.add(passwordLabel);
            newPanel.add(textField2);
            newPanel.add(b1);

            add(newPanel, BorderLayout.CENTER);

            b1.addActionListener(this);
            setTitle("Login Form");
        }

        public void actionPerformed(ActionEvent ae) {
        String userValue = textField1.getText();
        String passValue = textField2.getText();

        if (userValue.equals("1") && passValue.equals("1")) {
            NewPage page = new NewPage();
            page.setVisible(true);

            

        }
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
