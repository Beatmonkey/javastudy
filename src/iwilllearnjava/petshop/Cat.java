package iwilllearnjava.petshop;

/**
 * Created by david on 2/25/2017.
 */
public  class Cat extends Pet implements Tailable {
    int whiskersLength;

    public Cat (String name){
        this(300, name, 0);
    }

    public Cat(int cost, String name, int whiskersLength) {
        super(cost, name);
        this.whiskersLength = whiskersLength;
    }

    @Override
    String talk() {
        return super.talk() + " my whiskers length " + whiskersLength;
    }

    public boolean hasTale() {
        return true;
    }
}
