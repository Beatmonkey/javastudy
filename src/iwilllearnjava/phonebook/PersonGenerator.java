package iwilllearnjava.phonebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 3/11/2017.
 */
public class PersonGenerator implements PersonProvider {

    private static final List<String> NAMES = new ArrayList<>();

    private static final  List<String> SURNAMES = new ArrayList<>();

    private static final  List<Boolean> SEXIS = new ArrayList<>();

    static {
        NAMES.add("Alex");
        NAMES.add("Tolik");
        NAMES.add("Vova");
        NAMES.add("Dmitry");
        NAMES.add("Anastasia");
        NAMES.add("Sanya");
        NAMES.add("Anya");
        NAMES.add("Kolya");
        NAMES.add("Sveta");
        NAMES.add("Tanya");

        SURNAMES.add("Smith");
        SURNAMES.add("Johnson");
        SURNAMES.add("Williams");
        SURNAMES.add("Jones");
        SURNAMES.add("Daves");
        SURNAMES.add("Miller");
        SURNAMES.add("Wood");
        SURNAMES.add("Lewis");
        SURNAMES.add("Scott");
        SURNAMES.add("King");

        SEXIS.add(true);
        SEXIS.add(false);

    }

    @Override
    public List<Person> getPersons() {
        List<Person> result = new ArrayList<>();
        for (int i=0; i<1000000; i++) {
            result.add(generateRandomPerson());
        }
        return result;
    }

    public Person generateRandomPerson() {
        Person person = new Person();
        person.telNumber = generateRandomTelephoneNumber();
        person.name = generateRandomName();
        person.surname = generateRandomSurname();
        person.sex = generateRandomSex();
        return person;
    }

    private String generateRandomTelephoneNumber() {
        String result = "";
        for (int i=0; i<11; i++) {
            long randomNumber = Math.round(Math.random() * 9);
            result = result + randomNumber;
        }
        return result;
    }

    private String generateRandomName() {
        return getRandomListElement(NAMES);

    }

    private String generateRandomSurname() {
        return getRandomListElement(SURNAMES);
    }

    private static <T> T getRandomListElement(List<T> list) {
        long randomNumber = Math.round(Math.random() * (list.size()-1));
        return list.get((int) randomNumber);

    }

    private boolean generateRandomSex() {
        return getRandomListElement(SEXIS);
    }

}

