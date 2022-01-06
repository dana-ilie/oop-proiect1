package database;

import entities.Gift;
import factories.IChildFactory;
import input.*;
import interfaces.IChild;
import updates.AnnualChange;
import updates.ChildUpdate;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private Integer numberOfYears;
    private Double santaBudget;
    private List<IChild> children;
    private List<Gift> santaGiftsList;
    private List<AnnualChange> annualChanges;
    private List<List<IChild>> resultsList;

    public Database (Input input) {
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

        resultsList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Database{" +
                "numberOfYears=" + numberOfYears +
                ", santaBudget=" + santaBudget +
                ", children=" + children +
                ", santaGiftsList=" + santaGiftsList +
                ", annualChanges=" + annualChanges +
                ", resultsList=" + resultsList +
                '}';
    }
}
