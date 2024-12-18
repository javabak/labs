package oop.units;

import oop.interfaces.Attacker;
import oop.interfaces.Moveable;


public class Archer extends Unit implements Moveable, Attacker {

    @Override
    public void attack(Unit unit) {
        var hp = unit.getHp();
        var damage = unit.getHp() - hp * 0.9;

        if (unit.isAlive()) {
            unit.receiveDamage((float) damage);
            System.out.println(unit.getName() + " got damage " + damage);
        } else {
            System.out.println("Unit is not alive");
        }
    }

    @Override
    public void move(int x, int y) {
        System.out.println("Unit go to: " + x + ", " + y);
    }
}
