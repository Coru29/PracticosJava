import Entidades.Usuario;
import Entidades.Vino;
import Excepciones.EntidadNoExiste;
import Excepciones.EntidadYaExiste;
import tads.linkedlist.MyLinkedListImpl;
import tads.linkedlist.MyList;
import tads.queue.EmptyQueueException;

public class TuVinoImpl implements TuVinoMgt{

    MyList<Vino> vinosRegistrados = new MyLinkedListImpl<>();

    MyList<Usuario> usuariosRegistrados = new MyLinkedListImpl<>();

    // --------  --------  --------  --------  --------  --------  --------  --------  --------  --------
    @Override
    public void crearVino(String nombre, String variedad, String pais, int cosecha) throws EntidadYaExiste {
        Vino nuevoVino = new Vino(nombre,variedad,pais,cosecha);

        if (vinosRegistrados.contains(nuevoVino)){
            throw new EntidadYaExiste("este vino ya esta registrado");
        } else {
            vinosRegistrados.add(nuevoVino);
        }

    }

    @Override
    public void agregarVinoQueGusta(int cedula, String nombreVino) throws EntidadNoExiste {

        Usuario tempUsuario = new Usuario(cedula);
        Vino tempVino = new Vino(nombreVino, "a", "a", 0);

        if (!usuariosRegistrados.contains(tempUsuario)) usuariosRegistrados.add(tempUsuario);

        if (!vinosRegistrados.contains(tempVino)) throw new EntidadNoExiste("este vino no existe");

        for (int v = 0; v<vinosRegistrados.size();v++){
            if (vinosRegistrados.get(v).equals(tempVino)){
                for(int u = 0; u<usuariosRegistrados.size();u++){
                    if (usuariosRegistrados.get(u).equals(tempUsuario)){
                        usuariosRegistrados.get(u).getMeGusta().add(vinosRegistrados.get(v));
                    }
                }
            }
        }
    }

    @Override
    public void agregarRecomendacion(int cedula, int cedulaARecomendar, String nombreVino) throws EntidadNoExiste{
        Usuario tempUsuarioRecomienda = new Usuario(cedula);
        Usuario tempUsuarioARecomendar = new Usuario(cedulaARecomendar);
        Vino tempVino = new Vino(nombreVino, "a","a", 0);

        if (!vinosRegistrados.contains(tempVino) || !usuariosRegistrados.contains(tempUsuarioRecomienda) || !usuariosRegistrados.contains(tempUsuarioARecomendar)){
            throw new EntidadNoExiste("alguno de los 3 no existe, revisa");
        }

        for (int u = 0; u < usuariosRegistrados.size(); u++) {
            for (int vm = 0; vm < usuariosRegistrados.get(u).getMeGusta().size(); vm++) {
                if(usuariosRegistrados.get(u).getMeGusta().get(vm).equals(tempVino)){
                    for (int ur = 0; ur < usuariosRegistrados.size(); ur++) {
                        if (usuariosRegistrados.get(ur).equals(tempUsuarioARecomendar)){
                            usuariosRegistrados.get(ur).getMeRecomendaron().enqueue(usuariosRegistrados.get(u).getMeGusta().get(vm));
                        }
                    }
                }
            }
        }

    }


    @Override
    public Object obtenerProximaRecomendacion(int cedula) throws EmptyQueueException {
        Usuario tempUsuario = new Usuario(cedula);

        for (int ur = 0; ur < usuariosRegistrados.size(); ur++) {
            if (usuariosRegistrados.get(ur).equals(tempUsuario)){
                if(usuariosRegistrados.get(ur).getMeRecomendaron().size() > 0){
                    try {
                        return usuariosRegistrados.get(ur).getMeRecomendaron().dequeue().getNombre();
                    } catch (EmptyQueueException e) {
                        throw new EmptyQueueException();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void intercambiarVinos(int cedula, String nombreVino1, String nombreVino2) throws EntidadNoExiste {

    }

    @Override
    public void eliminarOcurrenciasRepetidasVino(int cedula, String nombreVino) throws EntidadNoExiste {

    }
}
