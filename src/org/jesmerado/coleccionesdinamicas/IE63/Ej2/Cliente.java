package org.jesmerado.coleccionesdinamicas.IE63.Ej2;

import java.util.*;

public class Cliente {
    private String dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private int telefono;
    private Map<Integer, Cuenta> lCuentas;

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

    public void añadirCuenta(Cuenta lcuenta){
        this.lCuentas.put(lcuenta.getNumCuenta(), lcuenta);
    }

    public void mostrarCuentas(){
        if (lCuentas.isEmpty()){
            System.out.println("Lo sentimos no hay ninguna cuenta creada");
        }else {
            lCuentas.values().stream()
                    .forEach(System.out::println);
        }
    }

    public void ingresarDinero(double cant, int key){
        lCuentas.get(key).anadirDinero(cant);
    }

    public void sacarDinero(double cant, int key){
        lCuentas.get(key).sacarDinero(cant);
    }

    public void eliminarCuentas(int key){
        lCuentas.remove(key);
    }

    public double consultarSaldo(int key){
        return lCuentas.get(key).getDinero();
    }

    public double revisionMensual(int key){
        return lCuentas.get(key).revisionMensual();
    }

    public void cambiarComision(int key, double comi){
        lCuentas.get(key).setComision(comi);
    }

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
