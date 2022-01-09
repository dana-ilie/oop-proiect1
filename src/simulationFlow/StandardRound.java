package simulationFlow;

import database.Database;
import entities.Gift;
import factories.IChildFactory;
import interfaces.IChild;
import updates.AnnualChange;
import updates.ChildUpdate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StandardRound {
    public void executeStandardRound(Database database, AnnualChange update) {
        // increment age of each child
        // remove youngAdults
        // recreate children list (factory)
        // sort children list by id
        // execute updates
        // assign gifts

        List<IChild> children = new ArrayList<>();

        for (IChild child : database.getChildren()) {
            /*
             * increment age and remove young adults
             */
            child.setAge(child.getAge() + 1);
        }
        database.getChildren().removeIf(x -> x.getAge() > 18);


        for (IChild child : database.getChildren()) {
            List<Double> niceScoreHistory = new ArrayList<>(child.getNiceScoreHistory());
            List<String> giftPreferences = new ArrayList<>(child.getGiftsPreferences());
            IChild copyChild = IChildFactory.createChild(child.getId(),
                    child.getLastName(), child.getFirstName(),
                    child.getAge(), child.getCity(), child.getNiceScore(),
                    giftPreferences);
            copyChild.setAverageScore(child.getAverageScore());
            copyChild.setNiceScoreHistory(niceScoreHistory);
            copyChild.setAssignedBudget(child.getAssignedBudget());
            copyChild.setReceivedGifts(child.getReceivedGifts());

            children.add(copyChild);
        }

        /*
         * sort children list by id
         */
        children.sort(Comparator.comparingInt(IChild::getId));
        database.setChildren(children);

        /*
         * execute updates
         */

        database.setSantaBudget(update.getNewSantaBudget());

        for (Gift newGift : update.getNewGifts()) {
            database.getSantaGiftsList().add(newGift);
        }

        for (IChild newChild : update.getNewChildren()) {
            if (newChild.getAge() <= 18) {
                newChild.getNiceScoreHistory().add(newChild.getNiceScore());
                database.getChildren().add(newChild);
            }
        }

        for (ChildUpdate cUpdate : update.getChildrenUpdates()) {
            /*
             * find the child to be updated
             */
            for (IChild child : database.getChildren()) {
                if (child.getId().equals(cUpdate.getId())) {
                    /*
                     * execute update on child
                     */
                    if (cUpdate.getNiceScore() != null) {
                        child.getNiceScoreHistory().add(cUpdate.getNiceScore());
                    }

                    /*
                     * delete old appearances of preferences
                     */

                    for (String newPreference : cUpdate.getGiftsPreferences()) {
                        child.getGiftsPreferences().removeIf(x -> x.equals(newPreference));
                    }
                    child.getGiftsPreferences().addAll(0, cUpdate.getGiftsPreferences());
                    int size = child.getGiftsPreferences().size();
                    for (int i = size - 1; i >= 0; i--) {
                        for (int j = i - 1; j >= 0; j--) {
                            if (child.getGiftsPreferences().get(i).equals(child.getGiftsPreferences().get(j))) {
                                child.getGiftsPreferences().remove(i);
                            }
                        }
                    }
                }
            }
        }

        InitialRound initialRound = new InitialRound();
        initialRound.executeInitialRound(database);


    }
}
