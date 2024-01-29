package org.example;

import org.example.exception.*;
import org.example.model.Moto;
import org.example.model.Parking;
import org.example.model.Velo;
import org.example.model.Voiture;

import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    private static String[] typeList = new String[]{"voiture","moto","velo"};
    private static String[] couleurList = new String[]{"bleu","blanc","noir","rose"};
    private static String[] marqueList = new String[]{"HARLEY","SUZUKI"};

    //Génere le Parking; alimente le Parking jusqu'au moment que tout les places pour les velos sont prises.
    // System.out les statistiques du parking
    public static void main(String[] args) {
        Random random = new Random();
        try {
            Parking parking = new Parking("Parking Arkea", 15, 20);
            while(parking.placesVelosRestants()){
                remplitParking(parking, random);
            }
            parking.etatParking();
            //Option pour System.out les nombres de vehicules par couleur
            /*for (String couleur:couleurList) {
                parking.nombreVehiculesAvecCouleur(couleur);
            }*/
        }
        catch (NOMVideException | InvalidYArgumentException | InvalidXArgumentException e){
            e.printStackTrace();
        }
        //Option pour System.out les nombres de vehicules par couleur
        /*catch (InvalidCouleurException e){
            e.printStackTrace();
        }*/

    }
    //Méthode pour alimenter le Parking avec des Vehicules aléatoires
    private static void remplitParking(Parking parking, Random random) {
        try {
            switch (typeList[random.nextInt(3)]) {
                case "voiture": {
                    Voiture voiture = new Voiture(couleurList[random.nextInt(4)]);
                    voiture.reponse(parking.ajouteVehicule(voiture));
                    break;
                }
                case "moto": {
                    Moto moto = new Moto(couleurList[random.nextInt(4)], marqueList[random.nextInt(2)]);
                    moto.reponse(parking.ajouteVehicule(moto));
                    break;
                }
                case "velo": {
                    Velo velo = new Velo(couleurList[random.nextInt(4)]);
                    velo.reponse(parking.ajouteVehicule(velo));
                    break;
                }
            }
        }
        catch (CouleurInconnuException | InvalidTypeVehiculeException | MarqueInconnuException e){
            e.printStackTrace();
        }
    }
}