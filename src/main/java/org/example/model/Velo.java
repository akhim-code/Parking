package org.example.model;

import org.example.exception.CouleurInconnuException;

//Rien a ajouter
public class Velo extends Vehicule{
    public Velo(String couleur) throws CouleurInconnuException {
        super(couleur);
    }
}
