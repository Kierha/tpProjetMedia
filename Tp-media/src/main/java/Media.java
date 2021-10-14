public class Media {
    String media_type;
    int id;
    String original_title;
    String overview;
    Double popularity;
    String release_date;
    String name;
    Double vote_average;
    int vote_count;

    public Media(String media_type, int id, String original_title, String overview, Double popularity, String release_date, String name, Double vote_average, int vote_count) {
        this.media_type = media_type;
        this.id = id;
        this.original_title = original_title;
        this.overview = overview;
        this.popularity = popularity;
        this.release_date = release_date;
        this.name = name;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }
}
