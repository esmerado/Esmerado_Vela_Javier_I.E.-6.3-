package org.jesmerado.coleccionesdinamicas.IE63.Ej2;

import java.util.*;

public class BancoMain {
    public static void main(String[] args) {

        ArrayList<Cliente> cliente = new ArrayList<>();
        ArrayList<Cuenta> cuenta = new ArrayList<>();

        Banco b = new Banco(cliente, cuenta);
        cliente.add(new Cliente("77822787X", "Javier", "Esmerado", "aldonoquijhano", 627478400));
        cliente.add(new Cliente("12345678A", "Jav", "Esme", "aldonoquijhano", 600471635));
        cuenta.add(new Cuenta(1200, 5));

        b.consultarSaldo();

    }
}
