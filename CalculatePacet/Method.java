package CalculatePacet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Method {


    private static boolean roman = false;

     static String scanExit() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    static String scanLine() {

        Scanner scan = new Scanner(System.in);
        String full = scan.nextLine();
        if (full.equals("Help")) {
            ShowInformation.showHelp();
            System.out.println();
            ShowInformation.showConditions();
            full = scan.nextLine();
        }
        Pattern p = Pattern.compile("[IVXLCDM]");
        Pattern p1 = Pattern.compile("[0-9]");
        Matcher mat1 = p1.matcher(full);
        Matcher mat = p.matcher(full);
        if (mat.find() && mat1.find()) {
            full = "5§5";
        }
        return full;
    }


    static int divisor(String scanLine) {

        int stop = 0;

        for (int i = 0; i < scanLine.length(); i++) {
            if (scanLine.charAt(i) == '-' || scanLine.charAt(i) == '+' || scanLine.charAt(i) == '§' || scanLine.charAt(i) == '*' || scanLine.charAt(i) == '/') {
                stop = i;
                break;
            }
//            else if (i == (scanLine.length())-1) {
//                ShowInformation.showSeparatorError();
//                            System.exit(0);
//            }
        }

        return stop;
    }


    static int getNumberRomanOrArabic(String st) {
        int number = 0;
        if (st.matches("[0-9]+")) {
            number = Integer.parseInt(st);

        } else if (st.matches("[IVXLCDM]+")) {
            for (Romans in : Romans.values()) {
                if (st.equals(in.getKey())) {
                    number = in.getValue();
                    roman = true;
                    break;
                }
            }

        } else {
            number = -1;
        }
        return number;
    }

    static int findNumber1(String scanLine, int stop) {
        String st1 = (scanLine.substring(0, stop)).trim();
        return getNumberRomanOrArabic(st1);
    }


    static int findNumber2(String scanLine, int stop) {
        String st1 = (scanLine.substring((stop + 1)).trim());
        return getNumberRomanOrArabic(st1);
    }


     static void romanToArabic(int arabic) {
        StringBuilder s = new StringBuilder();
        if (arabic > 0) {
            s.append("Ваш ответ: ");
            int b = 0;
            while (arabic != b) {
                for (Romans in : Romans.values()) {
                    if (arabic <= in.getValue()) {
                        int index = in.ordinal();
                        if (arabic < in.getValue()) {
                            index = (in.ordinal() - 1);
                        }
                        arabic -= Romans.values()[index].getValue();
                        s.append(Romans.values()[index].getKey());
                        break;
                    }
                }
            }
        } else {
            s.append("У римской системы исчиления отсутствует  0  и отрицательные числа\n" +
                    "Калькулятор завершил свою работу с ощибкой.");
        }
        System.out.println(s);
    }


    static void arithmetic(String scanLine, int number1, int number2, int stop) {
        if (number1 > 0 && number2 > 0 && number1 < 11 && number2 < 11) {
            switch (scanLine.charAt(stop)) {
                case '+':
                    if (roman) {
                        romanToArabic(number1 + number2);
                        break;
                    }
                    System.out.println("Ваш ответ: " + (number1 + number2));
                    break;
                case '-':
                    if (roman) {
                        romanToArabic(number1 - number2);
                        break;
                    }
                    System.out.println("Ваш ответ: " + (number1 - number2));
                    break;
                case '*':
                    if (roman) {
                        romanToArabic(number1 * number2);
                        break;
                    }
                    System.out.println("Ваш ответ: " + (number1 * number2));
                    break;
                case '/':
                    if (roman) {
                        romanToArabic(number1 / number2);
                        break;
                    }
                    System.out.println("Ваш ответ: " + (number1 / number2));
                    break;
                case '§':
                    System.out.println("Калькулятор не может производить математические действия между\n" +
                            "Римскими и Арабскиими системами исчисления");
                    ShowInformation.showCalculateError();

            }
        } else if (number1 == -1 && stop == 0) {
            ShowInformation.showSeparatorError();
            ShowInformation.showCalculateError();
        } else {
            System.out.println("Укажите числа от 1 до 10 или I до X включительно");
            ShowInformation.showCalculateError();

        }
    }

}
