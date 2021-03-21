package com.Vlad;

import java.util.ArrayList;
import java.util.List;

public abstract class Materie {
    private final String numeMaterie;
    private final List<Integer> noteMaterie;
    private int notaTeza;

    public Materie(String numeMaterie) {
        this.numeMaterie = numeMaterie;
        this.noteMaterie = new ArrayList<>();
        this.notaTeza = 0;
    }

    public int getNotaTeza() {
        return notaTeza;
    }

    public String getNumeMaterie() {
        return numeMaterie;
    }

    public List<Integer> getNoteMaterie() {
       // System.out.println("Notele la disciplina " + this.numeMaterie + " sunt: ");
        return noteMaterie;
    }

    //Functie care intoarce media notelor la materia respectiva

    public final int calculeazaMedia() {
        int mediaNotelor = 0;
        if (this.noteMaterie.size() == 0) {
           // System.out.println("Nu exista note la materia " + this.numeMaterie);
            return -1;
        } else if(this.getNotaTeza() == 0) {
           // System.out.println("Nu se poate calcula media finala la aceasta materie");
            return -1;
        }
        else {
            for (Integer nota : this.noteMaterie)
                mediaNotelor += nota;
        }
       // System.out.print("Media la materia " + this.numeMaterie + " este: ");
        mediaNotelor =   ( ( ( mediaNotelor / (this.noteMaterie.size()) ) * 3 + this.getNotaTeza() ) /4 );
        return mediaNotelor;
    }

    //Functie care imi permite sa adaug nota pentru teza
    // Le-am facut protected pentru siguranta

    public final void adaugaNotaTeza(int notaTeza) {
        this.notaTeza = notaTeza;
    }

    //Functie care imi permite sa adaug o nota

    public final void adaugaNota(int notaMaterie) {
        this.noteMaterie.add(notaMaterie);
    }

    //Functie care imi permite sa sterg o nota

    public final void stergeNota(int notaMaterie, int indexNota) {
        if (this.noteMaterie.size() == 0)
            System.out.println("Nu exista note la materia " + this.numeMaterie);
        else {
            for(Integer nota : this.noteMaterie)
                if ((nota == notaMaterie) && (this.noteMaterie.indexOf(nota) == indexNota))
                    this.noteMaterie.remove(indexNota);
        }
    }




}
