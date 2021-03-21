package com.company;

public class Song {
    private  String SongName;
    private double Duration;

    public Song(String SongName, double Duration)
    {
        this.SongName = SongName;
        this.Duration = Duration;
    }

    public String getSongName() {
        return SongName;
    }

    public double getDuration() {
        return Duration;
    }

    public void SongData()
    {
        System.out.println(this.getSongName() + ": " + this.getDuration());
    }
}
