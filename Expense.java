import java.util.List;

public class Expense {
    private String id;
    private String description;
    private double totalAmount;
    private List<Participant> participants;
    private SplitType splitType;  // Equal, Exact, Percentage

    public Expense(String id, String description, double totalAmount, List<Participant> participants, SplitType spliType) {
        this.id = id;
        this.description = description;
        this.totalAmount = totalAmount;
        this.participants = participants;
        this.splitType = spliType;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
