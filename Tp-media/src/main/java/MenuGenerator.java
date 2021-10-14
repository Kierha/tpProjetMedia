public class MenuGenerator {
     void displayMenu(){
        System.out.println(Color.yellow + "\n------------    Menu    ------------" + Color.yellow);
        System.out.println("1 : Search media by name ");
        System.out.println("2 : Details from ID ");
        System.out.println("3 : Close application ");
        System.out.println(Color.red + "\n||---- Choice: 1 || 2 || 3 ----||\n" + Color.red);
    }

    void exitMenu(){
        System.out.println(Color.red + "\nClosing app...");
        Main.onMenu = false;
    }
}
