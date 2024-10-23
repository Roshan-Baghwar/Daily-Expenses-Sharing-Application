import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class ExpenseService {
    private List<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public List<Expense> getExpensesForUser(User user) {
        List<Expense> userExpenses = new ArrayList<>();

        for(Expense expense : expenses) {
            for(Participant participant : expense.getParticipants()) {
                if(participant.getUser().equals(user)) {
                    userExpenses.add(expense);
                    break;
                }
            }
        }

        return userExpenses;
    }

    public List<Expense> getAllExpenses() {
        return expenses;
    }

    public void splitEqually(Expense expense) {
        double splitAmount = expense.getTotalAmount() / expense.getParticipants().size();
        for(Participant participant : expense.getParticipants()) {
            participant.setAmountOwed(splitAmount);
        }
    }

    public void splitExact(Expense expense, Map<User, Double> exactAmounts) {
        for(Participant participant : expense.getParticipants()) {
            double amount = exactAmounts.get(participant.getUser());
            participant.setAmountOwed(amount);
        }
    }

    public void splitByPercentage(Expense expense, Map<User, Double> percentages) {
        for(Participant participant : expense.getParticipants()) {
            double percentage = percentages.get(participant.getUser());
            double amount = (percentage / 100) * expense.getTotalAmount();
            participant.setAmountOwed(amount);
        }
    }
}