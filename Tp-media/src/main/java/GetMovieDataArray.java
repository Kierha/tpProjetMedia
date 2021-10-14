public class GetMovieDataArray {
    protected int page;
    protected MovieDto[] results;


    public GetMovieDataArray (int page, MovieDto[] results) {
        this.page = page;
        this.results = results;
    }
}
