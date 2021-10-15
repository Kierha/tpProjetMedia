package com.project.dietrich.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.project.dietrich.Dto.MovieDto;
import com.project.dietrich.Dto.SerieMediaDto;

import java.util.ArrayList;
import java.util.List;

public class MakeDetailRequestByID {
    MovieDto movieResult;
    SerieMediaDto serieResult;
    Media oneMovie = new Media();
    Media oneSerie = new Media();
    PrintResults printMedias = new PrintResults();

    public List<Media> detailsById(int idInputResearch) {
        apiRequests(idInputResearch);
        mediaObjectGenerator(movieResult, serieResult);
        List<Media> medias = new ArrayList<>();
        medias.add(oneMovie);
        medias.add(oneSerie);
        return medias;
        //printMedias.printResults(oneMovie, oneSerie);
    }

    private void apiRequests(int idInputResearch) {

        System.out.println("\nLoading ID n° " + idInputResearch + " ...");

        //com.project.dietrich.API MOVIE
        String movieSearch = "https://api.themoviedb.org/3/movie/" + idInputResearch + "?api_key=c0caae23e72eec445479c7a837fff962";
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

        String serieSearch = "https://api.themoviedb.org/3/tv/" + idInputResearch + "?api_key=c0caae23e72eec445479c7a837fff962";
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

    private void mediaObjectGenerator(MovieDto movieResult, SerieMediaDto serieResult) {
        //Movie Object
        oneMovie.setId(movieResult.getId());
        oneMovie.setName(movieResult.getOriginal_title());
        oneMovie.setMedia_type("movie");
        oneMovie.setOverview(movieResult.getOverview());
        oneMovie.setVote_average(movieResult.getVote_average());
        oneMovie.setVote_count(movieResult.getVote_count());

        // Serie Object
        oneSerie.setId(serieResult.getId());
        oneSerie.setName(serieResult.getName());
        oneSerie.setMedia_type("serie");
        oneSerie.setOverview(serieResult.getOverview());
        oneSerie.setVote_average(serieResult.getVote_average());
        oneSerie.setVote_count(serieResult.getVote_count());
    }
}
