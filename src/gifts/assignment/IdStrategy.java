package gifts.assignment;

import enums.ElvesType;
import gifts.DeliverPresents;
import gifts.Gifts;
import gifts.elves.Elf;
import gifts.elves.Santa;
import gifts.elves.YellowElf;
import nicelist.Child;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class IdStrategy implements AssignmentStrategy {
    private List<Child> childrenList;
    private List<Gifts> santaGiftList;

    public IdStrategy(final List<Child> children, final List<Gifts> santaGifts) {
        childrenList = children;
        santaGiftList = santaGifts;
    }

    @Override
    public void assignGifts() {
        for (Map.Entry<Child, Integer> entry : sortById()) {
            DeliverPresents.getGifts(santaGiftList, entry.getKey());
            if (entry.getKey().getElf().equals(ElvesType.YELLOW)) {
                Santa santa = new Santa();
                santa.talkToElves(new YellowElf(new Elf(entry.getKey(), santaGiftList)));

            }
        }
    }

    private List<Map.Entry<Child, Integer>> sortById() {
        HashMap<Child, Integer> childrenIds = new HashMap<>();
        for (Child child : childrenList) {
            childrenIds.put(child, child.getId());
        }

        List<Map.Entry<Child, Integer>> list = new LinkedList<>();
        list.addAll(childrenIds.entrySet());

        Collections.sort(list, Map.Entry.comparingByValue());
        return list;
    }
}
