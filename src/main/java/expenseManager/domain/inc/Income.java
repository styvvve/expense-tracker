package expenseManager.domain.inc;

import Errors.InvalidAmountException;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * Income class
 * save all the income from the user
 * 2 constructors
 * one with parameters (basically), one copy constructor for recurring incomes
 * comparing two incomes with incomeId, amount and recurring status
 * @author Steve
 * @version 1.0
 */

public class Income {

    private final String incomeId;
    private double amount;
    private boolean isRecurring;
    private LocalDate date;

    public Income(double amount, boolean isRecurring, LocalDate date) {
        this.incomeId = UUID.randomUUID().toString();
        if (amount < 0) throw new InvalidAmountException("Amount cannot be negative");
        this.amount = amount;
        this.isRecurring = isRecurring;
        this.date = date;
    }

    public Income(Income other) {
        this.incomeId = other.incomeId;
        this.amount = other.amount;
        this.isRecurring = other.isRecurring;
        this.date = other.date;
    }

    public Income(Income other, boolean recurring) {
        this.incomeId = other.incomeId;
        this.amount = other.amount;
        this.isRecurring = other.isRecurring;
        this.date = other.date.plusMonths(recurring ? 1 : 0);
    }

    public boolean hasSameRecurringStatus(Income other) {
        if (this.isRecurring() && other.isRecurring()) return true;
        else return !this.isRecurring() && !other.isRecurring();
    }

    //redefine to compare
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        else if (!(o instanceof Income)) return false;
        else return this.incomeId.equals(((Income) o).incomeId) && this.amount == ((Income) o).amount && this.hasSameRecurringStatus((Income) o);  //comparaison complete
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

    public void setNewDate(LocalDate date) { this.date = date; }
    public void setRecurringToFalse() { this.isRecurring = false; }
    public void setRecurringToTrue() { this.isRecurring = true; }
    public void setAmount(double amount) { this.amount = amount; }
}
