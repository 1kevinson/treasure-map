package com.mycompany.app.treasuremap.utils;

import com.mycompany.app.treasuremap.objects.Map;

import java.util.Arrays;

public class GridInitializer {

    public String[][] init(Map map) {
        return new String[map.rows()][map.columns()];
    }

    public String[][] fill(String[][] grid) {
        Arrays.stream(grid).forEach(row -> Arrays.fill(row, "[ + ]"));
        return grid;
    }
}
