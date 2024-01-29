import org.example.exception.*;
import org.example.model.Vehicule;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehiculeTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    //Test pour les System.out de la méthode reponse
    @Test
    public void ReponseTest() throws CouleurInconnuException {

        System.setOut(new PrintStream(outputStreamCaptor));
        Vehicule vehicule = new Vehicule("rose");

        vehicule.reponse(true);
        assertEquals("chouette, ma couleur est rose et je peux rentrer dans le parking.",
                outputStreamCaptor.toString().trim());
        outputStreamCaptor.reset();

        vehicule.reponse(false);
        assertEquals("zut je ne peux pas rentrer dans le parking.",
                outputStreamCaptor.toString().trim());
        outputStreamCaptor.reset();
    }
}
