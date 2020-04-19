package iwilllearnjava.petshop;

public class Pet  implements Tailable {

    int cost = 100;
    String name = "Tobby";

    public Pet(int cost, String name) {

        this.cost = cost;
        this.name = name;
    }

    String talk() {
        return "Hello my name is " + name + " my cost is " + cost;
    }

//    @Override
//    public boolean equals (Object obj){
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (!(obj instanceof Pet)) {
//            return false;
//        }
//        Pet pet = (Pet)obj;
//        if (pet.cost != cost) {
//            return false;
//        }
//        if (pet.name == null && this.name != null || pet.name != null && this.name == null) {
//            return false;
//        }
//        if (pet.name != null && !pet.name.equals(name)) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        if (cost != pet.cost) return false;
        return !(name != null ? !name.equals(pet.name) : pet.name != null);

    }

    @Override
    public int hashCode() {
        int result = cost;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public boolean hasTale() {
        return false;
    }
}
