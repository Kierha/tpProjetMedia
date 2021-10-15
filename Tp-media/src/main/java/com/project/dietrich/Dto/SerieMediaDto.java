package com.project.dietrich.Dto;

public class SerieMediaDto {
    private Integer id;
    private String name;
    private String overview;
    private Double vote_average;
    private Integer vote_count;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOverview() {
        return overview;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public Integer getVote_count() {
        return vote_count;
    }
}
