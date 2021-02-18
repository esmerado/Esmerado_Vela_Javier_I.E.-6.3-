package org.jesmerado.coleccionesdinamicas.IE63.Ej1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BMain {
    public static void main(String[] args) {

        ArrayList<ListaLibros> l = new ArrayList<ListaLibros>();
        ArrayList<ListaSocios> s = new ArrayList<ListaSocios>();

        BibliotecaM b = new BibliotecaM(l, s);

        l.add(new ListaLibros("Libro1", "Autor1", 0));
        l.add(new ListaLibros("Libro2", "Autor2", 0));
        l.add(new ListaLibros("Libro3", "Autor3", 0));
        l.add(new ListaLibros("Libro4", "Autor4", 0));
        s.add(new ListaSocios("Socio1", 1));
        s.add(new ListaSocios("Socio2", 2));
        s.add(new ListaSocios("Socio3", 3));
        s.add(new ListaSocios("Socio4", 4));

        b.atenderPeticion();

    }
}
