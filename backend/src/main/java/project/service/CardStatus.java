package project.service;

public enum CardStatus {

    OK("ok"),
    LOCKED("locked"),
    NOT_FOUND("notFound");

    private final String value;

    CardStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
