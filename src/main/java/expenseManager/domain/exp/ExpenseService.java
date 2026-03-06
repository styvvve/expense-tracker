package expenseManager.domain.exp;

import expenseManager.domain.enu.Categorizable;
import expenseManager.domain.enu.DynamicExpenseType;
import expenseManager.domain.enu.ExpenseRecurrentType;
import expenseManager.domain.enu.PaymentFrequency;
import expenseManager.domain.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Regroup all the complex operations about expenses
 * We use this class to avoid overloading in the user class/ same with the IncomeService class
 * @see Expense
 * @author Steve
 * @version 1.0
 */
public class ExpenseService {

    User user;

    public ExpenseService(User user) {
        this.user = user;
    }

    //filter expense per day, month and year

    public List<Expense> expensesPerDay(int day, int month, int year) {
        return user.getExpenses().stream()
                .filter(e -> e.getDateTime().getDayOfMonth() == day && e.getDateTime().getMonthValue() == month && e.getDateTime().getYear() == year)
                .collect(toList());
    }
    public List<Expense> expensesPerMonth(int month, int year) {
        return user.getExpenses().stream()
                .filter(e -> e.getDateTime().getMonthValue() == month && e.getDateTime().getYear() == year)
                .collect(toList());
    }
    public List<Expense> expensesPerYear(int year) {
        return user.getExpenses().stream()
                .filter(e -> e.getDateTime().getYear() == year)
                .collect(toList());
    }

    // filter for recurrent type

    public List<RecurrentExpense> getRecurrentExpenses() {
        List<RecurrentExpense> recurrentExpenses = new ArrayList<>();
        for  (Expense expense : user.getExpenses()) {
            if (expense instanceof RecurrentExpense) {
                recurrentExpenses.add((RecurrentExpense) expense);
            }
        }

        return recurrentExpenses;
    }

    public List<RecurrentExpense> recurrentExpensesPerPaymentFrequency(PaymentFrequency paymentFrequency) {
        return getRecurrentExpenses().stream()
                .filter(e -> e.getPaymentFrequency() == paymentFrequency)
                .collect(toList());
    }

    public List<RecurrentExpense> recurrentExpensesPerTypes(ExpenseRecurrentType type) {
        return getRecurrentExpenses().stream()
                .filter(e -> e.getExpenseRecurrentType() == type)
                .collect(toList());
    }

    //filter for dynamic type

    public List<DynamicExpense> getDynamicExpenses() {
        List<DynamicExpense> dynamicExpenses = new ArrayList<>();
        for (Expense expense : user.getExpenses()) {
            if (expense instanceof DynamicExpense) {
                dynamicExpenses.add((DynamicExpense) expense);
            }
        }

        return dynamicExpenses;
    }

    public List<DynamicExpense> dynamicExpensesPerType(DynamicExpenseType type) {
        return getDynamicExpenses().stream()
                .filter(e -> e.getType() == type)
                .collect(toList());
    }

    //ADD : TOTAL EXPENSE PER CATEGORY



}
