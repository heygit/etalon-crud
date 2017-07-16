package project.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import project.model.BalanceModel;
import project.model.Currency;
import project.service.CustomConversionService;
import project.service.model.Balance;
import project.utils.Formatter;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static project.constants.DateFormats.COMMON_FORMAT;

@Service
public class BalanceToBalanceModelConverter implements Converter<Balance, BalanceModel> {

    @Autowired
    private CustomConversionService conversionService;

    @Override
    public BalanceModel convert(Balance source) {
        BalanceModel target = new BalanceModel();
        target.setCardNumber(Formatter.CARD_NUMBER.format(source.getCardNumber()));
        target.setAmount(conversionService.convert(source.getAmount(), Currency.class));

        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(source.getDate()),
                ZoneId.systemDefault());
        DateTimeFormatter format = DateTimeFormatter.ofPattern(COMMON_FORMAT);
        String dateString = zonedDateTime.format(format);

        target.setDate(dateString);

        return target;
    }
}
