package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import project.service.CustomConversionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class ConversionServiceImpl implements CustomConversionService {

    private final ConversionService conversionService;

    @Autowired
    public ConversionServiceImpl(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public <T> T convert(Object source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }
        return conversionService.convert(source, targetClass);
    }

    @Override
    public <S, T> List<T> convert(Collection<S> source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }
        if (source.isEmpty()) {
            return Collections.emptyList();
        }
        List<T> result = new ArrayList<>(source.size());
        for (S elem: source) {
            result.add(conversionService.convert(elem, targetClass));
        }

        return result;
    }
}
