package input;

import gifts.Gifts;

import java.util.List;

public final class AnnualChange {
    private Double newSantaBudget;
    private List<Gifts> newGifts;
    private List<ChildInput> newChildren;
    private List<ChildUpdate> childrenUpdates;

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
}
