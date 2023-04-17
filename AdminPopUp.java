import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.net.*;
import java.util.LinkedList;
import java.awt.event.ActionListener;
import java.io.*;

class PopUp extends JFrame implements ActionListener {

    private JPanel carByID, jobByID, buttonPanel;
    private JLabel infoLabel;
    private JButton close;

    PopUp(Car car, Socket socket, DataInputStream inputStream, DataOutputStream outputStream) {

            infoLabel = new JLabel("This is the carByID pop up panel.", SwingConstants.CENTER);
            infoLabel.setForeground(Color.WHITE);
            infoLabel.setFont(new Font("Inter", Font.BOLD, 16));
            infoLabel.setBackground(new Color(217, 217, 217));

            carByID = new JPanel();
            carByID.setBackground(new Color(86, 53, 158));
            carByID.add(infoLabel);
            add(carByID, BorderLayout.CENTER);

            close = new JButton("Close");
            close.setBounds(110, 310, 100, 34);
            close.setBackground(new Color(217, 217, 217));
            close.setForeground(new Color(86, 53, 158));
            close.setFont(new Font("Inter", Font.BOLD, 16));

            buttonPanel = new JPanel();
            // Adding buttons to panel
            buttonPanel.add(close);
            add(buttonPanel, BorderLayout.SOUTH);
            close.addActionListener(this);


            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("Get Car By ID");
            setSize(400, 275);
            setVisible(true);
    }

    PopUp(Job job) {

        infoLabel = new JLabel("This is the jobByID pop up panel.", SwingConstants.CENTER);
        infoLabel.setForeground(Color.WHITE);
        infoLabel.setFont(new Font("Inter", Font.BOLD, 16));
        infoLabel.setBackground(new Color(217, 217, 217));

        jobByID = new JPanel();
        jobByID.setBackground(new Color(86, 53, 158));
        jobByID.add(infoLabel);
        add(jobByID, BorderLayout.CENTER);

        close = new JButton("Close");
        close.setBounds(110, 310, 100, 34);
        close.setBackground(new Color(217, 217, 217));
        close.setForeground(new Color(86, 53, 158));
        close.setFont(new Font("Inter", Font.BOLD, 16));

        buttonPanel = new JPanel();
        // Adding buttons to panel
        buttonPanel.add(close);
        add(buttonPanel, BorderLayout.SOUTH);
        close.addActionListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Get Job By ID");
        setSize(400, 275);
        setVisible(true);

    }

    PopUp(LinkedList<Car> Cars) {

    }
public void actionPerformed(ActionEvent e) {
    dispose();
}

}