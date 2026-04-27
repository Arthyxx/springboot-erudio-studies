package spring_boot_and_java_erudio.service;

import org.springframework.stereotype.Service;
import spring_boot_and_java_erudio.exceptions.UnsupportedMathOperationException;

@Service
public class MathService {

    public Double somar(String num1, String num2) {
        if (!isNumeric(num1) || !isNumeric(num2)) throw new UnsupportedMathOperationException("Please set a numeric value.");

        return convertDouble(num1) + convertDouble(num2);
    }

    public Double subtrair(String num1, String num2){
        if (!isNumeric(num1) || !isNumeric(num2)) throw new UnsupportedMathOperationException("Please set a number value.");

        return convertDouble(num1) - convertDouble(num2);
    }

    public Double multiplicar(String num1, String num2){
        if (!isNumeric(num1) || !isNumeric(num2)) throw new UnsupportedMathOperationException("Please set a number value");

        return convertDouble(num1) * convertDouble(num2);
    }

    public Double dividir(String num1, String num2){
        if (!isNumeric(num1) || !isNumeric(num2)) throw new UnsupportedMathOperationException("Please set a number value");

        Double n2 = convertDouble(num2);
        if (n2 == 0) throw new UnsupportedMathOperationException("The second number can't be zero!");

        return convertDouble(num1) / n2;
    }

    public Double media(String num1, String num2, String num3){
        if (!isNumeric(num1) || !isNumeric(num2) || !isNumeric(num3)) throw new UnsupportedMathOperationException("Please set a number value.");

        return (convertDouble(num1) + convertDouble(num2) + convertDouble(num3)) / 3;
    }

    public Double raiz(String num1){
        if (!isNumeric(num1)) throw new UnsupportedMathOperationException("Please set a number value");

        return Math.sqrt(convertDouble(num1));
    }

    public boolean isNumeric(String strNumber){
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");

        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    }

    public Double convertDouble(String strNumber) throws UnsupportedMathOperationException {
        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value.");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }
}
