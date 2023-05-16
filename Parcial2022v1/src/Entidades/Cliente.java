package Entidades;

import java.util.Objects;

public class Cliente {

    private long cedula;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return cedula == cliente.cedula;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }

    public Cliente(long cedula) {
        this.cedula = cedula;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }
}
