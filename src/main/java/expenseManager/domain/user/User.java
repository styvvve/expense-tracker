package expenseManager.domain.user;

import expenseManager.domain.exp.Expense;
import expenseManager.domain.inc.Income;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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

public class User {

    private String name;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;

    private ArrayList<Expense> expenses;
    private ArrayList<Income> incomes;

    public User(String name, String lastName, String email, LocalDate dateOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.expenses = new ArrayList<>();
        this.incomes = new ArrayList<>();
    }

    //GETTERS
    public String getName() { return this.name; }
    public String getLastName() { return this.lastName; }
    public String getEmail() { return this.email; }
    public LocalDate getDateOfBirth() { return this.dateOfBirth; }
    public ArrayList<Expense> getExpenses() { return this.expenses; }
    public ArrayList<Income> getIncomes() { return this.incomes; }

    //SETTERS
    public void setName(String name) { this.name = name; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }

    //LOGIQUE MÉTIER

    //Expense ->
    public void addExpense(Expense expense) { this.expenses.add(expense); }
    public double calculateTotalExpense() {
        return expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    //AMELIORER -> CALCULER EXPENSE PAR MOIS

    //Income ->
    public void addIncome(Income income) { this.incomes.add(income); }
    public double calculateTotalIncome() {
        return incomes.stream()
                .mapToDouble(Income::getAmount)
                .sum();
    }

    //

}
