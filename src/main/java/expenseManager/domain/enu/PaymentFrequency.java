package expenseManager.domain.enu;

public enum PaymentFrequency implements Categorizable{
    DAILY("Daily"),
    WEEKLY("Weekly"),
    MONTHLY("Monthly"),
    YEARLY("Yearly");

    private final String label;

    PaymentFrequency(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return this.label;
    }
}
