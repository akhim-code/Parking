package org.example.model;

import org.example.exception.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class Parking {
    private String NOM;
    private LinkedList<Vehicule> voitureList = new LinkedList<Vehicule>();
    private LinkedList<Vehicule> motoList = new LinkedList<Vehicule>();
    private LinkedList<Vehicule> veloList = new LinkedList<Vehicule>();

    //Map de nombres de Vehicules dans le Parking par clé couleur
    private HashMap<String, Integer> couleurList = new HashMap<String, Integer>() {{
        put("bleu", 0);
        put("blanc", 0);
        put("noir", 0);
        put("rose", 0);
    }};

    //Les nombres de places initializées aléatoirement dans les limites définis par
    // les constructeurs / et les limites en final
    private int nombrePlaceVoiture;
    private int nombrePlaceMoto;
    private int nombrePlaceVelo;

    //les limites de places en final
    final private int nombrePlaceVoitureMin = 10;
    final private int nombrePlaceMotoMax = 15;
    final private int nombrePlaceMotoMin = 1;
    final private int nombrePlaceVeloMax = 10;
    final private int nombrePlaceVeloMin = 1;


    public Parking(String NOM, int X) throws InvalidXArgumentException, NOMVideException {
        //contrôle des arguments dans le constructeur
        if(NOM.isEmpty()){throw new NOMVideException();}
        else if(X <= nombrePlaceVoitureMin) {throw new InvalidXArgumentException();}
        else {
            //initialization des nombres des places pour chaque type de vehicule
            Random random = new Random();
            this.NOM = NOM;
            this.nombrePlaceVoiture = random.nextInt(nombrePlaceVoitureMin, X);
            this.nombrePlaceMoto = random.nextInt(nombrePlaceMotoMin, nombrePlaceMotoMax);
            this.nombrePlaceVelo = random.nextInt(nombrePlaceVeloMin, nombrePlaceVeloMax);
        }
    }
    public Parking(String NOM, int X, int Y) throws InvalidXArgumentException, InvalidYArgumentException, NOMVideException {
        //contrôle des arguments dans le constructeur
        if(NOM.isEmpty()){throw new NOMVideException();}
        else if(X <= nombrePlaceVoitureMin) {throw new InvalidXArgumentException();}
        else if(Y <= nombrePlaceMotoMin) {throw new InvalidYArgumentException();}
        else {
            //initialization des nombres des places pour chaque type de vehicule
            Random random = new Random();
            this.NOM = NOM;
            this.nombrePlaceVoiture = random.nextInt(nombrePlaceVoitureMin, X);
            this.nombrePlaceMoto = random.nextInt(nombrePlaceMotoMin, Y);
            this.nombrePlaceVelo = random.nextInt(nombrePlaceVeloMin, nombrePlaceVeloMax);
        }
    }
    //Vérifie s'il reste de la place pour le type de véhicule dans le Parking. Si oui, ajoute la véhicule dans la
    //LinkedList associé selon sa type et retourne true. System.out.println la réponse du Parking
    public boolean ajouteVehicule(Vehicule vehicule) throws InvalidTypeVehiculeException {
        String typeVehicule = determineTypeVehicule(vehicule);
        int placeRestant = 0;
        boolean vehiculeAjoute = false;
        switch (typeVehicule) {
            case "voiture":
                if (voitureList.size() < nombrePlaceVoiture) {
                    voitureList.add(vehicule);
                    placeRestant = nombrePlaceVoiture - voitureList.size();
                    vehiculeAjoute = true;
                }
                break;
            case "moto":
                if (motoList.size() < nombrePlaceMoto) {
                motoList.add(vehicule);
                placeRestant = nombrePlaceMoto - motoList.size();
                vehiculeAjoute = true;
            }
                break;
            case "velo":
                if(veloList.size() < nombrePlaceVelo) {
                    veloList.add(vehicule);
                    placeRestant = nombrePlaceVelo - veloList.size();
                    vehiculeAjoute = true;
                }
                break;
        }
        if (vehiculeAjoute) {
            couleurList.put(vehicule.getCouleur(), couleurList.get(vehicule.getCouleur())+1);
            System.out.println("je suis le parking " + NOM + " et je viens d'accepter un(e) " + typeVehicule +
                    ". Il me reste maintenant " + placeRestant + " places pour les " +
                    typeVehicule + "s.");
        }
        else {
            System.out.println("je suis le parking " + NOM + " et je viens de refuser un(e) " + typeVehicule + ".");
        }

        return vehiculeAjoute;
    }

    //Determiner et controller la type de la véhicule
    public String determineTypeVehicule(Vehicule vehicule) throws InvalidTypeVehiculeException {
        if(vehicule instanceof Voiture) {return "voiture";}
        else if(vehicule instanceof Moto) {return "moto";}
        else if(vehicule instanceof Velo) {return "velo";}
        else {
            throw new InvalidTypeVehiculeException();
        }
    }

    //System.out les statistiques du Parking
    public void etatParking() {
        System.out.println("________________________________");
        System.out.println("Parking Voiture: " + voitureList.size() + "/" + nombrePlaceVoiture);
        System.out.println("Parking Moto: " + motoList.size() + "/" + nombrePlaceMoto);
        System.out.println("Parking Velo: " + veloList.size() + "/" + nombrePlaceVelo);
        for(String couleur:couleurList.keySet()) System.out.println(couleurList.get(couleur) + " vehicule(s)" + couleur);
        System.out.println("________________________________");
    }

    //System.out la nombre de Vehicules dans le Parking par couleur
    public void nombreVehiculesAvecCouleur(String couleur) throws InvalidCouleurException {
        if(couleurList.containsKey(couleur)) {System.out.println("je suis le parking " + NOM + " et j'ai " +
                couleurList.get(couleur) + " vehicule(s) " + couleur + "(s) en mon antre.");
        }
        else {throw new InvalidCouleurException();}
    }

    //Verification si toute les places pour les velos sont prises
    public boolean placesVelosRestants() {
        return veloList.size() < nombrePlaceVelo;
    }

    public void setNombrePlaceVoiture(int nombrePlaceVoiture) {
        this.nombrePlaceVoiture = nombrePlaceVoiture;
    }

    public void setNombrePlaceMoto(int nombrePlaceMoto) {
        this.nombrePlaceMoto = nombrePlaceMoto;
    }

    public void setNombrePlaceVelo(int nombrePlaceVelo) {
        this.nombrePlaceVelo = nombrePlaceVelo;
    }
}
