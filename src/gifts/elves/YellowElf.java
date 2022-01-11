package gifts.elves;

import gifts.DeliverPresents;
import gifts.Gifts;
import nicelist.Child;

import java.util.List;

public final class YellowElf implements Elf{
    Child child;
    List<Gifts> santaGiftsList;

    public YellowElf(final Child niceChild, final List<Gifts> giftsList) {
        child = niceChild;
        santaGiftsList = giftsList;
    }

    @Override
    public void doJob() {
        if (child.getReceivedGifts().isEmpty()) {
            List<Gifts> giftsFromCategory =
                    DeliverPresents.getGiftsFromCategory(child.getGiftsPreferences().get(0),
                    santaGiftsList);
            if (!giftsFromCategory.isEmpty() && giftsFromCategory.get(0).getQuantity() != 0) {
                child.getReceivedGifts().add(giftsFromCategory.get(0));
                giftsFromCategory.get(0).setQuantity(giftsFromCategory.get(0).getQuantity() - 1);
            }
        }
    }
}
