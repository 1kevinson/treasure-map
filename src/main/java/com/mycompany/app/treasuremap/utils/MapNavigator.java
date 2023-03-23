package com.mycompany.app.treasuremap.utils;

import com.mycompany.app.treasuremap.enums.Code;
import com.mycompany.app.treasuremap.objects.Adventurer;
import com.mycompany.app.treasuremap.objects.Treasure;

import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class MapNavigator {

    public void move(String movementSequence, Adventurer adventurer, String[][] grid) {
        String[] movements = movementSequence.split("");
        Arrays.stream(movements).forEach(move -> {
            switch (move) {
                case "A" -> {
                    if (isAdventurerFoundTreasure(adventurer, grid)) {
                        adventurer.collectTreasure();
                        int numberOfTreasures = getTreasureQuantity(adventurer, grid);
                        defineNewTreasureQuantity(numberOfTreasures, adventurer, grid);
                    }
                    grid[adventurer.getOrdinate()][adventurer.getAbscissa()] = "[ + ]";
                    adventurer.moveForward();
                }
                case "G" -> adventurer.turnLeft();
                case "D" -> adventurer.turnRight();
            }
        });
        grid[adventurer.getOrdinate()][adventurer.getAbscissa()] = adventurer.getCode() + "(" + adventurer.getTreasureCollected() + ") ";
    }

    private boolean isAdventurerFoundTreasure(Adventurer adventurer, String[][] grid) {
        return grid[adventurer.getOrdinate()][adventurer.getAbscissa()].contains("T");
    }

    private int getTreasureQuantity(Adventurer adventurer, String[][] grid) {
        String treasureBox = grid[adventurer.getOrdinate()][adventurer.getAbscissa()];
        return parseInt(treasureBox.substring(2, 3));
    }

    private void defineNewTreasureQuantity(int oldTreasureQuantity, Adventurer adventurer, String[][] grid) {
        Treasure treasure = new Treasure(Code.TREASURE, adventurer.getAbscissa(), adventurer.getOrdinate(), oldTreasureQuantity - 1);
        grid[treasure.getOrdinate()][treasure.getAbscissa()] = treasure.getCode() + "(" + treasure.getQuantity() + ") ";
    }
}