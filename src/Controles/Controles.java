package Controles;

import java.time.LocalDate;

public  class Controles {
    public static boolean controlFechas(LocalDate fecha1, LocalDate fecha2){
        return fecha1.isBefore(fecha2);
    }

    public static boolean controlNumeros(double numero){
        try {
            double numeroPrueba;
            numeroPrueba = numero;
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

}
