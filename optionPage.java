import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class optionPage extends JFrame implements ActionListener {
   JButton owner;
   JButton client;
   JPanel clientUser;
  optionPage() {
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Welcome");
    setSize(400,200);   
    
    

    owner = new JButton("Car");
    client = new JButton("Job");
    
    clientUser = new JPanel(new GridLayout(3, 1));
    JLabel welcomeLabel = new JLabel("Welcome, would you like to submit a car or a job?");
   
    clientUser.add(welcomeLabel);
    clientUser.add(owner);
    clientUser.add(client);


    add(clientUser, BorderLayout.CENTER);
    owner.addActionListener(this);
      client.addActionListener(this);
  }

   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      if (obj == owner) {
      ownerWindow ownerPage = new ownerWindow();
      ownerPage.setVisible(true);
      }
      else if (obj == client) {
         clientWindow clientWindow = new clientWindow();
         clientWindow.setVisible(true);
      }
      else {
         System.out.println("error");
      }
   }
}




