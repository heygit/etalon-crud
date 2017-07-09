package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import project.exception.CardNotFoundException;
import project.exception.MoneyOperationException;
import project.model.BalanceModel;
import project.model.WithdrawalResultModel;
import project.service.AuthSessionBean;
import project.service.CustomConversionService;
import project.service.PaymentService;
import project.service.model.Balance;
import project.service.model.WithdrawalResult;

import java.math.BigDecimal;

import static project.constants.ErrorCodes.CARD_NOT_FOUND;
import static project.constants.ErrorCodes.MONEY_OPERATION_FAILURE;
import static project.constants.ParamNames.*;

@Controller
@RequestMapping("/api/v1/paymentManagement")
public class PaymentController {

    private final PaymentService paymentService;
    private final AuthSessionBean authSessionBean;
    private final CustomConversionService conversionService;

    @Autowired
    public PaymentController(PaymentService paymentService, AuthSessionBean authSessionBean,
                             CustomConversionService conversionService) {
        this.paymentService = paymentService;
        this.authSessionBean = authSessionBean;
        this.conversionService = conversionService;
    }

    @RequestMapping(value = "getBalance", method = RequestMethod.POST)
    public void getBalance(Model model) {
        final String card = authSessionBean.getAuthorizedCard();
        try {
            Balance balance = paymentService.getBalance(card);
            BalanceModel result = conversionService.convert(balance, BalanceModel.class);
            model.addAttribute(BALANCE_KEY, result);
        } catch (CardNotFoundException ex) {
            model.addAttribute(ERROR_KEY, CARD_NOT_FOUND);
        }
    }

    //TODO: REWRITE TO BINDERS

    @RequestMapping(value = "getCash", method = RequestMethod.POST)
    public void getCash(@RequestParam(AMOUNT_KEY) String amountParam, Model model) {
        final String card = authSessionBean.getAuthorizedCard();
        final BigDecimal amount = new BigDecimal(amountParam);
        try {
            WithdrawalResult withdrawalResult = paymentService.getCash(card, amount);
            WithdrawalResultModel result = conversionService.convert(withdrawalResult, WithdrawalResultModel.class);
            model.addAttribute(WITHDRAWAL_RESULT_KEY, result);
        } catch (CardNotFoundException ex) {
            model.addAttribute(ERROR_KEY, CARD_NOT_FOUND);
        } catch (MoneyOperationException ex) {
            model.addAttribute(ERROR_KEY, MONEY_OPERATION_FAILURE);
        }
    }
}
