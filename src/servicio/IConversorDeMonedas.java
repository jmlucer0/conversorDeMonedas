package servicio;

import models.TasaDeCambio;

public interface IConversorDeMonedas {
    public String convertir(double monedaDeEntrada, String tipoDeMonedaDeSalida, TasaDeCambio tasaDeCambio);
}
