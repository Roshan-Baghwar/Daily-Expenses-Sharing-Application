import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class ExpenseSharingApp {
    private static UserService userService = new UserService();
    private static ExpenseService expenseService = new ExpenseService();
    private static SplitService splitService = new SplitService();
    private static BalanceSheet balanceSheet = new BalanceSheet();

    public static void main(String args[]) {
        userService.createUser("roshan.baghwar@gmail.com", "Roshan Baghwar", "9508850072");
        userService.createUser("pranaydeep@gmail.com", "Pranay Deep", "8766356478");

        User user1 = userService.getUser("roshan.baghwar@gmail.com");
        User user2 = userService.getUser("pranaydeep@gmail.com");

        Participant participant1 = new Participant(user1, 0, 0);
        Participant participant2 = new Participant(user2, 0, 0);
        List<Participant> participants = Arrays.asList(participant1, participant2);

        Expense expense = new Expense("1", "Dinner", 2000, participants, ExpenseType.PERCENTAGE);
        expenseService.addExpense(expense); 
        Map<User, Double> expenseMap = new HashMap<>();
        expenseMap.put(user1, 75.0);
        expenseMap.put(user2, 25.0);

        splitService.splitByPercentage(expense, expenseMap);
        balanceSheet.showIndividualExpenses(expense);
        balanceSheet.showOverallExpense(expense);

    }
}
