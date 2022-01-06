package factories;

import entities.Baby;
import entities.Kid;
import entities.Teen;
import entities.YoungAdult;
import interfaces.IChild;

import java.util.List;

public class IChildFactory {
    public static IChild createChild(Integer id, String lastName, String firstName,
                                     Integer age, String city, Double niceScore,
                                     List<String> giftsPreferences) {
        if (age < 5) {
            return new Baby(id, lastName, firstName, age, city, niceScore, giftsPreferences);
        } else if (age < 12) {
            return new Kid(id, lastName, firstName, age, city, niceScore, giftsPreferences);
        } else if (age <= 18) {
            return new Teen(id, lastName, firstName, age, city, niceScore, giftsPreferences);
        } else {
            return new YoungAdult(id, lastName, firstName, age, city, niceScore, giftsPreferences);
        }
    }
}
