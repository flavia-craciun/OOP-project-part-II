package nicelist;

import enums.Category;
import enums.Cities;
import input.ChildInput;
import gifts.Gifts;

import java.util.LinkedList;
import java.util.List;

public abstract class Child {
    private int id;
    private String lastName;
    private String firstName;
    private Cities city;
    private int age;
    private List<Category> giftsPreferences = new LinkedList<>();
    private Double averageScore;
    private List<Double> niceScoreHistory = new LinkedList<>();
    private Double assignedBudget;
    private List<Gifts> receivedGifts = new LinkedList<>();

    public Child(final ChildInput child) {
        this.id = child.getId();
        this.age = child.getAge();
        this.firstName = child.getFirstName();
        this.lastName = child.getLastName();
        this.city = child.getCity();
        this.giftsPreferences.addAll(child.getGiftsPreferences());
        niceScoreHistory.add(child.getNiceScore());
    }

    public Child(final Child child) {
        this.id = child.getId();
        this.age = child.getAge();
        this.firstName = child.getFirstName();
        this.lastName = child.getLastName();
        this.city = child.getCity();
        this.giftsPreferences.addAll(child.getGiftsPreferences());
        niceScoreHistory.addAll(child.getNiceScoreHistory());
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

    public abstract void calculateAverageScore();
}
