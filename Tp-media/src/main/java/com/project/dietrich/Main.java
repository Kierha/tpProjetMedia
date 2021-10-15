package com.project.dietrich;

import com.project.dietrich.API.*;
import com.project.dietrich.Menu.MenuGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Initialisation
    static boolean onMenu = true;
    static Scanner menuChoice = new Scanner(System.in);
    static Scanner scanInput = new Scanner(System.in);
    static MenuGenerator myMenu = new MenuGenerator();
    static MakeSearchRequestByName search = new MakeSearchRequestByName();
    static MakeDetailRequestByID details = new MakeDetailRequestByID();
    static PrintResults printMedias = new PrintResults();


    public static void main(String[] args) {
        if (args.length > 1) {
            if (args[0].equals("--search")) {
                search.searchByNameWithArgs(args[1]);
            } else if (args[0].equals("--detail")) {
                int argsToInt = Integer.parseInt(args[1]);
                List<Media> medias = details.detailsById(argsToInt);
                // TODO: print
                printMedias.printResults(medias);
            } else {
                System.out.println("Non reconnu");
            }
        } else {
            while (onMenu) {
                myMenu.displayMenu();
                String optionMenu = menuChoice.nextLine();
                switch (optionMenu) {

                    case "1":
                        try {

                            System.out.println(Color.getResetColor() + "\nType the name of a media ?\n" + Color.getResetColor());
                            String nameInputResearch = scanInput.nextLine();
                            search.searchByNameWithArgs(nameInputResearch);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        break;
                    case "2":
                        System.out.println(Color.getResetColor() + "\nType the ID from a media : ");
                        int idInputResearch = scanInput.nextInt();
                        List<Media> medias = details.detailsById(idInputResearch);
                        //  TODO: Print
                        String resetInput = scanInput.nextLine();
                        break;
                    case "3":
                        System.out.println(Color.getRed() + "\nClosing app...");
                        onMenu = false;
                }
            }
        }

    }

    //Gestion erreur//
    static void printError(Exception e) {
        System.out.println(Color.getRed() + e + Color.getRed());
    }


}
