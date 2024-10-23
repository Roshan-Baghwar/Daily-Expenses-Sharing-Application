public class Participant {
    private User user;
    private double amountOwed;
    private double percentageOwed;

    public Participant(User user, double amountOwed, double percentageOwed) {
        this.user = user;
        this.amountOwed = amountOwed;
        this.percentageOwed = percentageOwed;
    }
}
