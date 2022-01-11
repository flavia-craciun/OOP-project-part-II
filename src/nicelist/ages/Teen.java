package nicelist.ages;

import input.ChildInput;
import nicelist.Child;

public final class Teen extends Child  {
    public Teen(final ChildInput child) {
        super(child);
    }

    public Teen(final Child child) {
        super(child);
    }

    @Override
    public void calculateAverageScore() {
        Double totalNiceScore = 0.0;
        int index = 0;
        int indexSum = 0;
        for (Double niceScore : getNiceScoreHistory()) {
            ++index;
            indexSum += index;
            totalNiceScore += niceScore * index;
        }
        Double averageScore = totalNiceScore / indexSum;
        super.setAverageScore(averageScore);
    }
}
