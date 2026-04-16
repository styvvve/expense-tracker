package expenseManager.domain.user;

import expenseManager.domain.exp.Expense;
import expenseManager.domain.inc.Income;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * Represents the user of the app.
 *
 * Collect normal user data (name, lastName...) and manages the expenses and incomes of a user and provides summary calculations
 *
 * @see Income
 * @see Expense
 * @author Steve
 * @version 1.0
 * @since 1.0
 */

public class User implements Serializable {

    private String id;
    private String name;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;

    private List<Expense> allExpenses = new ArrayList<>();
    private List<Income> allIncomes =  new ArrayList<>();

    public User(String id, String name, String lastName, String email, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public User() {}

    //GETTERS
    public String getId() { return this.id; }
    public String getName() { return this.name; }
    public String getLastName() { return this.lastName; }
    public String getEmail() { return this.email; }
    public LocalDate getDateOfBirth() { return this.dateOfBirth; }
    public List<Expense> getExpenses() { return this.allExpenses; }
    public List<Income> getIncomes() { return this.allIncomes; }

    //SETTERS
    public void setName(String name) { this.name = name; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }

    //LOGIQUE MÉTIER

    //Expense ->
    public void addExpense(Expense expense) { this.allExpenses.add(expense); }

    public double calculateTotalExpense(List<Expense> exp) {
        return exp.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    //Income ->
    public void addIncome(Income income) { this.allIncomes.add(income); }

    public double calculateTotalIncome(List<Income> incomes) {
        return incomes.stream()
                .mapToDouble(Income::getAmount)
                .sum();
    }

}
