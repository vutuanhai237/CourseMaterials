package GUI;

// <editor-fold desc="import zone">

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// </editor-fold>

public class Main extends Application {  
    public static Stage primaryStage = null;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/form.fxml"));       
        Scene scene = new Scene(root, 758, 627);  
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();       
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
