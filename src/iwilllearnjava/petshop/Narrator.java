package iwilllearnjava.petshop;

/**
 * Created by david on 2/26/2017.
 */
public class Narrator {
    public static void main(String[] args) {
        Customer andrey = new Customer(1400, "Andrey");
        System.out.println(andrey.toString());

        NewPetShop shop = new NewPetShop();
        shop.pets.add(new Cat(300, "Vasya", 10));
        shop.pets.add(new Cat(330, "Timofey", 10));
        shop.pets.add(new Dog(500, "Kolya"));
        shop.pets.add(new Dog(560, "Sharik"));
        shop.pets.add(new Dog(550, "Dima"));
        shop.pets.add(new Spider(700, "Venya"));
//        System.out.println(shop.toString());

        shop.petFoods.add(new CatFood(50, "Whiskas", "For cats!"));
        PetFood foundPetFood = null;
        for (PetFood p: shop.petFoods ){
            if (p.name.equals("Whiskas")) {
                foundPetFood = p;
                System.out.println(foundPetFood.name + " " + foundPetFood.cost );

            }

        }


//        shop.buy("Vasya", andrey);
//
//        shop.buy("Vladimir", andrey);
//
//        shop.buy("Venya", andrey);
//        shop.buy("Dima", andrey);

    }
}
