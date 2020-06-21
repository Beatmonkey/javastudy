package geekBrains;

public class Animal {
    String name;
    String color;
    int age;
    int distance;
    double height;
    boolean isCanSwim;

//    static boolean isMaxHeightOrDistanceCorrect = false;

    public void run(int _distance) {
        boolean isCorrect = false;

        if (_distance < distance) {
            isCorrect = true;
        }
        System.out.println(isCorrect);
    }

    public void swim(int _distance) {
        boolean isCorrect = false;

        if (isCanSwim == true) {
            if (_distance < distance) {
                isCorrect = true;
            }
            System.out.println(isCorrect);

        } else {
            System.out.println("Это животное не умеет плавать!");
        }


    }

    public void jump(double _height) {
        boolean isCorrect = false;

        if (_height < height) {
            isCorrect = true;
        }
        System.out.println(isCorrect);

    }

    public Animal() {
        super();
    }
}


