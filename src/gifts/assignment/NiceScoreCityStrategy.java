package gifts.assignment;

import enums.Cities;
import gifts.Gifts;
import nicelist.Child;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;


import static java.lang.Double.NaN;

public final class NiceScoreCityStrategy implements AssignmentStrategy {
    private List<Child> childrenList;
    private List<Gifts> santaGiftListList;

    public NiceScoreCityStrategy(final List<Child> children, final List<Gifts> giftListList) {
        childrenList = children;
        santaGiftListList = giftListList;
    }

    @Override
    public void assignGifts() {
        HashMap<Cities, List<Child>> childrenFromCities = new HashMap<>();
        List<Map.Entry<Cities, Double>> sortedList = sortCitiesByNiceScore(childrenFromCities);

        Double score = sortedList.get(0).getValue();
        List<Cities> sameScore = new LinkedList<>();
        sameScore.add(sortedList.get(0).getKey());
        sortedList.remove(sortedList.get(0));

        for (Map.Entry<Cities, Double> entry : sortedList) {
            if (entry.getValue().equals(score)) {
                sameScore.add(entry.getKey());
            } else {
                sameScoreCities(sameScore, childrenFromCities);
                sameScore.clear();
                sameScore.add(entry.getKey());
                score = entry.getValue();
            }
        }
        sameScoreCities(sameScore, childrenFromCities);
    }

    private void sameScoreCities(final List<Cities> sameScore,
                                 final HashMap<Cities, List<Child>> childrenFromCities) {
        Collections.sort(sameScore, Comparator.comparing(Enum::toString));
        for (Cities city : sameScore) {
            IdStrategy strategy = new IdStrategy(childrenFromCities.get(city),
                    santaGiftListList);
            strategy.assignGifts();
        }
    }

    private List<Map.Entry<Cities, Double>> sortCitiesByNiceScore(
            final HashMap<Cities, List<Child>> childrenFromCities) {

        HashMap<Cities, Double> citiesNiceScores = new HashMap<>();

        for (Cities city : Cities.values()) {
            List<Child> childrenFromCity = new LinkedList<>();
            Double cityScore = 0.0;
            int children = 0;
            for (Child child : childrenList) {
                if (child.getCity().equals(city)) {
                    childrenFromCity.add(child);
                    cityScore += child.getAverageScore();
                    children++;
                }
            }
            childrenFromCities.put(city, childrenFromCity);
            citiesNiceScores.put(city, cityScore / children);
        }

        List<Map.Entry<Cities, Double>> list = new LinkedList<>();
        list.addAll(citiesNiceScores.entrySet());

        Collections.sort(list, Map.Entry.comparingByValue());
        Collections.reverse(list);

        return list.stream().filter(x -> !x.getValue().equals(NaN)).collect(Collectors.toList());
    }
}
