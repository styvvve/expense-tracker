package expenseManager.domain.interfaces;

import expenseManager.domain.user.User;

import java.util.Optional;

/**
 * Use this for the MVP -> user is aggregate
 * <p>
 *     We use an aggregate logic to save and load all the context through User class
 *     We get all expenses and incomes through User class and IncomeService and ExpenseService will implement this.
 * </p>
 * @author Steve
 * @version 1.0
 */

public interface UserRepository {
    void save(User user);

    User load();
}
