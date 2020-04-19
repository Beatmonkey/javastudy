package iwilllearnjava.petshop;

/**
 * Created by david on 3/23/2017.
 */
public abstract class PetFood {
    int cost = 100;
    String name = "test";

    public PetFood(int cost, String name) {
        this.cost = cost;
        this.name = name;
    }

    String talk() {
        return "Name: " + name + "has price: " + cost ;
    }
}



