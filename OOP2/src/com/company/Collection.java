package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Collection {
    private String name;
    private ArrayList<Track> collection;
    private ArrayList<Genre> genres;
    private ArrayList<Composer> artists;

    public Collection(String name) {
        collection = new ArrayList<>();
        genres = new ArrayList<>();
        artists = new ArrayList<>();
        this.name = name;
    }

    public void addAlbum(Album album) {
        for (int i = 0; i < album.getnSong(); i++) {
            collection.add(album.getTrack(i));
        }
        artists.add(album.getComposer());
        genres.add(album.getComposer().getComposerGenre());
        Collections.shuffle(collection);
    }

    public ArrayList<Track> getTracks() {
        return collection;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public ArrayList<Composer> getArtists() {
        return artists;
    }

    public String getName() {
        return name;
    }

    public void show() {
        System.out.println(name);
        for (int i = 0; i < collection.size(); i++)
            System.out.println(i + 1 + "." + " " + collection.get(i).getTrackName());
    }
}
