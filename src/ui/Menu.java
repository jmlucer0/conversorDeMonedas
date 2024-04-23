package ui;

import api.impl.ExchangeRateAPIImpl;
import models.TasaDeCambio;
import servicio.impl.ConversorDeMonedasImpl;

import java.util.Scanner;

public class Menu {
    String monedaDeEntrada;
    String monedaDeSalida;
    double cantidad;
    double convercion;
    String opcionElejida;
    Scanner ingresar = new Scanner(System.in);
    ExchangeRateAPIImpl informacionDeMoneda = new ExchangeRateAPIImpl();

    public void menuPrincipal(){
        String menu = """
                            Conversor de Monedas
                
                **************Menu Principal********************
                
                1 - Dolar --> Peso Argentino.
                2 - Peso Argentino --> Dolar.
                3 - Dolar --> Real Brasilenio.
                4 - Real Brasilenio --> Dolar.
                5 - Dolar --> Peso Colombiano.
                6 - Peso Colombiano --> Dolar.
                7 - Salir
                
                Elija una Opcion Valida:
                
                ************************************************
                """;
        System.out.println(menu);
        opcionElejida = ingresar.nextLine();
        System.out.println("Ingrese el valor a convertir");
        cantidad = ingresar.nextDouble();

        opcionDeCAmbio(opcionElejida);
        TasaDeCambio tasaDeCambio = informacionDeMoneda.buscarTasaDeCambio(monedaDeEntrada);
        ConversorDeMonedasImpl conversorDeMonedas = new ConversorDeMonedasImpl();
        convercion = conversorDeMonedas.convertir(cantidad, monedaDeSalida, tasaDeCambio);

        respuesta(opcionElejida, cantidad, convercion);


    }

    public void opcionDeCAmbio(String opcionElejida){
        switch (opcionElejida){
            case "1":
                monedaDeEntrada = "USD";
                monedaDeSalida = "ARS";
                break;
            case "2":
                monedaDeEntrada = "ARS";
                monedaDeSalida = "USD";
                break;
            case "3":
                monedaDeEntrada = "USD";
                monedaDeSalida = "BRL";
                break;
            case "4":
                monedaDeEntrada = "BRL";
                monedaDeSalida = "USD";
                break;
            case "5":
                monedaDeEntrada = "USD";
                monedaDeSalida = "COP";
                break;
            case "6":
                monedaDeEntrada = "COP";
                monedaDeSalida = "USD";
                break;
        }
    }

    public void respuesta(String opcionElejida, double cantidad, double convercion){
        switch (opcionElejida){
            case "1":
                System.out.println(
                        "Dolar: " + cantidad + " son Pesos Argentinos: " + convercion);
                break;
            case "2":
                System.out.println(
                        "Peso Argentino: " + cantidad + " son Dolar: " + convercion);
                break;
            case "3":
                System.out.println(
                        "Dolar: " + cantidad + " son Real Brasilenio: " + convercion);
                break;
            case "4":
                System.out.println(
                        "Real Brasilenio: " + cantidad + " son Dolar: " + convercion);
                break;
            case "5":
                System.out.println(
                        "Dolar: " + cantidad + " son Peso Colombiano: " + convercion);
                break;
            case "6":
                System.out.println(
                        "Peso Colombiano: " + cantidad + " son Dolar: " + convercion);
                break;
        }

    }
}
