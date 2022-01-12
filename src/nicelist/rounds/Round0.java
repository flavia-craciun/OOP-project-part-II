package nicelist.rounds;

import gifts.DeliverPresents;
import gifts.assignment.AssignmentStrategy;
import gifts.assignment.IdStrategy;

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

    private void calculateAge(final ChildInput child) {
        int age = child.getAge();
        Child niceChild;
        niceChild = AgeRangeFactory.chooseRange(getAgeRange(age), child);
        checkIfYoungAdult(niceChild);
    }

    private void checkIfYoungAdult(final Child niceChild) {
        if (!(niceChild instanceof YoungAdult)) {
            niceChild.calculateAverageScore();
            niceChild.roundAverageScore();
            getChildren().add(niceChild);
        }
    }

    public void receiveGifts(final InputData input) {
        Double budgetUnit = DeliverPresents.calculateBudgetUnit(input.getSantaBudget(),
                            getChildren());

        assignBudget(budgetUnit, input);

        AssignmentStrategy strategy = new IdStrategy(getChildren(),
                input.getInitialData().getSantaGiftsList());
        strategy.assignGifts();
    }
}
