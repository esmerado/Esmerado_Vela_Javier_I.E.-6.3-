package org.jesmerado.coleccionesdinamicas.IE63.Ej1;

import java.util.ArrayList;
import java.util.Objects;

public class ListaSocios {

    private String nombre;
    private int numCarnet;

    public ListaSocios(String nombre, int numCarnet) {
        this.nombre = nombre;
        this.numCarnet = numCarnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumCarnet() {
        return numCarnet;
    }

    public void setNumCarnet(int numCarnet) {
        this.numCarnet = numCarnet;
    }

    @Override
    public String toString() {
        return "nombre: '" + nombre + '\'' +
                ", numCarnet: " + numCarnet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaSocios that = (ListaSocios) o;
        return numCarnet == that.numCarnet && nombre.equals(that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, numCarnet);
    }
}
