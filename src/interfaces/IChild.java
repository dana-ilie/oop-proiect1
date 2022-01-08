package interfaces;

import entities.Gift;

import java.util.ArrayList;
import java.util.List;

public interface IChild {

    Integer getId();

    void setId(Integer id);

    String getLastName();

    void setLastName(String lastName);

    String getFirstName();

    void setFirstName(String firstName);

    Integer getAge();

    void setAge(Integer age);

    String getCity();

    void setCity(String city);

    Double getNiceScore();

    void setNiceScore(Double niceScore);

    List<String> getGiftsPreferences();

    void setGiftsPreferences(List<String> giftsPreferences);

    Double getAverageScore();

    List<Double> getNiceScoreHistory();

    Double getAssignedBudget();

    List<Gift> getReceivedGifts();

    void setAssignedBudget(Double assignedBudget);

    void calculateAverageScore();

    void setAverageScore(Double averageScore);

    void setNiceScoreHistory(List<Double> niceScoreHistory);

    void setReceivedGifts(List<Gift> receivedGifts);

}
