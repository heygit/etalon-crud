package project.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import project.model.Currency;
import project.model.WithdrawalResultModel;
import project.service.CustomConversionService;
import project.service.model.WithdrawalResult;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static project.constants.DateFormats.COMMON_FORMAT;

@Component
public class WithdrawalResultToWithdrawalResultModelConverter implements
        Converter<WithdrawalResult, WithdrawalResultModel> {

    @Autowired
    private CustomConversionService conversionService;

    @Override
    public WithdrawalResultModel convert(WithdrawalResult source) {
        WithdrawalResultModel target = new WithdrawalResultModel();
        target.setCardNumber(source.getCardNumber());
        target.setAmount(conversionService.convert(source.getAmount(), Currency.class));
        target.setBalance(conversionService.convert(source.getBalance(), Currency.class));

        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(source.getDate()),
                ZoneId.systemDefault());
        DateTimeFormatter format = DateTimeFormatter.ofPattern(COMMON_FORMAT);
        String dateString = zonedDateTime.format(format);

        target.setDate(dateString);

        return target;
    }

}
