package org.example.exception;
//Exception quand l'argument pour la couleur dans la méthode nombreVehiculesAvecCouleur pour Parking
// n'est pas valide
public class InvalidCouleurException extends Exception{
    public InvalidCouleurException() {
        super("La couleur n'est pas valide");
    }
}
