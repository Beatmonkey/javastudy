package iwilllearnjava.statics;

/**
 * Created by david on 3/14/2017.
 */
public class Main {
    public static void main(String[] args) {
        Car lexus = new Car("Gray");
        Car rolsRoise = new Car("Black");
        lexus.info();
        Car.setCoolColor(lexus);
        lexus.info();
        System.out.println(Car.cathegory_id);
        Car.cathegory_id = 10;
        System.out.println(Car.cathegory_id);
        rolsRoise.info();

    }

    static void hey () {

    }
}

class Car {
    static int cathegory_id = 8;
    String color;

    public Car(String color) {
        super();
        this.color = color;
    }

    public void info() {
        Car car = this;
        System.out.println("Color: " + color + " " + cathegory_id);
    }

    public static void setCoolColor (Car car) {
        car.color = "Red";
    }
}
