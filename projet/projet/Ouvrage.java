package com.projet;

import java.util.ArrayList;

/**
 * @author Belkalai Mohamed, Boutet Louison, Bigot Loic
 * Cette classe représente un ouvrage. Elle contient en attribut privée :
 * <ul>
 *     <li>le titre</li>
 *     <li>L'auteur</li>
 *     <li>La date sous le format Siècle en chiffre romain</li>
 *     <li>Le nombre de pages</li>
 * </ul>
 * Elle sera notament utiliser par GestionFichier
 * */
public class Ouvrage {
    private String titre = "inconnu";
    private String auteur = "inconnu";
    private String date = "inconnu";
    private ArrayList<String> tag;
    private int nbPage = 0;

    /**
     * C'est le constructeur de cette classe. Il représente la création d'un ouvrage.
     * @param titre,auteur,date,tag,nbPage
     **/
    public Ouvrage(String titre, String auteur, String date, ArrayList<String> tag, int nbPage) {
        this.titre = titre;
        this.auteur = auteur;
        this.date = date;
        this.tag = tag;
        this.nbPage = nbPage;
    }

    //GETTER
    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getDate() {
        return date;
    }


    public ArrayList<String> getTag() {
        return tag;
    }

    /**
     * Cette méthode permet de modifier les tags d'un ouvrage.
     * <ul>
     *     <li>Si le tag existe déjà alors il sera supprimer.</li>
     *     <li>Si le tag n'existe pas alors il sera ajouté.</li>
     * </ul>
     * @param tag
     * @return void
     * */
    public void setTag(String tag) {

    }

    public void setNbPage(int nbPage) {
        this.nbPage = nbPage;
    }
}
