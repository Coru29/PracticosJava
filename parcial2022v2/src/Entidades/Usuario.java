package Entidades;

import tads.linkedlist.MyLinkedListImpl;
import tads.linkedlist.MyList;
import tads.queue.MyQueue;

public class Usuario {
    private int cedula;

    MyList<Vino> meGusta = new MyLinkedListImpl<Vino>();
    MyQueue<Vino> meRecomendaron = new MyLinkedListImpl<>();

    public MyQueue<Vino> getMeRecomendaron() {
        return meRecomendaron;
    }

    public MyList<Vino> getMeGusta() {
        return meGusta;
    }


    public Usuario(int cedula) {
        this.cedula = cedula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return cedula == usuario.cedula;
    }

    public int getCedula() {
        return cedula;
    }
}
