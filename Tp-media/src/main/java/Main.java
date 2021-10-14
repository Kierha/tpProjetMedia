import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Scanner;

public class Main {
    static boolean onMenu = true;
    static Scanner menuChoice = new Scanner(System.in);
    static Scanner scanner2 = new Scanner(System.in);
    static MenuGenerator myMenu = new MenuGenerator();
    static MakeSearchRequestByName search = new MakeSearchRequestByName();
    static MakeDetailRequestByID details = new MakeDetailRequestByID();


    public static void main(String[] args) {

        while (onMenu) {
            myMenu.displayMenu();
            String optionMenu = menuChoice.nextLine();

            switch (optionMenu) {
                case "1" -> search.searchByName();
                case "2" -> details.detailsById();
                case "3" -> myMenu.exitMenu();
            }
        }
    }

    //Gestion erreur//
    static void printError(Exception e) {
        System.out.println(Color.red + e + Color.red);
    }


}
