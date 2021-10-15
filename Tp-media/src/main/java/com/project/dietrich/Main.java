package com.project.dietrich;

import com.project.dietrich.API.*;
import com.project.dietrich.Menu.MenuGenerator;

import java.util.ArrayList;
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

                        System.out.println(Color.getResetColor() + "\nType the name of a media ?\n" + Color.getResetColor());
                        try {
                            String nameInputResearch = scanInput.nextLine();
                            ArrayList<MultiMedia> finalList = search.searchByNameWithArgs(nameInputResearch);
                            printMedias.printMedias(finalList);
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println(Color.getRed() + "ERROR, Please use only characters to make your research !");
                        }
                        break;
                    case "2":
                        System.out.println(Color.getResetColor() + "\nType the ID from a media : ");
                        try {
                            int idInputResearch = scanInput.nextInt();
                            List<Media> medias = details.detailsById(idInputResearch);
                            //  TODO: Print
                            printMedias.printResults(medias);

                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println(Color.getRed() + "ERROR, Please use only numbers to make your research, unhandled value !");
                        }
                        String resetInput = scanInput.nextLine();
                        break;
                    case "3":
                        System.out.println(Color.getRed() + "\nClosing app...");
                        onMenu = false;
                }
            }
        }
    }
}
