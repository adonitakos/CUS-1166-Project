import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class NewPage extends JFrame implements ActionListener {
   JButton user;
   JButton client;
   JPanel clientUser;
  NewPage() {
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Welcome");
    setSize(400,200);   
    
    

    user = new JButton("User");
    client = new JButton("Client");
    
    clientUser = new JPanel(new GridLayout(3, 1));
    JLabel welcomeLabel = new JLabel("Welcome, are you a client or user?");
   
    clientUser.add(welcomeLabel);
    clientUser.add(user);
    clientUser.add(client);


    add(clientUser, BorderLayout.CENTER);
    user.addActionListener(this);
      client.addActionListener(this);
  }

   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      if (obj == user) {
      NewPage userPage = new NewPage();
      userPage.setVisible(true);
      }
      else if (obj == client) {
         NewPage clientPage = new NewPage();
         clientPage.setVisible(true);
      }
      else {
         System.out.println("error");
      }
   }
}




