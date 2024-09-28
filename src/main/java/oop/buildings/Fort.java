package oop.buildings;

import oop.Attacker;
import oop.units.Unit;


public class Fort extends Building implements Attacker {

    @Override
    public void attack(Unit unit) {
        var hp = unit.getHp();
        var damage = unit.getHp() - hp * 0.7;

        if (unit.isAlive()) {
            unit.receiveDamage((float) damage);
            System.out.println(unit.getName() + " got damage " + damage);
        } else {
            System.out.println("Unit is not alive");
        }
    }
}
