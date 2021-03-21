package com.Vlad;

import java.util.Locale;

public final class CarnetElev {
    private final int ID;
    private final String numeElev;
    private LimbaRomana limbaRomana;
    private Matematica matematica;
    private Geografie geografie;
    private Informatica informatica;

    public CarnetElev(String numeElev, int ID) {
        this.numeElev = numeElev;
        this.ID = ID;
        this.limbaRomana = new LimbaRomana();
        this.matematica = new Matematica();
        this.geografie = new Geografie();
        this.informatica = new Informatica();
    }

    public LimbaRomana getLimbaRomana() {
        return limbaRomana;
    }

    public Matematica getMatematica() {
        return matematica;
    }

    public Geografie getGeografie() {
        return geografie;
    }

    public Informatica getInformatica() {
        return informatica;
    }

    public int getID() {
        return ID;
    }

    public String getNumeElev() {
        return numeElev;
    }

    //Metoda care calculeaaz media finala(pe tot semestrul, a elevului)

    public int calculeazaMediaFinala() {
        int mediaFinala = 0;
        // Verific daca pot calcula media finala
        if ((this.limbaRomana.calculeazaMedia() != -1) && (this.matematica.calculeazaMedia() != -1) && (this.geografie.calculeazaMedia() != -1) && (this.informatica.calculeazaMedia() != -1)) {
            mediaFinala = ((this.limbaRomana.calculeazaMedia() + this.matematica.calculeazaMedia() + this.geografie.calculeazaMedia() + this.informatica.calculeazaMedia()) / 4);
            //System.out.print("Media finala a elevului " + this.numeElev + " este: ");
            return mediaFinala;
        } else {
            System.out.println("Nu s-a putut calcula media finala a elevului " + this.numeElev);
            return -1;
        }
    }

    //Functie care imi permit "sa scriu o nota in carnetul de elev "

    public void adaugaNota(String materie, int notaMaterie) {
        if (materie.toUpperCase().equals("ROMANA"))
            this.limbaRomana.adaugaNota(notaMaterie);
        else if (materie.toUpperCase().equals("MATEMATICA"))
            this.matematica.adaugaNota(notaMaterie);
        else if (materie.toUpperCase().equals("GEOGRAFIE"))
            this.geografie.adaugaNota(notaMaterie);
        else if (materie.toUpperCase().equals("INFORMATICA"))
            this.informatica.adaugaNota(notaMaterie);
    }

    //Functie care imi permite "sa scriu nota pentru teza "

    public void adaugaNotaTeza(String materie, int notaMaterie) {
        if (materie.toUpperCase().equals("ROMANA"))
            this.limbaRomana.adaugaNotaTeza(notaMaterie);
        else if (materie.toUpperCase().equals("MATEMATICA"))
            this.matematica.adaugaNotaTeza(notaMaterie);
        else if (materie.toUpperCase().equals("GEOGRAFIE"))
            this.geografie.adaugaNotaTeza(notaMaterie);
        else if (materie.toUpperCase().equals("INFORMATICA"))
            this.informatica.adaugaNotaTeza(notaMaterie);
    }

    //Functie care imi permite sa sterg o nota

    public void stergeNota(String materie, int notaMaterie, int indexNota) {
        if (materie.toUpperCase().equals("ROMANA"))
            this.limbaRomana.stergeNota(notaMaterie, indexNota);
        else if (materie.toUpperCase().equals("MATEMATICA"))
            this.matematica.stergeNota(notaMaterie, indexNota);
        else if (materie.toUpperCase().equals("GEOGRAFIE"))
            this.geografie.stergeNota(notaMaterie, indexNota);
        else if (materie.toUpperCase().equals("INFORMATICA"))
            this.informatica.stergeNota(notaMaterie, indexNota);
    }

    //Functie care afiseaza notele la o materie

    public void afiseazaNote(String materie) {
        if (materie.equalsIgnoreCase("ROMANA"))
            System.out.println(this.limbaRomana.getNoteMaterie());
        else if (materie.equalsIgnoreCase("MATEMATICA"))
            System.out.println(this.matematica.getNoteMaterie());
        else if (materie.equalsIgnoreCase("GEOGRAFIE"))
            System.out.println(this.geografie.getNoteMaterie());
        else if (materie.equalsIgnoreCase("INFORMATICA"))
            System.out.println(this.informatica.getNoteMaterie());
    }

    //Functie care imi afiseaza nota in teza la o materie

    public void afiseazaNotaTeza(String materie) {
        if (materie.equalsIgnoreCase("ROMANA"))
            System.out.println(this.limbaRomana.getNotaTeza());
        else if (materie.equalsIgnoreCase("MATEMATICA"))
            System.out.println(this.matematica.getNotaTeza());
        else if (materie.equalsIgnoreCase("GEOGRAFIE"))
            System.out.println(this.geografie.getNotaTeza());
        else if (materie.equalsIgnoreCase("INFORMATICA"))
            System.out.println(this.informatica.getNotaTeza());
    }

    @Override
    public int hashCode() {
        return this.ID * 10;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof CarnetElev))
            return false;

        CarnetElev carnetElev = (CarnetElev) obj;
        return carnetElev.numeElev.equals(this.numeElev) && (carnetElev.ID == this.ID);
    }
}
