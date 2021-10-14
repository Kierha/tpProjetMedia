import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Details {
    static void detailsById() {

        System.out.println(Color.resetColor + "\nType the ID from a media : ");

        int idInputSearch = Main.scanner2.nextInt();
        System.out.println("\nLoading ID n° " + idInputSearch + " ...");

        //API MOVIE
        String movieSearch = "https://api.themoviedb.org/3/movie/" + idInputSearch + "?api_key=c0caae23e72eec445479c7a837fff962";
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get(movieSearch)
                    .header(movieSearch, "")
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        Gson jsonWithIdSearch = new GsonBuilder().setPrettyPrinting().create();
        Media movieResult = jsonWithIdSearch.fromJson(String.valueOf(response.getBody()), Media.class);

        if (movieResult.id != 0) {
            System.out.println(Color.blue + "\n------- TYPE : MOVIE ------");
            System.out.println(Color.blue + "ID : " + movieResult.id);
            System.out.println(Color.blue + "Name : " + movieResult.original_title);
            System.out.println(Color.blue + "Overview : " + movieResult.overview);
            System.out.println(Color.blue + "Average : " + movieResult.vote_average);
            System.out.println(Color.blue + "Votes : " + movieResult.vote_count);
        } else {
            System.out.println("Whoops, no correspondance found... Try another ID ");
        }


        String serieSearch = "https://api.themoviedb.org/3/tv/" + idInputSearch + "?api_key=c0caae23e72eec445479c7a837fff962";
        HttpResponse<JsonNode> serieResponse = null;
        try {
            serieResponse = Unirest.get(serieSearch)
                    .header(serieSearch, "")
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        Gson jsonWithIdSearchSerie = new GsonBuilder().setPrettyPrinting().create();
        Media serieResult = jsonWithIdSearchSerie.fromJson(String.valueOf(serieResponse.getBody()), Media.class);


        System.out.println(Color.resetColor + "\n|---------------------------------------------------------|");
        if (serieResult.id != 0) {

            System.out.println(Color.green + "\n------- TYPE : SERIE ------");
            System.out.println(Color.green + "ID : " + serieResult.id);
            System.out.println(Color.green + "Name : " + serieResult.name);
            System.out.println(Color.green + "Overview : " + serieResult.overview);
            System.out.println(Color.green + "Average " + serieResult.vote_average);
            System.out.println(Color.green + "Vote : " + serieResult.vote_count);

        } else {
            System.out.println("Whoops, no correspondance found... Try another ID ");

        }

    }
}
