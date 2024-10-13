package oop;

import oop.buildings.Fort;
import oop.units.Archer;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer();
        archer.setName("archer");
        archer.setHp(100f);
        archer.setAlive(true);
        archer.setX(0);
        archer.setY(0);

        Fort fort = new Fort();
        fort.setName("fort");
        fort.setX(5);
        fort.setY(7);
        fort.setBuilt(true);


        fort.attack(archer);
        System.out.println("Current hp: " + archer.getHp());

        archer.move(1,3);
    }
}
