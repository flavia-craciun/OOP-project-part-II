package gifts.elves;

import common.Constants;
import nicelist.Child;

public final class PinkElf implements Elf{
    Child child;

    public PinkElf(final Child niceChild) {
        child = niceChild;
    }

    @Override
    public void doJob() {
        Double budget = child.getAssignedBudget();
        child.setAssignedBudget(budget + budget * Constants.ELF_PERCENTAGE);
    }
}
