package nicelist.ages;

import input.ChildInput;
import nicelist.Child;

public class AgeRangeFactory {
    public enum AgeRange {
            Baby, Kid, Teen, YoungAdult
        }

        public static Child chooseRange(final AgeRange childAgeRange, final ChildInput child) {
            if (child.getNiceScoreBonus() != 0) {
                switch (childAgeRange) {
                    case Baby:
                        return new Baby.Builder(child)
                                .niceScoreBonus(child.getNiceScoreBonus())
                                .build();
                    case Kid:
                        return new Kid.Builder(child)
                                .niceScoreBonus(child.getNiceScoreBonus())
                                .build();
                    case Teen:
                        return new Teen.Builder(child)
                                .niceScoreBonus(child.getNiceScoreBonus())
                                .build();
                    default:
                        return new YoungAdult.Builder(child)
                                .niceScoreBonus(child.getNiceScoreBonus())
                                .build();
                }
            } else {
                switch (childAgeRange) {
                    case Baby:
                        return new Baby.Builder(child).build();
                    case Kid:
                        return new Kid.Builder(child).build();
                    case Teen:
                        return new Teen.Builder(child).build();
                    default:
                        return new YoungAdult.Builder(child).build();
                }
            }
        }

        public static Child chooseRange(final AgeRange childAgeRange, final Child child) {
            switch (childAgeRange) {
                case Baby: return new Baby(child);
                case Kid: return new Kid(child);
                case Teen: return new Teen(child);
                default: return new YoungAdult(child);
            }
        }
}
