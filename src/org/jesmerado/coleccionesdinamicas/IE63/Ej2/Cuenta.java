package org.jesmerado.coleccionesdinamicas.IE63.Ej2;

import java.util.Objects;

public class Cuenta {
    private double dinero;
    private double interes = 0.1d;
    private int antiguedad = 0;

    public Cuenta(double dinero, int antiguedad) {
        this.dinero = dinero;
        this.antiguedad = antiguedad;
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
        return "dinero=" + dinero + ", antiguedad=" + antiguedad;
    }
}

