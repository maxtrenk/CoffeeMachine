package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Machine machine = new Machine(400, 540, 120, 9, 550);
        while(true) {
            String state = machine.stateMachine.name();
            switch (state) {
                case "WAITING": {
                    System.out.println("Write action (buy, fill, take, remaining, exit):");
                    String action = scanner.nextLine();
                    machine.action(action);
                    break;
                }
                case "CHOICE_COFFEE": {
                    System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino," +
                            " back - to main menu:");
                    String action = scanner.nextLine();
                    machine.action(action);
                    break;
                }
                case "FILL":
                    System.out.println("\nWrite how many ml of water you want to add:");
                    machine.fillWater(scanner.nextLine());
                    System.out.println("Write how many ml of milk you want to add:");
                    machine.fillMilk(scanner.nextLine());
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    machine.fillCoffeeBeans(scanner.nextLine());
                    System.out.println("Write how many disposable cups of coffee you want to add:");
                    machine.fillCups(scanner.nextLine());
                    break;
                case "OFF":
                    System.exit(0);
            }
        }
    }
}


