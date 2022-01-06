package interfaces;

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

    void calculateAverageScore();

}
