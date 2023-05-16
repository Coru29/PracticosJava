import Entidades.Cliente;
import Entidades.Pedido;
import Entidades.Producto;
import Excepciones.EntidadNoExiste;
import Excepciones.EntidadYaExiste;
import Excepciones.InformacionInvalida;
import tads.linkedlist.MyLinkedListImpl;
import tads.linkedlist.MyList;
import tads.queue.EmptyQueueException;
import tads.queue.MyQueue;
import tads.stack.EmptyStackException;
import tads.stack.MyStack;

public class SupermercadoMgr implements SupermercadoMgt{

    // listas para usar en los metodos

    MyList<Producto> productosRegistrados = new MyLinkedListImpl<Producto>();

    MyList<Cliente> clientesConPedidos = new MyLinkedListImpl<Cliente>();

    MyQueue<Pedido> pendientesNormal = new MyLinkedListImpl<Pedido>();

    MyStack<Pedido> pendientesPrioritarios = new MyLinkedListImpl<Pedido>();

    public MyQueue<Pedido> getPendientesNormal() {
        return pendientesNormal;
    }

    public MyStack<Pedido> getPendientesPrioritarios() {
        return pendientesPrioritarios;
    }

    MyList<Producto> prouctosDelPedido = new MyLinkedListImpl<>();

    MyList<Pedido> pedidosFinalizados = new MyLinkedListImpl<>();


// ---------  ---------  ---------  ---------  ---------  ---------  ---------  ---------  ---------  ---------



    public MyList<Producto> getProductosRegistrados() {
        return productosRegistrados;
    }


    @Override
    public void agregarProducto(String nombre, float precio) throws EntidadYaExiste {
        Producto prod = new Producto(nombre,precio);

        if (productosRegistrados.contains(prod)){

            throw new EntidadYaExiste("ya existe, abz");

        }else {
            productosRegistrados.add(prod);
        }

    }

    @Override
    public void ingresarPedido(long cedula, MyList<String> productos) throws EntidadNoExiste, InformacionInvalida {
        Cliente customer = new Cliente(cedula);



        if(clientesConPedidos.contains(customer)){

            throw new InformacionInvalida("el cliente ya tiene productos en procesos");

        }else {
            for(int i = 0; i < productos.size(); i++) {
                for (int x = 0; x < productosRegistrados.size(); x++) {
                    if (productos.get(i).equals(productosRegistrados.get(x).getNombre())) {
                        prouctosDelPedido.add(productosRegistrados.get(x));
                    }
                }
            }
        }
        if(prouctosDelPedido.size() != productos.size()){
            throw new EntidadNoExiste("algun producto no existe");
        }

        Pedido pedidito = new Pedido(cedula,prouctosDelPedido);

        if(prouctosDelPedido.size() >= 3){
            pendientesNormal.enqueue(pedidito); //es una queue xq es un pedido normal


        } else {
            pendientesPrioritarios.push(pedidito); // es un stack xq es un pedido con prioridad
        }

        clientesConPedidos.add(customer);

    }

    @Override
    public Pedido procesarProximoPedido() throws InformacionInvalida {

        if(pendientesPrioritarios.size() == 0 & pendientesNormal.size() == 0) throw new InformacionInvalida("no hay pedidos");

        Pedido pedidoAProcesar = null;

        if(pendientesPrioritarios.size() > 0){
            try{
                pedidoAProcesar = pendientesPrioritarios.pop();
                pedidosFinalizados.add(pedidoAProcesar);

            } catch (EmptyStackException e) {
                throw new RuntimeException(e);
            }
        } else if (pendientesNormal.size() > 0) {
            try {
                pedidoAProcesar = pendientesNormal.dequeue();
                pedidosFinalizados.add(pedidoAProcesar);

            } catch (EmptyQueueException e) {
                throw new RuntimeException(e);
            }
        }

        if(pedidoAProcesar != null) clientesConPedidos.remove((clientesConPedidos.get(-1)));

        return pedidoAProcesar;
    }

    @Override
    public void cancelarPedido(long cedula) throws EntidadNoExiste {
        Cliente tempCliente = new Cliente(cedula);

        if(!clientesConPedidos.contains(tempCliente)) throw new EntidadNoExiste("no existe ese cliente :( ");

        MyList<Pedido> auxPrioridad = new MyLinkedListImpl<>();
        MyList<Pedido> auxNormal = new MyLinkedListImpl<>();

        while (pendientesPrioritarios.size() != 0){
            try {
                auxNormal.add(pendientesNormal.dequeue());

            } catch (EmptyQueueException e) {
                throw new RuntimeException(e);
            }
        }

        while (pendientesPrioritarios.size() != 0){
            try {
                auxPrioridad.add(pendientesPrioritarios.pop());

            } catch (EmptyStackException e) {
                throw new RuntimeException(e);
            }
        }


        for(int i = 0; i<clientesConPedidos.size();  i++){
            if(clientesConPedidos.get(i).equals(tempCliente)){
                clientesConPedidos.remove(tempCliente);
//                MyList<Pedido> auxPedido = new Pedido(cedula,auxPrioridad.get(prouctosDelPedido(i)));

//                auxPrioridad.remove(auxPedido);

            }
        }


    }

    @Override
    public Cliente obtenerClienteConTicketMasCaro() {
        if(pedidosFinalizados.size() == 0) return null;

        Pedido pedidoMasCaro;

//        for (int pedido = 0; pedido<pedidosFinalizados.size(); pedido++)


        return null;
    }
}
