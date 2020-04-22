package adventofcode2015;


public class Advent01 {
    public static void main(String[] args) {
        String[] fileLines = FileUtils.readFromFile("/Users/macbookpro13/Desktop/Shares/iwilllearnjava/src/main/resources/Input_012.txt");
        String line = fileLines[0];
        char[] chars = line.toCharArray();
        System.out.println();
        if (chars[0] == '(') {
//            System.out.println(true);
        }
        int floorNubmer = 0;
        for (int i=0; i < chars.length; i++ ) {
            if (chars[i] == '(') {
                floorNubmer ++;
            } else if (chars[i] == ')') {
               floorNubmer --;
            }
            if (floorNubmer == -1) {
//                System.out.println(i);
            }
        }
        System.out.println(floorNubmer );
    }
}
