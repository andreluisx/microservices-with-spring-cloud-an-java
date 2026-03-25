package com.rest_with_spring.rest_with_spring.request.converters;

import org.springframework.stereotype.Service;

@Service()
public class DoubleConvert {
    public Double convertToDouble(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) throw new IllegalArgumentException();
        String number = strNumber.replace(",", ".");

        return Double.parseDouble(number);
    }
}
