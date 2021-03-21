package com.Vlad;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegistruMatricol {
    private static List<CarnetElev> RegistruMatricol = new ArrayList<CarnetElev>();


    public static void main(String[] args) throws IOException {

        try(FileWriter mihaitaPiticu = new FileWriter("SituatieFinala.txt")){
        for(CarnetElev carnetElev : RegistruMatricol)
        {
            mihaitaPiticu.write("Elevul " + carnetElev.getNumeElev() + " cu ID-ul " + carnetElev.getID() + " are urmatoarea situatie scoalara: \n");
            mihaitaPiticu.write("Media finala la " + carnetElev.getLimbaRomana().getNumeMaterie() + " este: " + carnetElev.getLimbaRomana().calculeazaMedia() + "\n");
            mihaitaPiticu.write("Media finala la " + carnetElev.getMatematica().getNumeMaterie() + " este: " + carnetElev.getMatematica().calculeazaMedia() + "\n");
            mihaitaPiticu.write("Media finala la " + carnetElev.getInformatica().getNumeMaterie() + " este: " + carnetElev.getInformatica().calculeazaMedia() + "\n");
            mihaitaPiticu.write("Media finala la " + carnetElev.getGeografie().getNumeMaterie() + " este: " + carnetElev.getGeografie().calculeazaMedia() + "\n");
            mihaitaPiticu.write("Toate acestea ducand la o medie finala de: " + carnetElev.calculeazaMediaFinala() + "\n");

        }
        }
    }

    static {
        Scanner scanner = null;
        try {

            scanner = new Scanner(new FileReader("DateElevi.txt"));

            while (scanner.hasNext()) {

                String numeElev = scanner.next();

                int elevId = scanner.nextInt(); // o sa atribuie astuia un String deci solutia a fost sa interschimb numeElev cu elevId


                CarnetElev elev = new CarnetElev(numeElev, elevId);


                String materie = scanner.next();


                int numarMaterii = 4;
                int contor = 0;

                while (contor <= numarMaterii) {

                    if (materie.equalsIgnoreCase("MATEMATICA")) { // E OK
                        int index = 1;
                        while (scanner.hasNextInt()) {
                            if (index == 1) {
                                int notaTeza = scanner.nextInt();
                                elev.adaugaNotaTeza(materie, notaTeza);
                                index++;
                            }
                            int nota = scanner.nextInt();
                            elev.adaugaNota(materie, nota);
                        }
                        contor++;
                        //System.out.println(contor);
                        if(contor < numarMaterii)
                        {
                            materie = scanner.next();
                           // System.out.println(materie);
                           // System.out.println("****************");
                        }
                        else {
                            contor++;
                        }
                    }


                        // AICI ERA PROBLEMA !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                        //dupa ce iesea din loop pt ca nu mai avea numere, urma o valoare String pe care trebuia sa o atribui,altfel dadea crash
                        //ca s-ar fi dus si ar fi pus o in valorile de la inceput




                    if (materie.equalsIgnoreCase("ROMANA")) {
                        int index = 1;
                        while (scanner.hasNextInt()) {
                            if (index == 1) {
                                int notaTeza = scanner.nextInt();
                                elev.adaugaNotaTeza(materie, notaTeza);
                                index++;
                            }
                            int nota = scanner.nextInt();
                            elev.adaugaNota(materie, nota);
                        }
                        contor++;
                        //System.out.println(contor);
                        if(contor < numarMaterii)
                        {
                            materie = scanner.next();
                            //System.out.println(materie);
                           // System.out.println("****************");
                        }
                        else {
                            contor++;
                        }

                    }

                        //materie = scanner.next(); // AICI ERA PROBLEMA !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


                    if (materie.equalsIgnoreCase("GEOGRAFIE")) {
                        int index = 1;
                        while (scanner.hasNextInt()) {
                            if (index == 1) {
                                int notaTeza = scanner.nextInt();
                                elev.adaugaNotaTeza(materie, notaTeza);
                                index++;
                            }
                            int nota = scanner.nextInt();
                            elev.adaugaNota(materie, nota);
                        }
                        contor++;
                       // System.out.println(contor);
                        if(contor < numarMaterii)
                        {
                            materie = scanner.next();
                           // System.out.println(materie);
                            //System.out.println("****************");
                        }
                        else {
                            contor++;
                        }
                    }
                       // materie = scanner.next(); // AICI ERA PROBLEMA !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!



                    if (materie.equalsIgnoreCase("INFORMATICA")) {
                        int index = 1;
                        while (scanner.hasNextInt()) {
                            if (index == 1) {
                                int notaTeza = scanner.nextInt();
                                elev.adaugaNotaTeza(materie, notaTeza);
                                index++;
                            }
                            int nota = scanner.nextInt();
                            elev.adaugaNota(materie, nota);
                        }
                        contor++;
                        //System.out.println(contor);
                        if(contor < numarMaterii)
                        {
                            materie = scanner.next();
                           // System.out.println(materie);
                            //System.out.println("****************");
                        }else {
                            contor++;
                        }


                    }




                        //materie = scanner.next(); // AICI ERA PROBLEMA !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

                    //Cand iesea de aici era problema ca (loop ul) lua si valoarea pentru id ul elevului si abia apoi zicea ca este fals si
                    //iesea din loop,dupa care   int elevId = scanner.nextInt(); ii se atributa un string si dadea programul crash


                }
                RegistruMatricol.add(elev);
            }
        } catch (IOException | ExceptionInInitializerError e) {
            e.printStackTrace();
        } finally {
            if (scanner != null)
                scanner.close(); // Inchid stream-ul
        }

    }


    /********************************************************************************************************************************
  /*   static {
        Scanner scanner = null;
        try {

            scanner = new Scanner(new FileReader("DateElevi.txt"));

            while (scanner.hasNext()) {

                String numeElev = scanner.next();

                int elevId = scanner.nextInt(); // o sa atribuie astuia un String deci solutia a fost sa interschimb numeElev cu elevId


                CarnetElev elev = new CarnetElev(numeElev, elevId);


                String materie = scanner.next();


                int numarMaterii = 4;
                int contor = 0;

                while (contor <= numarMaterii) {

                    if (materie.equalsIgnoreCase("MATEMATICA")) { // E OK
                        int index = 1;
                        while (scanner.hasNextInt()) {
                            if (index == 1) {
                                int notaTeza = scanner.nextInt();
                                elev.adaugaNotaTeza(materie, notaTeza);
                                index++;
                            }
                            int nota = scanner.nextInt();
                            elev.adaugaNota(materie, nota);
                        }
                        contor++;
                        System.out.println(contor);
                        if(contor < numarMaterii)
                        {
                            materie = scanner.next();
                            System.out.println(materie);
                            System.out.println("****************");
                        }
                        else {
                            contor++;
                        }
                    }


                        // AICI ERA PROBLEMA !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                        //dupa ce iesea din loop pt ca nu mai avea numere, urma o valoare String pe care trebuia sa o atribui,altfel dadea crash
                        //ca s-ar fi dus si ar fi pus o in valorile de la inceput




                    if (materie.equalsIgnoreCase("ROMANA")) {
                        int index = 1;
                        while (scanner.hasNextInt()) {
                            if (index == 1) {
                                int notaTeza = scanner.nextInt();
                                elev.adaugaNotaTeza(materie, notaTeza);
                                index++;
                            }
                            int nota = scanner.nextInt();
                            elev.adaugaNota(materie, nota);
                        }
                        contor++;
                        System.out.println(contor);
                        if(contor < numarMaterii)
                        {
                            materie = scanner.next();
                            System.out.println(materie);
                            System.out.println("****************");
                        }
                        else {
                            contor++;
                        }

                    }

                        //materie = scanner.next(); // AICI ERA PROBLEMA !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


                    if (materie.equalsIgnoreCase("GEOGRAFIE")) {
                        int index = 1;
                        while (scanner.hasNextInt()) {
                            if (index == 1) {
                                int notaTeza = scanner.nextInt();
                                elev.adaugaNotaTeza(materie, notaTeza);
                                index++;
                            }
                            int nota = scanner.nextInt();
                            elev.adaugaNota(materie, nota);
                        }
                        contor++;
                        System.out.println(contor);
                        if(contor < numarMaterii)
                        {
                            materie = scanner.next();
                            System.out.println(materie);
                            System.out.println("****************");
                        }
                        else {
                            contor++;
                        }
                    }
                       // materie = scanner.next(); // AICI ERA PROBLEMA !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!



                    if (materie.equalsIgnoreCase("INFORMATICA")) {
                        int index = 1;
                        while (scanner.hasNextInt()) {
                            if (index == 1) {
                                int notaTeza = scanner.nextInt();
                                elev.adaugaNotaTeza(materie, notaTeza);
                                index++;
                            }
                            int nota = scanner.nextInt();
                            elev.adaugaNota(materie, nota);
                        }
                        contor++;
                        System.out.println(contor);
                        if(contor < numarMaterii)
                        {
                            materie = scanner.next();
                            System.out.println(materie);
                            System.out.println("****************");
                        }else {
                            contor++;
                        }


                    }




                        //materie = scanner.next(); // AICI ERA PROBLEMA !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

                    //Cand iesea de aici era problema ca (loop ul) lua si valoarea pentru id ul elevului si abia apoi zicea ca este fals si
                    //iesea din loop,dupa care   int elevId = scanner.nextInt(); ii se atributa un string si dadea programul crash


                }
                RegistruMatricol.add(elev);
            }
        } catch (IOException | ExceptionInInitializerError e) {
            e.printStackTrace();
        } finally {
            if (scanner != null)
                scanner.close(); // Inchid stream-ul
        }

    }
    */
}

