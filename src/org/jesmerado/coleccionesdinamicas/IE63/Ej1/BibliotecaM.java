package org.jesmerado.coleccionesdinamicas.IE63.Ej1;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;

public class BibliotecaM {

    Scanner sc = new Scanner(System.in);
    ArrayList<ListaLibros> lLibros;
    ArrayList<ListaSocios> lSocios;


    public BibliotecaM(ArrayList<ListaLibros> lLibros, ArrayList<ListaSocios> lSocios) {
        this.lLibros = lLibros;
        this.lSocios = lSocios;
    }

    public BibliotecaM() {
    }

    public void añadirLibro(){
        int cont = 1;
        int numL = 0;
            try{
                System.out.println("Cuántos libros desea añadir??");
                numL = sc.nextInt();
            }catch (Exception e){
                System.err.println("¡¡Debe introducir un número!!");
                System.exit(1);
            }

        if (lLibros.isEmpty()){
            System.out.println("No hay ningún libro añadido!!");
            System.out.println("Se el primero en añadir un libro!!");
        }else {
            System.out.println("Estos son los libros que hay en la biblioteca");
            mostrarLibros();
        }

        do {
            System.out.println("Introduzca el nombre del libro: ");
            String libro = sc.next();
            System.out.println("Introduce el autor");
            String autor = sc.next();
            if(lLibros.isEmpty()){
                lLibros.add(new ListaLibros(libro, autor, 0));
            }else {
                lLibros.stream()
                        .filter(l -> (l.getTitulo().equals(libro) && l.getAutor().equals(autor))).findAny()
                        .ifPresentOrElse(l -> {
                            System.err.println("Este libro ya está en el sistema");
                            System.exit(1);
                        }, () -> lLibros.add(new ListaLibros(libro, autor, 0)));

                /*for (ListaLibros l: lLibros){
                    if ((libro.equals(l.getTitulo())) && (autor.equals(l.getAutor()))){
                        System.err.println("Este libro ya está en el sistema");
                        System.exit(1);
                    }else {
                        lLibros.add(new ListaLibros(libro, autor, 0));break;
                    }
                }*/
            }
            cont++;
        }while (cont <= numL);
    }

    public void añadirSocio(){

        int cont = 1;
        int numS = 0;
        try{
            System.out.println("Cuántos socios desea añadir??");
            numS = sc.nextInt();
        }catch (Exception e){
            System.err.println("¡¡Debe introducir un número!!");
            System.exit(1);
        }

        if (lSocios.isEmpty()){
            System.out.println("No hay ningún socio!!");
            System.out.println("Se el primero!!");
        }else {
            System.out.println("Estos son los socios que hay registrados");
            mostrarSocios();
        }
        Iterator<ListaSocios> it = lSocios.iterator();
        do {
            System.out.println("Introduzca el nombre: ");
            String nombre = sc.next();
            System.out.println("Introduce el numero de carnet: ");
            int numC = sc.nextInt();
            if(lSocios.isEmpty()){
                lSocios.add(new ListaSocios(nombre, numC));
                System.out.println("Socio añadido con éxito");
            }else {
                lSocios.stream()
                        .filter(l -> l.getNombre().equals(nombre) && l.getNumCarnet() == numC).findAny()
                        .ifPresentOrElse(l -> {
                            System.err.println("Este socio ya está en el sistema");
                            System.exit(1);
                        }, () -> lSocios.add(new ListaSocios(nombre, numC)));

                /*while (it.hasNext()){
                    String n = it.next().getNombre();
                    int n1 = it.next().getNumCarnet();
                    if ((nombre.equals(n)) && (numC == n1)){
                        System.err.println("Este socio ya está en el sistema");
                        System.exit(1);
                    }else {
                        lSocios.add(new ListaSocios(nombre, numC));
                        System.out.println("Socio añadido con éxito");break;
                    }
                }*/
            }
            cont++;
        }while (cont <= numS);

    }


    public void mostrarLibros(){
        lLibros.stream()
                .forEach(System.out::println);


        /*for (ListaLibros l: lLibros){
            if (!lLibros.isEmpty()){
                System.out.println("libros: " + l.toString());
            }else {
                System.out.println("No hay libros");
            }
        }*/
    }

    public void mostrarSocios(){
        lSocios.stream()
                .forEach(System.out::println);

        /*for (ListaSocios l: lSocios){
            if (lSocios.isEmpty()){
                System.out.println("No hay socios registrados");
            }else {
                System.out.println("Socios: " + l.toString());

            }
        }*/
    }

    public void eliminarLibro(){
        int cont = 1;
        int numL = 0;
        String libro;
        String autor;
        boolean disponible = true;
        System.out.println("Cuántos libros desea eliminar??");
        numL = sc.nextInt();

        if (lLibros.isEmpty()){
            System.err.println("ATENCIÓN");
            System.err.println("No hay nungún libro en la libreria!!");
            System.err.println("Antes de eliminar uno debe añadir algun libro!!");
        }else {
            System.out.println("Estos son los libros que hay en la biblioteca");
            mostrarLibros();
        }

        do {
            System.out.println("Introduzca el nombre del libro que desea eliminar: ");
            libro = sc.next();
            System.out.println("Introduce el nombre del autor: ");
            autor = sc.next();
            if(lLibros.isEmpty()){
                System.err.println("No hay libros que borrar");
            }else {
                lLibros.remove(new ListaLibros(libro, autor, 0));
            }
            cont++;
        }while (cont <= numL);
    }

    public void eliminarSocio(){
        int cont = 1;
        int numS = 0;
        String nombre;
        int ncuenta;
        System.out.println("Cuántos socios desea eliminar??");
        numS = sc.nextInt();

        if (lSocios.isEmpty()){
            System.err.println("ATENCIÓN");
            System.err.println("No hay nungún socio registrado!!");
            System.err.println("Antes de eliminar uno debe registrarse!!");
        }else {
            System.out.println("Estos son los socios que hay registrados en la biblioteca");
            mostrarSocios();
        }

        do {
            System.out.println("Introduzca el nombre del socio que desea eliminar: ");
            nombre = sc.next();
            System.out.println("Introduce el numerdo de cuenta: ");
            ncuenta = sc.nextInt();
            if(lSocios.isEmpty()){
                System.err.println("No hay socios que borrar");
            }else {
                lSocios.remove(new ListaSocios(nombre, ncuenta));
            }
            cont++;
        }while (cont <= numS);
    }

    public void atenderPeticion(){
        double ncarnet;
        String titulo;
        String autor;
        int num;
        System.out.println("Introduzca el número de su carnet: ");
        ncarnet = sc.nextDouble();
        do {
            try{
                for (ListaSocios l: lSocios){
                    if (ncarnet == l.getNumCarnet()){
                        System.out.println("Bienvenido "+ l.getNombre());
                        System.out.println("¿¿Qué acción desea realiar??");
                        System.out.println("1.- Sacar libro");
                        System.out.println("2.- Añadir libro");
                        System.out.println("3.- Eliminar libro");
                        System.out.println("4.- Añadir socio");
                        System.out.println("5.- Eliminar socio");
                        System.out.println("6.- Mis libros");
                        System.out.println("7.- Mostrar libros");
                        System.out.println("8.- Mostrar socios");
                        System.out.println("0.- Salir");
                        num = sc.nextInt();
                        switch (num){
                            case 1:
                                System.out.println("Qué libro desea sacar??");
                                mostrarLibros();
                                System.out.println("Escriba el título del libro");
                                titulo = sc.next();
                                Integer ncar = l.getNumCarnet();
                                for (ListaLibros j: lLibros){
                                    if (!lLibros.isEmpty()){
                                        if (titulo.equals(j.getTitulo()) && (ncar != 0)){
                                            j.setDisponible(l.getNumCarnet());
                                            System.out.println("Libro sacado con exito!!");break;
                                        }else if (false){
                                            System.err.println("¡¡ESTE LIBRO NO ESTÁ DISPONIBLE!!");
                                        }
                                    }else {
                                        System.err.println("¡¡NO HAY NINGÚN LIBRO DISPONIBLE EN LA BIBLIOTECA!!");
                                        System.err.println("¡¡AÑADE UN LIBRO ANTES DE SACAR!!");

                                    }
                                }break;

                            case 2:
                                añadirLibro();break;

                            case 3:
                                eliminarLibro();break;

                            case 4:
                                añadirSocio();break;

                            case 5:
                                eliminarSocio();break;

                            case 6:
                                lLibros.stream()
                                        .filter(p -> p.isDisponible() == ncarnet).findAny()
                                        .ifPresentOrElse(p -> {
                                            System.out.println(p.toString());
                                        }, () -> System.err.println("No tienes ningún libro"));


                                /*for (ListaLibros p: lLibros){
                                    if (ncarnet == p.isDisponible()){
                                        System.out.println(p.toString());break;
                                    }else{
                                        System.err.println("No tienes ningún libro");
                                    }
                                }break;*/

                            case 7:
                                mostrarLibros();break;

                            case 8:
                                mostrarSocios();break;

                            default:
                                System.out.println("VUELVA PRONTO!!");
                                System.exit(1);break;
                        }
                    }else if (false){
                        System.out.println("Lo sentimos este número de carnet no está registrado");
                        System.out.println("1.- Registrarse");
                        System.out.println("2.- Salir");
                        int i = sc.nextInt();
                        switch (i){
                            case 1:
                                añadirSocio();
                            case 2:
                                System.out.println("¡¡HASTA PRONTO!!");
                                System.exit(1);
                        }
                    }
                }
            }catch (ConcurrentModificationException e){
                System.exit(1);
            }
        }while (true);
    }

    public void ejercicioCompleto(){
        System.out.println("!!BIENVENIDO!!");
        atenderPeticion();
    }

}
