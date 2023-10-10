package BigSpeakDesignModel.SimpleFactory;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input first num!");
            Double numA = Double.parseDouble(sc.nextLine());
            System.out.println("Input operator!");
            String operator = sc.nextLine();
            System.out.println("Input second num!");
            Double numB = Double.parseDouble(sc.nextLine());
            Operation oper = OperationFactory.createOperation(operator);
            oper.setNumA(numA);
            oper.setNumB(numB);
            String result = oper.getResult().toString();
            System.out.println("Result is: " + result + ".");
        } catch (Exception e) {
            System.out.println("Wrong input, please check!");
        }
    }
}
