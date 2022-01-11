package gifts;

import enums.Category;
import nicelist.Child;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.List;


public abstract class DeliverPresents {

    /**
     * This method is used to calculate the budget unit in the following way:
     * budgetUnit = santaBudget / children average scores sum
     *
     * @param santaBudget santa's budget from the input file
     * @param children the list of children to be used to sum up the average scores
     */
    public static Double calculateBudgetUnit(final Double santaBudget, final List<Child> children) {
        Double budgetUnit;
        Double allAverageNiceScore = 0.0;
        for (Child child : children) {
            allAverageNiceScore += child.getAverageScore();
        }
        budgetUnit = santaBudget / allAverageNiceScore;
        return budgetUnit;
    }

    /**
     * This method is used to assign the budget for a child, look through the
     * their gifts preferences and pick the presents the child shall receive
     *
     * @param santaGiftsList santa's gift list used to give out presents
     * @param child the child who is due to receive a present
     */
    public static void getGifts(final List<Gifts> santaGiftsList, final Child child) {
        Double budget = child.getAssignedBudget();
        List<Category> childGiftsPreferences = new LinkedList<>();
        childGiftsPreferences.addAll(child.getGiftsPreferences());
        for (Category giftPreference : childGiftsPreferences) {
            List<Gifts> giftsFromCategory = getGiftsFromCategory(giftPreference, santaGiftsList);
            for (Gifts gift : giftsFromCategory) {
                if (gift.getPrice() <= budget) {
                    child.getReceivedGifts().add(gift);
                    budget = budget - gift.getPrice();
                    break;
                }
            }
        }
    }

    /**
     * This method is used to find all the gifts in santa's list from a given category
     *
     * @param category the parameter used to sort out the gifts by
     * @param santaGiftsList santa's gift list used to give out presents
     */
    private static List<Gifts> getGiftsFromCategory(final Category category,
                                                    final List<Gifts> santaGiftsList) {
        HashMap<Gifts, Double> giftsFromCategory = new HashMap<>();
        for (Gifts gift : santaGiftsList) {
            if (gift.getCategory().equals(category)) {
                giftsFromCategory.put(gift, gift.getPrice());
            }
        }
        return sortByPrice(giftsFromCategory);
    }

    /**
     * This method is used to sort all the gifts from a given category by price
     *
     * @param gifts the parameter is a hashmap of the gifts and their prices
     */
    public static List<Gifts> sortByPrice(final HashMap<Gifts, Double> gifts) {
        List<Map.Entry<Gifts, Double>> list = new LinkedList<>();
        list.addAll(gifts.entrySet());

        Collections.sort(list, Map.Entry.comparingByValue());

        List<Gifts> sortedGifts = new LinkedList<>();
        for (Map.Entry<Gifts, Double> entry : list) {
            sortedGifts.add(entry.getKey());
        }

        return sortedGifts;
    }
}
