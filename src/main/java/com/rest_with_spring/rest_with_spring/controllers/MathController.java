package com.rest_with_spring.rest_with_spring.controllers;

import com.rest_with_spring.rest_with_spring.exceptions.ImpossibleDivisionby0Exception;
import com.rest_with_spring.rest_with_spring.exceptions.UnsupportedMathOperationException;
import com.rest_with_spring.rest_with_spring.request.converters.DoubleConvert;
import com.rest_with_spring.rest_with_spring.request.converters.NumberConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired
    private NumberConverter numberConverter;
    @Autowired
    private DoubleConvert doubleConvert;

    @RequestMapping("/sum/{number1}/{number2}")
    public Double sum(
            @PathVariable(name = "number1")
            String number1,
            @PathVariable(name = "number2")
            String number2) throws IllegalArgumentException{
        if(!numberConverter.isNumeric(number1) || !numberConverter.isNumeric(number2)) throw new UnsupportedMathOperationException("digite numeros");
        return doubleConvert.convertToDouble(number1) + doubleConvert.convertToDouble(number2);
    }

@RequestMapping("/div/{numero1}/{numero2}")
    public Double divisao(
            @PathVariable(name = "numero1")
            String numero1,
            @PathVariable(name = "numero2")
            String numero2
    ){
        if(!numberConverter.isNumeric(numero1) || !numberConverter.isNumeric(numero2)) throw new UnsupportedMathOperationException("digite numeros");
        Double num1 = doubleConvert.convertToDouble(numero1);
        Double num2 = doubleConvert.convertToDouble(numero2);
        if(num2 == 0) throw new ImpossibleDivisionby0Exception("Divisao por 0");

        return num1 / num2;
    }




}
