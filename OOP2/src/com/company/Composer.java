package com.company;

public class Composer {
    private String ComposerName;
    private Genre ComposerGenre;

    public Composer(String name, Genre genre) {
        this.ComposerName = name;
        this.ComposerGenre = genre;
    }

    public Composer(String name) {
        this.ComposerName = name;
    }

    public Composer(Genre genre) {
        this.ComposerGenre = genre;
    }

    public void setComposerName(String name) {
        this.ComposerName = name;
    }

    public void setComposerGenre(Genre genre) {
        this.ComposerGenre = genre;
    }

    public String getComposerName() {
        return ComposerName;

    }

    public Genre getComposerGenre() {
        return ComposerGenre;
    }
}
