package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import interfaces.IChild;

import java.util.ArrayList;
import java.util.List;

public class Teen implements IChild {
    private Integer id;
    private String lastName;
    private String firstName;
    private Integer age;
    private String city;
    @JsonIgnore
    private Double niceScore;
    private List<String> giftsPreferences;
    private Double averageScore;
    private List<Double> niceScoreHistory;
    private Double assignedBudget;
    private List<Gift> receivedGifts;

    public Teen (Integer id, String lastName, String firstName,
                Integer age, String city, Double niceScore,
                List<String> giftsPreferences) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
        this.averageScore = 0.0;
        this.niceScoreHistory = new ArrayList<>();
        this.assignedBudget = 0.0;
        this.receivedGifts = new ArrayList<>();
    }

    @Override
    public void calculateAverageScore() {
        Double scoreSum = 0.0;
        Double weightSum = 0.0;
        for (int i = 0; i < niceScoreHistory.size(); i++) {
            scoreSum += niceScoreHistory.get(i) * (i + 1);
            weightSum += i + 1;
        }
        this.averageScore = scoreSum / weightSum;
    }

    @Override
    public String toString() {
        return "Teen{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", niceScore=" + niceScore +
                ", giftsPreferences=" + giftsPreferences +
                ", averageScore=" + averageScore +
                ", niceScoreHistory=" + niceScoreHistory +
                ", assignedBudget=" + assignedBudget +
                ", receivedGifts=" + receivedGifts +
                '}';
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public Double getNiceScore() {
        return niceScore;
    }

    @Override
    public void setNiceScore(Double niceScore) {
        this.niceScore = niceScore;
    }

    @Override
    public List<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    @Override
    public void setGiftsPreferences(List<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    @Override
    public Double getAverageScore() {
        return averageScore;
    }

    @Override
    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    @Override
    public Double getAssignedBudget() {
        return assignedBudget;
    }

    @Override
    public List<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    @Override
    public void setAssignedBudget(Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    @Override
    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public void setNiceScoreHistory(List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    @Override
    public void setReceivedGifts(List<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }
}
