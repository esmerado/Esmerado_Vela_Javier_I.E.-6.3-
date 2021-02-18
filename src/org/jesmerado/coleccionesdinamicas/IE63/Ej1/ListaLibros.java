package org.jesmerado.coleccionesdinamicas.IE63.Ej1;

import java.util.Objects;

public class ListaLibros {

    private String titulo;
    private String autor;
    private int disponible = 0;

    public ListaLibros(String titulo, String autor, int disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = disponible;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int isDisponible() {
        return disponible;
    }

    public void setDisponible(Integer disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "titulo: '" + titulo + '\'' +
                ", autor: '" + autor + '\'' +
                ", disponible: " + disponible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaLibros that = (ListaLibros) o;
        return disponible == that.disponible && titulo.equals(that.titulo) && autor.equals(that.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, disponible);
    }
}
