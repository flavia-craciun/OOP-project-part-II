package gifts.assignment;

import enums.Cities;
import gifts.Gifts;
import nicelist.Child;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Double.NaN;

public class NiceScoreCityStrategy implements AssignmentStrategy{
    List<Child> childrenList;
    List<Gifts> santaGiftListList;

    public NiceScoreCityStrategy(List<Child> children,
                                 List<Gifts> giftListList) {
        childrenList = children;
        santaGiftListList = giftListList;
    }

    @Override
    public void assignGifts() {
        HashMap<Cities, Double> citiesNiceScores = new HashMap<>();
        HashMap<Cities, List<Child>> childrenFromCities = new HashMap<>();

        for (Cities city : Cities.values()) {
            List<Child> childrenFromCity = new LinkedList<>();
            Double cityScore = 0.0;
            int children = 0;
            for (Child child : childrenList) {
                if (child.getCity().equals(city)) {
                    childrenFromCity.add(child);
                    cityScore += child.getAverageScore();
                    children ++;
                }
            }
            childrenFromCities.put(city, childrenFromCity);
            citiesNiceScores.put(city, cityScore / children);
        }

        List<Map.Entry<Cities, Double>> list = new LinkedList<>();
        list.addAll(citiesNiceScores.entrySet());

        Collections.sort(list, Map.Entry.comparingByValue());
        Collections.reverse(list);
        List<Map.Entry<Cities, Double>> sortedList = list.stream()
                .filter(x -> !x.getValue().equals(NaN))
                .collect(Collectors.toList());

        Double score = sortedList.get(0).getValue();
        List<Cities> sameScore = new LinkedList<>();
        sameScore.add(sortedList.get(0).getKey());
        sortedList.remove(sortedList.get(0));
        for (Map.Entry<Cities, Double> entry : sortedList) {
            if (entry.getValue().equals(score)) {
                sameScore.add(entry.getKey());
            } else {
                Collections.sort(sameScore, Comparator.comparing(Enum::toString));
                for (Cities city : sameScore) {
                    IdStrategy strategy = new IdStrategy(childrenFromCities.get(city),
                            santaGiftListList);
                    strategy.assignGifts();
                }
                sameScore.clear();
                sameScore.add(entry.getKey());
                score = entry.getValue();
            }
        }

        Collections.sort(sameScore, Comparator.comparing(Enum::toString));
        for (Cities city : sameScore) {
            IdStrategy strategy = new IdStrategy(childrenFromCities.get(city),
                    santaGiftListList);
            strategy.assignGifts();
        }
    }
}
