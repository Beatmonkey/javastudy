package differentTasks;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SearchEngine {


    public static void main(String[] args) throws FileNotFoundException {
        String fileDir = "";


        for (int i = 0; i < args.length; i += 2) {
            if (args[i].equals("--data")) {
                fileDir = args[i + 1];
            }

        }
        String[] people = fileReader(fileDir);
        Scanner scannerInt = new Scanner(System.in);
        boolean isActionZero = false;

        while (!isActionZero) {
            System.out.println("=== Menu ===");
            System.out.println("1. Find a person.");
            System.out.println("2. Print all people.");
            System.out.println("0. Exit");


            String action = scannerInt.next();
            switch (action) {
                case "1":
                    findPeople(people);
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

    public static void findPeople(String[] people) {
        System.out.println("Enter a name or email to search all suitable people.");
        Scanner scannerStr = new Scanner(System.in);
        String inputData = scannerStr.next();
        String[] peopleFound = searchByPattern(people, inputData);

        if (peopleFound.length > 0) {
            System.out.println("Found people:");

            for (String personData : peopleFound) {
                System.out.println(personData);

            }
        } else {
            System.out.println("No matching people found.");

        }

    }

    public static void printAllPeople(String[] people) {
        System.out.println("=== List of people ===");
        for (String personData : people) {
            System.out.println(personData);

        }
    }

    public static String[] searchByPattern(String[] people, String inputData) {
        int peopleFoundCounter = 0;
        for (String personData : people) {
            if (formatString(personData).contains(formatString(inputData))) {
                peopleFoundCounter++;
            }

        }
        if (peopleFoundCounter == 0) {
            return new String[peopleFoundCounter];
        }
        String[] peopleFound = new String[peopleFoundCounter];
        int a = 0;
        for (String personData : people) {
            if (formatString(personData).contains(formatString(inputData))) {
                peopleFound[a] = personData;
                a++;
            }

        }
        return peopleFound;

    }


    public static String formatString(String string) {
        return string.toLowerCase().replaceAll(" ", "");
    }


    public static String[] fileReader(String filePath) throws FileNotFoundException {
        FileReader fileReader = new FileReader(filePath);

        List<String> stringsFromFile = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.ready()) {
                String stringFromFile = bufferedReader.readLine();
                stringsFromFile.add(stringFromFile);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return stringsFromFile.toArray(new String[0]);
    }


}