package expenseManager.domain.inc;

import Errors.InvalidAmountException;
import expenseManager.domain.enu.*;
import expenseManager.domain.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//execute before or after code

import java.time.LocalDate;


public class IncomeTest {

    @Test
    public void shouldCreateIncomeWithCorrectAmount() {
        Income inc = new Income(1600, true, LocalDate.now());

        assertThrows(InvalidAmountException.class, () -> new Income(-100, false, LocalDate.of(2026, 2, 26)));

        assertEquals(1600, inc.getAmount());
    }

    @Test
    public void unicityOfIncomes() {
        User user = new User("US-01", "Test", "Tesssst", "stydbdj@gmail.com", LocalDate.of(2003, 2, 12));

        Income inc1 = new Income(2000, true, LocalDate.of(2003, 2, 12));
        Income inc2 = new Income(2000, true, LocalDate.of(2003, 2, 12));
        Income inc3 = new Income(2000, true, LocalDate.of(2003, 2, 12));
        Income inc4 = new Income(inc3);

        assertEquals(inc1, inc2);
        assertNotEquals(inc1, inc3);
        assertEquals(inc3, inc4);
    }

    @Test
    public void shouldCreateNextIncomeWithCopyConstructor() {
        Income inc = new Income(1600, true, LocalDate.now());
        Income inc2 = new Income(inc, true);

        assertEquals(inc, inc2);
        assertTrue(inc2.getDate().isEqual(inc.getDate().plusMonths(1)));
    }

    //we ll test if two incomes are the same
    @Test
    public void givenTwoRecurringIncomes_whenComparing_thenResultIsTrue() {
        Income inc1 = new Income(1600, true, LocalDate.of(2026, 3, 6));
        Income inc2 = new Income(1600, true, LocalDate.of(2026, 4, 6));
        Income inc3 = new Income(1600, true, LocalDate.of(2026, 4, 6));


        assertTrue(inc1.hasSameRecurringStatus(inc2));
        assertNotEquals(inc1, inc2);
        assertEquals(inc1, inc3);
    }
}
