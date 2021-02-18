package org.jesmerado.coleccionesdinamicas.IE63.Ej2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Banco {

    Scanner sc = new Scanner(System.in);
    Map<String, Cliente> cliente;



    public Banco(Map<String, Cliente> cliente) {
        this.cliente = cliente;
    }

    public void accederCliente(){
        try {
            System.out.println("Introduce el dni del cliente al que desea acceder: ");
            String dni = sc.nextLine();
            Cliente cli = cliente.get(dni);
            if (cli != null) {
                System.out.println("Bienvenido!!");
            } else {
                System.err.println("Lo sentimos no hay ningún cliente registrado con este DNI!!");
                System.out.println("Qué operación deseas realizar: ");
                System.out.println("1.- Registrarme");
                System.out.println("2.- Salir");
                int n = sc.nextInt();
                switch (n){
                    case 1:
                        nuevoCliente();break;
                    case 2:
                        System.out.println("Hasta pronto!!");
                        System.exit(1);break;
                }
            }
            do {
                System.out.println("Qué operacion desea realizar??");
                System.out.println("1.- Nuevo cliente");
                System.out.println("2.- Eliminar cliente");
                System.out.println("3.- Nueva cuenta");
                System.out.println("4.- Eliminar cuenta");;
                System.out.println("5.- Lista clientes");
                System.out.println("6.- Listar cuentas");
                System.out.println("7.- Ingresar dinero");
                System.out.println("8.- Sacar dinero");
                System.out.println("9.- Consultar saldo");
                System.out.println("10.- Revision mensual");
                System.out.println("11.- Cambiar comisión mensual");
                System.out.println("12.- Salir");
                int num = sc.nextInt();
                switch (num) {
                    case 1:
                        nuevoCliente();
                        break;
                    case 2:
                        eliminarCliente();
                        break;
                    case 3:
                        nuevaCuenta(cli);
                        break;
                    case 4:
                        eliminarCuenta(cli);
                        break;
                    case 5:
                        mostrarClientes();
                        break;
                    case 6:
                        mostrarCuenta(cli);
                        break;
                    case 7:
                        ingresarDinero(cli);
                        break;
                    case 8:
                        sacarDinero(cli);
                        break;
                    case 9:
                        mostrarSaldo(cli);
                        break;
                    case 10:
                        revisionMensual(cli);
                        break;
                    case 11:
                        cambiarComision(cli);
                        break;
                    default:
                        System.out.println("VUELVA PRONTO!!");
                        System.exit(1);
                        break;
                }

            } while (true);
        }catch (Exception e){
            System.err.println("Ha introducido algún valor erróneo");
            System.exit(1);
        }
    }


    public void nuevoCliente(){
        sc.nextLine();
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
                    cliente.put(dni, new Cliente(dni, nombre, apellidos, direc, telf));
                });

        /*for (Cliente c: cliente){
            if (c.getDni().equals(dni)){
                System.err.println("Lo sentimos este usuario ya es cliente!!");
            }else {
                cliente.add(new Cliente(dni, nombre, apellidos, direc, telf));
            }
        }*/

    }

    public void nuevaCuenta(Cliente cli){
        cli.añadirCuenta(new Cuenta());
        System.out.println("Cuenta añadida con éxito!!");

        /*if (cliente.containsKey(dni)){
            cliente.get(dni).añadirCuenta(new Cuenta());
        }else {
            System.err.println("Lo sentimos, este DNI no está asociado a ninguna cuenta!!");
        }*/
    }

    public void eliminarCliente(){
        System.out.println("ESTAS SON LOS CLIENTES DISPONIBLES: ");
        mostrarClientes();
        System.out.println("Introduzca el dni del cliente que desea eliminar: ");
        String dni = sc.next();
        if (cliente.containsKey(dni)){
            cliente.remove(dni);
            System.out.println("Cliente eliminado con éxito!!");
            System.out.println("Vuelva a inciar sesión");
            System.exit(1);
        }else {
            System.out.println("Lo sentimos no se encuentra ninguna cuenta asociada a ese dni.");
            System.out.println("Vuelva a inciar sesión");
            System.exit(1);
        }
    }

    public void eliminarCuenta(Cliente cli){
        cli.mostrarCuentas();
        System.out.println("Introduzca el número de la cuenta que desea eliminar: ");
        int key = sc.nextInt();
        if (cli.getlCuentas().containsKey(key)){
            cli.eliminarCuentas(key);
            System.out.println("Cuenta eliminada con éxito!!");
        }else {
            System.out.println("Lo sentimos ha seleccionado una clave inexistente!!");
            System.exit(1);
        }
    }

    public void mostrarClientes(){
        cliente.values().stream()
                .forEach(System.out::println);
    }

    public void mostrarCuenta(Cliente cli){
        cli.mostrarCuentas();
    }

    public void ingresarDinero(Cliente cli){
        if (cli.empty() == true){
            System.out.println("No hay cuentas disponibles");
            System.exit(1);
        }
        mostrarCuenta(cli);
        System.out.println("En que cuenta desea añadir el dinero: ");
        int key = sc.nextInt();
        if (cli.getlCuentas().containsKey(key)){
            System.out.println("Qué cantidad de dinero desea ingresar: ");
            double cant = sc.nextDouble();
            cli.ingresarDinero(cant, key);
            System.out.println("El dinero ha sido ingresasado con éxito!!");
        }else {
            System.out.println("Lo sentimos la cuenta seleccionada no existe!!");
            System.exit(1);
        }
    }

    public void sacarDinero(Cliente cli){
        if (cli.empty() == true){
            System.out.println("No hay cuentas disponibles");
            System.exit(1);
        }
        mostrarCuenta(cli);
        System.out.println("En que cuenta desea sacar el dinero: ");
        int key = sc.nextInt();
        if (cli.getlCuentas().containsKey(key)){
            System.out.println("Qúe cantidad desea sacar: ");
            double cant = sc.nextDouble();
            cli.sacarDinero(cant, key);
        }else {
            System.out.println("Lo sentimos la cuenta seleccionada no existe!!");
        }
    }

    public void mostrarSaldo(Cliente cli){
        mostrarCuenta(cli);
        System.out.println("De que cuenta deseas saber el saldo: ");
        int key = sc.nextInt();
        if (cli.getlCuentas().containsKey(key)){
            System.out.println("Su saldo es: " + cli.consultarSaldo(key));
        }else {
            System.out.println("Lo sentimos la cuenta seleccionada no existe!!");
        }
    }

    public void revisionMensual(Cliente cli){
        if (cli.empty() == true){
            System.out.println("No hay cuentas disponibles");
            System.exit(1);
        }
        mostrarCuenta(cli);
        System.out.println("De que cuenta desea saber la revisión mensual: ");
        int key = sc.nextInt();
        if (cli.getlCuentas().containsKey(key)){
            System.out.println("La revisión mensual es de: " + cli.revisionMensual(key));
        }else {
            System.out.println("Lo sentimos la cuenta seleccionada no existe!!");
        }
    }

    public void cambiarComision(Cliente cli){
        if (cli.empty() == true){
            System.out.println("No hay cuentas disponibles");
            System.exit(1);
        }
        Scanner s = new Scanner(System.in);
        mostrarCuenta(cli);
        System.out.println("De que cuenta desea cambiar la comisión: ");
        int key = s.nextInt();
        System.out.println("A cuánto desea cambiar la comisión: ");
        double comi = s.nextDouble();
        if (cli.getlCuentas().containsKey(key)){
            cli.cambiarComision(key, comi);
        }else {
            System.out.println("Lo sentimos la cuenta seleccionada no existe!!");
        }
    }
}


