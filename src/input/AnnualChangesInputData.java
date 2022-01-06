package input;

import entities.Gift;
import interfaces.IChild;
import updates.ChildUpdate;

import java.util.List;

public class AnnualChangesInputData {
    private Double newSantaBudget;
    private List<SantaGiftsInputData> newGifts;
    private List<ChildrenInputData> newChildren;
    private List<ChildUpdateInputData> childrenUpdates;

    public AnnualChangesInputData(Double newSantaBudget,
                        List<SantaGiftsInputData> newGifts,
                        List<ChildrenInputData> newChildren,
                        List<ChildUpdateInputData> childrenUpdates) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
    }



    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public void setNewSantaBudget(Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public List<SantaGiftsInputData> getNewGifts() {
        return newGifts;
    }

    public void setNewGifts(List<SantaGiftsInputData> newGifts) {
        this.newGifts = newGifts;
    }

    public List<ChildrenInputData> getNewChildren() {
        return newChildren;
    }

    public void setNewChildren(List<ChildrenInputData> newChildren) {
        this.newChildren = newChildren;
    }

    public List<ChildUpdateInputData> getChildrenUpdates() {
        return childrenUpdates;
    }

    public void setChildrenUpdates(List<ChildUpdateInputData> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    @Override
    public String toString() {
        return "AnnualChangesInputData{" +
                "newSantaBudget=" + newSantaBudget +
                ", newGifts=" + newGifts +
                ", newChildren=" + newChildren +
                ", childrenUpdates=" + childrenUpdates +
                '}';
    }
}
