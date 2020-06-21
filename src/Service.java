public interface Service {

    @Loggable
    @Measure
    void doGood();

    @Measure
    String getResult(String data);

    @Measure
    int calculate();
}
