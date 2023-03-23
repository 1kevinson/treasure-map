package com.mycompany.app.treasuremap.utils;

import com.mycompany.app.treasuremap.enums.Code;
import com.mycompany.app.treasuremap.enums.Orientation;
import com.mycompany.app.treasuremap.objects.Adventurer;
import com.mycompany.app.treasuremap.objects.Map;
import com.mycompany.app.treasuremap.objects.Mountain;
import com.mycompany.app.treasuremap.objects.Treasure;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public final class MapConfigurator {

    public static final int MAP_ROWS = 6;
    public static final int MAP_COLUMNS = 5;
    public static final String ADVENTURER_MOVEMENT = "AAGAGADDAAD";

    public static Map getMap() {
        return new Map(Code.MAP, MAP_ROWS, MAP_COLUMNS);
    }

    public static Adventurer getAdventurer() {
        return Adventurer.builder()
                .code(Code.ADVENTURER)
                .name("Ingrid")
                .abscissa(1)
                .ordinate(4)
                .orientation(Orientation.NORTH)
                .movements(ADVENTURER_MOVEMENT)
                .build();
    }

    public static Set<Mountain> getMountains() {
        Mountain mountain1 = new Mountain(Code.MOUNTAIN, 1, 0);
        Mountain mountain2 = new Mountain(Code.MOUNTAIN, 2, 1);
        return Set.of(mountain1, mountain2);
    }

    public static Set<Treasure> getTreasures() {
        Treasure treasure1 = new Treasure(Code.TREASURE, 0, 3, 2);
        Treasure treasure2 = new Treasure(Code.TREASURE, 1, 3, 3);
        Treasure treasure3 = new Treasure(Code.TREASURE, 4, 2, 4);
        return Set.of(treasure1, treasure2, treasure3);
    }

    /**
     * X axe is represent by Column | Y axe is represent by Row in 2D Array
     */
    public void locateElementsOnGrid(Adventurer adventurer, Set<Mountain> mountains, Set<Treasure> treasures, String[][] grid) {
        grid[adventurer.getOrdinate()][adventurer.getAbscissa()] =  adventurer.getCode()+ "(" + adventurer.getTreasureCollected() + ") ";
        mountains.forEach(mountain -> grid[mountain.getOrdinate()][mountain.getAbscissa()] = "{ " + mountain.getCode().toString() + " }");
        treasures.forEach(treasure -> grid[treasure.getOrdinate()][treasure.getAbscissa()] = treasure.getCode() + "(" + treasure.getQuantity() + ") ");
    }
}
