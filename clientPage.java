import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
class clientWindow extends JFrame implements ActionListener {

JPanel clientPage;

    clientWindow() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Welcome User");
        setSize(400,200);   

        clientPage = new JPanel(new GridLayout(4, 1));
        JLabel welcome = new JLabel("Welcome to the client page.");

        clientPage.add(welcome);
        add(clientPage, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
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