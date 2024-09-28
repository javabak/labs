package oop.buildings;

import oop.interfaces.Moveable;

public class MobileHouse extends Building implements Moveable {

    @Override
    public void move(int x, int y) {
        System.out.println("Go to: " + x + ", " + y);
    }
}
