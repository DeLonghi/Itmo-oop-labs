package com.company;


import java.util.ArrayList;

public class Catalog {
    private ArrayList<Album> albums;
    private ArrayList<Collection> collections;

    public Catalog() {
        albums = new ArrayList<>();
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public void addCollection(Collection collection) {
        collections.add(collection);
    }

    public void searchArtist(String name) {
        for (int i = 0; i < albums.size(); i++) {
            if (name.equalsIgnoreCase(albums.get(i).getComposer().getComposerName()))
                albums.get(i).showAlbum();
        }
    }

    public void searchGenre(String name) {
        Genre temp = new Genre();
        boolean l = false;
        for (int i = 0; i < albums.size(); i++) {
            if (name.equalsIgnoreCase(albums.get(i).getComposer().getComposerGenre().getGenreName())) {
                temp = albums.get(i).getComposer().getComposerGenre();
                l = true;
                break;
            }
        }
        if (l) {
            for (int i = 0; i < albums.size(); i++) {
                if (temp == albums.get(i).getComposer().getComposerGenre() ||
                        temp.getSubGenres().contains(albums.get(i).getComposer().getComposerGenre()))
                    albums.get(i).showAlbum();
            }
        }
    }

    public void searchYear(int year) {
        for (int i = 0; i < albums.size(); i++) {
            if (albums.get(i).getReleaseYear() == year)
                albums.get(i).showAlbum();
        }
    }

}
