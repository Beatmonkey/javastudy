package iwilllearnjava.petshop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 2/26/2017.
 */
public class NewPetShop {
    List<Pet> pets = new ArrayList<Pet>();
    List<PetFood> petFoods = new ArrayList<>();

    /**
     * This metod buys pets for customer by desired name.
     * @param name pet name
     * @param customer this is a customer
     * @return true if purchase is successful
     *         false if: pet is not found or
     */
    public boolean buy(String name, Customer customer) {
        // If pet with name exists, if not then false
        Pet foundPet = null;
        for (Pet p: pets) {
            if (p.name.equals(name)) {
                foundPet = p;
                break;
            }
        }
        if (foundPet == null) {
            System.out.println("Pet with name: " + name + " was not found");
            return false;
        }
        // find a cost and check customer balance, if not enough then false
        if (foundPet.cost >= customer.money) {
            System.out.println("You don't have enough money for purchase (need " + (foundPet.cost - customer.money) + " more)");
            return false;
        }
        // withdraw customer balance, remove pet from shop petlist add pet to customer petlist
        customer.money = customer.money - foundPet.cost;
        pets.remove(foundPet);
        customer.boughtPets.add(foundPet);
        System.out.println(name + " is successfully bought by " + customer.name);
        System.out.println(this.toString());
        System.out.println(customer.toString());
        return true;
    }


    @Override
    public String toString() {

        List<Pet> allCats = new ArrayList<Pet>();
        for (Pet p : pets) {
            if (p instanceof Cat) {
                allCats.add(p);
            }
        }

        List<Pet> allDogs = new ArrayList<Pet>();
        for (Pet p : pets) {
            if (p instanceof Dog) {
                allDogs.add((Dog)p);
            }
        }
        List<Pet> allSpiders = new ArrayList<Pet>();
        for (Pet p : pets) {
            if (p instanceof Spider) {
                allSpiders.add((Spider)p);
            }
        }
       return "Shop:" + "\n" +
               "-> Cats: " + CollectionUtil.listNameOfPetsWithCost(allCats) + "\n" +
               "-> Dogs: " + CollectionUtil.listNameOfPetsWithCost(allDogs) + "\n" +
               "-> Spiders: " + CollectionUtil.listNameOfPetsWithCost(allSpiders) + "\n";
    }
}
