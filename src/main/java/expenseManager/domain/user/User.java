package expenseManager.domain.user;

import java.time.LocalDate;

public class User {

    private String name;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;

    public User(String name, String lastName, String email, LocalDate dateOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() { return this.name; }
    public String getLastName() { return this.lastName; }
    public String getEmail() { return this.email; }
    public LocalDate getDateOfBirth() { return this.dateOfBirth; }
}
