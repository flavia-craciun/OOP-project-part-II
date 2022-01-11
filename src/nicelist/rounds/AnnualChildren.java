package nicelist.rounds;

import common.Constants;
import nicelist.Child;
import nicelist.ages.AgeRangeFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AnnualChildren {
    private List<Child> children = new ArrayList<>();

    public final List<Child> getChildren() {
        return children;
    }

    public final void setChildren(final List<Child> children) {
        this.children = children;
    }

    /**
     * This method is used to identify which age range fits to a child
     *
     * @param age the age of a child used to identify their age category
     */
    public static AgeRangeFactory.AgeRange getAgeRange(final int age) {
        if (age < Constants.BABY_AGE_LIMIT) {
            return AgeRangeFactory.AgeRange.Baby;
        } else if (age >= Constants.BABY_AGE_LIMIT && age < Constants.KID_AGE_LIMIT) {
            return AgeRangeFactory.AgeRange.Kid;
        } else if (age >= Constants.KID_AGE_LIMIT && age <= Constants.TEEN_AGE_LIMIT) {
            return AgeRangeFactory.AgeRange.Teen;
        }
        return AgeRangeFactory.AgeRange.YoungAdult;
    }
}
