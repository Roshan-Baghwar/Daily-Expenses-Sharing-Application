public class ExpenseSharingApp {
    private static UserService userService = new UserService();
    private static ExpenseService expenseService = new ExpenseService();

    public static void main(String args[]) {
        userService.createUser("roshan.baghwar@gmail.com", "Roshan Baghwar", "9508850072");
        userService.createUser("pranaydeep@gmail.com", "Pranay Deep", "8766356478");

        User roshan = userService.getUser("roshan.baghwar@gmail.com");
    }
}
