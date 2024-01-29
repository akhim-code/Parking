package org.example.exception;
//Exception quand la couleur dans le constructeur pour une Vehicule n'est pas connue
public class CouleurInconnuException extends Exception{
    public CouleurInconnuException(){super("La couleur de la Vehicule n'est pas connue");}

}
