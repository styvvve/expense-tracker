package expenseManager;

import java.time.LocalDate;
import java.util.Objects;

public class Income {

    private final String incomeId;
    private double amount;
    private boolean isRecurring;
    private LocalDate date;

    public Income(String incomeId, double amount, boolean isRecurring, LocalDate date) {
        this.incomeId = incomeId;
        this.amount = amount;
        this.isRecurring = isRecurring;
        this.date = date;
    }

    //redefine to compare
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        else if (!(o instanceof Income)) return false;
        else return this.incomeId.equals(((Income) o).incomeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(incomeId);
    }

    //getters and setters
    public String getIncomeId() { return this.incomeId; }
    public double getAmount() { return this.amount; }
    public boolean isRecurring() { return this.isRecurring; }
    public LocalDate getDate() { return this.date; }
}
