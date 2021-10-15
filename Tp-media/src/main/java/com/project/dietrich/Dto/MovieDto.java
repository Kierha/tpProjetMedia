package com.project.dietrich.Dto;

public class MovieDto {
    private Integer id;
    private String original_title;
    private String overview;
    private Double vote_average;
    private Integer vote_count;

    public Integer getId() {
        return id;
    }

    public String getOriginal_title() {
        return original_title;
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
