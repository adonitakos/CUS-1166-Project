import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class optionPage extends JFrame implements ActionListener {
   // initializing variables
   JButton owner;
   JButton client;
   JPanel clientUser;

  optionPage() {
   // assigning variables values
    owner = new JButton("Car");
    client = new JButton("Job");
    // creating new panel
    clientUser = new JPanel(new GridLayout(5, 1));
    JLabel welcomeLabel = new JLabel("Welcome to Vehicle Vortex. Would you like to submit a car or a job?");
   
    // adding variables to the panel
    clientUser.add(welcomeLabel);
    clientUser.add(owner);
    clientUser.add(client);
    add(clientUser, BorderLayout.CENTER);
    // creating action listeners for the two buttons
    owner.addActionListener(this);
    client.addActionListener(this);

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Welcome");
    setSize(1000,800);  
   }

   // action  listener method
   public void actionPerformed(ActionEvent e) {
      // finding the source of the action and assigning it to an object variable
      Object obj = e.getSource();

      // if the "car" button was pressed, it will take them to the ownerPage
      if (obj == owner) {
      ownerWindow ownerPage = new ownerWindow();
      ownerPage.setVisible(true);
      }
      // if the "job" button was pressed, it will take them to the clientPage
      else if (obj == client) {
         clientWindow clientWindow = new clientWindow();
         clientWindow.setVisible(true);
      }
      else {
         System.out.println("error");
      }
   }
}