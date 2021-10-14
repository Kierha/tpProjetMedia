import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Search {
     void searchByName() {
        int maxLenght = 0;


        System.out.println(Color.resetColor + "\nType the name of a media ?\n" + Color.resetColor);
        String inputToSearch = Main.scanner2.nextLine();
        System.out.println("\nLoading " + inputToSearch + "......\n");
        String urlSearch = "https://api.themoviedb.org/3/search/multi?api_key=cc684f060406396e3845afc82fe9a689&query=";
        if (inputToSearch != null) {
            HttpResponse<JsonNode> reponseSearch = null;
            try {
                reponseSearch = Unirest.get(urlSearch + inputToSearch)
                        .header(urlSearch + inputToSearch, "")
                        .asJson();
            } catch (UnirestException e) {
                e.printStackTrace();
            }
            Gson jsonWithSearch = new GsonBuilder().setPrettyPrinting().create();
            Results results = jsonWithSearch.fromJson(String.valueOf(reponseSearch.getBody()), Results.class);

            //maxLenght = 15;
            if (results.results.length > 15) {
                maxLenght = 15;
            } else if (results.results.length < 15) {
                maxLenght = results.results.length;
            }

            for (int i = 0; i < maxLenght; i++) {
                switch (results.results[i].media_type) {
                    case "tv":
                        System.out.println(Color.green + "ID : " + Color.green + results.results[i].id);
                        System.out.println(Color.green + "Name : " + Color.green + results.results[i].name);
                        System.out.println(Color.green + "Type : " + Color.green + results.results[i].media_type);
                        System.out.println(Color.green + "--------------------------------");
                        break;
                    case "movie":
                        System.out.println(Color.blue + "ID : " + Color.blue + results.results[i].id);
                        System.out.println(Color.blue + "Name : " + Color.blue + results.results[i].original_title);
                        System.out.println(Color.blue + "Type : " + Color.blue + results.results[i].media_type);
                        System.out.println(Color.blue + "--------------------------------");
                        break;
                    default:
                        System.out.println("Erreur");
                        break;
                }
            }
        }
    }


}
