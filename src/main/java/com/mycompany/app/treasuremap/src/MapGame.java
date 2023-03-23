package com.mycompany.app.treasuremap.src;

import com.mycompany.app.treasuremap.objects.Adventurer;
import com.mycompany.app.treasuremap.objects.Map;
import com.mycompany.app.treasuremap.objects.Mountain;
import com.mycompany.app.treasuremap.objects.Treasure;
import com.mycompany.app.treasuremap.utils.GridInitializer;
import com.mycompany.app.treasuremap.utils.GridViewer;
import com.mycompany.app.treasuremap.utils.MapConfigurator;
import com.mycompany.app.treasuremap.utils.MapNavigator;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public final class MapGame {

    private String[][] grid;
    private final Map map;
    private final GridInitializer gridInitializer;
    private final GridViewer gridViewer;
    private final MapConfigurator mapConfigurator;
    private final MapNavigator mapNavigator;
    private final Adventurer adventurer;

    public String[][] initEmptyGrid() {
        grid = gridInitializer.init(map);
        return grid;
    }

    public void fillGrid() {
        grid = gridInitializer.fill(initEmptyGrid());
    }

    public void configureGrid(Set<Mountain> mountains, Set<Treasure> treasures) {
        mapConfigurator.locateElementsOnGrid(adventurer, mountains, treasures, grid);
    }

    public void moveAdventurer() {
        mapNavigator.move(adventurer.getMovements(), adventurer, grid);
    }

    public void displayGrid() {
        gridViewer.display(grid);
    }
}
