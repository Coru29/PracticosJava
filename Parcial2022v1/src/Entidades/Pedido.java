package Entidades;

import tads.linkedlist.MyList;

public class Pedido {

    private long cliente;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return cliente == pedido.cliente;
    }


    public Pedido(long cliente, MyList<Producto> productosDeLaClasePedido) {
        this.cliente = cliente;
        this.productosDeLaClasePedido = productosDeLaClasePedido;
    }

    MyList<Producto> productosDeLaClasePedido;


    public long getCliente() {
        return cliente;
    }

}
