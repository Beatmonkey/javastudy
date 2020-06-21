package iwilllearnjava.petshop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 2/26/2017.
 */
public class Customer extends Object{
    int money = 0;
    String name = null;
    List<Pet> boughtPets = new ArrayList<Pet>();

    public Customer(int money, String name) {
        this.money = money;
        this.name = name;
    }

    @Override
    public String toString() {
        String petNames = CollectionUtil.listNameOfPets(boughtPets);

        return "Customer: " + this.name + "\n" +
                "money: " + money + "\n" +
                "pets: " + petNames;
    }
}
