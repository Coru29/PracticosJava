package Entidades;

public class Vino {

    public Vino(String nombre, String variedad, String pais, int cosecha) {
        this.nombre = nombre;
        this.variedad = variedad;
        this.pais = pais;
        this.cosecha = cosecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vino vino = (Vino) o;
        return nombre.equals(vino.nombre);
    }

    public String getNombre() {
        return nombre;
    }

    private String nombre;

    private String variedad;

    private String pais;

    private int cosecha;
}
