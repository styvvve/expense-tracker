package expenseManager.domain.exp;

import Errors.InvalidAmountException;
import expenseManager.domain.enu.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//execute before or after code

import java.time.LocalDate;

public class ExpenseTest {

    @Test
    void shouldCreateExpenseWithCorrectAmount() {
        assertThrows(InvalidAmountException.class, () -> new DynamicExpense("SS", -100, "test", LocalDate.of(2026, 2, 24), DynamicExpenseType.FUEL));
        assertThrows(InvalidAmountException.class, () -> new RecurrentExpense("SS", -100, "test", LocalDate.of(2026, 2, 24), ExpenseRecurrentType.ALIMONY, PaymentFrequency.MONTHLY));
    }
}
