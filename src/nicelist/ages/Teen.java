package nicelist.ages;

import common.Constants;
import enums.Category;
import enums.Cities;
import enums.ElvesType;
import input.ChildInput;
import nicelist.Child;

import java.util.LinkedList;
import java.util.List;

public final class Teen extends Child  {
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

        public Teen build() {
            return new Teen(this);
        }
    }

    private Teen(final Builder builder) {
        super(builder.id, builder.age, builder.lastName, builder.firstName, builder.city,
                builder.giftsPreferences, builder.elf, builder.niceScoreHistory,
                builder.niceScoreBonus);
    }
    public Teen(final Child child) {
        super(child);
    }

    @Override
    public void calculateAverageScore() {
        Double totalNiceScore = 0.0;
        int index = 0;
        int indexSum = 0;
        for (Double niceScore : getNiceScoreHistory()) {
            ++index;
            indexSum += index;
            totalNiceScore += niceScore * index;
        }
        Double averageScore = totalNiceScore / indexSum;
        averageScore += averageScore * getNiceScoreBonus() / Constants.PERCENTAGE;
        setAverageScore(averageScore);
    }
}
