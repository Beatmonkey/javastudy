package iwilllearnjava.petshop;

/**
 * Created by david on 3/23/2017.
 */
public class EqualsTest {
    public static void main(String[] args) {
        Pet p1 = new Pet (100, "Dima");

        Pet p2 = new Pet (100, "Dima");
        Pet p3 = new Pet (100, null);
        Pet p4 = new Cat (200, "Vasya", 10);
        Pet p5 = new Pet (100, "Kolya");
        Pet p6 = new Pet (400, "Kolya");
        Pet p7 = null;

        System.out.println("p1 p1: " + p1.equals(p1));
        System.out.println("p1 p2: " + p1.equals(p2));
        System.out.println("p1 p3: " + p1.equals(p3));
        System.out.println("p1 p4: " + p1.equals(p4));
        System.out.println("p1 p5: " + p1.equals(p5));
        System.out.println("p1 p6: " + p1.equals(p6));
        System.out.println("p1 p7: " + p1.equals(p7));
        System.out.println("p3 p1: " + p3.equals(p1));
    }
}

