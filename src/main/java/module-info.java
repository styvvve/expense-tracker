module expense.tracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;

    // Autorise JavaFX à accéder à tes contrôleurs pour le FXML
    opens expenseManager.controller to javafx.fxml;

    // Autorise Jackson à accéder à ton Domain (User, Expense) pour la sérialisation
    opens expenseManager.domain.user to com.fasterxml.jackson.databind;
    opens expenseManager.domain.exp to com.fasterxml.jackson.databind;
    opens expenseManager.domain.inc to com.fasterxml.jackson.databind;
    opens expenseManager.domain.enu to com.fasterxml.jackson.databind;

    opens expenseManager.infrastructures.persistence to com.fasterxml.jackson.databind;

    exports expenseManager;
}