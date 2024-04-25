package servicio.impl;

import models.TasaDeCambio;
import servicio.IConversorDeMonedas;

import java.text.DecimalFormat;

public class ConversorDeMonedasImpl implements IConversorDeMonedas {

    public String convertir(double monedaDeEntrada, String tipoDeMonedaDeSalida, TasaDeCambio tasaDeCambio){
        double monedaDeSalida = tasaDeCambio.conversion_rates().get(tipoDeMonedaDeSalida);
        double conversion = monedaDeEntrada*monedaDeSalida;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String respuesta = decimalFormat.format(conversion);
        return respuesta;
    }
}