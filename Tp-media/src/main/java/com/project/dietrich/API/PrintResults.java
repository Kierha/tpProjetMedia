package com.project.dietrich.API;

import java.util.ArrayList;
import java.util.List;

public class PrintResults {

    public void printMedias(ArrayList<MultiMedia> listFinal) {
        for (MultiMedia media : listFinal) {

            if (media.getMedia_type().equals("tv")) {
                System.out.println(Color.getGreen() + "ID : " + Color.getGreen() + media.getId());
                System.out.println(Color.getGreen() + "Name : " + Color.getGreen() + media.getName());
                System.out.println(Color.getGreen() + "Type : " + Color.getGreen() + media.getMedia_type());
                System.out.println(Color.getGreen() + "--------------------------------");
            } else if (media.getMedia_type().equals("movie")) {
                System.out.println(Color.getBlue() + "ID : " + Color.getBlue() + media.getId());
                System.out.println(Color.getBlue() + "Name : " + Color.getBlue() + media.getOriginal_title());
                System.out.println(Color.getBlue() + "Type : " + Color.getBlue() + media.getMedia_type());
                System.out.println(Color.getBlue() + "--------------------------------");
            } else {
                System.out.println(Color.getResetColor() + "ID : " + Color.getRed() + media.getId());
                System.out.println(Color.getRed() + "Type : " + Color.getRed() + "Type de média non géré");
                System.out.println(Color.getResetColor() + "--------------------------------");
            }
        }
    }

    public void printResults(List<Media> medias) {

        for (Media oneMedia : medias) {
            if (oneMedia.getId() != 0) {
                if (oneMedia.getMedia_type().equals("movie")) {
                    System.out.println(Color.getBlue() + "\n------- TYPE : MOVIE ------");
                    System.out.println(Color.getBlue() + "ID : " + oneMedia.getId());
                    System.out.println(Color.getBlue() + "Name : " + oneMedia.getName());
                    System.out.println(Color.getBlue() + "Type : " + oneMedia.getMedia_type());
                    System.out.println(Color.getBlue() + "Overview : " + oneMedia.getOverview());
                    System.out.println(Color.getBlue() + "Average : " + oneMedia.getVote_average());
                    System.out.println(Color.getBlue() + "Count : " + oneMedia.getVote_count());
                }
                if (oneMedia.getMedia_type().equals("serie")) {
                    System.out.println(Color.getGreen() + "\n------- TYPE : SERIE ------");
                    System.out.println(Color.getGreen() + "ID : " + oneMedia.getId());
                    System.out.println(Color.getGreen() + "Name : " + oneMedia.getName());
                    System.out.println(Color.getGreen() + "Name : " + oneMedia.getMedia_type());
                    System.out.println(Color.getGreen() + "Overview : " + oneMedia.getOverview());
                    System.out.println(Color.getGreen() + "Average " + oneMedia.getVote_average());
                    System.out.println(Color.getGreen() + "Vote : " + oneMedia.getVote_count());
                }
            }  else {
                System.out.println("Whooops, no correspondance found... Try another ID ");
            }

        }
    }

}
