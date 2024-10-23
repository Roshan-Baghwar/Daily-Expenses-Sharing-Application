public class ExpenseSharingApp {
    private static UserService userService = new UserService();
    private static ExpenseService expenseService = new ExpenseService();

    public static void main(String args[]) {
        userService.createUser("roshan.baghwar@gmail.com", "Roshan Baghwar", "9508850072");
        userService.createUser("pranaydeep@gmail.com", "Pranay Deep", "8766356478");

        User roshan = userService.getUser("roshan.baghwar@gmail.com");
        User pranay = userService.getUser("pranaydeep@gmail.com");

        Participant participant1 = new Participant(roshan, 0, 0);
        Participant participant2 = new Participant(pranay, 0, 0);
        List<Participant> participants = Arrays.asList(participant1, participant2);

        Expense expense = new Expense("1", "Dinner", 2000, participants, ExpenseType.EQUAL);
        expenseService.addExpense(expense);
    }
}
