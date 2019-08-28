package machine;

import java.util.List;

import static machine.CoffeeMachine.*;
import static machine.TypesOfCoffee.chooseTypesOfCoffee;

public enum States {

    BUY,
    FILL,
    TAKE,
    REMAINING,
    EXIT;


    public static void mainLoop() {

        int water = 400, milk = 540, coffeeBeans = 120, money = 550, disposableCups = 9;
        boolean exit = false;

        String returnActionName = makeAction();
        while (true) {

            switch (returnActionName) {

                case "buy":

                    List<Integer> listOfCoffeeTypeParams = chooseTypesOfCoffee();

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

}

