import Excepciones.EntidadNoExiste;
import Excepciones.EntidadYaExiste;
import tads.queue.EmptyQueueException;

public interface TuVinoMgt<T> {

    void crearVino(String nombre, String variedad, String pais, int cosecha) throws EntidadYaExiste;

    void agregarVinoQueGusta(int cedula, String nombreVino) throws EntidadNoExiste;

    void agregarRecomendacion(int cedula, int cedulaARecomendar, String nombreVino) throws EntidadNoExiste;

    T obtenerProximaRecomendacion(int cedula) throws EmptyQueueException;

    void intercambiarVinos(int cedula, String nombreVino1, String nombreVino2) throws EntidadNoExiste;

    void eliminarOcurrenciasRepetidasVino(int cedula, String nombreVino) throws EntidadNoExiste;




}
