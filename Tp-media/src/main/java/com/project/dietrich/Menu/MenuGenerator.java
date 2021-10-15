package com.project.dietrich.Menu;

import com.project.dietrich.API.Color;

public class MenuGenerator {
    public void displayMenu() {
        System.out.println(Color.getYellow() + "\n------------    com.project.dietrich.Menu    ------------" + Color.getYellow());
        System.out.println("1 : Search media by name ");
        System.out.println("2 : Details from ID ");
        System.out.println("3 : Close application ");
        System.out.println(Color.getRed() + "\n||---- Choice: 1 || 2 || 3 ----||\n" + Color.getRed());
    }
}
