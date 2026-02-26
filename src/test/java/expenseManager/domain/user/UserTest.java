package expenseManager.domain.user;

import Errors.InvalidAmountException;
import expenseManager.domain.enu.*;
import expenseManager.domain.exp.DynamicExpense;
import expenseManager.domain.exp.Expense;
import expenseManager.domain.inc.Income;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


public class UserTest {

    @Test
    void shouldCreateAValidUser() {
        User user = new User("Test", "Tesssst", "stydbdj@gmail.com", LocalDate.of(2003, 2, 12));

        assertEquals(0, user.getExpenses().size());
        assertEquals(0, user.getIncomes().size());
    }

    @Test
    void addIncomeShouldAddIncome() {
        User user = new User("Test", "Tesssst", "stydbdj@gmail.com", LocalDate.of(2003, 2, 12));

        Income income = new Income("AAA", 2000, true, LocalDate.of(2026, 2, 12));
        user.addIncome(income);

        assertEquals(1, user.getIncomes().size());
        assertEquals(income, user.getIncomes().getFirst());
    }

    @Test
    void addExpenseShouldAddExpense() {
        User user = new User("Test", "Tesssst", "stydbdj@gmail.com", LocalDate.of(2003, 2, 12));

        Expense exp = new DynamicExpense("EEE", 500, "play", LocalDateTime.now(), DynamicExpenseType.SHOPPING);
        user.addExpense(exp);

        assertEquals(1, user.getExpenses().size());
        assertEquals(exp, user.getExpenses().getFirst());
    }
}
