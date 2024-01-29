package org.example.exception;
//Exception quand le NOM est vide dans le constructeur pour un Parking
public class NOMVideException extends Exception{
    public NOMVideException() {
        super("NOM ne peut pas être vide");
    }
}
