import java.util.HashMap;

public class MyService implements Service{

    public void doGood() {
        System.out.println("Real doGood");
    }

    public String getResult(String data) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int calculate() {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        for (int i=0; i<1000000; i++) {
            objectObjectHashMap.put(i, i);
        }
        return 0;
    }

}
