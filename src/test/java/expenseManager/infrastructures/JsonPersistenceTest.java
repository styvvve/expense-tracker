package expenseManager.infrastructures;

import expenseManager.domain.enu.DynamicExpenseType;
import expenseManager.domain.enu.ExpenseRecurrentType;
import expenseManager.domain.enu.PaymentFrequency;
import expenseManager.domain.exp.DynamicExpense;
import expenseManager.domain.exp.Expense;
import expenseManager.domain.exp.RecurrentExpense;
import expenseManager.domain.interfaces.UserRepository;
import expenseManager.domain.user.User;
import expenseManager.infrastructures.repos.JsonUserRepository;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonPersistenceTest {

    @Test
    public void saveDataToFile() throws IOException {
        User user = new User("US-01", "Test", "Tesssst", "stydbdj@gmail.com", LocalDate.of(2003, 2, 12));

        Expense exp = new DynamicExpense("EEE", 500, "play", LocalDate.now(), DynamicExpenseType.SHOPPING);
        Expense exp2 = new RecurrentExpense("AAA", 500, "rent", LocalDate.of(2026, 2, 1), ExpenseRecurrentType.RENT, PaymentFrequency.MONTHLY);

        user.addExpense(exp);
        user.addExpense(exp2);

        Path file = Path.of("data/user.json");

        UserRepository repo = new JsonUserRepository(file);

        repo.save(user);

        assertTrue(Files.exists(file));
        Files.deleteIfExists(file);
    }
}
