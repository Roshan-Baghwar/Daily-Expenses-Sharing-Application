import java.util.Map;

public class SplitService {

    private static DataValidation dataValidation = new DataValidation();

    public void splitEqually(Expense expense) {
        double splitAmount = expense.getTotalAmount() / expense.getParticipants().size();
        // System.out.println(splitAmount);
        for(Participant participant : expense.getParticipants()) {
            participant.setAmountOwed(splitAmount);
        }
    }

    public void splitExact(Expense expense, Map<User, Double> exactAmounts) {
        if(dataValidation.isInputDataForExactSplitValid(expense, exactAmounts)) {
            for(Participant participant : expense.getParticipants()) {
                double amount = exactAmounts.get(participant.getUser());
                participant.setAmountOwed(amount);
            }
        }
    }

    public void splitByPercentage(Expense expense, Map<User, Double> percentages) {
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
