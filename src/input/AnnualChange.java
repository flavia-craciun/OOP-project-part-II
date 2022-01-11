package input;

import enums.CityStrategyEnum;
import gifts.Gifts;

import java.util.List;

public final class AnnualChange {
    private Double newSantaBudget;
    private List<Gifts> newGifts;
    private List<ChildInput> newChildren;
    private List<ChildUpdate> childrenUpdates;
    private CityStrategyEnum strategy;

    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public List<Gifts> getNewGifts() {
        return newGifts;
    }

    public List<ChildInput> getNewChildren() {
        return newChildren;
    }

    public List<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    public void setNewSantaBudget(final Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public void setNewGifts(final List<Gifts> newGifts) {
        this.newGifts = newGifts;
    }

    public void setNewChildren(final List<ChildInput> newChildren) {
        this.newChildren = newChildren;
    }

    public void setChildrenUpdates(final List<ChildUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    public CityStrategyEnum getStrategy() {
        return strategy;
    }

    public void setStrategy(final CityStrategyEnum strategy) {
        this.strategy = strategy;
    }
}
