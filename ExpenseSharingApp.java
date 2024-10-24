import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class ExpenseSharingApp {
    private static UserService userService = new UserService();
    private static ExpenseService expenseService = new ExpenseService();
    private static SplitService splitService = new SplitService();
    private static BalanceSheet balanceSheet = new BalanceSheet();
    private static BalanceSheetGenerator balanceSheetGenerator = new BalanceSheetGenerator();

    private static final String fileName = "balance_sheet.csv";

    public static void main(String args[]) {
        userService.createUser("roshan.baghwar@gmail.com", "Roshan Baghwar", "9508850072");
        userService.createUser("manisha.keshrip@gmail.com", "Manisha Keshri", "8766356478");

        User user1 = userService.getUser("roshan.baghwar@gmail.com");
        User user2 = userService.getUser("manisha.keshrip@gmail.com");

        Participant participant1 = new Participant(user1, 0, 0);
        Participant participant2 = new Participant(user2, 0, 0);
        List<Participant> participants = Arrays.asList(participant1, participant2);

        Expense expense1 = new Expense("1", "Breakfast", 2000, participants, SplitType.EQUAL);
        Expense expense2 = new Expense("2", "Lunch", 3000, participants, SplitType.PERCENTAGE);
        Expense expense3 = new Expense("3", "Dinner", 5000, participants, SplitType.EXACT);

        expenseService.addExpense(expense1); 
        expenseService.addExpense(expense2);
        expenseService.addExpense(expense3);

        splitService.splitExpense(expense1);
        balanceSheet.showBalanceSheet(expense1);


        Map<User, Double> percentageSplitMap = new HashMap<>();
        percentageSplitMap.put(user1, 75.0);
        percentageSplitMap.put(user2, 25.0);

        splitService.setSplitMap(percentageSplitMap);
        splitService.splitExpense(expense2);
        balanceSheet.showBalanceSheet(expense2);

        Map<User, Double> exactSplitMap = new HashMap<>();
        exactSplitMap.put(user1, 4500.0);
        exactSplitMap.put(user2, 500.0);

        splitService.setSplitMap(exactSplitMap);
        splitService.splitExpense(expense3);
        balanceSheet.showBalanceSheet(expense3);

        // Un-comment this to generate Balance Sheet CSV File
        // balanceSheetGenerator.getBalanceSheet(Arrays.asList(expense1, expense2, expense3), fileName);

    }
}
