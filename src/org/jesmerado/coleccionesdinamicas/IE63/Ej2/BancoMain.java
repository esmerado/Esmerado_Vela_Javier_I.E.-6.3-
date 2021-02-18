package org.jesmerado.coleccionesdinamicas.IE63.Ej2;

import java.util.*;

public class BancoMain {
    public static void main(String[] args) {

        Map<String, Cliente> cliente = new TreeMap<>();

        Scanner sc = new Scanner(System.in);
        Banco b = new Banco(cliente);
        cliente.put("77822787X",new Cliente("77822787X", "Javier", "Esmerado", "aldonoquijhano", 627478400));
        cliente.put("12345678A", new Cliente("12345678A", "Jav", "Esme", "aldonoquijhano", 600471635));


        b.accederCliente();
    }
}
