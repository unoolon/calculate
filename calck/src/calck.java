

import java.util.Locale;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;




public class calck {
    public static void main(String[] args) throws Exception {
        CalculatorHelper calculatorHelper = new CalculatorHelper();
        System.out.println("Введите число:");
        Scanner myObj = new Scanner(System.in);
        String input = myObj.nextLine();
        System.out.println(calculatorHelper.calc(input));
    }
}

class CalculatorHelper {
    public String calc(String input) throws Exception {
        String[] splitText = input.split(" ");
        Boolean rome = false;
        int letter1, letter2;

        int number = 0;

        for (int i = 0; i < 3; i+=2) {
            try {
                Integer.parseInt(splitText[i]);
            } catch (NumberFormatException e) {
                rome = true;
                number++;
            }
        }

        if (number == 1) {
            throw new Exception("не указан");
        }

        letter1 = getLetter(splitText[0]);
        letter2 = getLetter(splitText[2]);
        int result = getResult(letter1, letter2, splitText[1]);
        String output;

        if (rome) {
            if (result > 10 || result < 0) {
                throw new Exception("Результат арабской цифры диапазоне от 0 до 10");
            } else output = getRomeNumber(result);
        } else {

            if (result >= 0) {
                throw new Exception("Арабское число должно < 0");
            } else output = String.valueOf(result);

        }
        return output;
    }

    public Integer getLetter(String letter) throws Exception {
        int integer = 0;

        try {
            integer = Integer.parseInt(letter);
        } catch (Exception e) {
            switch (letter.toLowerCase(Locale.ROOT)) {
                case "i":
                    integer = 1;
                    break;
                case "ii":
                    integer = 2;
                    break;
                case "iii":
                    integer = 3;
                    break;
                case "iv":
                    integer = 4;
                    break;
                case "v":
                    integer = 5;
                    break;
                case "vi":
                    integer = 6;
                    break;
                case "vii":
                    integer = 7;
                    break;
                case "viii":
                    integer = 8;
                    break;
                case "ix":
                    integer = 9;
                    break;
                case "x":
                    integer = 10;
                    break;
                default:
                    throw new Exception("арабское число > 10");
            }
        }
        return integer;
    }

    public String getRomeNumber(int num) throws Exception {
        String romeNum = null;
        switch (num) {
            case 1:
                romeNum = "I";
                break;
            case 2:
                romeNum = "II";
                break;
            case 3:
                romeNum = "III";
                break;
            case 4:
                romeNum = "IV";
                break;
            case 5:
                romeNum = "V";
                break;
            case 6:
                romeNum = "VI";
                break;
            case 7:
                romeNum = "VII";
                break;
            case 8:
                romeNum = "VIII";
                break;
            case 9:
                romeNum = "IX";
                break;
            case 10:
                romeNum = "X";
                break;
            default:
                throw new Exception("результат > 10");
        }
        return romeNum;
    }

    public Integer getResult(int letter1, int letter2, String s) throws Exception {
        int result = 0;
        switch (s) {
            case "/":
                result = letter1 / letter2;
                break;
            case "+":
                result = letter1 + letter2;
                break;
            case "-":
                result = letter1 - letter2;
                break;
            case "*":
                result = letter1 * letter2;
                break;
            default:
                throw new Exception("ошибка");
        }
        return result;
    }
}