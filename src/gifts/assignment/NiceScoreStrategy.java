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

public final class NiceScoreStrategy implements AssignmentStrategy {
    private List<Child> childrenList;
    private List<Gifts> santaGiftList;

    public NiceScoreStrategy(final List<Child> children, final List<Gifts> santaGifts) {
        childrenList = children;
        santaGiftList = santaGifts;
    }

    @Override
    public void assignGifts() {
        List<Map.Entry<Child, Double>> sortedList = sortByNiceScore();

        Double score = sortedList.get(0).getValue();
        List<Child> sameScore = new LinkedList<>();
        sameScore.add(sortedList.get(0).getKey());
        sortedList.remove(sortedList.get(0));

        for (Map.Entry<Child, Double> entry : sortedList) {
            if (entry.getValue().equals(score)) {
                sameScore.add(entry.getKey());
            } else {
                sameScoreGifts(sameScore);
                sameScore.clear();
                sameScore.add(entry.getKey());
                score = entry.getValue();
            }
        }
        sameScoreGifts(sameScore);
    }

    private void sameScoreGifts(final List<Child> sameScore) {
        if (sameScore.size() > 1) {
            IdStrategy strategy = new IdStrategy(sameScore, santaGiftList);
            strategy.assignGifts();
        } else {
            DeliverPresents.getGifts(santaGiftList, sameScore.get(0));
            if (sameScore.get(0).getElf().equals(ElvesType.YELLOW)) {
                Santa santa = new Santa();
                santa.talkToElves(new YellowElf(new Elf(sameScore.get(0), santaGiftList)));
            }
        }
    }

    private List<Map.Entry<Child, Double>> sortByNiceScore() {
        HashMap<Child, Double> childrenNiceScores = new HashMap<>();
        for (Child child : childrenList) {
            childrenNiceScores.put(child, child.getAverageScore());
        }

        List<Map.Entry<Child, Double>> list = new LinkedList<>();
        list.addAll(childrenNiceScores.entrySet());

        Collections.sort(list, Map.Entry.comparingByValue());
        Collections.reverse(list);

        return list;
    }
}
