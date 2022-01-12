package nicelist.ages;

import common.Constants;
import enums.Category;
import enums.Cities;
import enums.ElvesType;
import input.ChildInput;
import nicelist.Child;

import java.util.LinkedList;
import java.util.List;

public final class Baby extends Child {
    public Baby(final Child child) {
        super(child);
    }

    public static final class Builder {
        private int id;
        private String lastName;
        private String firstName;
        private Cities city;
        private int age;
        private List<Category> giftsPreferences = new LinkedList<>();
        private List<Double> niceScoreHistory = new LinkedList<>();
        private Double niceScoreBonus = 0.0;
        private ElvesType elf;

        public Builder(final ChildInput child) {
            this.id = child.getId();
            this.age = child.getAge();
            this.firstName = child.getFirstName();
            this.lastName = child.getLastName();
            this.city = child.getCity();
            this.giftsPreferences.addAll(child.getGiftsPreferences());
            this.elf = child.getElf();
            this.niceScoreHistory.add(child.getNiceScore());
        }

        public Builder niceScoreBonus(final Double scoreBonus) {
            niceScoreBonus = scoreBonus;
            return this;
        }

        public Baby build() {
            return new Baby(this);
        }
    }

    private Baby(final Builder builder) {
        super(builder.id, builder.age, builder.lastName, builder.firstName, builder.city,
                builder.giftsPreferences, builder.elf, builder.niceScoreHistory,
                builder.niceScoreBonus);
    }

    @Override
    public void calculateAverageScore() {
        Double averageScore = Constants.BABY_AVERAGE_SCORE
                + Constants.BABY_AVERAGE_SCORE * super.getNiceScoreBonus() / Constants.PERCENTAGE;
        super.setAverageScore(averageScore);
    }
}
