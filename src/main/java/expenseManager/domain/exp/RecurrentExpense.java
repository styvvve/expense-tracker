package expenseManager.domain.exp;

import expenseManager.domain.enu.*;

import java.time.LocalDate;

public class RecurrentExpense extends Expense {

    private ExpenseRecurrentType type;
    private PaymentFrequency paymentFrequency;

    public RecurrentExpense(double amount, String description, LocalDate dateTime, ExpenseRecurrentType type, PaymentFrequency paymentFrequency) {
        super(amount, description, dateTime);
        this.type = type;
        this.paymentFrequency = paymentFrequency;
    }

    public ExpenseRecurrentType getExpenseRecurrentType() { return this.type; }
    public PaymentFrequency getPaymentFrequency() { return this.paymentFrequency; }

    public void setRecurrentType (ExpenseRecurrentType type) { this.type = type; }
    public void setPaymentFrequency (PaymentFrequency paymentFrequency) { this.paymentFrequency = paymentFrequency; }
}
