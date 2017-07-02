package project.service;

import java.util.Collection;
import java.util.List;

public interface CustomConversionService {

    <T> T convert(Object source, Class<T> targetClass);

    <S, T> List<T> convert(Collection<S> source, Class<T> targetClass);
}
