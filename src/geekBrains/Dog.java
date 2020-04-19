package geekBrains;

public class Dog extends Animal  {
    int dogSize;
    int maxDistance = 400;



    public Dog () {
        isCanSwim = true;
        height = 0.5f;
    }


    public Dog (int _maxDistance) {
        this();
        maxDistance = _maxDistance;
    }

}
