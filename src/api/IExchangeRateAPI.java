package api;

import models.TasaDeCambio;

public interface IExchangeRateAPI {
    public TasaDeCambio buscarTasaDeCambio(String tipoDeMonedaEntrada);

}
