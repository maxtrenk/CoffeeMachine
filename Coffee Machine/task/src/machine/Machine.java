package machine;

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
        this. coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.money = money;
        stateMachine = StateMachine.WAITING;
    }

    void action(String action) {


    }

}


