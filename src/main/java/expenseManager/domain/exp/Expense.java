package expenseManager.domain.exp;

import Errors.InvalidAmountException;

import java.util.Objects;
import java.util.UUID;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "ExpenseType")
@JsonSubTypes({
        @Type(value = DynamicExpense.class, name = "DynamicExpense"),
        @Type(value = RecurrentExpense.class, name = "RecurrentExpense")
})
public abstract class Expense {

    protected final String expenseId;
    protected double amount;
    protected String description;
    protected LocalDate dateTime;


    public Expense(double amount, String description, LocalDate dateTime) {
        this.expenseId = UUID.randomUUID().toString();
        if (amount < 0) throw new InvalidAmountException("Amount cannot be negative");
        this.amount = amount;
        this.description = description;
        this.dateTime = dateTime;
    }

    //redefine to compare
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        else if (!(o instanceof Expense)) return false;
        else return this.expenseId.equals(((Expense) o).expenseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expenseId);
    }

    //getters and setters
    public final String getExpenseId() { return this.expenseId; }
    public final double getAmount() { return this.amount; }
    public final String getDescription() { return this.description; }
    public final LocalDate getDateTime() { return this.dateTime; }

}
