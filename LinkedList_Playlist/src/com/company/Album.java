package com.company;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Album {
    private String AlbumName;
    private String ArtistName;
    private LinkedList<Song> songs = new LinkedList<Song>();
    private static int NumberOfSongs;

    public Album(String AlbumName, String AristName) {
        this.AlbumName = AlbumName;
        this.ArtistName = AristName;
        LinkedList<Song> songs = new LinkedList<Song>();
    }

    /******************************************************************************************************/
    // Add a song
    public void AddSong(String SongName, double Duration) {
        System.out.println("The song has been added successfully.");
        this.songs.add(new Song(SongName, Duration));
        NumberOfSongs++;
    }

    public void AddSong(int position, String SongName, double Duration) {
        System.out.println("The song has been added successfully.");
        this.songs.add(position, new Song(SongName, Duration));
        NumberOfSongs++;

    }

    /******************************************************************************************************/
    // Remove a song
    public void RemoveSong(String SongName) {
        if (this.songs.size() == 0) {
            System.out.println("The playlist is empty.");
        } else {
            for (int i = 0; i < this.songs.size(); i++)
                if (this.songs.get(i).getSongName().equals(SongName)) {
                    System.out.println("The song " + SongName + " has been removed successfully.");
                    this.songs.remove(this.songs.get(i));
                }
        }

    }

    /******************************************************************************************************/
    // Find a Song
    public boolean FindSong(String SongName) {
        ListIterator<Song> iterator = this.songs.listIterator();
        boolean checker = false;
        while (iterator.hasNext()) {
            if (iterator.next().getSongName().equals(SongName)) {

                return true;
            }
        }

        return false;
    }

    /******************************************************************************************************/
    // Number of Songs
    public static int getNumberOfSongs() {
        return NumberOfSongs;
    }

    /******************************************************************************************************/
    // Show album data
    public void AlbumData() {
        if (getNumberOfSongs() == 0) {
            System.out.println("The album has no data.");
        } else {
            System.out.println(this.AlbumName + " album has " + getNumberOfSongs() + " tracks: ");
            for (int i = 0; i < this.songs.size(); i++) {
                System.out.print("Track #" + (i + 1) + " ");
                this.songs.get(i).SongData();
            }
        }

    }

    /******************************************************************************************************/
    // Start playlist
    public void StartPlaylist() {
        Scanner scanner = new Scanner(System.in);
        ListIterator<Song> iterator = this.songs.listIterator();
        boolean quit = false;
        int choice = 0;
        boolean goingForward = true;
        if (this.songs.isEmpty())
            System.out.println("The playlist is empty");
        else {
            System.out.println("The playlist is starting...\n");
            System.out.println("Now playing " + iterator.next().getSongName());
        }
        PrintInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    if (!goingForward) {
                        if (iterator.hasNext())
                            iterator.next();

                        goingForward = true;
                    }
                    if (iterator.hasNext()) {
                        System.out.println("Now playing " + iterator.next().getSongName());
                    } else {
                        System.out.println("You reached the end of the playlist.");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (iterator.hasPrevious())
                            iterator.previous();

                        goingForward = false;
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println("Now playing " + iterator.previous().getSongName());
                    } else {
                        System.out.println("You are at the first song.");
                        goingForward = true;
                    }
                    break;
                case 3:
                    System.out.println("The playlist is stopping...");
                    quit = true;
                    break;
            }

        }

    }

    /******************************************************************************************************/
    private void PrintInstructions() {
        System.out.println("\n Press:");
        System.out.println("\t 1 - To go to the next song.");
        System.out.println("\t 2 - To go to the previous song.");
        System.out.println("\t 3 - To stop the playlist.");
    }

}


