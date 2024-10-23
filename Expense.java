import java.util.List;

public class Expense {
    private String id;
    private String description;
    private double totalAmount;
    private List<Participant> participants;
    private ExpenseType splitType;  // Equal, Exact, Percentage

    public Expense(String id, String description, double totalAmount, List<Participant> participants, ExpenseType spliType) {
        this.id = id;
        this.description = description;
        this.totalAmount = totalAmount;
        this.participants = participants;
        this.splitType = spliType;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Participant> getParticipants() {
        return participants;
    }
}
