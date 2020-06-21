package iwilllearnjava.phonebook;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by david on 3/11/2017.
 */
public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "TestValue1");
        map.put(2, "TestValue2");
        map.put(3, "TestValue3");
        System.out.println(map.get(1));
        System.out.println(map.containsKey(1));
        System.out.println(map.containsValue(5));

        map.put(1, "Hui");
        System.out.println(map.get(1));

        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            System.out.println(key);
        }


        Collection<String> values = map.values();
        for (String value : values) {
            System.out.println(value);
        }
    }
}
