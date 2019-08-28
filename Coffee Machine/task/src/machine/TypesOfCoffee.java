package machine;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public enum TypesOfCoffee {
    ESPRESSO,
    LATTE,
    CAPPUCCINO;

    public static List chooseTypesOfCoffee() {

        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        Scanner scanner = new Scanner(System.in);

        int chosenNumber = 31;
        String chosenString = scanner.nextLine();

        if (chosenString.equals("back")) {
            chosenNumber = 0;
        } else {
            chosenNumber = Integer.parseInt(chosenString);
        }


        switch (chosenNumber) {

            case 0:
                return Collections.singletonList(0);


            case 1: // espresso

                return Arrays.asList(250, 0, 16, 4, 1);

            case 2: // latte

                return Arrays.asList(350, 75, 20, 7, 1);

            case 3: // cappuccino

                return Arrays.asList(200, 100, 12, 6, 1);
        }
        return null;
    }

}
