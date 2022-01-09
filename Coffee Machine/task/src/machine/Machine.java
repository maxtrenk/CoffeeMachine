package machine;

import java.lang.invoke.SwitchPoint;

public class Machine {
    int water;
    int milk;
    int coffeeBeans;
    int disposableCups;
    int money;
    StateMachine stateMachine;

    Machine(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.money = money;
        stateMachine = StateMachine.WAITING;
    }

    void action(String action) {
        switch (stateMachine) {
            case WAITING:
                this.firstAction(action);
                break;
            case CHOICE_COFFEE:
                this.choiceCoffeeAction(action);
                break;
        }
    }

    void buyCappuccino() {
        if (this.water < 200) {
            System.out.println("Sorry, not enough water!");
        } else if (this.milk < 100) {
            System.out.println("Sorry, not enough milk!");
        } else if (this.coffeeBeans < 12) {
            System.out.println("Sorry, not enough coffeeBeans!");
        } else if (this.disposableCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
            this.water -= 200;
            this.milk -= 100;
            this.coffeeBeans -= 12;
            this.disposableCups -= 1;
            this.money += 6;
            this.stateMachine = StateMachine.WAITING;
        }
    }

    void buyEspresso() {
        if (this.water < 250) {
            System.out.println("Sorry, not enough water!");
        } else if (this.coffeeBeans < 16) {
            System.out.println("Sorry, not enough coffeeBeans!");
        } else if (this.disposableCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
            this.water -= 250;
            this.coffeeBeans -= 16;
            this.disposableCups -= 1;
            this.money += 4;
            this.stateMachine = StateMachine.WAITING;
        }
    }

    void buyLatte() {
        if (this.water < 350) {
            System.out.println("Sorry, not enough water!");
        } else if (this.milk < 75) {
            System.out.println("Sorry, not enough milk!");
        } else if (this.coffeeBeans < 20) {
            System.out.println("Sorry, not enough coffeeBeans!");
        } else if (this.disposableCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
            this.water -= 350;
            this.milk -= 75;
            this.coffeeBeans -= 20;
            this.disposableCups -= 1;
            this.money += 7;
            this.stateMachine = StateMachine.WAITING;
        }
    }

    void takeMoney() {
        System.out.printf("%nI gave you $%d%n", this.money);
        this.money = 0;
    }

    void stocks() {
        System.out.printf("%nThe coffee machine has:%n" +
                "%d ml of water%n" +
                "%d ml of milk%n" +
                "%d g of coffee beans%n" +
                "%d disposable cups%n" +
                "%d$ of money%n%n", this.water, this.milk, this.coffeeBeans, this.disposableCups, this.money);
    }

    void firstAction(String action){
        switch (action){
            case "buy":
                this.stateMachine = StateMachine.CHOICE_COFFEE;
                break;
            case "fill":
                this.stateMachine = StateMachine.FILL;
                break;
            case "take":
                this.takeMoney();
                break;
            case "remaining":
                this.stocks();
                break;
            case "exit":
                this.stateMachine = StateMachine.OFF;
        }
    }

    void choiceCoffeeAction(String action) {
        switch (action) {
            case "1":
                this.buyEspresso();
                this.stateMachine = StateMachine.WAITING;
                break;
            case "2":
                this.buyLatte();
                this.stateMachine = StateMachine.WAITING;
                break;
            case "3":
                this.buyCappuccino();
                this.stateMachine = StateMachine.WAITING;
                break;
        }
    }

    void fillWater(String countWater) {
        this.water += Integer.parseInt(countWater.trim());
    }

    void fillMilk(String countMilk) {
        this.milk += Integer.parseInt(countMilk.trim());
    }

    void fillCoffeeBeans(String countBeans){
        this.coffeeBeans += Integer.parseInt(countBeans.trim());
    }

    void fillCups(String countCups) {
        this.disposableCups = Integer.parseInt(countCups.trim());
        System.out.println();
        this.stateMachine = StateMachine.WAITING;
    }
}


