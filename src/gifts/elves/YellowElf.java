package gifts.elves;

import nicelist.Child;

public final class YellowElf implements SantaWorkshop {
    private Elf elf;

    public YellowElf(final Elf elf) {
        this.elf = elf;
    }

    @Override
    public Child doJob() {
        return elf.yellowElfJob();
    }
}
