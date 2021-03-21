package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Album album = new Album("Layla", "Eric Clapton");

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        PrintInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    PrintInstructions();
                    break;
                case 1:
                     AlbumData();
                     break;
                case 2:
                    AddSong();
                    break;
                case 3:
                    RemoveSong();
                    break;
                case 4:
                    FindSong();
                    break;
                case 5:
                    StartPlaylist();
                    break;
                case 6:
                    System.out.println("Thank you for using my app.");
                    quit = true;
                    break;
            }

        }
    }

    public static void PrintInstructions() {
        System.out.println("\nPress: ");
        System.out.println("\t 0 - To print instructions.");
        System.out.println("\t 1 - To print album data.");
        System.out.println("\t 2 - To add a song.");
        System.out.println("\t 3 - To remove a song.");
        System.out.println("\t 4 - To find a song.");
        System.out.println("\t 5 - To start playlist.");
        System.out.println("\t 6 - To quit.");

    }

    public static void AlbumData()
    {
        album.AlbumData();
    }

    public static  void AddSong()
    {
        System.out.println("Enter the name of the song,please.");
        String SongName = scanner.nextLine();
        System.out.println("Enter the duration of the song,please.");
        double SongDuration = scanner.nextDouble();
        scanner.nextLine();
        album.AddSong(SongName,SongDuration);
    }

    public static void RemoveSong()
    {
        System.out.println("Enter the name of the song,plase.");
        String songName = scanner.nextLine();
        album.RemoveSong(songName);
    }

    public static void FindSong()
    {
        System.out.println("Enter the name of the song,please.");
        String songName = scanner.nextLine();
        if(album.FindSong(songName) == true )
            System.out.println("The song exists in the playlist");
        else System.out.println("The song does not exist in the playlist.");
    }

    public static void StartPlaylist()
    {
        album.StartPlaylist();
    }


}
