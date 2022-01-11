package nicelist.ages;

import input.ChildInput;
import nicelist.Child;

public final class YoungAdult extends Child {
    public YoungAdult(final ChildInput child) {
        super(child);
    }

    public YoungAdult(final Child child) {
        super(child);
    }

    @Override
    public void calculateAverageScore() {
        return;
    }
}
