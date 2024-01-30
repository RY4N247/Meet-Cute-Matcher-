package org.example.meetcute;

import com.opencsv.bean.CsvToBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.sql.Date;


import com.opencsv.bean.CsvToBeanBuilder;

public class MeetCuteController {
    private File selectedCsvFile;
    @FXML
    private Button uploadCSVButton;

    @FXML
    private void initialize() {
        // You can perform any initialization here
    }

    @FXML
    private void handleUploadCSVButtonAction(ActionEvent event) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose CSV File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));

        // Show open file dialog
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        // Process the selected file (you can replace this with your logic)
        if (selectedFile != null) {
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        try{
            // Create CSVBeanDater and use CsvToBean to read CSV data into a list of beans
            CSVBeanDater beanDater = new CSVBeanDater();
            CsvToBean<CSVBeanDater> csvToBean = new CsvToBeanBuilder<CSVBeanDater>(new FileReader(selectedFile))
                    .withType(CSVBeanDater.class)
                    .build();

            List<CSVBeanDater> beans = csvToBean.parse();

            // Now 'beans' contains the data from the CSV file mapped to your Java bean
            // You can iterate through the list and work with the data as needed

            // Example: Print the data from the first bean
            if (!((List<?>) beans).isEmpty()) {
                CSVBeanDater firstBean = beans.get(0);
                System.out.println("Name:  " + firstBean.getFullName());
                System.out.println("Email: " + firstBean.getEmailAddress());
                System.out.println("Pronouns: " + firstBean.getPronouns());
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("No file selected");
    }


        }
    }


