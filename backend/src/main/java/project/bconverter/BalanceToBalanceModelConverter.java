package project.bconverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import project.service.model.Balance;
import project.service.CustomConversionService;
import project.viewmodel.BalanceModel;
import project.viewmodel.Currency;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static project.constants.DateFormats.COMMON_FORMAT;

@Service
public class BalanceToBalanceModelConverter implements Converter<Balance, BalanceModel> {

    private final CustomConversionService conversionService;

    @Autowired
    public BalanceToBalanceModelConverter(CustomConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public BalanceModel convert(Balance source) {
        BalanceModel target = new BalanceModel();
        target.setCardNumber(source.getCardNumber());
        target.setAmount(conversionService.convert(source.getAmount(), Currency.class));

        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(source.getDate()),
                ZoneId.systemDefault());
        DateTimeFormatter format = DateTimeFormatter.ofPattern(COMMON_FORMAT);
        String dateString = zonedDateTime.format(format);

        target.setDate(dateString);

        return target;
    }
}
