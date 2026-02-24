package expenseManager.domain;

import Errors.InvalidAmountException;
import expenseManager.domain.enu.*;
import expenseManager.domain.exp.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//execute before or after code
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.time.LocalDateTime;

public class ExpenseTest {

    @Test
    void shouldCreateExpenseWithCorrectAmount() {
        assertThrows(InvalidAmountException.class, () -> new DynamicExpense("SS", -100, "test", LocalDateTime.of(2026, 2, 24, 1, 48), DynamicExpenseType.FUEL));
        assertThrows(InvalidAmountException.class, () -> new RecurrentExpense("SS", -100, "test", LocalDateTime.of(2026, 2, 24, 1, 48), ExpenseRecurrentType.ALIMONY, PaymentFrequency.MONTHLY));
    }
}
