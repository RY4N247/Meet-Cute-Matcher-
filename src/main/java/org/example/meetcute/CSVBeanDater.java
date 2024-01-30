package org.example.meetcute;
import com.opencsv.bean.CsvBindByName;


public class CSVBeanDater {

    //Basic Information
    @CsvBindByName(column = "Full Name", required = true)
    public String fullName;

    @CsvBindByName(column = "Email Address", required = true)
    public String emailAddress;

    @CsvBindByName(column = "Student ID", required = true)
    public String studentID;

    @CsvBindByName(column = "I identify as...", required = true)
    public String identity;

    @CsvBindByName(column = "My age is...", required = true)
    public String age;

    public String getPronouns() {
        return pronouns;
    }


    @CsvBindByName(column = "My pronouns are", required = true)
    public String pronouns;

    @CsvBindByName(column = "Dietary requirements", required = true)
    public String diet;


    // Getters and Setters for each field

    public String getFullName() {
        return fullName;
    }



    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }









    //Preferences

}
/*
Full Name
Email Address
Student ID
I identify as...
My ethnicity is...
My age is...
My pronouns are	I am in...
Dietary requirements
I would like my date to be in the age range.. (State your preferred age range as, for example, 18-21)
I want to go on a ... (choose between being matched with a new friend or a date)
I am adventurous
I am confident
I like to have intellectual conversations
I like talking about my feelings and emotions
I am an extrovert	I care about the environment
I like to dance	I have a strong connection with religion
On a Friday night, I would most likely be out clubbing
I believe being close to your family is important
I like to travel
I tend to swear a lot
I am always very organised and tidy	I tend to prioritise my academic life over my social life
I like discussing books or/and movies
I am laid back
I like sarcastic people
I tend to base my decisions on feelings rather than rational thinking
In a heated argument, I am okay with being proven wrong and/or change my view based on what my opponent has said
Healthy living is important to me
I believe actions speak louder than words
I am passionate about talking about politics
It's important for my friends to share the same morals as me
I am more interested in STEM subjects than humanities
Who would you like to date? (please double check that you have correctly entered in your preference for the below question, before submitting this form)	What language(s) are you proficient in (you may select multiple options)	Would you like your date to be in the language you are proficient in?	I am adventurous	I am looking for something serious	I like to have intellectual conversations	I am an extrovert	I like to travel.	It's important for my partner to share the same morals as me.	I am a romantic.
 */