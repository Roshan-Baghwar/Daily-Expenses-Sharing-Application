public class BalanceSheet {

    public void showBalanceSheet(Expense expense) {
        System.out.println("***************************************");
        System.out.println("Balance Sheet for " + expense.getDescription() + " (" + expense.getSplitType() + " Split)");
        System.out.println("***************************************");

        showIndividualExpenses(expense);
        showOverallExpense(expense);
    }
    
    private void showIndividualExpenses(Expense expense) {
        System.out.println("---------------------------------------");
        System.out.println("Showing INDIVIDUAL Expenses");
        System.out.println("---------------------------------------");
        System.out.println("Name \t\t Expense Owed");
        
        for(Participant participant : expense.getParticipants()) {
            System.out.println(participant.getUser().getName() + " \t " + participant.getAmountOwed());
        }
    }

    private void showOverallExpense(Expense expense) {
        System.out.println("---------------------------------------");
        System.out.println("Showing OVERALL Expenses");
        System.out.println("---------------------------------------");
        System.out.println("Total Amount: \t" + expense.getTotalAmount());
        System.out.println();
    }
}
