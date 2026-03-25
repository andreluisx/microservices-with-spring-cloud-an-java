package com.rest_with_spring.rest_with_spring.request.converters;

import com.rest_with_spring.rest_with_spring.exceptions.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;

@Service()
public class NumberConverter {
    public boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.trim().isEmpty()) throw new UnsupportedMathOperationException("digite numeros");

        String number = strNumber.replace(",", ".");

        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
