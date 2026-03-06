package expenseManager.domain.inc;

import expenseManager.domain.user.User;
import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.util.*;

/**
 * Regroup all the complex operations about incomes
 * the same with expenseService class
 * @see Income
 * @author Steve
 * @version 1.0
 */
public class IncomeService {

    User user;

    public IncomeService(User user) { this.user = user; }

    //all the filters

    //recurring and not recurring
    public List<Income> getRecurrentIncomes() {
        return user.getIncomes().stream()
                .filter(Income::isRecurring)
                .collect(toList());
    }

    public List<Income> getNotRecurrentIncomes() {
        return user.getIncomes().stream()
                .filter(i -> !i.isRecurring())
                .collect(toList());
    }

    //recurrent incomes must be present each month at the same date
    public void ensureRecurringIncomesPresence() {
        LocalDate currentDate = LocalDate.now();
        ArrayList<Income> thisMonthlyIncomes = new ArrayList<>();

        for (Income inc : this.getRecurrentIncomes()) {
            if (inc.getDate().getMonthValue() == currentDate.getMonthValue()) {
                thisMonthlyIncomes.add(inc);
            }
        }

        thisMonthlyIncomes
                .forEach(inc -> user.addIncome(new Income(inc, true)));
    }

    //get incomes for one day
    public List<Income> incomesPerDay(LocalDate date) {
        return user.getIncomes().stream()
                .filter(i -> i.getDate().isEqual(date))
                .collect(toList());
    }

    public List<Income> incomesPerMonth(LocalDate date) {
        return user.getIncomes().stream()
                .filter(i -> i.getDate().getMonthValue() == date.getMonthValue())
                .collect(toList());
    }

    //filter incomes that come in the next 7 days
    public Map<LocalDate, List<Income>> getNextIncomes(int nbDays) {
        LocalDate currentDate = LocalDate.now();
        TreeMap<LocalDate, List<Income>> nextIncomes = new TreeMap<>();
        for (int i = 1; i < nbDays; i++) {
            LocalDate nextDate = currentDate.plusDays(i);
            if (!incomesPerDay(nextDate).isEmpty()) nextIncomes.put(nextDate, incomesPerDay(nextDate));
        }
        return nextIncomes;
    }

}
