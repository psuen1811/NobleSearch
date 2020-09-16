package com.pakfortune;

public class NobleSearch {

    public static void main(String[] arg) {
        // initialize CircularArrayList for shifting elements purpose
        NobleSearchService nobleSearchService = NobleSearchService.getInstance();
        nobleSearchService.getYearlyResult();
        nobleSearchService.getMonthlyResult();
    }
}
