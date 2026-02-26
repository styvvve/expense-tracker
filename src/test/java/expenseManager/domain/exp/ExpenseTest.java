package expenseManager.domain.exp;

import Errors.InvalidAmountException;
import expenseManager.domain.enu.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//execute before or after code

import java.time.LocalDateTime;

public class ExpenseTest {

    @Test
    void shouldCreateExpenseWithCorrectAmount() {
        assertThrows(InvalidAmountException.class, () -> new DynamicExpense("SS", -100, "test", LocalDateTime.of(2026, 2, 24, 1, 48), DynamicExpenseType.FUEL));
        assertThrows(InvalidAmountException.class, () -> new RecurrentExpense("SS", -100, "test", LocalDateTime.of(2026, 2, 24, 1, 48), ExpenseRecurrentType.ALIMONY, PaymentFrequency.MONTHLY));
    }
}
