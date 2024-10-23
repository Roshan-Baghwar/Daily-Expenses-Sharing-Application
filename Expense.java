import java.util.List;

public class Expense {
    private String id;
    private String description;
    private double totalAmount;
    private List<Participant> participants;
    private ExpenseType splitType;  // Equal, Exact, Percentage
}
