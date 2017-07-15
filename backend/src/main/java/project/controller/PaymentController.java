package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
import java.util.HashMap;
import java.util.Map;

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
    @ResponseBody
    public Map<String, Object> getBalance() {
        final Map<String, Object> response = new HashMap<>();
        final String card = authSessionBean.getAuthorizedCard();
        try {
            Balance balance = new Balance("1111-3333", System.currentTimeMillis(), BigDecimal.TEN);//paymentService.getBalance(card);TODO
            BalanceModel balanceModel = conversionService.convert(balance, BalanceModel.class);
            response.put(BALANCE_KEY, balanceModel);
        } catch (CardNotFoundException ex) {
            response.put(ERROR_KEY, CARD_NOT_FOUND);
        }

        return response;
    }

    //TODO: REWRITE TO BINDERS

    @RequestMapping(value = "getCash", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getCash(@RequestParam(AMOUNT_KEY) String amountParam) {
        final Map<String, Object> response = new HashMap<>();
        final String card = authSessionBean.getAuthorizedCard();
        final BigDecimal amount = new BigDecimal(amountParam);
        try {
            WithdrawalResult withdrawalResult = paymentService.getCash(card, amount);
            WithdrawalResultModel result = conversionService.convert(withdrawalResult, WithdrawalResultModel.class);
            response.put(WITHDRAWAL_RESULT_KEY, result);
        } catch (CardNotFoundException ex) {
            response.put(ERROR_KEY, CARD_NOT_FOUND);
        } catch (MoneyOperationException ex) {
            response.put(ERROR_KEY, MONEY_OPERATION_FAILURE);
        }

        return response;
    }
}
