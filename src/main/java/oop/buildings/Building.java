package oop.buildings;

import lombok.*;
import lombok.experimental.FieldDefaults;
import oop.GameObject;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Building extends GameObject {

    boolean isBuilt;
}
