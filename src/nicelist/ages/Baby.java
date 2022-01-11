package nicelist.ages;

import common.Constants;
import input.ChildInput;
import nicelist.Child;

public final class Baby extends Child {
    public Baby(final ChildInput child) {
        super(child);
    }

    public Baby(final Child child) {
        super(child);
    }

    @Override
    public void calculateAverageScore() {
        super.setAverageScore(Constants.BABY_AVERAGE_SCORE);
    }
}
