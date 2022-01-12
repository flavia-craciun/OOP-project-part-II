package gifts.elves;

import common.Constants;
import gifts.DeliverPresents;
import gifts.Gifts;
import nicelist.Child;

import java.util.List;

public final class Elf {
    private Child child;
    private List<Gifts> santaGiftsList;

    public Elf(final Child child, final List<Gifts> santaGiftsList) {
        this.child = child;
        this.santaGiftsList = santaGiftsList;
    }

    public Child blackElfJob() {
        Double budget = child.getAssignedBudget();
        budget -= budget * Constants.ELF_BONUS / Constants.PERCENTAGE;
        child.setAssignedBudget(budget);
        return child;
    }

    public Child pinkElfJob() {
        Double budget = child.getAssignedBudget();
        budget += budget * Constants.ELF_BONUS / Constants.PERCENTAGE;
        child.setAssignedBudget(budget);
        return child;
    }

    public Child yellowElfJob() {
        if (child.getReceivedGifts().isEmpty()) {
            List<Gifts> giftsFromCategory =
                    DeliverPresents.getGiftsFromCategory(child.getGiftsPreferences().get(0),
                            santaGiftsList);
            if (!giftsFromCategory.isEmpty() && giftsFromCategory.get(0).getQuantity() > 0) {
                child.getReceivedGifts().add(giftsFromCategory.get(0));
                giftsFromCategory.get(0).setQuantity(giftsFromCategory.get(0).getQuantity() - 1);
            }
        }
        return child;
    }

    public Child whiteElfJob() {
        return child;
    }
}
