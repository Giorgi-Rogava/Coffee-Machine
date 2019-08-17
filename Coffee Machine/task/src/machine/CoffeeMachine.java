package machine;

import java.util.*;


public class CoffeeMachine {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has: ");
        int inputVolumeOfWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int inputVolumeOfMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int inputWeightOfCoffeeBeans = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need: ");
        int numberCupsOfCoffee = scanner.nextInt();

        int result = countCupsOfCoffee(numberCupsOfCoffee, inputVolumeOfWater, inputVolumeOfMilk, inputWeightOfCoffeeBeans);

        if (result != 0) {
            System.out.println(printAnswer(numberCupsOfCoffee, result));
        }

    }


    public static int countCupsOfCoffee(int numberOfCups, int water, int milk, int coffeeBeans) {
        List<Integer> possibleNumber = new ArrayList<Integer>();

        if (numberOfCups == 0 && water == 0 && milk == 0 && coffeeBeans == 0) {
            System.out.println("Yes, I can make that amount of coffee ");
            return 0;
        }

        if (numberOfCups == 1 && water == 0 && milk == 0 && coffeeBeans == 0) {
            System.out.println("No, I can make only 0 cup(s) of coffee ");
            return 0;
        }


        int possibleVolumeOfWater = water / 200;
        int possibleVolumeOfMilk = milk / 50;
        int possibleWeightOfCoffeeBeans = coffeeBeans / 15;

        possibleNumber.add(possibleVolumeOfWater);
        possibleNumber.add(possibleVolumeOfMilk);
        possibleNumber.add(possibleWeightOfCoffeeBeans);

        int localresult = Collections.min(possibleNumber);


        System.out.println(localresult);
        return localresult;
    }


    public static String printAnswer(int numberOfCoffeeCups, int resultNumber) {
        String stringResult = "";
        if (numberOfCoffeeCups == resultNumber) {
            stringResult = ("Yes, I can make that amount of coffee");
        } else if (numberOfCoffeeCups > resultNumber) {
            stringResult = ("No, I can make only " + resultNumber + " cup(s) of coffee");
        } else if (numberOfCoffeeCups < resultNumber) {
            stringResult = ("Yes, I can make that amount of coffee (and even " + (resultNumber - numberOfCoffeeCups) + " more than that)");
        }
        return stringResult;
    }

}


