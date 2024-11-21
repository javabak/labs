package structural_patterns.adapter;

public class Adapter {
    public static void main(String[] args) {
        IPhone6s iphone6s = new IPhone6s(new Iphone4sTo6sAdapter());
        iphone6s.onCharge();
    }
}

interface IPhone {
    public void onCharge();
}

interface Charger {
    public void charge();
}

class Iphone4sCharger implements Charger
{
    public void charge()
    {
        System.out.println("charging with 4s charger");
    }
}


class Iphone4sTo6sAdapter implements Charger {
    Iphone4sCharger iphone4sCharger;

    Iphone4sTo6sAdapter()
    {
        iphone4sCharger = new Iphone4sCharger();
    }

    @Override
    public void charge()
    {
        iphone4sCharger.charge();
    }
}


class IPhone6s implements IPhone {
    Charger Iphone4sTo6sAdapter;
    public IPhone6s(Charger iphone4sTo6sAdapter)
    {
        this.Iphone4sTo6sAdapter = iphone4sTo6sAdapter;
    };

    @Override
    public void onCharge()
    {
        Iphone4sTo6sAdapter.charge();
    }
}