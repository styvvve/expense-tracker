package expenseManager.domain.enu;

public enum ExpenseRecurrentType implements Categorizable{
    RENT("Rent"),
    BANK_LOAN("Bank loan"),
    UTILITIES("Utilities"), //electricity, water, gaz
    INTERNET_PHONE("Internet/phone"),
    INSURANCE("Insurance"),
    TAXES("Taxes"),
    TRANSPORT("Transport"),
    STREAMING("Streaming"),
    GYM("Gym"),
    CLOUD_STORAGE("Cloud Storage"),
    SAVINGS_TRANSFER("Savings Transfer"),
    ALIMONY("Alimony"), //pension alimentaire
    OTHER("Other");

    private final String label;

    private ExpenseRecurrentType(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return this.label;
    }
}
