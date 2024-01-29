package org.example.exception;
//Exception quand l'argument pour la type de Vehicule dans la méthode determineTypeVehicule pour Parking n'est
//pas valide
public class InvalidTypeVehiculeException extends Exception{
    public InvalidTypeVehiculeException() {
        super("Le type de véhicule n'est pas valide");
    }
}
