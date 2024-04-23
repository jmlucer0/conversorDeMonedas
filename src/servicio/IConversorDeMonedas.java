package servicio;

import models.TasaDeCambio;

public interface IConversorDeMonedas {
    public double convertir(double monedaDeEntrada, String tipoDeMonedaDeSalida, TasaDeCambio tasaDeCambio);

    public void opcionDeCAmbio(String opcionElejida);
}
