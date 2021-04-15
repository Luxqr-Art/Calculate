package CalculatePacet;


public class Calculate {





    public static void calculateAssembly() {
        ShowInformation.showConditions();
        String scanLine = Method.scanLine();
        int divisorIndex = Method.divisor(scanLine);
        int number1 = Method.findNumber1(scanLine, divisorIndex);
        int number2 = Method.findNumber2(scanLine, divisorIndex);
        Method.arithmetic(scanLine, number1, number2, divisorIndex);
    }





    public static void main(String[] args) {

        String s = "";

        while (!s.equals("Y")) {
            calculateAssembly();
            System.out.println();
            System.out.println("Завершить работу калькулятора Y/N ?");
            s = Method.scanExit().toUpperCase();
        }
    }
}
