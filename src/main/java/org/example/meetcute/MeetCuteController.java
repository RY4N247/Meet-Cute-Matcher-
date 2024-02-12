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
import java.sql.SQLOutput;
import java.util.*;
import java.sql.Date;


import com.opencsv.bean.CsvToBeanBuilder;

public class MeetCuteController {
    private File selectedCsvFile;
    @FXML
    private Button uploadCSVButton;
    private ArrayList<CSVBeanDater> Romanticlist = new ArrayList<>();
    private ArrayList<CSVBeanDater> FriendList = new ArrayList<>();
    private ArrayList<CSVBeanDater> SpeedDate = new ArrayList<>();
    private int matchedCount = 0;

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
            try {
                // Create CSVBeanDater and use CsvToBean to read CSV data into a list of beans
                CSVBeanDater beanDater = new CSVBeanDater();
                CsvToBean<CSVBeanDater> csvToBean = new CsvToBeanBuilder<CSVBeanDater>(new FileReader(selectedFile))
                        .withType(CSVBeanDater.class)
                        .build();

                List<CSVBeanDater> beans = csvToBean.parse();

                // Now 'beans' contains the data from the CSV file mapped to your Java bean
                // You can iterate through the list and work with the data as needed

                // Example: Print the data from the first bean
                //if (!((List<?>) beans).isEmpty()) {
                //CSVBeanDater firstBean = beans.get(0);
                //System.out.printf("" + firstBean.getFullName());


                for (CSVBeanDater bean : beans) {
                    if ("Romantic Date (First Dates)".equalsIgnoreCase(bean.getMatchPreference())) {
                        Romanticlist.add(bean);
                    } else if ("Friend Date (First Dates)".equalsIgnoreCase(bean.getMatchPreference())) {
                        FriendList.add(bean);
                    } else {
                        SpeedDate.add(bean);
                    }


                }


                int countRom = 0;

                for (CSVBeanDater bean : Romanticlist) {
                    countRom++;
                    System.out.println("Romantic" + ": " + bean.getFullName() + "" + bean.getMatchPreference());
                }
                System.out.println(countRom);

                int countFriend = 0;

                for (CSVBeanDater bean : FriendList) {
                    countFriend++;
                    System.out.println("Friend" + ": " + bean.getFullName() + "" + bean.getMatchPreference());
                }
                System.out.println(countFriend);

                int countspeed = 0;

                for (CSVBeanDater bean : SpeedDate) {
                    countspeed++;
                    System.out.println("Speed" + ": " + bean.getFullName() + "" + bean.getMatchPreference());
                }
                System.out.println(countspeed);
                System.out.println(countspeed + countRom + countFriend);




            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No file selected");
        }
        matchAndCalculateCompatibility(Romanticlist);
        friendCompatibility(FriendList);


    }

    private void friendCompatibility(List<CSVBeanDater> participants) {
        List<MatchedPair> matchedPairs = new ArrayList<>();
        Set<CSVBeanDater> matched = new HashSet<>();
        List<CSVBeanDater> unmatchedParticipants = new ArrayList<>(participants);
        for (int i = 0; i < unmatchedParticipants.size(); i++) {
                CSVBeanDater participant1 = unmatchedParticipants.get(i);

                // Skip participant1 if already matched
                if (matched.contains(participant1)) {
                    continue;
                }

                System.out.println("Checking participant1: " + participant1.getFullName());

                for (int j = 0; j < unmatchedParticipants.size(); j++) {
                    CSVBeanDater participant2 = unmatchedParticipants.get(j);

                    // Skip participant2 if already matched or if it's the same as participant1
                    if (i == j || matched.contains(participant2)) {
                        continue;
                    }

                    System.out.println("Checking participant2: " + participant2.getFullName());

                    int compatibilityScore = calculateCompatibilityScoreFriends(participant1, participant2);
                    System.out.println("Compatibility score between " + participant1.getFullName() +
                            " and " + participant2.getFullName() + ": " + compatibilityScore);

                    if (compatibilityScore >= 1) { // Adjusted to match only if compatibility score is 1 or above
                        MatchedPair pairs = new MatchedPair(participant1, participant2, compatibilityScore);
                        matchedPairs.add(pairs);
                        matched.add(participant1);
                        matched.add(participant2);
                        matchedCount += 2; // Increment matched count for both participants
                        System.out.println("Pair added to matchedPairs.");
                        break; // Exit the inner loop once a match is found
                    }
                }
        }
        // Output matched pairs
        outputMatches(matchedPairs);
    }
    

    private int calculateCompatibilityScoreFriends (CSVBeanDater participant1, CSVBeanDater participant2) {
        int compatibilityScores = 0;
        // Compare responses for each question and calculate the score
        boolean adventurous = participant1.getAdventurousLevel() == participant2.getAdventurousLevel();
        if (adventurous){
            compatibilityScores++;
        }


        boolean confidence = participant1.getConfidenceLevel() == participant2.getConfidenceLevel();
        if (confidence) {
            compatibilityScores++;
        }

        boolean dance = participant1.getLikesDancing() == participant2.getLikesDancing();
        if (dance) {
            compatibilityScores++;
        }
        boolean clubbng = participant1.getGoesClubbing() == participant2.getGoesClubbing();
        if (clubbng){
            compatibilityScores++;
        }
        boolean booksmovies = participant1.getLikesBookAndMovies() == participant2.getLikesBookAndMovies();
        if (booksmovies){
            compatibilityScores++;
        }
        boolean sarcastic = participant1.getLikesSarcasticPeople() == participant2.getLikesSarcasticPeople();
        if (sarcastic){
            compatibilityScores++;
        }

        boolean polictics =  participant1.getPassionateAboutPolitics() == participant2.getPassionateAboutPolitics();
        if (polictics){
            compatibilityScores++;
        }
        return compatibilityScores;


    }

    private void matchAndCalculateCompatibility(List<CSVBeanDater> participants) {
        // Implement matching and compatibility score calculation logic here
        List<MatchedPair> matchedPairs = new ArrayList<>();
        Set<CSVBeanDater> alreadyMatched = new HashSet<>();
        List<CSVBeanDater> unmatchedParticipants = new ArrayList<>(participants);

        for (int i = 0; i < unmatchedParticipants.size(); i++) {
            CSVBeanDater participant1 = unmatchedParticipants.get(i);

            // Skip participant1 if already matched
            if (alreadyMatched.contains(participant1)) {
                continue;
            }

            System.out.println("Checking participant1: " + participant1.getFullName());

            for (int j = 0; j < unmatchedParticipants.size(); j++) {
                CSVBeanDater participant2 = unmatchedParticipants.get(j);

                // Skip participant2 if already matched or if it's the same as participant1
                if (i == j || alreadyMatched.contains(participant2)) {
                    continue;
                }

                System.out.println("Checking participant2: " + participant2.getFullName());

                if (areCompulsoryFieldsMatching(participant1, participant2)) {
                    int compatibilityScore = calculateCompatibilityScore(participant1, participant2);
                    System.out.println("Compatibility score between " + participant1.getFullName() +
                            " and " + participant2.getFullName() + ": " + compatibilityScore);

                    if (compatibilityScore >= 1) { // Adjusted to match only if compatibility score is 1 or above
                        MatchedPair pair = new MatchedPair(participant1, participant2, compatibilityScore);
                        matchedPairs.add(pair);
                        alreadyMatched.add(participant1);
                        alreadyMatched.add(participant2);
                        matchedCount += 2; // Increment matched count for both participants
                        System.out.println("Pair added to matchedPairs.");
                        break; // Exit the inner loop once a match is found
                    }
                }
            }
        }

        // Output matched pairs
        outputMatches(matchedPairs);
    }





    private boolean areCompulsoryFieldsMatching(CSVBeanDater participant1, CSVBeanDater participant2) {
        // Check if gender identity and preferred gender match based on the first character
        boolean genderMatch = participant1.getGenderIdentity().charAt(0) == participant2.getPreferredDate().charAt(0) &&
                participant2.getGenderIdentity().charAt(0) == participant1.getPreferredDate().charAt(0);
        System.out.println("Gender Match: " + genderMatch);

        // Check if age preferences match
        boolean ageMatch = participant1.getMaxPreferredAge() >= participant2.getAge() &&
                participant2.getMaxPreferredAge() >= participant1.getAge();
        System.out.println("Age Match: " + ageMatch);

        // Check if language proficiency and language preference match
        boolean languageMatch = participant1.getProficientLanguage().equalsIgnoreCase(participant2.getPreferredLanguage()) &&
                participant2.getProficientLanguage().equalsIgnoreCase(participant1.getPreferredLanguage());
        System.out.println("Language Match: " + languageMatch);

        // Return true if all compulsory fields match, otherwise return false
        boolean allFieldsMatch = genderMatch && ageMatch && languageMatch;
        System.out.println("All Fields Match: " + allFieldsMatch);
        return allFieldsMatch;
    }


    private int calculateCompatibilityScore(CSVBeanDater participant1, CSVBeanDater participant2) {
        int compatibilityScore = 0;

        // Compare responses for each question and calculate the score
        boolean adventure = participant1.getIsAdventurous() == participant2.getIsAdventurous();
        if (adventure){
            compatibilityScore++;
        }


        boolean serious = participant1.getLookingForSeriousRelationship() == participant2.getLookingForSeriousRelationship();
        if (serious) {
            compatibilityScore++;
        }

        boolean intellectual = participant1.getIntellectualLevel() == participant2.getIntellectualLevel();
        if (intellectual) {
            compatibilityScore++;
        }
        boolean extrovert = participant1.getExtrovertLevel() == participant2.getExtrovertLevel();
        if (extrovert){
            compatibilityScore++;
        }
        boolean travel = participant1.getLikesTraveling() == participant2.getLikesTraveling();
        if (travel){
            compatibilityScore++;
        }
        boolean morals = participant1.getSharedMorals() == participant2.getSharedMorals();
        if (morals){
            compatibilityScore++;
        }

        boolean romantic =  participant1.getIsRomantic() == participant2.getIsRomantic();
        if (romantic){
            compatibilityScore++;
        }
        return compatibilityScore;


    }

    private void outputMatches(List<MatchedPair> matchedPairs) {
        // Output matched pairs or groups of participants
        for (MatchedPair pair : matchedPairs) {
            CSVBeanDater participant1 = pair.getParticipant1();
            CSVBeanDater participant2 = pair.getParticipant2();
            int compatibilityScore = pair.getCompatibilityScore();
            // Output the match
            System.out.println("Matched Pair:");
            System.out.println("Participant 1: " + participant1.getFullName());
            System.out.println("Participant 2: " + participant2.getFullName());
            System.out.println("Compatibility Score: " + compatibilityScore);
            System.out.println();

        }
        System.out.println("Total Matched Count: " + matchedCount);
    }
    
}






