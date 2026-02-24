package expenseManager.domain.exp;

import expenseManager.domain.enu.DynamicExpenseType;

import java.time.LocalDateTime;

public class DynamicExpense extends Expense {

    private DynamicExpenseType type;

    public DynamicExpense(String expenseId, double amount, String description, LocalDateTime dateTime, DynamicExpenseType type) {
        super(expenseId, amount, description, dateTime);
        this.type = type;
    }

    public DynamicExpenseType getType() { return this.type; }

}
