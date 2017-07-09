package project.service.model;

public enum CheckPinStatus {

    OK("ok"),
    WRONG_PIN("wrongPin"),
    CARD_LOCKED("cardLocked");

    private final String value;

    CheckPinStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
