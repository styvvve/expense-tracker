package expenseManager.domain.inc;

import Errors.InvalidAmountException;
import expenseManager.domain.enu.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//execute before or after code

import java.time.LocalDate;


public class IncomeTest {

    @Test
    void shouldCreateIncomeWithCorrectAmount() {
        Income inc = new Income("GGG", 1600, true, LocalDate.now());

        assertThrows(InvalidAmountException.class, () -> new Income("TTT", -100, false, LocalDate.of(2026, 2, 26)));

        assertEquals(1600, inc.getAmount());
    }
}
