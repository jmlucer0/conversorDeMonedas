package servicio.impl;

import models.TasaDeCambio;
import servicio.IConversorDeMonedas;

public class ConversorDeMonedasImpl implements IConversorDeMonedas {

    public double convertir(double monedaDeEntrada, String tipoDeMonedaDeSalida, TasaDeCambio tasaDeCambio){
        double monedaDeSalida = tasaDeCambio.conversion_rates().get(tipoDeMonedaDeSalida);

        return monedaDeEntrada*monedaDeSalida;
    }


}