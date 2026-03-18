package expenseManager.domain.interfaces;

import expenseManager.domain.exp.Expense;
import expenseManager.domain.inc.Income;

import java.util.List;

/**
 * Persistence interface for the management of data
 * <p>
 *     Defines storage operations, recovery and removal of financial data from the user. This interface is a part
 *     of the Domain couch et must be implemented by the infrastructures couch.
 * </p>
 *
 * @author Steve NGUELE
 * @version 1.0
 * @see Expense
 * @see Income
 */

public interface ExpenseTrackerRepository<T> {
    void saveAll(List<T> obj);
    List<T> loadAll();
}
