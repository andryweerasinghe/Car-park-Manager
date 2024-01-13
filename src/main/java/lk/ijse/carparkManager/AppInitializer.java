package lk.ijse.carparkManager;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class AppInitializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/login_form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Load the CSS file
        scene.getStylesheets().add(getClass().getResource("/cssFiles/errorStyle.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("/cssFiles/buttonStyle.css").toExternalForm());

        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Login");
        stage.show();
    }
}
