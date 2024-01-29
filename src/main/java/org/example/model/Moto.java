package org.example.model;

import org.example.exception.CouleurInconnuException;
import org.example.exception.MarqueInconnuException;

public class Moto extends Vehicule {
    private String marque;
    private final String[] marqueList=new String[]{"HARLEY","SUZUKI"};

    public Moto(String couleur, String marque) throws MarqueInconnuException, CouleurInconnuException {
        super(couleur);

        //Si la marque n'est pas connue, throw MarqueInconnuException.
        if(this.containsMarque(marque)) {this.marque = marque;}
        else {
            throw new MarqueInconnuException();
        }
    }

    //Le moto écrit dans la console une réponse selon la disponibilité de places dans le parking
    @Override
    public void reponse(boolean placeDisponible) {
        if (placeDisponible) {
            System.out.println("youpi! ma couleur est " + this.couleur + " et je peux rentrer dans le parking.");
        } else {
            System.out.println("hey! je suis une " + this.marque + " vous allez regretter de ne pas m'avoir laissé entrer.");
        }
    }

    //method pour controller la marque dans le constructor
    public boolean containsMarque(String marque) {
        for (String marqueElem : marqueList) {
            if (marqueElem.equals(marque)) {
                return true;
            }
        }
        return false;
    }
}

