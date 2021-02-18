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
        System.out.println("Introduce el dni del cliente al que desea acceder: ");
        String dni = sc.nextLine();
        Cliente cli = cliente.get(dni);
        if (cli != null){
            System.out.println("Bienvenido!!");
        }else {
            System.err.println("Lo sentimos no hay ningún cliente registrado con este DNI!!");
            System.exit(1);
        }
        do{
            System.out.println("Qué operacion desea realizar??");
            System.out.println("1.- Eliminar cuenta");
            System.out.println("2.- Añadir cuenta");
            System.out.println("3.- Ingresar dinero");
            System.out.println("4.- Mostrar cuentas");
            System.out.println("5.- Sacar dinero");
            System.out.println("6.- Mostrar saldo");
            System.out.println("7.- Revision mensual");
            System.out.println("8.- Cambiar comisión");
            int num = sc.nextInt();
            switch (num){
                case 1:
                    eliminarCuenta(cli);break;
                case 2:
                    nuevaCuenta(cli);break;
                case 3:
                    ingresarDinero(cli);break;
                case 4:
                    mostrarCuenta(cli);break;
                case 5:
                    sacarDinero(cli);break;
                case 6:
                    mostrarSaldo(cli);break;
                case 7:
                    revisionMensual(cli);break;
                case 8:
                    cambiarComision(cli);
            }

        }while (true);

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
        String dni = sc.nextLine();
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
        mostrarCuenta(cli);
        System.out.println("En que cuenta desea añadir el dinero: ");
        int key = sc.nextInt();
        if (cli.getlCuentas().containsKey(key)){
            System.out.println("Qué cantidad de dinero desea sacar: ");
            double cant = sc.nextDouble();
            if (cli.consultarSaldo(key) > cant){
                cli.sacarDinero(cant, key);
                System.out.println("El dinero ha sido retirado con éxito!!");
            }else {
                System.out.println("Lo sentimos el saldo de su cuenta es inferior a la cantidad que desea sacar!!");
                System.exit(1);
            }
        }else {
            System.out.println("Lo sentimos la cuenta seleccionada no existe!!");
            System.exit(1);
        }
    }

    public void sacarDinero(Cliente cli){
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
        mostrarCuenta(cli);
        System.out.println("De que cuenta desea cambiar la comisión: ");
        int key = sc.nextInt();
        System.out.println("A cuánto desea cambiar la comisión: ");
        double comi = sc.nextDouble(); //Fallo al introducir el valor Double
        if (cli.getlCuentas().containsKey(key)){
            cli.cambiarComision(key, comi);
        }else {
            System.out.println("Lo sentimos la cuenta seleccionada no existe!!");
        }
    }
}


