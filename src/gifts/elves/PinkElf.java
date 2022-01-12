package gifts.elves;

import nicelist.Child;

public final class PinkElf implements SantaWorkshop {
    private Elf elf;

    public PinkElf(final Elf elf) {
        this.elf = elf;
    }
    @Override
    public Child doJob() {
        return elf.pinkElfJob();
    }
}
