package geekBrains;

public class Cat extends Animal {
    String name;
    int appetite;
    boolean isHungry = true;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isCanSwim = false;
        distance = 200;
        height = 2;

    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", isHungry=" + isHungry +
                '}';
    }

    /**
     * Функция кормит кота из тарелки.
     * @param plate Тарелка с едой из которой ест кот
     * @return true - если кот накормлен, false - если кот не поел
     */
    public boolean feedCat(Plate plate) {
        if (appetite > plate.currentPlateVolume) {
            System.out.println("Текущий объем миски: " + plate.currentPlateVolume + " добавь еще!");

            int quantityPerTime = 100;
            plate.currentPlateVolume += quantityPerTime;
            System.out.println("Добавлено еще " + quantityPerTime + " еды. Текущий объем миски после добавления: " + plate.currentPlateVolume );

        } else {
            plate.currentPlateVolume = plate.currentPlateVolume - appetite;
            this.isHungry = false;

        }
        return !isHungry;

/*        boolean isEatEnough;
        if (isHungry == false) {
            isEatEnough = true;
        } else {
            isEatEnough = false;
        }


        return isEatEnough;*/
    }


}



