package validacion;

import java.util.Scanner;

public class Validador {

    public boolean validadorDeMenu(String opcion) {
        try {
            int numeroDeOpcion = Integer.parseInt(opcion);
            if (numeroDeOpcion >= 1 && numeroDeOpcion <= 7) {
                return true;
            }else {
                System.out.println("Opcion invalida, elija una opcion valida.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Debe ingresar un numero correspondiente a una opcion.");
        }
        return false;
    }
}
