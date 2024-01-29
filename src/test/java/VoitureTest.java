import org.example.exception.*;
import org.example.model.Voiture;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VoitureTest {
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        //Test pour les System.out de la méthode reponse
        @Test
        public void ReponseTest() throws CouleurInconnuException {

            System.setOut(new PrintStream(outputStreamCaptor));
            Voiture voiture = new Voiture("bleu");

            voiture.reponse(true);
            assertEquals("vroum! vroum! ma couleur est bleu et je peux rentrer dans le parking.",
                    outputStreamCaptor.toString().trim());
            outputStreamCaptor.reset();

            voiture.reponse(false);
            assertEquals("zut je ne peux pas rentrer dans le parking.",
                    outputStreamCaptor.toString().trim());
            outputStreamCaptor.reset();
        }
}
