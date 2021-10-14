import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MakeSearchRequestByName {
    ArrayList<MultiMedia> finalList = new ArrayList<MultiMedia>();
    GetMultiDataArray values;

     protected void searchByName() {
         apiRequestAllMedias();
         finalTableGenerator(values);
         printMedias(finalList);
    }


    private void apiRequestAllMedias() {
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
            values = jsonWithSearch.fromJson(String.valueOf(reponseSearch.getBody()), GetMultiDataArray.class);
        }
    }

    private void finalTableGenerator(GetMultiDataArray values) {
        int j = 0;
        if (values != null) {
            while (j < 15) {
                finalList.add(values.results[j]);
                j++;
            }
        } else {
            System.out.println("Values est vide !");
        }

    }

    private void printMedias(ArrayList<MultiMedia> listFinal) {
        for (MultiMedia media: listFinal){

            if (media.media_type.equals("tv")){
                System.out.println(Color.green + "ID : " + Color.green + media.id);
                System.out.println(Color.green + "Name : " + Color.green + media.name);
                System.out.println(Color.green + "Type : " + Color.green + media.media_type);
                System.out.println(Color.green + "--------------------------------");
            } else if (media.media_type.equals("movie")){
                System.out.println(Color.blue + "ID : " + Color.blue + media.id);
                System.out.println(Color.blue + "Name : " + Color.blue + media.original_title);
                System.out.println(Color.blue + "Type : " + Color.blue + media.media_type);
                System.out.println(Color.blue + "--------------------------------");
            } else {
                System.out.println(Color.blue + "ID : " + Color.blue + media.id);
                System.out.println(Color.blue + "Name : " + Color.blue + media.original_title);
                System.out.println(Color.blue + "Type : " + Color.blue + "Type de média non géré");
                System.out.println(Color.blue + "--------------------------------");
            }
        }
    }




}
