public class Participant {
    private User user;
    private double amountOwed;
    private double percentageOwed;

    public Participant(User user, double amountOwed, double percentageOwed) {
        this.user = user;
        this.amountOwed = amountOwed;
        this.percentageOwed = percentageOwed;
    }

    public User getUser() {
        return user;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public double getPercentageOwed() {
        return percentageOwed;
    }

    public void setAmountOwed(double amountOwed) {
        this.amountOwed = amountOwed;
    }
}
