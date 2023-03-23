package com.mycompany.app.treasuremap.utils;

import java.util.Arrays;

public class GridViewer {

    public void display(String[][] filledGrid) {
        Arrays.stream(filledGrid)
                .forEach(row -> {
                    System.out.println();
                    Arrays.stream(row).forEach(block -> System.out.print(block + "  "));
                    System.out.println();
                });
    }
}
