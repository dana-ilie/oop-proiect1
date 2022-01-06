package updates;

import entities.Gift;
import interfaces.IChild;

import java.util.List;

public class AnnualChange {
    private Double newSantaBudget;
    private List<Gift> newGifts;
    private List<IChild> newChildren;
    private List<ChildUpdate> childrenUpdates;

    public AnnualChange(Double newSantaBudget,
                         List<Gift> newGifts,
                         List<IChild> newChildren,
                         List<ChildUpdate> childrenUpdates) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
    }

    @Override
    public String toString() {
        return "AnnualChange{" +
                "newSantaBudget=" + newSantaBudget +
                ", newGifts=" + newGifts +
                ", newChildren=" + newChildren +
                ", childrenUpdates=" + childrenUpdates +
                '}';
    }

    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public void setNewSantaBudget(Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public List<Gift> getNewGifts() {
        return newGifts;
    }

    public void setNewGifts(List<Gift> newGifts) {
        this.newGifts = newGifts;
    }

    public List<IChild> getNewChildren() {
        return newChildren;
    }

    public void setNewChildren(List<IChild> newChildren) {
        this.newChildren = newChildren;
    }

    public List<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    public void setChildrenUpdates(List<ChildUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }
}
