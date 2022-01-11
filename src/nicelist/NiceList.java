package nicelist;

import input.AnnualChange;
import input.InputData;
import nicelist.rounds.AnnualChildren;
import nicelist.rounds.Round0;
import nicelist.rounds.YearlyRound;

import java.util.ArrayList;
import java.util.List;

public final class NiceList {
    private List<AnnualChildren> annualChildren = new ArrayList<>();

    public List<AnnualChildren> getAnnualChildren() {
        return annualChildren;
    }

    public void setAnnualChildren(final List<AnnualChildren> annualChildren) {
        this.annualChildren = annualChildren;
    }

    public void makeList(final InputData input) {
        // A new list of nice children
        AnnualChildren niceChildrenList = new Round0();
        ((Round0) niceChildrenList).makeNiceList(input.getInitialData().getChildren());

        // Assign budget for each child
        ((Round0) niceChildrenList).receiveGifts(input);

        //  Add the list of nice children to the nice list
        annualChildren.add(niceChildrenList);

        // A new list of children every year
        for (int year = 0; year < input.getNumberOfYears(); year++) {
            AnnualChildren newNiceChildrenList = new YearlyRound();
            AnnualChange change = input.getAnnualChanges().get(year);

            // Update the already existing children's ages, nice score history
            // and gifts preferences
            ((YearlyRound) newNiceChildrenList).makeNiceList(niceChildrenList
                    .getChildren(), change);

            // Adding the new children to the list
            AnnualChildren newChildrenList = new Round0();
            ((Round0) newChildrenList).makeNiceList(input.getAnnualChanges().
                    get(year).getNewChildren());
            newNiceChildrenList.getChildren().addAll(newChildrenList.getChildren());

            // Assign the budget to each child and give out the gifts
            ((YearlyRound) newNiceChildrenList).receiveGifts(year, input);

            annualChildren.add(newNiceChildrenList);
            niceChildrenList = newNiceChildrenList;
        }
    }

}
