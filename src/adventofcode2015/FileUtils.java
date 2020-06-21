package adventofcode2015;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileUtils {
    public static String[] readFromFile (String fileName) {
        List<String> list = new ArrayList<>();
        InputStream is = FileUtils.class.getResourceAsStream(fileName);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.toArray(new String[0]);
    }
}
