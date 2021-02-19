package org.jesmerado.coleccionesdinamicas.IE63.Ej2;

import java.util.*;

/**
 * @author esmer
 */
public class Cliente {
    private String dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private int telefono;
    private Map<Integer, Cuenta> lCuentas;

    /**
     * Constructor con las variables de nuestro cliente y la colección de cuentas inicializada.
     * @param dni
     * @param nombre
     * @param apellido
     * @param direccion
     * @param telefono
     */
    public Cliente(String dni, String nombre, String apellido, String direccion, int telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.lCuentas = new HashMap<>();
    }

    public Map getlCuentas() {
        return lCuentas;
    }

    public void setlCuentas(Map lCuentas) {
        this.lCuentas = lCuentas;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * Método para añadir cuentas a nuestro cliente.
     * @param lcuenta
     */
    public void anadirCuenta(Cuenta lcuenta){
        this.lCuentas.put(lcuenta.getNumCuenta(), lcuenta);
    }

    /**
     * Método  para mostrar las cuentas de nuestro cliente
     */
    public void mostrarCuentas(){
        if (lCuentas.isEmpty()){
            System.out.println("Lo sentimos no hay ninguna cuenta creada");
        }else {
            lCuentas.values().stream()
                    .forEach(System.out::println);
        }
    }

    /**
     * Método para ingresar dinero a nuestra cuenta
     * @param cant
     * @param key
     */
    public void ingresarDinero(double cant, int key){
        lCuentas.get(key).anadirDinero(cant);
    }

    /**
     * Método para sacar dinero de nuestra cuenta
     * @param cant
     * @param key
     */
    public void sacarDinero(double cant, int key){
        lCuentas.get(key).sacarDinero(cant);
    }

    /**
     * Método para eliminar cuentas
     * @param key
     */
    public void eliminarCuentas(int key){
        lCuentas.remove(key);
    }

    /**
     * Método para consultar el saldo
     * @param key
     * @return
     */
    public double consultarSaldo(int key){
        return lCuentas.get(key).getDinero();
    }

    /**
     * Calculo de la revisión mensual
     * @param key
     * @return
     */
    public double revisionMensual(int key){
        return lCuentas.get(key).revisionMensual();
    }

    /**
     * Cambio de la comisión
     * @param key
     * @param comi
     */
    public void cambiarComision(int key, double comi){
        lCuentas.get(key).setComision(comi);
    }

    /**
     * Método para saber si hay alguna cuenta creada
     * @return
     */
    public boolean empty(){
        return lCuentas.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return dni == cliente.dni && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido, cliente.apellido) && Objects.equals(direccion, cliente.direccion) && Objects.equals(telefono, cliente.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, nombre, apellido, direccion, telefono);
    }

    @Override
    public String toString() {
        return "dni=" + dni +
                ", nombre: '" + nombre + '\'' +
                ", apellido: '" + apellido + '\'' +
                ", direccion: '" + direccion + '\'' +
                ", telefono: '" + telefono;
    }
}
