package com.rullierGwen.android.myapplication.Models;

public class Movie {

    private String titreFilm;
    private String dateSortie;
    private String genre;
    private String description;
    private String realisateur;
    private String acteur;
    private String awards;
    //private String image;

    public String getTitreFilm() {
        return titreFilm;
    }

    public void setTitreFilm(String titreFilm) {
        this.titreFilm = titreFilm;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public String getActeur() {
        return acteur;
    }

    public void setActeur(String acteur) {
        this.acteur = acteur;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }


    public Movie(String titreFilm, String dateSortie, String genre, String description, String realisateur,
                 String acteur, String awards) {
        this.titreFilm = titreFilm;
        this.dateSortie = dateSortie;
        this.genre = genre;
        this.description = description;
        this.realisateur = realisateur;
        this.acteur = acteur;
        this.awards = awards;


    }
}
