package nicelist;

import common.Constants;
import enums.Category;
import enums.Cities;
import enums.ElvesType;
import gifts.Gifts;

import java.util.LinkedList;
import java.util.List;

public abstract class Child {
    private int id;
    private String lastName;
    private String firstName;
    private Cities city;
    private int age;
    private List<Category> giftsPreferences;
    private Double averageScore;
    private List<Double> niceScoreHistory;
    private Double assignedBudget;
    private List<Gifts> receivedGifts = new LinkedList<>();
    private Double niceScoreBonus;
    private ElvesType elf;

    public Child(final int id, final int age, final String lastName, final String firstName,
                 final Cities city, final List<Category> giftsPreferences, final ElvesType elf,
                 final List<Double> niceScoreHistory, final Double niceScoreBonus) {
        this.id = id;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.giftsPreferences = giftsPreferences;
        this.elf = elf;
        this.niceScoreHistory = niceScoreHistory;
        this.niceScoreBonus = niceScoreBonus;
    }

    public Child(final Child child) {
        this.id = child.getId();
        this.age = child.getAge();
        this.firstName = child.getFirstName();
        this.lastName = child.getLastName();
        this.city = child.getCity();
        this.giftsPreferences = new LinkedList<>();
        this.giftsPreferences.addAll(child.getGiftsPreferences());
        this.elf = child.getElf();
        this.niceScoreHistory = new LinkedList<>();
        niceScoreHistory.addAll(child.getNiceScoreHistory());
        this.niceScoreBonus = child.getNiceScoreBonus();
    }

    public final int getId() {
        return id;
    }

    public final String getLastName() {
        return lastName;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final int getAge() {
        return age;
    }

    public final void setAge(final int age) {
        this.age = age;
    }

    public final Cities getCity() {
        return city;
    }

    public final List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public final void setGiftsPreferences(final List<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public final Double getAverageScore() {
        return averageScore;
    }

    public final void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    public final List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public final void setNiceScoreHistory(final List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public final Double getAssignedBudget() {
        return assignedBudget;
    }

    public final void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public final List<Gifts> getReceivedGifts() {
        return receivedGifts;
    }

    public final void setReceivedGifts(final List<Gifts> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    public final Double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    public final void setNiceScoreBonus(final Double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    public final ElvesType getElf() {
        return elf;
    }

    public final void setElf(final ElvesType elf) {
        this.elf = elf;
    }

    public abstract void calculateAverageScore();

    public final void roundAverageScore() {
        if (averageScore > Constants.MAX_AVERAGE_SCORE) {
            averageScore = Constants.MAX_AVERAGE_SCORE;
        }
    }

}
