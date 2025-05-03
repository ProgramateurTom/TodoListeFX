package model;

import Database.Database;

public class Liste {
    private int idListe;
    private String nom;
    private String role;
    public Liste(int idListe, String nom, String role) {
        this.idListe = idListe;
        this.nom = nom;
        this.role = role;
    }
    public Liste(String nom) {this.nom = nom;}
    public int getIdListe() {return idListe;}
    public void setIdListe(int idListe) {this.idListe = idListe;}
    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}
    @Override
    public String toString() {
        return "Liste{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
