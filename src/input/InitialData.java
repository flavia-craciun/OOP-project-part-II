package input;

import enums.Cities;
import gifts.Gifts;

import java.util.List;

public final class InitialData {
    private List<ChildInput> children;
    private List<Gifts> santaGiftsList;
    private List<Cities> santaCitiesList;

    public List<ChildInput> getChildren() {
        return children;
    }

    public void setChildren(final List<ChildInput> children) {
        this.children = children;
    }

    public List<Gifts> getSantaGiftsList() {
        return santaGiftsList;
    }

    public List<Cities> getSantaCitiesList() {
        return santaCitiesList;
    }
}
