package nicelist.rounds;

import enums.Cities;
import enums.CityStrategyEnum;
import enums.ElvesType;
import gifts.DeliverPresents;
import gifts.Gifts;
import gifts.assignment.AssignmentStrategy;
import gifts.assignment.IdStrategy;
import gifts.assignment.NiceScoreCityStrategy;
import gifts.assignment.NiceScoreStrategy;
import gifts.elves.*;
import input.ChildInput;
import input.InputData;
import nicelist.Child;
import nicelist.ages.*;

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
            niceChild.roundAverageScore();
            getChildren().add(niceChild);
        }
    }

    public void receiveGifts(final InputData input) {
        Double budgetUnit = DeliverPresents.calculateBudgetUnit(input.getSantaBudget(),
                                                                getChildren());
        for (Child child : getChildren()) {
            child.setAssignedBudget(child.getAverageScore() * budgetUnit);
            Elf elf = chooseElf(child.getElf(), child, input.getInitialData().getSantaGiftsList());
            SantaWorkshop workshop = new SantaWorkshop();
            if (!child.getElf().equals(ElvesType.YELLOW)) {
                workshop.work(elf);
            }
        }
        AssignmentStrategy strategy = new IdStrategy(getChildren(),
                input.getInitialData().getSantaGiftsList());
                strategy.assignGifts();
    }
}
