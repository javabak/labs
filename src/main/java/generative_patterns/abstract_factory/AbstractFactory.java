package generative_patterns.abstract_factory;

public class AbstractFactory {
    public static void main(String[] args) {
        Factory carFactory = new AbstractFact().create("car");
        Factory tankFactory = new AbstractFact().create("tank");
        Car toyota = carFactory.createCar("toyota");
        Tank tiger = tankFactory.createTank("tiger");
        tiger.driveTank();
        toyota.drive();
    }
}


interface Car {
    void drive();
}

class Toyota implements Car {
    @Override
    public void drive() {
        System.out.println("driving toyota");
    }
}

class Audi implements Car {
    @Override
    public void drive() {
        System.out.println("driving audi");
    }
}


interface Tank {
    void driveTank();
}

class Tiger implements Tank{
    @Override
    public void driveTank() {
        System.out.println("driving tiger");
    }
}

class T34 implements Tank{
    @Override
    public void driveTank() {
        System.out.println("driving t34");
    }
}


interface Factory {
    Car createCar(String typeOfCar);
    Tank createTank(String typeOfTank);
}


class CarFactory implements Factory {
    public Car createCar(String typeOfCar) {
        switch (typeOfCar) {
            case "audi" : return new Audi();
            case "toyota" : return new Toyota();
            default: return null;
        }
    }

    @Override
    public Tank createTank(String typeOfTank) {
        return null;
    }
}



class TankFactory implements Factory {
    public Tank createTank(String typeOfTank) {
        switch (typeOfTank) {
            case "t34" : return new T34();
            case "tiger" : return new Tiger();
            default: return null;
        }
    }

    @Override
    public Car createCar(String typoOfCar) {
        return null;
    }
}



class AbstractFact {
    public Factory create(String typeOf) {
        switch (typeOf) {
            case "car" : return new CarFactory();
            case "tank" : return new TankFactory();
            default: return null;
        }
    }
}