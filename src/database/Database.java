package database;

import entities.Gift;
import factories.IChildFactory;
import input.Input;
import input.ChildUpdateInputData;
import input.ChildrenInputData;
import input.SantaGiftsInputData;
import input.AnnualChangesInputData;
import interfaces.IChild;
import updates.AnnualChange;
import updates.ChildUpdate;

import java.util.ArrayList;
import java.util.List;

public final class Database {
    private static Database database = null;
    private Integer numberOfYears;
    private Double santaBudget;
    private List<IChild> children;
    private List<Gift> santaGiftsList;
    private List<AnnualChange> annualChanges;
    private final List<List<IChild>> resultsList;

    private Database(final Input input) {
        children = new ArrayList<>();
        santaGiftsList = new ArrayList<>();
        annualChanges = new ArrayList<>();
        resultsList = new ArrayList<>();

        this.numberOfYears = input.getNumberOfYears();
        this.santaBudget = input.getSantaBudget();

        for (ChildrenInputData child : input.getChildren()) {
            children.add(IChildFactory.createChild(child.getId(),
                    child.getLastName(), child.getFirstName(),
                    child.getAge(), child.getCity(), child.getNiceScore(),
                    child.getGiftsPreferences()));
        }

        for (IChild child : children) {
            child.getNiceScoreHistory().add(child.getNiceScore());
        }

        for (SantaGiftsInputData gift : input.getSantaGiftsList()) {
            santaGiftsList.add(new Gift(gift.getProductName(),
                    gift.getPrice(), gift.getCategory()));
        }

        for (AnnualChangesInputData change : input.getAnnualChanges()) {
            List<Gift> newGifts = new ArrayList<>();
            List<IChild> newChildren = new ArrayList<>();
            List<ChildUpdate> childrenUpdates = new ArrayList<>();

            for (SantaGiftsInputData gift : change.getNewGifts()) {
                newGifts.add(new Gift(gift.getProductName(), gift.getPrice(),
                        gift.getCategory()));
            }

            for (ChildrenInputData child : change.getNewChildren()) {
                newChildren.add(IChildFactory.createChild(child.getId(),
                        child.getLastName(), child.getFirstName(),
                        child.getAge(), child.getCity(), child.getNiceScore(),
                        child.getGiftsPreferences()));
            }

            for (ChildUpdateInputData cUpdate : change.getChildrenUpdates()) {
                childrenUpdates.add(new ChildUpdate(cUpdate.getId(),
                        cUpdate.getNiceScore(), cUpdate.getGiftsPreferences()));
            }

            annualChanges.add(new AnnualChange(change.getNewSantaBudget(),
                    newGifts, newChildren, childrenUpdates));
        }
    }

    /**
     * @param input the input
     * @return singleton database
     */
    public static Database getDatabase(final Input input) {
        if (database == null) {
            database = new Database(input);
        }
        return database;
    }

    /**
     * @param index position where to add in the results list
     */
    public void addResults(final int index) {
        List<IChild> resultChildren = new ArrayList<>();

        for (IChild child : children) {
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

            resultChildren.add(copyChild);
        }
        resultsList.add(index, resultChildren);
    }

    @Override
    public String toString() {
        return "Database{"
                +
                "numberOfYears="
                + numberOfYears
                + ", santaBudget="
                + santaBudget
                + ", children="
                + children
                + ", santaGiftsList="
                + santaGiftsList
                + ", annualChanges="
                + annualChanges
                + ", resultsList="
                + resultsList
                + '}';
    }

    public Integer getNumberOfYears() {
        return numberOfYears;
    }

    public Double getSantaBudget() {
        return santaBudget;
    }

    public List<IChild> getChildren() {
        return children;
    }

    public List<Gift> getSantaGiftsList() {
        return santaGiftsList;
    }

    public List<AnnualChange> getAnnualChanges() {
        return annualChanges;
    }

    public List<List<IChild>> getResultsList() {
        return resultsList;
    }

    public void setChildren(final List<IChild> children) {
        this.children = children;
    }

    public void setNumberOfYears(final Integer numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setSantaBudget(final Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    public void setSantaGiftsList(final List<Gift> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }

    public void setAnnualChanges(final List<AnnualChange> annualChanges) {
        this.annualChanges = annualChanges;
    }

    /**
     * resets the database for the next test input file
     */
    public void resetDatabase() {
        database = null;
    }
}
