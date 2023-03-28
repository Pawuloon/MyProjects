package zad1;

import java.math.*;
import java.util.*;
import java.util.function.*;

public class Calc
{

    public String doCalc(String cmd)
    {
        BigDecimal last;
        Map<String, BinaryOperator<BigDecimal>> operatorMap = new HashMap<>();
        operatorMap.put("+", BigDecimal::add);
        operatorMap.put("-", BigDecimal::subtract);
        operatorMap.put("/", BigDecimal::divide);
        operatorMap.put("*",BigDecimal::multiply);

        String[]split = cmd.split(" ");
        try
        {
            String operator = split[1];
            BigDecimal number = new BigDecimal(split[0]);
            BigDecimal number2 = new BigDecimal(split[2]);
            last = operatorMap.get(operator).apply(number,number2);
        }
        catch (Exception exception)
        {
            return "Invalid command to calc";
        }
       return last.stripTrailingZeros().toString();
    }
}
