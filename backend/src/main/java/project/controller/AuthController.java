package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import project.service.AuthService;
import project.service.model.CardStatus;
import project.service.model.CheckPinStatus;
import project.service.AuthSessionBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Collections;
import java.util.Map;

import static project.constants.ParamNames.*;

@Controller
@RequestMapping("/api/v1/authManagement")
public class AuthController {

    private final AuthService authService;
    private final AuthSessionBean authSessionBean;

    @Autowired
    public AuthController(AuthService authService, AuthSessionBean authSessionBean) {
        this.authService = authService;
        this.authSessionBean = authSessionBean;
    }

    @RequestMapping(value = "checkCard", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> checkCard(@RequestParam(CARD_NUMBER_KEY) String cardNumber, HttpServletRequest request) {
        CardStatus cardStatus = authService.checkCard(cardNumber);
        if (cardStatus == CardStatus.OK) {
            invalidateSession(request);
            request.getSession(true);
            authSessionBean.setCardNumber(cardNumber);
        }
        authSessionBean.setAuthorized(false);
        return Collections.singletonMap(STATUS_KEY, cardStatus.toString());
    }

    @RequestMapping(value = "checkPin", method = RequestMethod.POST)
    public void checkPin(@RequestParam(PIN_KEY) String pin, Model model, HttpServletRequest request) {
        final String cardNumber = authSessionBean.getCardNumber();
        CheckPinStatus checkPinStatus = authService.checkPin(cardNumber, pin);
        if (checkPinStatus == CheckPinStatus.OK) {
            authSessionBean.setAuthorized(true);
        }

        model.addAttribute(STATUS_KEY, checkPinStatus.toString());
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public void logout(HttpServletRequest request) {
        invalidateSession(request);
    }

    private void invalidateSession(HttpServletRequest request) {
        HttpSession oldSession = request.getSession(false);
        if (oldSession != null) {
            oldSession.invalidate();
        }
    }
}
