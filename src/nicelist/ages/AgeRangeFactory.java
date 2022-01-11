package nicelist.ages;

import input.ChildInput;
import nicelist.Child;

public class AgeRangeFactory {
    public enum AgeRange {
            Baby, Kid, Teen, YoungAdult
        }

        public static Child chooseRange(final AgeRange childAgeRange, final ChildInput child) {
            switch (childAgeRange) {
                case Baby: return new Baby(child);
                case Kid: return new Kid(child);
                case Teen: return new Teen(child);
                default: return new YoungAdult(child);
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
