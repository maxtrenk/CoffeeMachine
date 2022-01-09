package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] supply = {400, 540, 120, 9, 550};
        Machine machine = new Machine(400, 540, 120, 9, 550);
        while(true) {
            String state = machine.stateMachine.name();
            if (state.equals("WAITING")){
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                String action = scanner.nextLine();
                machine.action(action);
            } else if (state.equals("CHOICE_COFFEE")) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino," +
                        " back - to main menu:");
                String action = scanner.nextLine();
                machine.action(action);
            } else if (state.equals("FILL")) {
                System.out.println("Write how many ml of water you want to add:");
                machine.water += scanner.nextInt();
                System.out.println("Write how many ml of milk you want to add:");
                machine.milk += scanner.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add:");
                machine.coffeeBeans += scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee you want to add:");
                machine.disposableCups += scanner.nextInt();
            }
        }
        /*switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                int order = scanner.nextInt();
                switch (order){
                    case 1:
                        buyEspresso(supply);
                        break;
                    case 2:
                        buyLatte(supply);
                        break;
                    case 3:
                        buyCappuccino(supply);
                        break;
                }
                printSupply(supply);
                break;
            case "fill":
                refillSupply(supply);
                printSupply(supply);
                break;
            case "take":
                payment(supply);
                printSupply(supply);
                break;
        }*/


       /*
       System.out.println("Write how many ml of water the coffee machine has:");
       int countWater = scanner.nextInt();
       System.out.println("Write how many ml of milk the coffee machine has:");
       int countMilk = scanner.nextInt();
       System.out.println("Write how many grams of coffee beans the coffee machine has");
       int countBeans = scanner.nextInt();
       System.out.println("Write how many cups of coffee you will need:");
       int cupsCoffee = scanner.nextInt();
       int maxWater = countWater / 200;
       int maxMilk = countMilk / 50;
       int maxBeans = countBeans / 15;
       int maxCups = maxWater;
       if (maxWater > maxMilk) {
           maxCups = maxMilk;
       } else if (maxWater > maxBeans) {
           maxCups = maxBeans;
       }
       if (maxCups == cupsCoffee) {
           System.out.println("Yes, I can make that amount of coffee");
       } else if (maxCups > cupsCoffee) {
           System.out.println("Yes, I can make that amount of coffee (and even " + (maxCups - cupsCoffee)
                   + " more than that)");
       } else {
           System.out.println("No, I can make only " + maxCups + " cup(s) of coffee");
       }*/
    }

    public static void refillSupply(int[] supply) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add");
        supply[0] += scan.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        supply[1] += scan.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        supply[2] += scan.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        supply[3] += scan.nextInt();
    }

    public static void printSupply(int[] supply) {
        System.out.printf("The coffee machine has:%n" +
                "%d ml of water%n" +
                "%d ml of milk%n" +
                "%d g of coffee beans%n" +
                "%d disposable cups%n" +
                "%d$ of money%n", supply[0], supply[1], supply[2], supply[3], supply[4]);

    }

    public static void payment(int[] supply) {
        System.out.printf("I gave you $%d", supply[4]);
        supply[4] = 0;
    }

    public static void buyEspresso(int[] supply) {
        supply[0] -= 250;
        supply[2] -= 16;
        supply[3] -= 1;
        supply[4] += 4;
    }

    public static void buyLatte(int[] supply) {
        supply[0] -= 350;
        supply[1] -= 75;
        supply[2] -= 20;
        supply[3] -= 1;
        supply[4] += 7;
    }

    public static void buyCappuccino(int[] supply) {
        supply[0] -= 200;
        supply[1] -= 100;
        supply[2] -= 12;
        supply[3] -= 1;
        supply[4] += 6;
    }
}


