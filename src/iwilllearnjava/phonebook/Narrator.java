package iwilllearnjava.phonebook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by david on 3/11/2017.
 */
public class Narrator {
    public static void main(String[] args) {
        PersonProvider personProvider = new PersonGenerator();
        List<Person> persons = personProvider.getPersons();
        System.out.println(persons.size());

        for (Person p : persons) {
//            System.out.println(p.telNumber + " " + p.name + " " + p.surname + " " + p.sex);
        }
        Person lastPerson = persons.get(persons.size() - 1);
        String telNumber = lastPerson.telNumber;

        long listbefore = System.currentTimeMillis();
        Person foundPerson = null;
        for (Person p : persons) {
            if (p.telNumber.equals(telNumber)) {
                foundPerson = p;
                break;
            }
        }
        long listAfter = System.currentTimeMillis();
        System.out.println("Time to find in list: " + (listAfter - listbefore));

        Map<String, Person> map = new HashMap<>();
        for (Person p: persons) {
            map.put(p.telNumber, p);
        }
        long mapBefore = System.currentTimeMillis();
        Person person = map.get(telNumber);
        long mapAfter = System.currentTimeMillis();
        System.out.println("Time to find in map: " + (mapAfter - mapBefore));


    }
}
