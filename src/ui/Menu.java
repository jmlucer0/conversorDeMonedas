package ui;

import api.impl.ExchangeRateAPIImpl;
import models.TasaDeCambio;
import servicio.impl.ConversorDeMonedasImpl;
import validacion.Validador;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    boolean errorDeIngreso = false;
    String monedaDeEntrada;
    String monedaDeSalida;
    double monto;
    String conversion;
    String opcionElejida;
    Scanner ingresar = new Scanner(System.in);
    ExchangeRateAPIImpl informacionDeMoneda = new ExchangeRateAPIImpl();
    Validador validador = new Validador();

    public void menuPrincipal() {
        do {
            do {
                String menu = """
                                    
                         -----------------------------------------------
                                    
                                    Conversor de Monedas
                                        
                        **************Menu Principal********************
                                        
                        1 - Dolar --> Peso Argentino.
                        2 - Peso Argentino --> Dolar.
                        3 - Dolar --> Real Brasilenio.
                        4 - Real Brasilenio --> Dolar.
                        5 - Dolar --> Peso Colombiano.
                        6 - Peso Colombiano --> Dolar.
                        7 - Salir
                                        
                        Elija una Opcion:
                                        
                        ************************************************
                        """;
                System.out.println(menu);
                opcionElejida = ingresar.nextLine();

                if(Integer.parseInt(opcionElejida) == 7){
                    System.out.println("Cerrando Aplicacion...");
                }
            }while (!validador.validadorDeMenu(opcionElejida));
            if(Integer.parseInt(opcionElejida) == 7){
                break;
            }

            do{
                System.out.println("Ingrese el valor a convertir:");
                try{
                    monto = ingresar.nextDouble();
                    errorDeIngreso = false;
                }catch(NumberFormatException | InputMismatchException e){
                    System.out.println("Error: Debe ingresar un numero. El numero ingresado no puede ser '0'.");
                    errorDeIngreso = true;
                    ingresar = new Scanner(System.in);
                }
            }while (errorDeIngreso || monto == 0);
            //limpio el cache del scanner
            ingresar = new Scanner(System.in);
            opcionDeCAmbio(opcionElejida);

            TasaDeCambio tasaDeCambio = informacionDeMoneda.buscarTasaDeCambio(monedaDeEntrada);
            ConversorDeMonedasImpl conversorDeMonedas = new ConversorDeMonedasImpl();
            conversion = conversorDeMonedas.convertir(monto, monedaDeSalida, tasaDeCambio);

            respuesta(opcionElejida, monto, conversion);

        } while (Integer.parseInt(opcionElejida) != 7);
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

    public void respuesta(String opcionElejida, double cantidad, String convercion){
        switch (opcionElejida) {
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
