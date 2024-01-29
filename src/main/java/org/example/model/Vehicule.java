package org.example.model;

import org.example.exception.CouleurInconnuException;

public class Vehicule {
    protected String couleur;
    private final String[] couleurList=new String[]{"bleu","blanc","noir","rose"};

    public Vehicule(String couleur) throws CouleurInconnuException {
        this.couleur = couleur;
        //Si la couleur n'est pas dans la liste de couleurs possibles, throw CouleurInconnuException
        if(this.containsCouleur(couleur)) {this.couleur = couleur;}
        else {
            throw new CouleurInconnuException();
        }
    }

    //La véhicule écrit dans la console une réponse selon la disponibilité de places dans le parking
    public void reponse(boolean placeDisponible) {
        if (placeDisponible) {
            System.out.println("chouette, ma couleur est " + couleur + " et je peux rentrer dans le parking.");
        } else {
            System.out.println("zut je ne peux pas rentrer dans le parking.");
        }
    }

    //method pour controller la couleur dans le constructor
    public boolean containsCouleur(String couleur) {
        for (String couleurElem : couleurList) {
            if (couleurElem.equals(couleur)) {
                return true;
            }
        }
        return false;
    }

    public String getCouleur() {
        return couleur;
    }
}
