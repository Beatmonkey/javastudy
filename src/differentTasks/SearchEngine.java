package differentTasks;

import com.sun.nio.sctp.AbstractNotificationHandler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class SearchEngine {


    public static void main(String[] args) throws FileNotFoundException {
        String fileDir = "/Users/macbookpro13/IdeaProjects/javastudy/src/file.txt";


        for (int i = 0; i < args.length; i += 2) {
            if (args[i].equals("--data")) {
                fileDir = args[i + 1];
            }

        }

        SearchingEngine searchingEngine = new SearchingEngine(fileDir);
    }
}

class SearchingEngine {

    Scanner scanner = new Scanner(System.in);
    List<String> people;

    SearchingEngine(String fileDir) throws FileNotFoundException {
        this.people = fileReader(fileDir);
        menu();
    }


    void menu() {
        boolean isActionZero = false;

        while (!isActionZero) {
            System.out.println("=== Menu ===");
            System.out.println("1. Find a person.");
            System.out.println("2. Print all people.");
            System.out.println("0. Exit");


            String action = scanner.next();
            switch (action) {
                case "1":
                    findPeople(invertedIndex(people), people);
                    break;
                case "2":
                    printAllPeople(people);
                    break;
                case "0":
                    System.out.println("Bye!");
                    isActionZero = true;
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
                    break;
            }
        }


    }

    void findPeople(Map<String, List> invertedIndex, List<String> people) {

        System.out.println("Enter a name or email to search all suitable people.");
        String input = scanner.next().toLowerCase();

        List<Integer> listOfIndex = invertedIndex.get(input);

        if (!(listOfIndex == null)) {
            System.out.println("Found people:");
            for (int i = 0; i < listOfIndex.size(); i++) {
                System.out.println(people.get(listOfIndex.get(i)));
            }
        } else {
            System.out.println("No matching people found");
        }
    }

    public List<String> fileReader(String filePath) throws FileNotFoundException {
        FileReader fileReader = new FileReader(filePath);

        List<String> listOfStrings = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.ready()) {
                String stringFromFile = bufferedReader.readLine();
                listOfStrings.add(stringFromFile);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return listOfStrings;
    }

    public void printAllPeople(List<String> people) {
        System.out.println("=== List of people ===");
        for (String personData : people) {
            System.out.println(personData);

        }
    }

    public String formatString(String string) {
        return string.toLowerCase().replaceAll(" ", "");
    }

    public Map<String, List> invertedIndex(List<String> listOfStrings) {


        Map<String, List> invertedMap = new HashMap<>();
        int strNumber = 0;


        for (String line : listOfStrings) {

            String[] wordsInLine = line.toLowerCase().split(" ");
            for (String word : wordsInLine) {
                if (invertedMap.containsKey(word)) {
                    invertedMap.get(word).add(strNumber);
                } else {
                    invertedMap.put(word, new ArrayList<>());
                    invertedMap.get(word).add(strNumber);
                }

            }
            strNumber++;

        }

        return invertedMap;

    }

}













