package iwilllearnjava.petshop;

/**
 * Created by david on 2/26/2017.
 */
public class Dog extends Pet implements Tailable {
    public Dog(int cost, String name) {
        super(cost, name);

    }

    public boolean hasTale() {
        return true;
    }
}
