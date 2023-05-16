import Excepciones.EntidadNoExiste;
import Excepciones.EntidadYaExiste;
import org.junit.jupiter.api.Test;
import tads.queue.EmptyQueueException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TuVinoImplTest {

    @Test
    void crearVino() {
        TuVinoImpl vinosCoru = new TuVinoImpl();

        try {
            vinosCoru.crearVino("vino1", "variedad1", "uy", 1);
            vinosCoru.crearVino("vino2", "variedad3", "uy", 2);

            assertEquals(2, vinosCoru.vinosRegistrados.size());

        } catch (EntidadYaExiste e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void crearVinoQueYaExiste(){
        TuVinoImpl vinosCoru = new TuVinoImpl();

        try {
            vinosCoru.crearVino("vino1", "variedad1", "uy", 1);
            vinosCoru.crearVino("vino1", "variedad1", "uy", 1);


        } catch (EntidadYaExiste e) {
            assertEquals(1, vinosCoru.vinosRegistrados.size());
        }
    }


    @Test
    void agregarVinoQueGusta() {
        TuVinoImpl vinosCoru = new TuVinoImpl();

        try {
            vinosCoru.crearVino("vino1", "variedad1", "uy", 1);
            vinosCoru.crearVino("vino2", "variedad3", "uy", 2);

            vinosCoru.agregarVinoQueGusta(12345678,"vino2");

            assertEquals(1, vinosCoru.usuariosRegistrados.get(0).getMeGusta().size());

        } catch (EntidadYaExiste | EntidadNoExiste e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void agregarVinoQuegustaNoExiste(){
        TuVinoImpl vinosCoru = new TuVinoImpl();

        try {
            vinosCoru.crearVino("vino1", "variedad1", "uy", 1);
            vinosCoru.crearVino("vino2", "variedad3", "uy", 2);

            vinosCoru.agregarVinoQueGusta(12345678,"vino1");


        } catch (EntidadYaExiste | EntidadNoExiste e) {
            assertEquals(0, vinosCoru.usuariosRegistrados.get(0).getMeGusta().size());

        }
    }

    @Test
    void agregarRecomendacion() {

        TuVinoImpl vinosCoru = new TuVinoImpl();


        try {
            vinosCoru.crearVino("vino1", "variedad1", "uy", 1);
            vinosCoru.crearVino("vino2", "variedad3", "uy", 2);

            vinosCoru.agregarVinoQueGusta(12345678,"vino1");
            vinosCoru.agregarVinoQueGusta(87654321,"vino2");

            vinosCoru.agregarRecomendacion(12345678,87654321,"vino1");

            assertEquals(1, vinosCoru.usuariosRegistrados.get(1).getMeRecomendaron().size());

        } catch (EntidadYaExiste | EntidadNoExiste e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void agregarRecomendacionUsuarioNoExiste (){
        TuVinoImpl vinosCoru = new TuVinoImpl();

        try {
            vinosCoru.crearVino("vino1", "variedad1", "uy", 1);
            vinosCoru.crearVino("vino2", "variedad3", "uy", 2);

            vinosCoru.agregarVinoQueGusta(12345678,"vino1");

            vinosCoru.agregarRecomendacion(12345678,87654321,"vino1");


        } catch (EntidadYaExiste | EntidadNoExiste e) {
            assertEquals(1, vinosCoru.usuariosRegistrados.size());
        }
    }

    @Test
    void obtenerProximaRecomendacion() {
        TuVinoImpl vinosCoru = new TuVinoImpl();


        try {
            vinosCoru.crearVino("vino1", "variedad1", "uy", 1);
            vinosCoru.crearVino("vino2", "variedad3", "uy", 2);

            vinosCoru.agregarVinoQueGusta(12345678,"vino1");
            vinosCoru.agregarVinoQueGusta(87654321,"vino2");

            vinosCoru.agregarRecomendacion(12345678,87654321,"vino1");


            assertEquals("vino1",vinosCoru.obtenerProximaRecomendacion(87654321));
            assertNull(vinosCoru.obtenerProximaRecomendacion(12345678));



        } catch (EntidadYaExiste | EntidadNoExiste | EmptyQueueException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void noHayQueue(){
        TuVinoImpl vinosCoru = new TuVinoImpl();


        try {
            vinosCoru.crearVino("vino1", "variedad1", "uy", 1);
            vinosCoru.crearVino("vino2", "variedad3", "uy", 2);

            vinosCoru.agregarVinoQueGusta(12345678,"vino1");
            vinosCoru.agregarVinoQueGusta(87654321,"vino2");

            vinosCoru.agregarRecomendacion(12345678,87654321,"vino1");


            assertNull(vinosCoru.obtenerProximaRecomendacion(12345678));



        } catch (EntidadYaExiste | EntidadNoExiste | EmptyQueueException e) {
            throw new RuntimeException(e);
        }
    }

}