package nicelist.ages;

import enums.Category;
import enums.Cities;
import enums.ElvesType;
import input.ChildInput;
import nicelist.Child;

import java.util.LinkedList;
import java.util.List;

public final class YoungAdult extends Child {
    public static class Builder {
        private int id;
        private String lastName;
        private String firstName;
        private Cities city;
        private int age;
        private List<Category> giftsPreferences = new LinkedList<>();
        private List<Double> niceScoreHistory = new LinkedList<>();
        private Double niceScoreBonus = 0.0;
        private ElvesType elf;

        public Builder(ChildInput child) {
            this.id = child.getId();
            this.age = child.getAge();
            this.firstName = child.getFirstName();
            this.lastName = child.getLastName();
            this.city = child.getCity();
            this.giftsPreferences.addAll(child.getGiftsPreferences());
            this.elf = child.getElf();
            niceScoreHistory.add(child.getNiceScore());
        }

        public Builder niceScoreBonus(Double niceScoreBonus) {
            this.niceScoreBonus = niceScoreBonus;
            return this;
        }

        public YoungAdult build() {
            return new YoungAdult(this);
        }
    }

    private YoungAdult(final Builder builder) {
        super(builder.id, builder.age, builder.lastName, builder.firstName, builder.city,
                builder.giftsPreferences, builder.elf, builder.niceScoreHistory,
                builder.niceScoreBonus);
    }
    public YoungAdult(final Child child) {
        super(child);
    }

    @Override
    public void calculateAverageScore() {
        return;
    }
}
