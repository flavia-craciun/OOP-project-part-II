package gifts.elves;

import nicelist.Child;

public final class WhiteElf implements Elf{
    Child child;

    public WhiteElf(final Child niceChild) {
        child = niceChild;
    }

    @Override
    public void doJob() {
        return;
    }
}
