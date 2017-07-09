package project.service;

import project.service.model.CardStatus;
import project.service.model.CheckPinStatus;

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
    CheckPinStatus checkPin(String cardNumber, String pin);
}
