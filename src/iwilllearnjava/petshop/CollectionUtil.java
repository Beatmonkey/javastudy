package iwilllearnjava.petshop;

import java.util.Iterator;
import java.util.List;

/**
 * Created by david on 2/26/2017.
 */
public class CollectionUtil {
    public static String listNameOfPetsWithCost(List<Pet> pets) {
        return listNameOfPets(pets, true);
    }

    public static String listNameOfPets(List<Pet> pets){
        return listNameOfPets(pets, false);
    }

    private static String listNameOfPets(List<Pet> pets, boolean showCost) {
        String petNames = "";
        if (pets != null) {
            Iterator<Pet> iterator = pets.iterator();
            while (iterator.hasNext()) {
                Pet p = iterator.next();
                if (showCost) {
                    petNames = petNames + p.name + "(" +  p.cost + ")";
                } else {
                    petNames = petNames + p.name;
                }
                if (iterator.hasNext()) {
                    petNames = petNames + ", ";
                }
            }

        }
        return petNames;
    }

}
