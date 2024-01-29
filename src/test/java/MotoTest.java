import org.example.exception.*;
import org.example.model.Moto;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MotoTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    //Test pour les System.out de la méthode reponse
    @Test
    public void ReponseTest() throws CouleurInconnuException, MarqueInconnuException {

        System.setOut(new PrintStream(outputStreamCaptor));
        Moto moto = new Moto("noir", "SUZUKI");

        moto.reponse(true);
        assertEquals("youpi! ma couleur est noir et je peux rentrer dans le parking.",
                outputStreamCaptor.toString().trim());
        outputStreamCaptor.reset();

        moto.reponse(false);
        assertEquals("hey! je suis une SUZUKI vous allez regretter de ne pas m'avoir laissé entrer.",
                outputStreamCaptor.toString().trim());
        outputStreamCaptor.reset();
    }
}
