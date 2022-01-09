
class Car {

    int yearModel;
    String make;
    int speed;
    final int five = 5;
    final int zero = 0;

    void accelerate() {
        this.speed += five;
    }

    void brake() {
        if (this.speed >= five) {
            this.speed -= five;
        } else {
            this.speed = zero;
        }
    }
}