package expenseManager.domain.exp;

import expenseManager.domain.enu.*;

import java.time.LocalDateTime;

public class RecurrentExpense extends Expense {

    private ExpenseRecurrentType type;
    private PaymentFrequency paymentFrequency;

    public RecurrentExpense(String expenseId, double amount, String description, LocalDateTime dateTime, ExpenseRecurrentType type, PaymentFrequency paymentFrequency) {
        super(expenseId, amount, description, dateTime);
        this.type = type;
        this.paymentFrequency = paymentFrequency;
    }

    public ExpenseRecurrentType getExpenseRecurrentType() { return this.type; }
    public PaymentFrequency getPaymentFrequency() { return this.paymentFrequency; }
}
