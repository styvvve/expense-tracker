package expenseManager.domain.user;

import Errors.InvalidAmountException;
import expenseManager.domain.enu.*;
import expenseManager.domain.exp.DynamicExpense;
import expenseManager.domain.exp.Expense;
import expenseManager.domain.exp.RecurrentExpense;
import expenseManager.domain.inc.Income;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


public class UserTest {

    @Test
    void shouldCreateAValidUser() {
        User user = new User("US-01", "Test", "Tesssst", "stydbdj@gmail.com", LocalDate.of(2003, 2, 12));

        assertEquals(0, user.getExpenses().size());
        assertEquals(0, user.getIncomes().size());
    }

    @Test
    void addIncomeShouldAddIncome() {
        User user = new User("US-01", "Test", "Tesssst", "stydbdj@gmail.com", LocalDate.of(2003, 2, 12));

        Income income = new Income(2000, true, LocalDate.of(2026, 2, 12));
        user.addIncome(income);

        assertEquals(1, user.getIncomes().size());
        assertEquals(income, user.getIncomes().getFirst());
    }

    @Test
    void addExpenseShouldAddExpense() {
        User user = new User("US-01", "Test", "Tesssst", "stydbdj@gmail.com", LocalDate.of(2003, 2, 12));

        Expense exp = new DynamicExpense(500, "play", LocalDate.now(), DynamicExpenseType.SHOPPING);
        user.addExpense(exp);

        assertEquals(1, user.getExpenses().size());
        assertEquals(exp, user.getExpenses().getFirst());
    }

    @Test
    void getExpensesShouldReturnExpenses() {
        User user = new User("US-01", "Test", "Tesssst", "stydbdj@gmail.com", LocalDate.of(2003, 2, 12));

        Expense exp = new DynamicExpense(500, "play", LocalDate.now(), DynamicExpenseType.SHOPPING);
        Expense exp2 = new RecurrentExpense(500, "rent", LocalDate.of(2026, 3, 1), ExpenseRecurrentType.RENT, PaymentFrequency.MONTHLY);

        user.addExpense(exp);
        user.addExpense(exp2);

        assertEquals(2, user.getExpenses().size());
    }

    @Test
    void calculateTotalExpenseShouldCalculate() {
        User user = new User("US-01", "Test", "Tesssst", "stydbdj@gmail.com", LocalDate.of(2003, 2, 12));

        Expense exp = new DynamicExpense(500, "play", LocalDate.now(), DynamicExpenseType.SHOPPING);
        Expense exp2 = new RecurrentExpense(500, "rent", LocalDate.of(2026, 3, 1), ExpenseRecurrentType.RENT, PaymentFrequency.MONTHLY);
        user.addExpense(exp);
        user.addExpense(exp2);

        assertEquals(1000, user.calculateTotalExpense(user.getExpenses()));
    }

    @Test
    void calculateTotalIncomeShouldCalculate() {
        User user = new User("US-01", "Test", "Tesssst", "stydbdj@gmail.com", LocalDate.of(2003, 2, 12));

        Income inc = new Income(2000, true, LocalDate.of(2026, 2, 12));
        Income inc2 = new Income(2000, true, LocalDate.of(2026, 2, 15));
        user.addIncome(inc);
        user.addIncome(inc2);

        assertEquals(4000, user.calculateTotalIncome(user.getIncomes()));
    }
}
