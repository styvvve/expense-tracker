package expenseManager.domain.inc;

import expenseManager.domain.Main;
import expenseManager.domain.user.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

public class IncomeServiceTest {

    @Test
    public void getRecurrentIncomesShouldReturnRecurrentIncomes() {
        User user = new User("US-01", "Test", "Tesssst", "stydbdj@gmail.com", LocalDate.of(2003, 2, 12));

        Income inc1 = new Income(2000, true, LocalDate.of(2003, 2, 12));
        Income inc2 = new Income(2000, false, LocalDate.of(2003, 2, 12));
        Income inc3 = new Income(2000, true, LocalDate.of(2003, 2, 12));

        user.addIncome(inc1);
        user.addIncome(inc2);
        user.addIncome(inc3);

        IncomeService svr = new IncomeService(user);

        List<Income> recIncomes = svr.getRecurrentIncomes();
        List<Income> notRecIncomes = svr.getNotRecurrentIncomes();

        assertEquals(2, recIncomes.size());
        assertEquals(1, notRecIncomes.size());
    }

    @Test
    public void getIncomesPerDayShouldReturnIncomesPerDay() {
        User user = new User("US-01", "Test", "Tesssst", "stydbdj@gmail.com", LocalDate.of(2003, 2, 12));

        Income inc1 = new Income(2000, true, LocalDate.of(2003, 2, 12));

        user.addIncome(inc1);

        IncomeService svr = new IncomeService(user);

        assertEquals(1, svr.incomesPerDay(LocalDate.of(2003, 2, 12)).size());
    }

    @Test
    public void ensureRecurrentIncomesShouldCreateNextIncomes() {
        User user = new User("US-01", "Test", "Tesssst", "stydbdj@gmail.com", LocalDate.of(2003, 2, 12));

        Income inc1 = new Income(2000, true, LocalDate.now());
        Income inc2 = new Income(2000, false, LocalDate.of(2003, 3, 12));

        user.addIncome(inc1);
        user.addIncome(inc2);
        IncomeService svr = new IncomeService(user);

        svr.ensureRecurringIncomesPresence();

        assertEquals(3, user.getIncomes().size());
        assertEquals(2, svr.getRecurrentIncomes().size());
        assertTrue(user.getIncomes().getLast().getDate().isEqual(LocalDate.now().plusMonths(1)));
        assertEquals(user.getIncomes().getLast(), inc1);
    }

    @Test
    public void weGetAllTheNextIncomes() {
        User user = new User("US-01", "Test", "Tesssst", "stydbdj@gmail.com", LocalDate.of(2003, 2, 12));

        Income inc1 = new Income(2000, true, LocalDate.now());

        user.addIncome(inc1);

        IncomeService svr = new IncomeService(user);

        svr.ensureRecurringIncomesPresence();

        assertEquals(2, user.getIncomes().size());
        Map<LocalDate, List<Income>> nextIncomes;
        nextIncomes = svr.getNextIncomes(40);
        assertEquals(1, nextIncomes.size());
        assertEquals(inc1, nextIncomes.get(LocalDate.now().plusMonths(1)).getFirst());
    }
}
