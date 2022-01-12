package gifts.elves;

import nicelist.Child;

public final class WhiteElf implements SantaWorkshop {
    private Elf elf;

    public WhiteElf(final Elf elf) {
        this.elf = elf;
    }
    @Override
    public Child doJob() {
        return elf.whiteElfJob();
    }
}
