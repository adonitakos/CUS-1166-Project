import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;

public class FirebaseConnection {

    public static void connection() {

        FirebaseApp.initializeApp();
        
        FileInputStream serviceAccount =
        new FileInputStream("path/to/serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .build();

        FirebaseApp.initializeApp(options);

    } // <--- connection() method ends here

} // <--- FirebaseConnection{} class ends here

