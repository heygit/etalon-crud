package project.utils;


public enum OperationType {

    SHOW_BALANCE("showBalance"),
    GET_CASH("getCash");

    private final String value;

    OperationType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
