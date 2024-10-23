import java.util.ArrayList;

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
    }

    public List<Expense> getAllExpenses() {
        return expenses;
    }
}