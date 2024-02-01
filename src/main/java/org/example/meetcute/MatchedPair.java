package org.example.meetcute;

public class MatchedPair {
    private CSVBeanDater participant1;
    private CSVBeanDater participant2;
    private int compatibilityScore;

    public MatchedPair(CSVBeanDater participant1, CSVBeanDater participant2, int compatibilityScore) {
        this.participant1 = participant1;
        this.participant2 = participant2;
        this.compatibilityScore = compatibilityScore;
    }

    public CSVBeanDater getParticipant1() {
        return participant1;
    }

    public CSVBeanDater getParticipant2() {
        return participant2;
    }

    public int getCompatibilityScore() {
        return compatibilityScore;
    }
}
