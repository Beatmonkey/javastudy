package iwilllearnjava.petshop;


import java.util.*;


public class PetShop {
    public static void main(String[] args) {
        Pet vasya = new Dog (200, "Vasya");
        Dog bobby = new Dog(600, "Bobby");
        Cat fluffy = new Cat(400, "Fluffy", 10);
        Pet petya = new Cat (500, "Petya", 10);
        Spider venya = new Spider(150, "Venya");

        List<Pet> list = new ArrayList<Pet>();
        list.add(vasya);
        list.add(venya);
        list.add(petya);
        list.add(fluffy);
        list.add(bobby);

        for(Pet p: list){
            System.out.println(p.talk());
        }

        list.remove(0);
        list.remove(bobby);

        Collection<Tailable> set = new HashSet<Tailable>();
        set.add(fluffy);
        set.add(bobby);
        set.add(venya);

        Iterator<Tailable> iterator = set.iterator();
        while(iterator.hasNext()){
            Tailable t = iterator.next();
            if (t == venya){
                iterator.remove();
            }
        }

        for(Tailable t: set){
            System.out.println(t.getClass().getName() + " " + t.hasTale());
        }



//        Object vasya = list.get(1);
//        Pet petVasya = (Pet) vasya;
//        System.out.println(petVasya.talk());
    }

}

