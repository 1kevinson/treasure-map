package com.mycompany.app.treasuremap;

import com.mycompany.app.treasuremap.src.MapGame;
import com.mycompany.app.treasuremap.utils.GridInitializer;
import com.mycompany.app.treasuremap.utils.GridViewer;
import com.mycompany.app.treasuremap.utils.MapConfigurator;
import com.mycompany.app.treasuremap.utils.MapNavigator;

public class MapApplication {

    public static void main(String[] args) {
        MapGame treasureMapGame = new MapGame(
                MapConfigurator.getMap(),
                new GridInitializer(),
                new GridViewer(),
                new MapConfigurator(),
                new MapNavigator(),
                MapConfigurator.getAdventurer()
        );

        treasureMapGame.fillGrid();
        treasureMapGame.configureGrid(MapConfigurator.getMountains(), MapConfigurator.getTreasures());
        treasureMapGame.moveAdventurer();
        treasureMapGame.displayGrid();
    }
}