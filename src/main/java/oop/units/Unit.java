package oop.units;

import lombok.*;
import lombok.experimental.FieldDefaults;
import oop.GameObject;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Unit extends GameObject {

    float hp;
    boolean isAlive;

    public boolean isAlive() {
        return hp > 0;
    }

    public float getHp() {
        return hp;
    }

    public void receiveDamage(float damage) {
        this.hp -= damage;
        if (hp < 0) {
            isAlive = false;
        }
    }
}
