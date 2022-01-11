package nicelist.ages;

import input.ChildInput;
import nicelist.Child;

public final class Kid extends Child {
    public Kid(final ChildInput child) {
        super(child);
    }

    public Kid(final Child child) {
        super(child);
    }

    @Override
    public void calculateAverageScore() {
        Double totalNiceScore = getNiceScoreHistory().stream()
                .mapToDouble(Double::doubleValue).sum();
        Double averageScore = totalNiceScore / (double) getNiceScoreHistory().size();
        super.setAverageScore(averageScore);
    }
}
