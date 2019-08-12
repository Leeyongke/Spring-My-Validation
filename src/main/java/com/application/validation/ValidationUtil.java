package com.application.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

public abstract class ValidationUtil {

    public static void validationNotEmptyForObject(Object o) throws ValidationException {
        Field[] fields = o.getClass().getDeclaredFields();
        if (!ObjectUtils.isEmpty(fields)) {
            for (Field f : fields) {
                if (f.isAnnotationPresent(NotEmpty.class)) {
                    NotEmpty notEmpty = f.getAnnotation(NotEmpty.class);
                    f.setAccessible(true);
                    Object value = ReflectionUtils.getField(f, o);
                    if (value == null || StringUtils.isEmpty(value.toString())) {
                        throw new ValidationException(String.format(notEmpty.message(), f.getName()));
                    }
                }
            }
        }
    }


}
