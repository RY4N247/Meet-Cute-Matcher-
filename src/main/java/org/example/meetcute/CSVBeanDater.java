package org.example.meetcute;
import com.opencsv.bean.CsvBindByName;


public class CSVBeanDater {
    @CsvBindByName(column = "Email address", required = true)
    public String emailAddress;

    @CsvBindByName(column = "Full Name", required = true)
    public String fullName;
    @CsvBindByName(column = "Email Address", required = true)
    public String alternativeEmail;

    @CsvBindByName(column = "Student ID", required = true)
    public String studentId;

    @CsvBindByName(column = "I identify as...", required = true)
    public String genderIdentity;

    @CsvBindByName(column = "My age is...", required = true)
    public int age;

    @CsvBindByName(column = "My pronouns are", required = true)
    public String pronouns;

    @CsvBindByName(column = "I am in...", required = true)
    public String currentStatus;

    @CsvBindByName(column = "Dietary requirements", required = true)
    public String dietaryRequirements;

    @CsvBindByName(column = "What is the maximum age you would date?", required = true)
    public int maxPreferredAge;

    @CsvBindByName(column = "I want to go on a ... \n" +
            "(choose between being matched with a new friend or a date)", required = true)
    public String matchPreference;

    @CsvBindByName(column = "I am adventurous")
    public int adventurousLevel;

    @CsvBindByName(column = "I am confident")
    public int confidenceLevel;

    @CsvBindByName(column = "I like to have intellectual conversations")
    public int intellectualLevel;

    @CsvBindByName(column = "I am an extrovert")
    public int extrovertLevel;

    @CsvBindByName(column = "I like to dance")
    public int likesDancing;

    @CsvBindByName(column = "On a Friday night, I would most likely be out clubbing")
    public int goesClubbing;

    @CsvBindByName(column = "I like to travel")
    public int likesTraveling;

    @CsvBindByName(column = "I like discussing books or/and movies")
    public int likesBookAndMovies;

    @CsvBindByName(column = "I like sarcastic people")
    public int likesSarcasticPeople;

    @CsvBindByName(column = "I am passionate about talking about politics")
    public int passionateAboutPolitics;

    @CsvBindByName(column = "Who would you like to date? (please double check that you have correctly entered in your preference for the below question, before submitting this form)")
    public String preferredDate;

    @CsvBindByName(column = "What language are you proficient in?")
    public String proficientLanguage;

    @CsvBindByName(column = "What language would you prefer your date to be in?")
    public String preferredLanguage;

    @CsvBindByName(column = "I am Adventurous")
    public int isAdventurous;

    @CsvBindByName(column = "I am looking for something serious")
    public int lookingForSeriousRelationship;

    @CsvBindByName(column = "I like to have intellectual conversations ")
    public int intellectualConversations;

    @CsvBindByName(column = "I am an Extrovert ")
    public int isExtrovert;

    @CsvBindByName(column = "I like to travel. ")
    public int likeTravel;

    @CsvBindByName(column = "It's important for my partner to share the same morals as me.")
    public int sharedMorals;

    @CsvBindByName(column = "I am a romantic.")
    public int isRomantic;


    //getters
    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAlternativeEmail() {
        return alternativeEmail;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getGenderIdentity() {
        return genderIdentity;
    }

    public int getAge() {
        return age;
    }

    public String getPronouns() {
        return pronouns;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public String getDietaryRequirements() {
        return dietaryRequirements;
    }

    public int getMaxPreferredAge() {
        return maxPreferredAge;
    }

    public String getMatchPreference() {
        return matchPreference;
    }

    public int getAdventurousLevel() {
        return adventurousLevel;
    }

    public int getConfidenceLevel() {
        return confidenceLevel;
    }

    public int getLikesDancing() {
        return likesDancing;
    }

    public int getGoesClubbing() {
        return goesClubbing;
    }

    public int getLikesBookAndMovies() {
        return likesBookAndMovies;
    }

    public int getLikesSarcasticPeople() {
        return likesSarcasticPeople;
    }

    public int getPassionateAboutPolitics() {
        return passionateAboutPolitics;
    }

    public String getPreferredDate() {
        return preferredDate;
    }

    public String getProficientLanguage() {
        return proficientLanguage;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public int getIsAdventurous() {
        return isAdventurous;
    }

    public int getLookingForSeriousRelationship() {
        return lookingForSeriousRelationship;
    }

    public int getIntellectualLevel() {
        return intellectualConversations;
    }

    public int getExtrovertLevel() {
        return isExtrovert;
    }

    public int getLikesTraveling() {
        return likeTravel;
    }

    public int getSharedMorals() {
        return sharedMorals;
    }

    public int getIsRomantic() {
        return isRomantic;
    }
}
