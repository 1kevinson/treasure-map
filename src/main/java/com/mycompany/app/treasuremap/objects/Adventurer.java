package com.mycompany.app.treasuremap.objects;

import com.mycompany.app.treasuremap.enums.Code;
import com.mycompany.app.treasuremap.enums.Orientation;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import static com.mycompany.app.treasuremap.enums.Orientation.*;

@Getter
@SuperBuilder
public final class Adventurer  {

    private final Code code;
    private int abscissa;
    private int ordinate;
    private final String name;
    private final String movements;
    private Orientation orientation;
    private int treasureCollected;

    public void collectTreasure() {
        treasureCollected++;
    }

    public void moveForward() {
        switch (orientation) {
            case NORTH -> ordinate -= 1;
            case EAST -> abscissa += 1;
            case SOUTH -> ordinate += 1;
            case WEST -> abscissa -= 1;
        }
    }

    public void turnLeft() {
        switch (orientation) {
            case NORTH, SOUTH -> orientation = WEST;
            case EAST -> orientation = NORTH;
            case WEST -> orientation = SOUTH;
        }
    }

    public void turnRight() {
        switch (orientation) {
            case NORTH, SOUTH -> orientation = EAST;
            case EAST -> orientation = SOUTH;
            case WEST -> orientation = NORTH;
        }
    }
}
