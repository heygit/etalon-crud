package project.service;

public interface AuthService {

    /**
     * Check if user can authorize with specified card
     *
     * @param cardNumber
     * @return
     */
    CardStatus checkCard(String cardNumber);

    /**
     * Check if specified pin matches specified card
     *
     * @param cardNumber
     * @return
     */
    boolean checkPin(String cardNumber, String pin);
}
