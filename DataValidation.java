import java.util.Map;

public class DataValidation {
    
    // Total sum of exact-amounts per participants should be equal to the totalAmount of the expense
    public boolean isInputDataForExactSplitValid(Expense expense, Map<User, Double> exactAmounts) {
        double totalExactAmount = 0.0;
        for(double exactAmount : exactAmounts.values()) {
            totalExactAmount += exactAmount;
        }

        if(totalExactAmount != expense.getTotalAmount()) {
            System.out.println("Total Expense Amount: " + expense.getTotalAmount());
            System.out.println("Sum of Exact-Amount per user: " + totalExactAmount);
            throw new IllegalArgumentException("Sum of Exact-Split amount per User is not equal to total expense amount!");
        }

        return true;
    }

    public boolean isInputDataForPercentageSplitValid(Expense expense, Map<User, Double> percentages) {
        double totalPercentage = 0.0;
        for(double percentage : percentages.values()) {
            totalPercentage += percentage;
        }

        if(totalPercentage != 100.0) {
            System.out.println("Total Expense Share: 100.0%");
            System.out.println("Sum of Percentage Share per User: " + totalPercentage+" daf");
            throw new IllegalArgumentException("Sum of Percentage-Split per User is not equal to 100.0%!"); 
        }

        return true;
    }
}
