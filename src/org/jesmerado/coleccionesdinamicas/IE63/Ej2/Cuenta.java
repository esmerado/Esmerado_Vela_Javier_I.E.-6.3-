package org.jesmerado.coleccionesdinamicas.IE63.Ej2;

import java.util.Objects;

public class Cuenta {
    private int numCuenta;
    private double dinero = 1000;
    private double interes = 0.1d;
    private int antiguedad = 5;
    private double comision = 0.6;
    private static int cont = 1;

    public Cuenta() {
        numCuenta = cont++;
    }

    public Cuenta(double dinero, int antiguedad) {
        this.dinero = dinero;
        this.antiguedad = antiguedad;
        this.numCuenta = cont;
        cont++;
    }

    public double revisionMensual(){
        return dinero = dinero + (antiguedad*interes) + (antiguedad*comision);
    }

    public void anadirDinero(double dinero){
        this.dinero += dinero;
    }

    public void sacarDinero(double dinero){
        this.dinero -= dinero;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuenta cuenta = (Cuenta) o;
        return Double.compare(cuenta.dinero, dinero) == 0 && Double.compare(cuenta.interes, interes) == 0 && antiguedad == cuenta.antiguedad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dinero, interes, antiguedad);
    }

    @Override
    public String toString() {
        return "numCuenta=" + numCuenta +
                ", dinero=" + dinero +
                ", antiguedad=" + antiguedad +
                ", comision=" + comision;
    }
}

