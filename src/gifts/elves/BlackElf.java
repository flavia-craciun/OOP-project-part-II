package gifts.elves;

import nicelist.Child;

public final class BlackElf implements SantaWorkshop {
    private Elf elf;

    public BlackElf(final Elf elf) {
        this.elf = elf;
    }

    @Override
    public Child doJob() {
        return elf.blackElfJob();
    }
}
