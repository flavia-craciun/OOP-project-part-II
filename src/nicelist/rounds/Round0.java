package nicelist.rounds;

import gifts.DeliverPresents;
import input.ChildInput;
import input.InputData;
import nicelist.Child;
import nicelist.ages.AgeRangeFactory;
import nicelist.ages.YoungAdult;

import java.util.List;

public final class Round0 extends AnnualChildren {
    public void makeNiceList(final List<ChildInput> children) {
        for (ChildInput child : children) {
            calculateAge(child);
        }
    }

    public void calculateAge(final ChildInput child) {
        int age = child.getAge();
        Child niceChild;
        niceChild = AgeRangeFactory.chooseRange(getAgeRange(age), child);
        checkIfYoungAdult(niceChild);
    }

    public void checkIfYoungAdult(final Child niceChild) {
        if (!(niceChild instanceof YoungAdult)) {
            niceChild.calculateAverageScore();
            getChildren().add(niceChild);
        }
    }

    public void receiveGifts(final InputData input) {
        Double budgetUnit = DeliverPresents.calculateBudgetUnit(input.getSantaBudget(),
                                                                getChildren());
        for (Child child : getChildren()) {
            child.setAssignedBudget(child.getAverageScore() * budgetUnit);
            DeliverPresents.getGifts(input.getInitialData().getSantaGiftsList(), child);
        }
    }
}
