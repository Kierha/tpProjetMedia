package com.project.dietrich.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.project.dietrich.Main;

import java.util.ArrayList;

public class MakeSearchRequestByName {
    PrintResults printMedias = new PrintResults();
    ArrayList<MultiMedia> finalList = new ArrayList<MultiMedia>();
    GetMultiDataArray values;

    public void searchByNameWithArgs(String nameInputResearch) {
        apiRequest(nameInputResearch);
        finalTableGenerator(values);
        printMedias.printMedias(finalList);
    }

    public void apiRequest(String nameInputResearch){
        System.out.println("\nLoading " + nameInputResearch + "......\n");
        String urlSearch = "https://api.themoviedb.org/3/search/multi?api_key=cc684f060406396e3845afc82fe9a689&query=";
        if (nameInputResearch != null) {
            HttpResponse<JsonNode> reponseSearch = null;
            try {
                reponseSearch = Unirest.get(urlSearch + nameInputResearch)
                        .header(urlSearch + nameInputResearch, "")
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
                finalList.add(values.getResults()[j]);
                j++;
            }
        } else {
            System.out.println("Values est vide !");
        }

    }


}
