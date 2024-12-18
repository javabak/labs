package structural_patterns.bridge;

public class Bridge {
    public static void main(String[] args) {
        ICar car = new ToyotaCar(new CarBridge());
        car.drive();

        ICar track = new Track(new TrackBridge());
        track.drive();
    }
}

abstract class ICar {
    IBridge iBridge;

    public ICar(IBridge iBridge) {
        this.iBridge = iBridge;
    }

    abstract void drive();
}

abstract class ITrack {
    IBridge iBridge;

    public ITrack(IBridge iBridge) {
        this.iBridge = iBridge;
    }

    abstract void drive();
}


interface IBridge {
    void drive();
}

class CarBridge implements IBridge{
    @Override
    public void drive() {
        System.out.println("drive car");
    }
}

class TrackBridge implements IBridge{
    @Override
    public void drive() {
        System.out.println("drive track");
    }
}

class ToyotaCar extends ICar{

    public ToyotaCar(IBridge iBridge) {
        super(iBridge);
    }

    @Override
    void drive() {
        System.out.println("drive toyota");
    }
}

class Track extends ICar {

    public Track(IBridge iBridge) {
        super(iBridge);
    }

    @Override
    void drive() {
        System.out.println("drive track");
    }
}