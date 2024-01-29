package org.example.model;

import org.example.exception.CouleurInconnuException;

public class Voiture extends Vehicule {
    public Voiture(String couleur) throws CouleurInconnuException {
        super(couleur);
    }

    //La voiture écrit dans la console une réponse selon la disponibilité de places dans le parking
    @Override
    public void reponse(boolean placeDisponible) {
        if (placeDisponible) {
            System.out.println("vroum! vroum! ma couleur est " + this.couleur + " et je peux rentrer dans le parking.");
        } else {
            System.out.println("zut je ne peux pas rentrer dans le parking.");
        }
    }
}
