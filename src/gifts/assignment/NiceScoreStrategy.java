package gifts.assignment;

import enums.Cities;
import enums.ElvesType;
import gifts.DeliverPresents;
import gifts.Gifts;
import gifts.elves.SantaWorkshop;
import gifts.elves.YellowElf;
import nicelist.Child;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NiceScoreStrategy implements AssignmentStrategy{
    List<Child> childrenList;
    List<Gifts> santaGiftList;

    public NiceScoreStrategy(List<Child> children, List<Gifts> santaGifts) {
        childrenList = children;
        santaGiftList = santaGifts;
    }

    @Override
    public void assignGifts() {
        HashMap<Child, Double> childrenNiceScores = new HashMap<>();
        for (Child child : childrenList) {
            childrenNiceScores.put(child, child.getAverageScore());
        }

        List<Map.Entry<Child, Double>> list = new LinkedList<>();
        list.addAll(childrenNiceScores.entrySet());

        Collections.sort(list, Map.Entry.comparingByValue());
        Collections.reverse(list);

        Double score = list.get(0).getValue();
        List<Child> sameScore = new LinkedList<>();
        sameScore.add(list.get(0).getKey());
        list.remove(list.get(0));
        for (Map.Entry<Child, Double> entry : list) {
            if (entry.getValue().equals(score)) {
                sameScore.add(entry.getKey());
            } else {
                if (sameScore.size() > 1) {
                    IdStrategy strategy = new IdStrategy(sameScore, santaGiftList);
                    strategy.assignGifts();
                } else {
                    DeliverPresents.getGifts(santaGiftList, sameScore.get(0));
                    if (sameScore.get(0).getElf().equals(ElvesType.YELLOW)) {
                        SantaWorkshop workshop = new SantaWorkshop();
                        workshop.work(new YellowElf(sameScore.get(0), santaGiftList));
                    }
                }
                sameScore.clear();
                sameScore.add(entry.getKey());
                score = entry.getValue();
            }
        }

        if (sameScore.size() > 1) {
            IdStrategy strategy = new IdStrategy(sameScore, santaGiftList);
            strategy.assignGifts();
        } else {
            DeliverPresents.getGifts(santaGiftList, sameScore.get(0));
            if (sameScore.get(0).getElf().equals(ElvesType.YELLOW)) {
                SantaWorkshop workshop = new SantaWorkshop();
                workshop.work(new YellowElf(sameScore.get(0), santaGiftList));
            }
        }
    }
}
