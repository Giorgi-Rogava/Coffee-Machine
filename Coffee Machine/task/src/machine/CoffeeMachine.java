package machine;

import java.util.*;

import static machine.States.mainLoop;
import static machine.TypesOfCoffee.chooseTypesOfCoffee;

public class CoffeeMachine {

    public static void main(String[] args) {
        mainLoop();
    }


    static void hasResorces(int money, int water, int milk, int coffeeBeans, int disposableCups) {

        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " of water ");
        System.out.println(milk + " of milk ");
        System.out.println(coffeeBeans + " of coffee beans ");
        System.out.println(disposableCups + " of disposable cups ");
        System.out.println("$" + money + " of money \n");
    }


    static String makeAction() {
        System.out.print("Write action (buy, fill, take , remaining, exit): ");
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        return scanner.nextLine();
    }


    static List fillCoffeeMachine() {

        Scanner scanner = new Scanner(System.in);
        List<Integer> fillParametersList = new ArrayList<Integer>();

        System.out.println("\nWrite how many ml of water do you want to add: ");
        int inputWaterNumber = scanner.nextInt();
        fillParametersList.add(inputWaterNumber);

        System.out.println("Write how many ml of milk do you want to add: ");
        int inputMilkNumber = scanner.nextInt();
        fillParametersList.add(inputMilkNumber);

        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int inputNumberOfCoffeeBeans = scanner.nextInt();
        fillParametersList.add(inputNumberOfCoffeeBeans);

        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        int inputNumberOfdisposableCups = scanner.nextInt();
        fillParametersList.add(inputNumberOfdisposableCups);

        System.out.println();

        return fillParametersList;
    }
}







