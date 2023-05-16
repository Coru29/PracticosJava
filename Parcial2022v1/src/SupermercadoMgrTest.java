import Excepciones.EntidadNoExiste;
import Excepciones.EntidadYaExiste;
import Excepciones.InformacionInvalida;
import org.junit.jupiter.api.Test;
import tads.linkedlist.MyLinkedListImpl;
import tads.linkedlist.MyList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SupermercadoMgrTest {

    @Test
    void agregarProducto() {
        SupermercadoMgr superCoru = new SupermercadoMgr();

        try {
            superCoru.agregarProducto("harina", 10);
            superCoru.agregarProducto("pan", 20);
            superCoru.agregarProducto("coca",30);
            assertEquals("harina", superCoru.getProductosRegistrados().get(0).getNombre());
            assertEquals("pan", superCoru.getProductosRegistrados().get(1).getNombre());



        } catch (EntidadYaExiste e) {
            System.out.println(e);
        }


    }

    @Test
    void ingresarPedido() {

        try {
            SupermercadoMgr superCoru2 = new SupermercadoMgr();

            superCoru2.agregarProducto("p1", 20);
            superCoru2.agregarProducto("p2", 30);
            superCoru2.agregarProducto("p3", 10);
            superCoru2.agregarProducto("p4", 40);

            MyList<String> listaDeProductos = new MyLinkedListImpl<>();

            listaDeProductos.add("p1");
            listaDeProductos.add("p2");
            listaDeProductos.add("p3");
            listaDeProductos.add("p4");

            superCoru2.ingresarPedido(12345678,listaDeProductos); //en el caso q sea normal

            assertEquals(1, superCoru2.getPendientesNormal().size());

            SupermercadoMgr superCoru3 = new SupermercadoMgr();

            superCoru3.agregarProducto("p1", 20);
            superCoru3.agregarProducto("p2", 30);
            superCoru3.agregarProducto("p3", 10);
            superCoru3.agregarProducto("p4", 40);

            MyList<String> listaDeProductos2 = new MyLinkedListImpl<>();

            listaDeProductos2.add("p1");
            listaDeProductos2.add("p2");

            superCoru3.ingresarPedido(87654321,listaDeProductos2); //en caso q sea con prioridad
            assertEquals(1, superCoru3.getPendientesPrioritarios().size());


        } catch (InformacionInvalida | EntidadNoExiste | EntidadYaExiste e) {
            throw new RuntimeException(e);
        }

    }
}