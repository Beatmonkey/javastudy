package iwilllearnjava.phonebook;

import java.util.List;

/**
 * Created by david on 3/11/2017.
 */
public interface PersonProvider {
    /**
     * Get the list of all persons.
     * @return
     */
    List<Person> getPersons();
}
