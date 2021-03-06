package CalculatePacet;

public class ShowInformation {

    public static void showHelp() {
        System.out.println("Добро пожаловать в Калькулятор <<Школьник>>\n" +
                "Данный калькулятор позоляет:\n" +
                "Умножать  -  << * >>\n" +
                "Делить    -  << / >>\n" +
                "Складывать - << + >>\n" +
                "Отнимать  -  << - >>\n" +
                "Калькулятор умеет работать как с арабскими, так и с римскими числами\n" +
                "Арехметические действия можно производить только <<Арабские с Арабскими>> или <<Риские с Римскими>>");
    }

    public static void showConditions() {
        System.out.println("Для знакомства с калькультором напишите  <Help>\n" +
                " \n" +
                "Введите два любых числа от 1 до 10 или I до X включительно и незабудте арехметический знак между числами");
    }

    public static void showSeparatorError(){
        System.out.println("Вы не указали арифметические действия\n" +
                "Умножить  -  << * >>\n" +
                "Делить    -  << / >>\n" +
                "Сложения - << + >>\n" +
                "Вычитание  -  << - >>");
    }

    public static void showCalculateError(){
        System.out.println("Калькулятор завершил свою работу с ощибкой.");
    }
}
