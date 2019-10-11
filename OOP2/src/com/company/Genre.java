package com.company;

import java.util.ArrayList;
import java.util.Vector;

public class Genre implements Cloneable {
    private String GenreName;
    private ArrayList<Genre> subGenres;

    public Genre(String name) {
        this.GenreName = name;
        subGenres = new ArrayList<>();
    }
    public Genre() {
        subGenres = new ArrayList<>();
    }

    public void addSubGenre(Genre sg) throws CloneNotSupportedException{
        this.subGenres.add(sg);
    }

    public void addSubGenre(ArrayList<Genre> sg) {
        this.subGenres = sg;
    }

    public String getGenreName() {
        return GenreName;
    }

    public ArrayList<Genre> getSubGenres() {
        return subGenres;
    }

    @Override
    public Genre clone() throws CloneNotSupportedException {
        return (Genre) super.clone();
    }
}
