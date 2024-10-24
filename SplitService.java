import java.util.Map;

public class SplitService {

    private static DataValidation dataValidation = new DataValidation();

    public void splitExpense(Expense expense, Map<User, Double> expenseMap) {
        switch (expense.getSplitType()) {
            case EQUAL:
                        splitEqually(expense);
                        break;

            case EXACT:
                        splitExact(expense, expenseMap);
                        break;

            case PERCENTAGE:
                        splitByPercentage(expense, expenseMap);
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
