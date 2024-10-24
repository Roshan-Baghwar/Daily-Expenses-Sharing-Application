public class BalanceSheet {
    
    public void showIndividualExpenses(Expense expense) {
        System.out.println("------------------------------");
        System.out.println("Showing INDIVIDUAL Expenses");
        System.out.println("------------------------------");
        System.out.println("Name \t\t Expense Owed");
        
        for(Participant participant : expense.getParticipants()) {
            System.out.println(participant.getUser().getName() + " \t " + participant.getAmountOwed());
        }
    }

    public void showOverallExpense(Expense expense) {
        System.out.println("------------------------------");
        System.out.println("Showing OVERALL Expenses");
        System.out.println("------------------------------");
        System.out.println("Total Amount: \t" + expense.getTotalAmount());
    }
}
