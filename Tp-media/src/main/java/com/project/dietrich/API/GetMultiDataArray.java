package com.project.dietrich.API;

import com.project.dietrich.API.MultiMedia;

public class GetMultiDataArray {
    private int page;
    private MultiMedia[] results;


    public GetMultiDataArray (int page, MultiMedia[] results) {
        this.page = page;
        this.results = results;
    }

    public MultiMedia[] getResults() {
        return results;
    }
}
