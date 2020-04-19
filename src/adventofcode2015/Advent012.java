package adventofcode2015;

/**
 * Created by david on 3/30/2017.
 */
public class Advent012 {
    public static void main(String[] args) {
        String[] fileLines = FileUtils.readFromFile("C:\\Users\\david\\IdeaProjects\\iwilllearnjava\\src\\main\\resources\\Input_021.txt");
        int sum = 0;
        for (String fileLine : fileLines) {
            String[] parts = fileLine.split("x");
            int w = Integer.valueOf(parts[0]);
            int l = Integer.valueOf(parts[1]);
            int h = Integer.valueOf(parts[2]);
            int volume = (w * l * h);
            int perimeter = 0;
            if (w >= l && w >= h) {
                perimeter = 2 * (l + h);
            } else if (l >= w && l >= h) {
                perimeter = 2 * (w + h);
            } else if (h >= w && h >= l) {
                perimeter = 2 * (w  + l);
            }
//            System.out.println(square);

            int result = volume + perimeter;  // result = perimeter + volume;
            sum += result;
            System.out.println(fileLine + " " + volume + " " + perimeter);
        }

        System.out.println(sum);
    }
}
