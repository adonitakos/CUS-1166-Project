import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

class ownerWindow extends JFrame implements ActionListener {

// Intializing variables
    JPanel ownerPage;
    JLabel ownerID, make, model, licensePlate;
    final JTextField ownerIDText, makeText, modelText, licensePlateText;
    JButton submit;

    ObjectMapper objectMapper = new ObjectMapper();

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
    // Assigning the information that will be inputted by the user as string variables
        String ownerIDInfo = ownerIDText.getText();
        String ownerMake = makeText.getText();
        String ownerModel = modelText.getText();
        String ownerLicensePlate = licensePlateText.getText();

      // Creating a JSON object to store the information
      JSONObject carInformation = new JSONObject();
      carInformation.put("ownerID", ownerIDInfo);
      carInformation.put("make", ownerMake);
      carInformation.put("model", ownerModel);
      carInformation.put("licensePlate", ownerLicensePlate);

  // Read the existing db.json file
      JSONParser parser = new JSONParser();
      try {
          Object obj = parser.parse(new FileReader("db.json"));
          JSONObject jsonObject = (JSONObject) obj;
          JSONArray ownerArray = (JSONArray) jsonObject.get("owner");
          ownerArray.add(carInformation);

          // Write the updated db.json file
          try (FileWriter file = new FileWriter("db.json")) {
              file.write(jsonObject.toJSONString());
              System.out.println("Successfully Copied JSON Object to File...");
              System.out.println("\nJSON Object: " + jsonObject);
          }
      } catch (IOException | ParseException ex) {
          ex.printStackTrace();
      }

  // Confirm to the user that their information has been submitted
      System.out.println("Thank you. Your car has been submitted.");


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