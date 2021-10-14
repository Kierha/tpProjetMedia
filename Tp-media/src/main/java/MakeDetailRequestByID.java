import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class MakeDetailRequestByID {
    MovieDto movieResult;
    SerieMediaDto serieResult;
    Media oneMovie = new Media();
    Media oneSerie = new Media();

    void detailsById() {
        apiRequests();
        mediaObjectGenerator();
        printResults();
    }

    public void apiRequests(){
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
        movieResult = jsonWithIdSearch.fromJson(String.valueOf(response.getBody()), MovieDto.class);

        // SERIE


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
        serieResult = jsonWithIdSearchSerie.fromJson(String.valueOf(serieResponse.getBody()), SerieMediaDto.class);
    }

    public void mediaObjectGenerator(){
        //Movie Object

        oneMovie.id = movieResult.id;
        oneMovie.name = movieResult.original_title;
        oneMovie.type = "movie";
        oneMovie.overview = movieResult.overview;
        oneMovie.vote_average = movieResult.vote_average;
        oneMovie.vote_count = movieResult.vote_count;

        // Serie Object
        oneSerie.id = serieResult.id;
        oneSerie.name = serieResult.name;
        oneSerie.media_type = "serie";
        oneSerie.overview = serieResult.overview;
        oneSerie.vote_average = serieResult.vote_average;
        oneSerie.vote_count = serieResult.vote_count;
    }

    public void printResults() {
        //Movie
        if (oneMovie.id != 0) {
            System.out.println(Color.blue + "\n------- TYPE : MOVIE ------");
            System.out.println(Color.blue + "ID : " + oneMovie.id);
            System.out.println(Color.blue + "Name : " + oneMovie.name);
            System.out.println(Color.blue + "Type : " + oneMovie.type);
            System.out.println(Color.blue + "Overview : " + oneMovie.overview);
            System.out.println(Color.blue + "Average : " + oneMovie.vote_average);
            System.out.println(Color.blue + "Votes : " + oneMovie.vote_count);
        } else {
            System.out.println("Whoops, no correspondance found... Try another ID ");
        }
        //Serie
        System.out.println(Color.resetColor + "\n|---------------------------------------------------------|");
        if (oneSerie.id != 0) {
            System.out.println(Color.green + "\n------- TYPE : SERIE ------");
            System.out.println(Color.green + "ID : " + oneSerie.id);
            System.out.println(Color.green + "Name : " + oneSerie.name);
            System.out.println(Color.green + "Name : " + oneSerie.media_type);
            System.out.println(Color.green + "Overview : " + oneSerie.overview);
            System.out.println(Color.green + "Average " + oneSerie.vote_average);
            System.out.println(Color.green + "Vote : " + oneSerie.vote_count);
        } else {
            System.out.println("Whoops, no correspondance found... Try another ID ");

        }
    }
}
