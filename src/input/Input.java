package input;

import entities.Gift;
import interfaces.IChild;
import updates.AnnualChange;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private Integer numberOfYears;
    private Double santaBudget;
    private List<ChildrenInputData> children;
    private List<SantaGiftsInputData> santaGiftsList;
    private List<AnnualChangesInputData> annualChanges;

    public Input() {
        this.numberOfYears = 0;
        this.santaBudget = 0.0;
        this.children = null;
        this.santaGiftsList = null;
        this.annualChanges = null;
    }

    public Input(Integer numberOfYears, Double santaBudget,
                 List<ChildrenInputData> children,
                 List<SantaGiftsInputData> santaGiftsList,
                 List<AnnualChangesInputData> annualChanges) {
        this.numberOfYears = numberOfYears;
        this.santaBudget = santaBudget;
        this.children = children;
        this.santaGiftsList = santaGiftsList;
        this.annualChanges = annualChanges;
    }

    public Integer getNumberOfYears() {
        return numberOfYears;
    }

    public Double getSantaBudget() {
        return santaBudget;
    }

    public List<ChildrenInputData> getChildren() {
        return children;
    }

    public List<SantaGiftsInputData> getSantaGiftsList() {
        return santaGiftsList;
    }

    public List<AnnualChangesInputData> getAnnualChanges() {
        return annualChanges;
    }

    @Override
    public String toString() {
        return "Input{" +
                "numberOfYears=" + numberOfYears +
                ", santaBudget=" + santaBudget +
                ", children=" + children +
                ", santaGiftsList=" + santaGiftsList +
                ", annualChanges=" + annualChanges +
                '}';
    }
}
