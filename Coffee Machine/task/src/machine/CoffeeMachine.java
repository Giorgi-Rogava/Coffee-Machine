package machine;

import java.util.*;


public class CoffeeMachine {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Write how many ml of water the coffee machine has: ");
//        int inputVolumeOfWater = scanner.nextInt();
//        System.out.println("Write how many ml of milk the coffee machine has: ");
//        int inputVolumeOfMilk = scanner.nextInt();
//        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
//        int inputWeightOfCoffeeBeans = scanner.nextInt();
//
//        System.out.println("Write how many cups of coffee you will need: ");
//        int numberCupsOfCoffee = scanner.nextInt();
//
//        int result = countCupsOfCoffee(numberCupsOfCoffee, inputVolumeOfWater, inputVolumeOfMilk, inputWeightOfCoffeeBeans);
//
//        if (result != 0) {
//            System.out.println(printAnswer(numberCupsOfCoffee, result));
//        }

        ArrayList<Integer> returnNumbers = new ArrayList<Integer>();

        int money = 550, water = 1200;
        int milk = 540, coffeeBeans = 120, disposableCups = 9;

        String actionNameV1 = "";
        hasResorces(money, water, milk, coffeeBeans, disposableCups);
        System.out.println();
        actionNameV1 = makeAction();
        returnNumbers = (ArrayList<Integer>) Actions(actionNameV1);

        if (actionNameV1.equals("buy")) {
            money += returnNumbers.get(3);
            water -= returnNumbers.get(0);
            milk -= returnNumbers.get(1);
            coffeeBeans -= returnNumbers.get(2);
            disposableCups -= returnNumbers.get(4);
            System.out.println();

            hasResorces(money, water, milk, coffeeBeans, disposableCups);

        } else if (actionNameV1.equals("fill")) {

            water += returnNumbers.get(0);
            milk += returnNumbers.get(1);
            coffeeBeans += returnNumbers.get(2);
            disposableCups += returnNumbers.get(3);

            hasResorces(money, water, milk, coffeeBeans, disposableCups);

        } else if (actionNameV1.equals("take")) {
            System.out.println("I gave you $" + money);
            System.out.println();
            money = 0;
            hasResorces(money, water, milk, coffeeBeans, disposableCups);

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


    public static void hasResorces(int money, int water, int milk, int coffeeBeans, int disposableCups) {

        System.out.println("The coffee machine has:");
        System.out.println(water + " of water ");
        System.out.println(milk + " of milk ");
        System.out.println(coffeeBeans + " of coffee beans ");
        System.out.println(disposableCups + " of disposable cups ");
        System.out.println(money + " of money ");

    }


    public static String makeAction() {

        System.out.println("Write action (buy, fill, take): ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }


    public static List<Integer> Actions(String nameOfAction) {


        if (nameOfAction.equals("buy")) {

            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {

                case 1: // espresso

                    ArrayList<Integer> parametersV1 = new ArrayList<Integer>();

                    int waterVar = 250;
                    parametersV1.add(waterVar);

                    int milkVar = 0;
                    parametersV1.add(milkVar);

                    int beansVar = 16;
                    parametersV1.add(beansVar);

                    int moneyVar = 4;
                    parametersV1.add(moneyVar);

                    int disposableCupsVar = 1;
                    parametersV1.add(disposableCupsVar);


                    return parametersV1;

                case 2: // latte
                    ArrayList<Integer> parametersV2 = new ArrayList<Integer>();

                    waterVar = 350;
                    parametersV2.add(waterVar);

                    milkVar = 75;
                    parametersV2.add(milkVar);

                    beansVar = 20;
                    parametersV2.add(beansVar);

                    moneyVar = 7;
                    parametersV2.add(moneyVar);

                    disposableCupsVar = 1;
                    parametersV2.add(disposableCupsVar);


                    return parametersV2;

                case 3: // cappuccino

                    ArrayList<Integer> parametersV3 = new ArrayList<Integer>();

                    waterVar = 200;
                    parametersV3.add(waterVar);

                    milkVar = 100;
                    parametersV3.add(milkVar);

                    beansVar = 12;
                    parametersV3.add(beansVar);

                    moneyVar = 6;
                    parametersV3.add(moneyVar);

                    disposableCupsVar = 1;
                    parametersV3.add(disposableCupsVar);

                    return parametersV3;

            }
        } else if (nameOfAction.equals("fill")) {
            ArrayList<Integer> parametersV4 = new ArrayList<Integer>();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Write how many ml of water do you want to add: ");
            int waterVar = scanner.nextInt();
            parametersV4.add(waterVar);

            System.out.println("Write how many ml of milk do you want to add: ");
            int milkVar = scanner.nextInt();
            parametersV4.add(milkVar);

            System.out.println("Write how many grams of coffee beans do you want to add: ");
            int beansVar = scanner.nextInt();
            parametersV4.add(beansVar);

            System.out.println("Write how many disposable cups of coffee do you want to add: ");
            int disposableCupsVar = scanner.nextInt();
            parametersV4.add(disposableCupsVar);
            System.out.println();

            return parametersV4;

        }
        return null;
    }
}
















