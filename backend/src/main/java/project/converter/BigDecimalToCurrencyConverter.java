package project.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import project.model.Currency;

import java.math.BigDecimal;

@Service
public class BigDecimalToCurrencyConverter implements Converter<BigDecimal, Currency> {

    @Override
    public Currency convert(BigDecimal source) {
        BigDecimal integer = source.setScale(0, BigDecimal.ROUND_DOWN);
        BigDecimal fractional = source
                .abs()
                .remainder(BigDecimal.ONE);

        String fractionalPrefix = fractional.intValue() < 10 ? "0" : "";

        return new Currency(integer.toString(), fractionalPrefix + fractional.toString());
    }
}
