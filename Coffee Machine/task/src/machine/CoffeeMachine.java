package machine;

import java.util.*;


public class CoffeeMachine {

    public static void main(String[] args) {

        int water = 400, milk = 540, coffeeBeans = 120, money = 550, disposableCups = 9;
        boolean exit = false;

        String returnActionName = makeAction();

        while (true) {

            switch (returnActionName) {

                case "buy":

                    List<Integer> listOfCoffeeTypeParams = chooseSpeciesOfCoffee();

                    if (listOfCoffeeTypeParams.get(0) == 0) {
                        returnActionName = makeAction();
                        continue;
                    }

                    if (water >= listOfCoffeeTypeParams.get(0) && milk >= listOfCoffeeTypeParams.get(1) && coffeeBeans >= listOfCoffeeTypeParams.get(2) && disposableCups >= listOfCoffeeTypeParams.get(4)) {

                        water -= listOfCoffeeTypeParams.get(0);
                        milk -= listOfCoffeeTypeParams.get(1);
                        coffeeBeans -= listOfCoffeeTypeParams.get(2);
                        money += listOfCoffeeTypeParams.get(3);
                        disposableCups -= listOfCoffeeTypeParams.get(4);

                        System.out.println("I have enough resources, making you a coffee! \n");

                    } else {
                        System.out.println("I can't make a cup of coffee. \n");
                    }

                    returnActionName = makeAction();
                    continue;


                case "fill":

                    List<Integer> fillParametersList = fillCoffeeMachine();
                    water += fillParametersList.get(0);
                    milk += fillParametersList.get(1);
                    coffeeBeans += fillParametersList.get(2);
                    disposableCups += fillParametersList.get(3);

                    returnActionName = makeAction();
                    continue;


                case "take":
                    System.out.println("\nI gave you $" + money + "\n");
                    money = 0;
                    returnActionName = makeAction();
                    continue;


                case "remaining":
                    hasResorces(money, water, milk, coffeeBeans, disposableCups);
                    returnActionName = makeAction();
                    continue;


                case "exit":
                    exit = true;
                    break;
            }

            if (exit) {
                break;
            }

        }

    }


    public static void hasResorces(int money, int water, int milk, int coffeeBeans, int disposableCups) {

        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " of water ");
        System.out.println(milk + " of milk ");
        System.out.println(coffeeBeans + " of coffee beans ");
        System.out.println(disposableCups + " of disposable cups ");
        System.out.println("$" + money + " of money \n");
    }


    public static String makeAction() {
        System.out.print("Write action (buy, fill, take , remaining, exit): ");
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        return scanner.nextLine();
    }


    public static List chooseSpeciesOfCoffee() {

        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        Scanner scanner = new Scanner(System.in);

        int chosenNumber = 31;
        String chosenString = scanner.nextLine();

        if (chosenString.equals("back")) {
            chosenNumber = 0;
        } else {
            chosenNumber = Integer.valueOf(chosenString);
        }


        switch (chosenNumber) {

            case 0:
                List goBack = Arrays.asList(0);
                return goBack;


            case 1: // espresso

                List espressoParametersList = Arrays.asList(250, 0, 16, 4, 1);

                return espressoParametersList;

            case 2: // latte

                List latteParametersList = Arrays.asList(350, 75, 20, 7, 1);

                return latteParametersList;

            case 3: // cappuccino

                List cappuccinoParametersList = Arrays.asList(200, 100, 12, 6, 1);

                return cappuccinoParametersList;
        }
        return null;
    }


    public static List fillCoffeeMachine() {

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








