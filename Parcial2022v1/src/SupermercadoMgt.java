import Entidades.Cliente;
import Entidades.Pedido;
import Excepciones.EntidadNoExiste;
import Excepciones.EntidadYaExiste;
import Excepciones.InformacionInvalida;
import tads.linkedlist.MyList;

public interface SupermercadoMgt {
    void agregarProducto(String nombre, float precio) throws EntidadYaExiste;

    void ingresarPedido(long cedula, MyList<String> productos) throws EntidadNoExiste, InformacionInvalida;

    Pedido procesarProximoPedido() throws InformacionInvalida;

    void cancelarPedido(long cedula) throws EntidadNoExiste;

    Cliente obtenerClienteConTicketMasCaro();


}
