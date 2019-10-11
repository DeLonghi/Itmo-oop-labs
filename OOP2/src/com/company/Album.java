package com.company;

import java.util.Arrays;

public class Album {
    private String AlbumName;
    private Composer composer;
    private int nSong;
    private Track[] tracks;
    private int addedTracks;
    private int releaseYear;

    public Album(String name, Composer _composer, int n, int year) {
        this.AlbumName = name;
        this.composer = _composer;
        this.nSong = n;
        this.addedTracks = 0;
        tracks = new Track[n];
        this.releaseYear = year;
    }

    public void addTrack(Track track) throws Exception {
        if (addedTracks == nSong) throw new Exception();
        tracks[addedTracks] = track;
        addedTracks++;
    }

    public void setReleaseYear(int year) {
        this.releaseYear = year;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public Composer getComposer() {
        return composer;
    }

    public Track[] getTracks() {
        return tracks;
    }

    public Track getTrack(int i) {
        return tracks[i];


    }

    public int getnSong() {
        return addedTracks;
    }

    public void showAlbum() {
        System.out.println(composer.getComposerName() + " : " + composer.getComposerGenre().getGenreName());
        System.out.println("@" + AlbumName + "@" + " " + "(" + releaseYear + ")");
        for (int i = 0; i < addedTracks; i++) {
            System.out.println(i + 1 + "." + " " + tracks[i].getTrackName());
        }
        System.out.println("********************************");
    }
}
