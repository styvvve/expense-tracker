package expenseManager.domain.enu;

public enum DynamicExpenseType implements Categorizable{
    GROCERIES("Groceries"),
    RESTAURANT_CAFE("Restaurant/cafe"),
    SHOPPING("Shopping"),
    FUEL("Fuel"),
    PARKING_TOLL("Parking/toll"),
    TAXI_VTC("Taxi/VTC"),
    ENTERTAINMENT("Entertainment"),
    HEALTH("Health"),
    GIFT("Gift"),
    MAINTENANCE("Maintenance"),
    MISCELLANEOUS("Miscellaneous");

    private final String label;
    DynamicExpenseType(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return this.label;
    }
}
