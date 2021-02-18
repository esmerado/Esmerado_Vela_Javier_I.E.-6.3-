package org.jesmerado.coleccionesdinamicas.IE63.Ej2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Banco {

    Scanner sc = new Scanner(System.in);
    ArrayList<Cliente> cliente;
    ArrayList<Cuenta> cuenta;

    public Banco(ArrayList<Cliente> cliente, ArrayList<Cuenta> cuenta) {
        this.cliente = cliente;
        this.cuenta = cuenta;
    }

    public void ingresarDinero(){
        int cant;
        System.out.println("¿Qué cantidad desea ingresa?: ");
        cant = sc.nextInt();
        cuenta.values().parallelStream()
                .forEach(d -> {
                    d.setDinero(d.getDinero() + cant);
                });

        /*for (Cuenta l: cuenta){
            double cant2 = l.getDinero();
            l.setDinero((cant2 + cant));
        }*/
    }

    public void sacarDinero(){
        int cant;
        System.out.println("¿Qué cantidad desea sacar?: ");
        cant = sc.nextInt();
        .forEach(d -> {
                    d.setDinero(d.getDinero() - cant);
                });

    }

    public void consultarSaldo(){
        System.out.println("Introduzca su DNI: ");
        String dni = sc.nextLine();
        cuenta.values().parallelStream()
                .filter(l -> cuenta.containsKey(dni))
                .forEach(l -> System.out.println(l.getDinero()));
    }

    public void nuevoCliente(){
        System.out.println("Introduzca su DNI: ");
        String dni = sc.nextLine();
        System.out.println("Introduzca su nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Introduzca su primer apellido: ");
        String apellidos = sc.nextLine();
        System.out.println("Introduzca su direccion: ");
        String direc = sc.nextLine();
        System.out.println("Introduce su telefono: ");
        int telf = sc.nextInt();
        cliente.values().parallelStream().findAny()
                .filter(l -> l.getDni().equals(dni))
                .ifPresentOrElse(l -> {
                    System.err.println("Lo sentimos este usuario ya es cliente!!");
                }, () -> {
                    cliente.put(dni, new Cliente(dni, nombre, apellidos, direc, telf, ));
                });

        /*for (Cliente c: cliente){
            if (c.getDni().equals(dni)){
                System.err.println("Lo sentimos este usuario ya es cliente!!");
            }else {
                cliente.add(new Cliente(dni, nombre, apellidos, direc, telf));
            }
        }*/

    }

    public void eliminarCliente(){
        System.out.println("Introduzca el DNI del cliente que desea introducir: ");
        String dni = sc.nextLine();
        if (cliente.containsKey(dni)){
            cliente.remove(dni);
            cuenta.remove(dni);
        }else {
            System.err.println("Lo sentimos no hay ninguna cuenta vinculada a este DNI");
        }

    }

    public void nuevaCuenta(){
        System.out.println("Introduzca su DNI: ");
        String dni = sc.nextLine();
        if (cliente.containsKey(dni)){
            if (cuenta.containsKey(dni)){
                System.out.println("Lo sentimos ya hay una cuenta asociada a este DNI");
            }else {
                cuenta.put(dni, new Cuenta(0, 0));
            }
        }else {
            System.err.println("Lo sentimos, este DNI no está asociado a ninguna cuenta!!");
        }
    }

    public void mostrarClientesCuentas(){
        System.out.println("Cuentas: ");
        cuenta.values().parallelStream()
                .forEach(System.out::println);
        System.out.println("Clientes: ");
        cliente.values().parallelStream()
                .forEach(System.out::println);
    }

    public void revisionMensual(){
        System.out.println("Introduzca su DNI: ");
        String dni = sc.nextLine();
        cuenta.values().parallelStream()
                .filter(l -> (l.getDinero() + (l.getInteres()*l.getAntiguedad() - (l.getAntiguedad()*l.getAntiguedad()))))


    }

}


