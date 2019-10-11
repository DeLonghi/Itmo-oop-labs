package com.company;

public class Track {
    private String TrackName;
    private short duration;

    public Track(String name, short _duration) {
        this.TrackName = name;
        this.duration = _duration;
    }

    public Track(String name) {
        this.TrackName = name;
    }

    public String getTrackName(){
        return this.TrackName;
    }

    public short getDuration(){
        return this.duration;
    }
}
