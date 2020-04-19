package adventofcode2015;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Advent06 {
    public static void main(String[] args) {
        String[] fileLines = FileUtils.readFromFile("/Users/macbookpro13/Desktop/Shares/iwilllearnjava/src/main/resources/Input_5.txt");
        String[][] lightsArray = new String[1000][1000];

        for (int i = 0; i < lightsArray.length; i++) {
            for (int j = 0; j < lightsArray.length; j++) {
                lightsArray[i][j] = "OFF";
            }
        }


        for (String fileName : fileLines ) {
            if (fileName.contains("turn on")) {
                Light light = getCoordinates(fileName);
                for (int i = light.x1; i <= light.x2; i++) {
                    for (int j = light.y1; j <= light.y2; j++) {
                        lightsArray[i][j] = "ON";
                    }
                }

            } else if (fileName.contains("turn off")) {
                Light light = getCoordinates(fileName);
                for (int i = light.x1; i <= light.x2; i++) {
                    for (int j = light.y1; j <= light.y2; j++) {
                        lightsArray[i][j] = "OFF";
                    }
                }

            } else if (fileName.contains("toggle")) {
                Light light = getCoordinates(fileName);
                for (int i = light.x1; i <= light.x2; i++) {
                    for (int j = light.y1; j <= light.y2; j++) {
                        if (lightsArray[i][j] == "OFF") {
                            lightsArray[i][j] = "ON";
                        } else if (lightsArray[i][j] == "ON") {
                            lightsArray[i][j] = "OFF";
                        }
                    }

                }

            }

        }
/*        for (String toggle : fileLines) {
            Light light = getCoordinates(toggle);
            for (int i = light.x1; i <= light.x2; i++) {
                for (int j = light.y1; j <= light.y2; j++) {
                    if (lightsArray[i][j] == "OFF") {
                        lightsArray[i][j] = "ON";
                    } else if (lightsArray[i][j] == "ON") {
                        lightsArray[i][j] = "OFF";
                    }
                }

            }
        }*/

        int howManyLightsLit = 0;
        for (int i = 0; i < lightsArray.length; i++) {
            for (int j = 0; j < lightsArray.length; j++) {
                if (lightsArray[i][j] == "ON") {
                    howManyLightsLit ++;

                }
            }
        }

        System.out.println(howManyLightsLit);


        }

        public static Light getCoordinates(String string) {
            Pattern pattern = Pattern.compile("(turn on|turn off|toggle) (\\d.*),(\\d.*) through (\\d.*),(\\d.*)");
            Matcher matcher = pattern.matcher(string);

            if (matcher.find()) {


            }
            int x1 = Integer.parseInt(matcher.group(2));
            int y1 = Integer.parseInt(matcher.group(3));
            int x2 = Integer.parseInt(matcher.group(4));
            int y2 = Integer.parseInt(matcher.group(5));
            return new Light(x1, y1, x2, y2);
            /*System.out.println(x1 + " " + x2 + " " + y1 + " " + y2);*/





        }
}
