package org.example.meetcute;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MeetCuteController {
    @FXML
    private Button uploadCSVButton;

    @FXML
    private void initialize() {
        // You can perform any initialization here
    }

    @FXML
    private void handleUploadCSVButtonAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose CSV File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));

        // Show open file dialog
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        // Process the selected file (you can replace this with your logic)
        if (selectedFile != null) {
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            // Add your logic to handle the selected file here
        } else {
            System.out.println("No file selected");
        }
    }
}