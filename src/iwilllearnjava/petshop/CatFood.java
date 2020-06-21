package iwilllearnjava.petshop;

/**
 * Created by david on 3/24/2017.
 */
public class CatFood extends PetFood {

    String catFoodIdentity = "For cats";

    public CatFood(int cost, String name, String catFoodIdentity) {
        super(cost, name);

    }

    String talk() {
        return super.talk() + catFoodIdentity;
    }
}