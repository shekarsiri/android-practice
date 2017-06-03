package com.siri;

class Movie {
    private final String title, genre, year;

    Movie(final String title, final String genre, final String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }

    String getTitle() {
        return title;
    }

    String getGenre() {
        return genre;
    }

    String getYear() {
        return year;
    }
}
