package differentTasks;


import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystemException;
import java.util.Scanner;

public class TestSC {
    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        //String filename = in.nextLine();
        File file = new File("/Users/macbookpro13/IdeaProjects/javastudy/src/file.txt");
        Searcher searcher = new Searcher(file);
        searcher.showMenu();

    }
    static class Searcher{
        String[] infoArr;
        Scanner in = new Scanner(System.in);

        Searcher(File file){
            int people = 0;
            try(Scanner scanner = new Scanner(file)){
                while (scanner.hasNextLine()){
                    people = people + 1;
                    String text = scanner.nextLine();
                }
                infoArr = new String[people];

                Scanner scanner1 = new Scanner(file);
                for (int i = 0; i< people; i++){
                    infoArr[i] = scanner1.nextLine();
                }
                scanner1.close();

            }catch (FileNotFoundException e ){
                System.out.println("No file found: " + file);
            }
        }

        void findPerson(){
            System.out.println("Enter a name or email to search all suitable people.");
            String person = in.next().trim().toLowerCase();
            boolean found = false;

            for (int i =0; i<infoArr.length;i++){
                if (infoArr[i].toLowerCase().contains(person)){
                    System.out.println(infoArr[i]);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No matching people found.");
            }
            System.out.print("\n");

        }

        public void showMenu() {
            char op;
            do {
                System.out.println("=== Menu ===");
                System.out.println("1. Find a person\n" + "2. Print all people\n" + "0. Exit");

                op = in.next().charAt(0);
                switch (op){
                    case '1':
                        findPerson();
                        break;
                    case '2':
                        printPeople();
                        break;
                    case '0':
                        System.out.println("Bye!");
                        break;
                    default:
                        System.out.println("Incorrect option! Try again.");
                }
            }while (op != '0');

        }

        private void printPeople() {
            if (infoArr.length > 0) {
                System.out.println("=== List of people ===");
                for (int i = 0; i < infoArr.length; i++) {
                    System.out.println(infoArr[i]);
                }
            }else {
                System.out.println("No data available.");
            }
        }
    }
}