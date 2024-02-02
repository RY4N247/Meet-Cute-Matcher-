package org.example.meetcute;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MeetCuteApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MeetCuteApplication.class.getResource("index.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 1371, 834);// Set the size to match the preferred size of BorderPane
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("Meet Cute");
        stage.setScene(scene);
        stage.show();

        // Access the controller and call the matchmaking method
        MeetCuteController controller = fxmlLoader.getController();
    }

    public static void main(String[] args) {
        launch();
    }
}

