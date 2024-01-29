import org.example.exception.*;
import org.example.model.Moto;
import org.example.model.Parking;
import org.example.model.Velo;
import org.example.model.Voiture;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingTests {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private Parking parking;
    private HashMap<String, Integer> couleurList = new HashMap<String, Integer>() {{
        put("bleu", 4);
        put("blanc", 1);
        put("noir", 3);
        put("rose", 2);
    }};

    //Test pour les System.out de la méthode ajouteVehicule
    @Test
    public void AjouteVehiculeTest() throws NOMVideException, InvalidXArgumentException,
            CouleurInconnuException, InvalidTypeVehiculeException, MarqueInconnuException {

        System.setOut(new PrintStream(outputStreamCaptor));
        parking = new Parking("Parking", 11);
        parking.setNombrePlaceVoiture(10);
        parking.setNombrePlaceMoto(7);
        parking.setNombrePlaceVelo(5);

        Voiture voiture = new Voiture("bleu");
        Boolean reponseParking = parking.ajouteVehicule(voiture);
        assertEquals("je suis le parking Parking et je viens d'accepter un(e) voiture. Il me reste maintenant"
                        + " 9 places pour les voitures.",
                outputStreamCaptor.toString().trim());
        outputStreamCaptor.reset();

        Moto moto = new Moto("noir", "HARLEY");
        reponseParking = parking.ajouteVehicule(moto);
        assertEquals("je suis le parking Parking et je viens d'accepter un(e) moto. Il me reste maintenant"
                        + " 6 places pour les motos.",
                outputStreamCaptor.toString().trim());
        outputStreamCaptor.reset();

        Velo velo = new Velo("rose");
        reponseParking = parking.ajouteVehicule(velo);
        assertEquals("je suis le parking Parking et je viens d'accepter un(e) velo. Il me reste maintenant"
                        + " 4 places pour les velos.",
                outputStreamCaptor.toString().trim());
        outputStreamCaptor.reset();

        parking.setNombrePlaceVoiture(1);
        parking.setNombrePlaceMoto(1);
        parking.setNombrePlaceVelo(1);

        voiture = new Voiture("blanc");
        reponseParking = parking.ajouteVehicule(voiture);
        assertEquals("je suis le parking Parking et je viens de refuser un(e) voiture.",
                outputStreamCaptor.toString().trim());
        outputStreamCaptor.reset();

        moto = new Moto("bleu", "SUZUKI");
        reponseParking = parking.ajouteVehicule(moto);
        assertEquals("je suis le parking Parking et je viens de refuser un(e) moto.",
                outputStreamCaptor.toString().trim());
        outputStreamCaptor.reset();

        velo = new Velo("noir");
        reponseParking = parking.ajouteVehicule(velo);
        assertEquals("je suis le parking Parking et je viens de refuser un(e) velo.",
                outputStreamCaptor.toString().trim());
        outputStreamCaptor.reset();

    }

    //Test pour les System.out de la méthode nombreVehiculesAvecCouleurTest
    @Test
    public void nombreVehiculesAvecCouleurTest() throws NOMVideException, InvalidXArgumentException,
            InvalidTypeVehiculeException, CouleurInconnuException, MarqueInconnuException, InvalidCouleurException {
        System.setOut(new PrintStream(outputStreamCaptor));
        parking = new Parking("Parking", 11);
        parking.setNombrePlaceVoiture(3);
        parking.setNombrePlaceMoto(3);
        parking.setNombrePlaceVelo(4);
        parking.ajouteVehicule(new Voiture("bleu"));
        parking.ajouteVehicule(new Voiture("bleu"));
        parking.ajouteVehicule(new Voiture("rose"));
        parking.ajouteVehicule(new Moto("noir", "SUZUKI"));
        parking.ajouteVehicule(new Moto("bleu", "SUZUKI"));
        parking.ajouteVehicule(new Moto("noir", "HARLEY"));
        parking.ajouteVehicule(new Velo("bleu"));
        parking.ajouteVehicule(new Velo("noir"));
        parking.ajouteVehicule(new Velo("blanc"));
        parking.ajouteVehicule(new Velo("rose"));
        outputStreamCaptor.reset();

        for (String couleur:couleurList.keySet()) {
                parking.nombreVehiculesAvecCouleur(couleur);
                assertEquals("je suis le parking Parking et j'ai " +
                                couleurList.get(couleur) + " vehicule(s) " + couleur + "(s) en mon antre.",
                    outputStreamCaptor.toString().trim());
                outputStreamCaptor.reset();

            }









    }
}
