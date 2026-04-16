package expenseManager.domain.exp;

import expenseManager.domain.enu.DynamicExpenseType;

import java.time.LocalDate;

public class DynamicExpense extends Expense {

    private DynamicExpenseType type;

    public DynamicExpense(double amount, String description, LocalDate dateTime, DynamicExpenseType type) {
        super(amount, description, dateTime);
        this.type = type;
    }

    public DynamicExpense() {
        super();
    }

    public DynamicExpenseType getType() { return this.type; }

    public void setType(DynamicExpenseType type) { this.type = type; }

}
