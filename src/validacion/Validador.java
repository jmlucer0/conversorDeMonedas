package validacion;

public class Validador {

    public boolean validadorDeMenu(String opcion){
        int numeroDeOpcion = Integer.parseInt(opcion);
        if(numeroDeOpcion >= 1 && numeroDeOpcion <=7){
            return true;
        }
        return false;
    }
}
