package src.calculator;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Calculator {

    public Calculator() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Eingabe: ");
        String input = scanner.nextLine();
        Calculator calculator = new Calculator();
        try {
            String result = calculator.eval(input);
            System.out.println("Ausgabe: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid equation");
        }
        scanner.close();
    }

    public String eval(String userinput) throws Exception {
        userinput = userinput.replaceAll("\\s+", "");
        userinput = userinput.replace("--", "+"); 

        Pattern pattern = Pattern.compile("(-?\\d+(?:\\.\\d+)?)([+\\-*/])(-?\\d+(?:\\.\\d+)?)");
        Matcher matcher = pattern.matcher(userinput);

        if (matcher.matches()) {
            double operand1 = Double.parseDouble(matcher.group(1));
            String operator = matcher.group(2);
            double operand2 = Double.parseDouble(matcher.group(3));

            switch (operator) {
                case "+":
                    return String.valueOf(addition(operand1, operand2));
                case "-":
                    return String.valueOf(subtraction(operand1, operand2));
                case "*":
                    return String.valueOf(multiplication(operand1, operand2));
                case "/":
                    if (operand2 == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    return String.valueOf(division(operand1, operand2));
                default:
                    throw new Exception("Invalid operator");
            }
        } else {
            throw new Exception("Invalid equation format");
        }
    }

    public double addition(double a, double b) {
        return a + b;
    }

    public double subtraction(double a, double b) {
        return a - b;
    }

    public double multiplication(double a, double b) {
        return a * b;
    }

    public double division(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}
