package gifts.elves;

import common.Constants;
import nicelist.Child;

public final class BlackElf implements Elf{
    Child child;

    public BlackElf(final Child niceChild) {
        child = niceChild;
    }

    @Override
    public void doJob() {
        Double budget = child.getAssignedBudget();
        budget -= budget * 30 / 100;
        child.setAssignedBudget(budget);
    }
}
