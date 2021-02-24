package com.ebi.person.common;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Date;

/**
 * Custom date to long converter for JPA.
 */
@Converter
public class CustomDateConverter implements AttributeConverter<Long, Date> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Date convertToDatabaseColumn(Long time) {

        Date value = null;
        if (time != null) {
            value = new Date(time);
        }

        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long convertToEntityAttribute(Date date) {

        Long value = null;
        if (date != null) {
            value = date.getTime();
        }

        return value;
    }
}
