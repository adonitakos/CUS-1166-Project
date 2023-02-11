import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
class userPage extends JFrame {

JPanel userPage;

    userPage() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Welcome User");
        setSize(400,200);   

        userPage = new JPanel(new GridLayout(4, 1));
        JLabel welcome = new JLabel("Welcome to the user page.");

        userPage.add(welcome);

    }
}


