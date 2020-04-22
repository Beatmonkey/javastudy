package adventofcode2015;


public class Advent02 {
    public static void main(String[] args) {
        String[] fileLines = FileUtils.readFromFile("/Users/macbookpro13/Desktop/Shares/iwilllearnjava/src/main/resources/Input_021.txt");
        int sum = 0;
        for (String fileLine : fileLines) {
            String[] parts = fileLine.split("x");
            int w = Integer.valueOf(parts[0]);
            int l = Integer.valueOf(parts[1]);
            int h = Integer.valueOf(parts[2]);
            int square = (2*w*l) + (2*w*h) + (2*l*h);  // calculate rectangle square
//            System.out.println(square);
            int slack = 0;  // get max of w,l,h and multiplie the other two = slack
            if (w >= l && w >= h) {
                slack = l * h;
            } else if (l >= w && l >= h) {
                slack = w * h;
            } else if (h >= w && h >= l) {
                slack = w * l;
            }
            int result = square + slack;  // result = suqare + slack;
            sum += result;
            System.out.println(fileLine + " " + square + " " + slack);
        }

        System.out.println(sum);
    }
}
