package geekBrains;

import java.lang.reflect.Array;
import java.util.*;

public class TicTacToe2 {
    /*
    блок настроек игры
     */
    private static char[][] map; // матрица игры
    private static int SIZE = 3;

    private static final char DOT_EMPTY = 'E';
    private static final char DOT_X = 'X';
    private static final char DOT_O = '0';

    private final static boolean SILLY_MODE = false;

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    static int turnCounter = 0;


    public static void main(String[] args) {
        initMap();
        printMap();


        while (true) {
            humanTurn();
            if (isEndGame(DOT_X)) {
                break;
            }

            computerTurn();
            if (isEndGame(DOT_O)) {
                break;
            }
            turnCounter++;

        }
        System.out.println("Игра закончена!");

    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void humanTurn() {
        int x, y;

        do {
            System.out.println("Введите координаты ячейки через пробел:");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));

        map[x][y] = DOT_X;
    }

    private static void computerTurn() {
        int nextTurn = 0;
        int[] axisX = new int[9];
        int[] axisY = new int[9];
        int x = -1;
        int y = -1;
        if (SILLY_MODE) {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValid(x, y));
        } else {
            // Первая часть, выбираем первую свободную клетку слева направо сверху вниз
            if (turnCounter == 0) {
                here:
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (map[i][j] == DOT_EMPTY) {
                            x = i;
                            y = j;
                            break here;
                        }

                    }
                }
            }


            // Вторая часть, обходим клетки если соседняя клетка содержит 0, то ставим в текущую
            if (turnCounter > 0) {
//               here:
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        boolean isLeftTopZero = map[Math.max(0, i - 1)][Math.max(0, j - 1)] == DOT_O;
                        boolean isTopZero = map[Math.max(0, i - 1)][j] == DOT_O;
                        boolean isTopRightZero = map[Math.max(0, i - 1)][Math.min(2, j + 1)] == DOT_O;
                        boolean isLeftZero = map[i][Math.max(0, j - 1)] == DOT_O;
                        boolean isRightZero = map[i][Math.min(2, j + 1)] == DOT_O;
                        boolean isBottomLeftZero = map[Math.min(2, i + 1)][Math.max(0, j - 1)] == DOT_O;
                        boolean isBottomZero = map[Math.min(2, i + 1)][j] == DOT_O;
                        boolean isBottomRightZero = map[Math.min(2, i + 1)][Math.min(2, j + 1)] == DOT_O;

                        boolean isAnyCellZero = isLeftTopZero || isBottomRightZero || isRightZero || isLeftZero || isBottomZero || isTopZero || isBottomLeftZero || isTopRightZero;
                        if (map[i][j] == DOT_EMPTY && isAnyCellZero) {
                          /*  x = i;
                            y = j;*/
                            axisX[nextTurn] = i;
                            axisY[nextTurn] = j;
                            nextTurn++;
                        /*    System.out.println(axisX[i]);
                            System.out.println(axisY[j]);*/
                        
//                            break here;
                        }

                    }

                }
                int randomNextTurn = random.nextInt(nextTurn);
                x = axisX[randomNextTurn];
                y = axisY[randomNextTurn];
                /*System.out.println(Arrays.toString(axisX));
                System.out.println(Arrays.toString(axisY));*/


            }
        }


        System.out.println("Компьютер выбрал ячейку " + (x + 1) + " " + (y + 1));
        map[x][y] = DOT_O;


    }

    private static boolean isCellValid(int x, int y) {
        boolean result = true;

        // проверка координаты
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            result = false;
        }
        // проверка заполненности поля
        if (map[x][y] != DOT_EMPTY) {
            System.out.println("Клетка не пустая!");
            result = false;
        }
        return result;
    }

    private static boolean isEndGame(char playerSymbol) {
        boolean result = false;

        printMap();
        // проверяем необходимость следующего хода
        if (checkWin(playerSymbol)) {
            System.out.println("Победили " + playerSymbol);
            result = true;
        }

        if (isMapFull()) {
            System.out.println("Ничья!");
            result = true;
        }

        return result;
    }

    private static boolean isMapFull() {
        boolean result = true;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY)
                    result = false;
            }

        }
        return result;
    }

    private static boolean checkWin(char playerSymbol) {
        boolean result = false;
        if (
                (map[0][0] == playerSymbol && map[0][1] == playerSymbol && map[0][2] == playerSymbol) ||
                        (map[1][0] == playerSymbol && map[1][1] == playerSymbol && map[1][2] == playerSymbol) ||
                        (map[2][0] == playerSymbol && map[2][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][0] == playerSymbol && map[2][0] == playerSymbol) ||
                        (map[0][1] == playerSymbol && map[1][1] == playerSymbol && map[2][1] == playerSymbol) ||
                        (map[0][2] == playerSymbol && map[1][2] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[2][2] == playerSymbol && map[1][1] == playerSymbol && map[0][2] == playerSymbol)) {
            result = true;
        }

        return result;
    }


}
