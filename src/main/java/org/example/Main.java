package org.example;

import expenseManager.domain.enu.DynamicExpenseType;
import expenseManager.domain.exp.DynamicExpense;

public class Main {
    public static void main(String[] args) {
        System.out.println(DynamicExpenseType.ENTERTAINMENT.getLabel());
    }
}