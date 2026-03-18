package expenseManager.domain.exp;

import expenseManager.domain.enu.DynamicExpenseType;
import expenseManager.domain.enu.ExpenseRecurrentType;
import expenseManager.domain.enu.PaymentFrequency;
import expenseManager.domain.user.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExpenseServiceTest {

    @Test
    public void expensePerMonthReturnExpensesFromTheMonth() {
        User user = new User("US-01", "Test", "Tesssst", "stydbdj@gmail.com", LocalDate.of(2003, 2, 12));

        Expense exp = new DynamicExpense("EEE", 500, "play", LocalDateTime.now(), DynamicExpenseType.SHOPPING);
        Expense exp2 = new RecurrentExpense("AAA", 500, "rent", LocalDateTime.of(2026, 2, 1, 22, 11), ExpenseRecurrentType.RENT, PaymentFrequency.MONTHLY);

        user.addExpense(exp);
        user.addExpense(exp2);

        ExpenseService svr = new ExpenseService(user);

        List<Expense> expensesFeb = svr.expensesPerMonth(2, 2026);

        assertEquals(1, expensesFeb.size());
        assertEquals(exp2, expensesFeb.getFirst());
    }

    @Test
    public void expensePerDayReturnExpensesFromTheDay() {

        User user = new User("US-01", "Test", "Tesssst", "stybuud@gmail.com", LocalDate.of(2003, 2, 12));

        Expense exp = new DynamicExpense("EEE", 500, "play", LocalDateTime.now(), DynamicExpenseType.SHOPPING);
        Expense exp2 = new DynamicExpense("EEE", 60, "play", LocalDateTime.now(), DynamicExpenseType.RESTAURANT_CAFE);
        Expense exp3 = new RecurrentExpense("AAA", 500, "rent", LocalDateTime.of(2026, 2, 1, 22, 11), ExpenseRecurrentType.RENT, PaymentFrequency.MONTHLY);

        user.addExpense(exp);
        user.addExpense(exp2);
        user.addExpense(exp3);

        ExpenseService svr = new ExpenseService(user);

        List<Expense> expensesToday = svr.expensesPerDay(2, 3, 2026);

        assertEquals(2, expensesToday.size());
        assertEquals(exp, expensesToday.getFirst());
        assertEquals(exp2, expensesToday.get(1));
    }

    @Test
    public void expensePerYearReturnExpensesFromTheYear() {

        User user = new User("US-01", "Test", "Tesssst", "stybuud@gmail.com", LocalDate.of(2003, 2, 12));

        Expense exp = new DynamicExpense("EEE", 500, "play", LocalDateTime.of(2025, 2, 25, 11, 30), DynamicExpenseType.SHOPPING);
        Expense exp2 = new DynamicExpense("EEE", 60, "play", LocalDateTime.of(2025, 10, 10, 12, 30), DynamicExpenseType.RESTAURANT_CAFE);
        Expense exp3 = new RecurrentExpense("AAA", 500, "rent", LocalDateTime.of(2026, 2, 1, 22, 11), ExpenseRecurrentType.RENT, PaymentFrequency.MONTHLY);

        user.addExpense(exp);
        user.addExpense(exp2);
        user.addExpense(exp3);

        ExpenseService svr = new ExpenseService(user);

        List<Expense> expensesYear = svr.expensesPerYear(2025);
        assertEquals(2, expensesYear.size());
        assertEquals(exp, expensesYear.get(0));
        assertEquals(exp2, expensesYear.get(1));
    }

    @Test
    public void getRecurrentExpensesReturnRecurrentExpenses() {

        User user = new User("US-01", "Test", "Tesssst", "stybuud@gmail.com", LocalDate.of(2003, 2, 12));

        Expense exp = new DynamicExpense("EEE", 500, "play", LocalDateTime.of(2025, 2, 25, 11, 30), DynamicExpenseType.SHOPPING);
        Expense exp2 = new DynamicExpense("EEE", 60, "play", LocalDateTime.of(2025, 10, 10, 12, 30), DynamicExpenseType.RESTAURANT_CAFE);
        Expense exp3 = new RecurrentExpense("AAA", 500, "rent", LocalDateTime.of(2026, 2, 1, 22, 11), ExpenseRecurrentType.RENT, PaymentFrequency.MONTHLY);

        user.addExpense(exp);
        user.addExpense(exp2);
        user.addExpense(exp3);

        ExpenseService svr = new ExpenseService(user);

        List<RecurrentExpense> recurrentExpenses = svr.getRecurrentExpenses();

        assertEquals(1, recurrentExpenses.size());
        assertEquals(exp3, recurrentExpenses.getFirst());
    }

    @Test
    public void getDynamicExpensesReturnDynamicExpenses() {

        User user = new User("US-01", "Test", "Tesssst", "stybuud@gmail.com", LocalDate.of(2003, 2, 12));

        Expense exp = new DynamicExpense("EEE", 500, "play", LocalDateTime.of(2025, 2, 25, 11, 30), DynamicExpenseType.SHOPPING);
        Expense exp2 = new DynamicExpense("EEE", 60, "play", LocalDateTime.of(2025, 10, 10, 12, 30), DynamicExpenseType.RESTAURANT_CAFE);
        Expense exp3 = new RecurrentExpense("AAA", 500, "rent", LocalDateTime.of(2026, 2, 1, 22, 11), ExpenseRecurrentType.RENT, PaymentFrequency.MONTHLY);

        user.addExpense(exp);
        user.addExpense(exp2);
        user.addExpense(exp3);

        ExpenseService svr = new ExpenseService(user);

        List<DynamicExpense> dynamicExpenses = svr.getDynamicExpenses();

        assertEquals(2, dynamicExpenses.size());
        assertEquals(exp, dynamicExpenses.getFirst());
    }

    @Test
    public void expensesFilterShouldReturnCorrectFilteredExpenses() {
        User user = new User("US-01", "Test", "Tesssst", "stybuud@gmail.com", LocalDate.of(2003, 2, 12));

        Expense exp = new DynamicExpense("EEE", 500, "play", LocalDateTime.of(2025, 2, 25, 11, 30), DynamicExpenseType.SHOPPING);
        Expense exp2 = new DynamicExpense("EEE", 60, "play", LocalDateTime.of(2025, 10, 10, 12, 30), DynamicExpenseType.RESTAURANT_CAFE);
        Expense exp3 = new RecurrentExpense("AAA", 500, "rent", LocalDateTime.of(2026, 2, 1, 22, 11), ExpenseRecurrentType.RENT, PaymentFrequency.MONTHLY);
        Expense exp4 = new RecurrentExpense("FFF", 500, "rent", LocalDateTime.of(2026, 2, 1, 22, 11), ExpenseRecurrentType.INTERNET_PHONE, PaymentFrequency.YEARLY);

        user.addExpense(exp);
        user.addExpense(exp2);
        user.addExpense(exp3);
        user.addExpense(exp4);

        ExpenseService svr = new ExpenseService(user);

        List<DynamicExpense> shopping = svr.dynamicExpensesPerType(DynamicExpenseType.SHOPPING);
        assertEquals(1, shopping.size());

        List<RecurrentExpense> rentExpenses = svr.recurrentExpensesPerTypes(ExpenseRecurrentType.RENT);
        assertEquals(1, rentExpenses.size());

        List<RecurrentExpense> yearlyExpenses = svr.recurrentExpensesPerPaymentFrequency(PaymentFrequency.YEARLY);
        assertEquals(1, yearlyExpenses.size());
    }
}
