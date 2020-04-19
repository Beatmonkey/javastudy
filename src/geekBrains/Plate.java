package geekBrains;

public class Plate {
    int currentPlateVolume;
    int maxPlateVolume;

    public Plate(int currentPlateVolume) {
        this.currentPlateVolume = currentPlateVolume;

    }

    public int getCurrentPlateVolume() {
        return this.currentPlateVolume;

    }

    public void setCurrentPlateVolume(int currentPlateVolume) {
        this.currentPlateVolume = currentPlateVolume;
        System.out.println("Миска наполнена на: " + currentPlateVolume);
    }
}

