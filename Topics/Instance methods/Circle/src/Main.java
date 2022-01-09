
class Circle {

    double radius;

    // write methods here
    double getLength() {
        return 2 * Math.PI * this.radius;
    }

    double getArea() {
        return Math.PI * (this.radius * this.radius);
    }
}