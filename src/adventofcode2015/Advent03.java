package adventofcode2015;

import java.util.HashSet;


public class Advent03 {
    public static void main(String[] args) {
        String[] fileLines = FileUtils.readFromFile("C:\\Users\\david\\IdeaProjects\\iwilllearnjava\\src\\main\\resources\\Input_03.txt");
        HashSet<House> uniqueHouses = new HashSet<>();
        String line = fileLines[0];
        char[] chars = line.toCharArray();
        int santaX = 0;
        int santaY = 0;
        int roboSantaX = 0;
        int roboSantaY = 0;
        uniqueHouses.add(new House(santaX, santaY));
        for  (int index=0; index < chars.length; index++ ) {
            if (index % 2 != 0) {
                // santa
                if (chars[index] == '>'){
                    santaX = santaX + 1;
                } else if (chars[index] == '<') {
                    santaX = santaX - 1;
                } else if (chars[index] == '^') {
                    santaY = santaY + 1;
                } else if (chars[index] == 'v') {
                    santaY = santaY - 1;
                }
            } else {
                // robo santa
                if (chars[index] == '>') {
                    roboSantaX = roboSantaX + 1;
                } else if (chars[index] == '<') {
                    roboSantaX = roboSantaX - 1;
                } else if (chars[index] == '^') {
                    roboSantaY = roboSantaY + 1;
                } else if (chars[index] == 'v') {
                    roboSantaY = roboSantaY - 1;
                }
            }
            
       /* for (char c: chars) {
            if (c == '^') {
                santaY = santaY + 1;
            } else if (c == '>') {
                santaX = santaX + 1;
            } else if (c == '<') {
                santaX = santaX - 1;
            } else if (c == 'v') {
                santaY = santaY - 1;
            }*/
            uniqueHouses.add(new House(santaX, santaY));
            uniqueHouses.add(new House(roboSantaX, roboSantaY));
        }
        System.out.println(uniqueHouses.size());
    }
    static class House {
        int x;
        int y;

        public House (int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            House house = (House) o;

            if (x != house.x) return false;
            return y == house.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}


