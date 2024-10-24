import java.util.Map;
import java.util.HashMap;

public class SplitService {

    private Map<User, Double> splitMap;
    private DataValidation dataValidation;

    public SplitService() {
        this.splitMap = new HashMap<>();
        this.dataValidation = new DataValidation();
    }

    public void setSplitMap(Map<User, Double> splitMap) {
        this.splitMap = splitMap;
    }

    public void splitExpense(Expense expense) {
        switch (expense.getSplitType()) {
            case EQUAL:
                        splitEqually(expense);
                        break;

            case EXACT:
                        splitExact(expense, splitMap);
                        break;

            case PERCENTAGE:
                        splitByPercentage(expense, splitMap);
                        break;
        
            default:
                    return;
        }
    }

    private void splitEqually(Expense expense) {
        double splitAmount = expense.getTotalAmount() / expense.getParticipants().size();
        // System.out.println(splitAmount);
        for(Participant participant : expense.getParticipants()) {
            participant.setAmountOwed(splitAmount);
        }
    }

    private void splitExact(Expense expense, Map<User, Double> exactAmounts) {
        if(dataValidation.isInputDataForExactSplitValid(expense, exactAmounts)) {
            for(Participant participant : expense.getParticipants()) {
                double amount = exactAmounts.get(participant.getUser());
                participant.setAmountOwed(amount);
            }
        }
    }

    private void splitByPercentage(Expense expense, Map<User, Double> percentages) {
        if(dataValidation.isInputDataForPercentageSplitValid(expense, percentages)) {
            for(Participant participant : expense.getParticipants()) {
                double percentage = percentages.get(participant.getUser());
                double amount = (percentage / 100) * expense.getTotalAmount();
                participant.setAmountOwed(amount);
                participant.setPercentageOwed(percentage);
            }
        }
    }
}
