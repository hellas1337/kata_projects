package calculator;


import java.util.List;
import java.util.Scanner;

public class Calculator {
    public static List<String> arabianNumbers = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    public static List<String> romanNumbers = List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
    public static List<String> actionList = List.of("+", "-", "*", "/");
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите математическое выражение: ");
        String line = scanner.nextLine();
        System.out.println(calc(line));

    }

    public static String calc(String input) {
        String[] str = input.split(" ");
        if (str.length != 3) {
            throw new RuntimeException("Формат математической операции не удовлетворяет заданию, " +
                    "необходимы два операнда и один оператор");
        }

        String num1 = str[0];
        String action = str[1];
        String num2 = str[2];
        int valueOfNum1;
        int valueOfNum2;


        if (!actionList.contains(action)) {
            throw new RuntimeException("Формат математической операции не удовлетворяет заданию, " +
                    "необходим один оператор");
        }

        if (arabianNumbers.contains(num1) &&
                arabianNumbers.contains(num2)) {
            return countArabian(num1, action, num2);
        } else if (romanNumbers.contains(num1) &&
                romanNumbers.contains(num2)) {
            return countRoman(num1, action, num2);
        } else {
            throw new RuntimeException("Используются одновременно разные системы счисления");
        }
    }

    private static String countRoman(String num1, String action, String num2) {
        int valueOfNum1;
        int valueOfNum2;
        valueOfNum1 = getArabian(num1);
        valueOfNum2 = getArabian(num2);
        return romanResult(valueOfNum1, valueOfNum2, action);
    }

    private static String countArabian(String num1, String action, String num2) {
        int valueOfNum2;
        int valueOfNum1;
        valueOfNum1 = Integer.parseInt(num1);
        valueOfNum2 = Integer.parseInt(num2);
        return String.valueOf(calculate(action, valueOfNum1, valueOfNum2));
    }

    private static String romanResult(int valueOfNum1, int valueOfNum2, String action) {
        int result = calculate(action, valueOfNum1, valueOfNum2);
        return arabianToRoman(result);
    }

    private static String arabianToRoman(int result) {
        String[] romanAll = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII",
                "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        try {
            return romanAll[result];
        } catch (Exception e) {
            throw new RuntimeException("В римской системе нет отрицательных чисел");
        }

    }

    private static int calculate(String action, Integer valueOfNum1, Integer valueOfNum2) {
        switch (action) {
            case "+":
                return valueOfNum1 + valueOfNum2;
            case "-":
                return valueOfNum1 - valueOfNum2;
            case "/":
                return valueOfNum1 / valueOfNum2;
            case "*":
                return valueOfNum1 * valueOfNum2;
            default:
                throw new RuntimeException("Оператор не соответствует необходимым (+, -, /, *)");
        }
    }

    private static int getArabian(String roman) {
        switch (roman) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                throw new RuntimeException("Вычисление поддерживается только между числами I-X");
        }
    }


}