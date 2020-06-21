package geekBrains;

public class FeedTheCat {
    public static void main(String[] args) {


//        geekBrains.Cat cat1 = new geekBrains.Cat("Барсик",100);

        Plate plate1 = new Plate(200);

        Cat[] cats = new Cat[6];
        cats[0] = new Cat("Вова", 250);
        cats[1] = new Cat("Дима", 150);
        cats[2] = new Cat("Барсик", 50);
        cats[3] = new Cat("Вова", 120);
        cats[4] = new Cat("Дима", 40);
        cats[5] = new Cat("Барсик", 50);



            for (int i = 0; i < cats.length; i++) {
                boolean isCatEatEnough = false;

                while (!isCatEatEnough) {
                    isCatEatEnough = cats[i].feedCat(plate1);

                    if (isCatEatEnough) {
                        System.out.println("Кот " + cats[i].name + " поел!");

                    }

                }


            }
        System.out.println(cats[2].toString());






    }


}
