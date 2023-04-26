package Controles;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controles {
    static Scanner ingreso = new Scanner(System.in);

    public static LocalDate fechaMayor(String fecha1, DateTimeFormatter fmt) {
        try {
            LocalDate fechaCompra = LocalDate.parse(fecha1, fmt);
            LocalDate fechaActual = LocalDate.now();
            if (fechaCompra.isBefore(fechaActual) || fechaCompra.equals(fechaActual)) {
                return fechaCompra;
            } else {
                System.out.println("La fecha de compra no puede ser posterior a la fecha actual ");
                System.out.println("Ingrese la fecha otra vez: ");
                String fechaNuevaStr = ingreso.next();
                return fechaMayor(fechaNuevaStr, fmt);
            }
        } catch (DateTimeParseException e) {
            System.out.println("Error: formato de fecha inválido ");
            System.out.println("Ingrese la fecha otra vez: ");
            String fechaNuevaStr = ingreso.next();
            return fechaMayor(fechaNuevaStr, fmt);
        }

    }



    public static LocalDate controlFechas(String fecha1, String fecha2, DateTimeFormatter fmt) {
        try {
            LocalDate fechaCompra = LocalDate.parse(fecha1, fmt);
            LocalDate fechaDepreciar = LocalDate.parse(fecha2, fmt);
            if (fechaDepreciar.isAfter(fechaCompra)) {
                return fechaDepreciar;
            } else {
                System.out.println("La fecha de depreciacion debe ser posterior a la fecha de compra");
                System.out.println("Ingrese la fecha otra vez: ");
                String fechaNuevaStr = ingreso.next();
                return controlFechas(fecha1, fechaNuevaStr, fmt);
            }
        } catch (DateTimeParseException e) {
            System.out.println("Error: formato de fecha inválido");
            System.out.println("Ingrese la fecha otra vez: ");
            String fechaNuevaStr = ingreso.next();
            return controlFechas(fecha1, fechaNuevaStr, fmt);
        }
    }



    public static double controlNumeros() {
        double precio = 0;
        boolean entradaValida = false;
        do {
            System.out.println("Ingrese el precio de su vehiculo: ");
            try {
                precio = ingreso.nextDouble();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("ERROR: INGRESE SOLO NUMEROS ENTEROS O DECIMALES SEPARADOS POR UNA COMA");
                ingreso.next();
            }
        } while (!entradaValida || precio < 0);
        return precio;
    }

    public static String opcion(){
        String opcion;
        do {
            System.out.println("Desea calcular la depreciacion de nuevo S/N: ");
            opcion = ingreso.next().toUpperCase();
            if (!(opcion.equals("S") || opcion.equals("N"))){
                System.out.println("INGRESE SOLO S/N");
            }
        }while (!(opcion.equals("S") || opcion.equals("N")));
        return opcion;
    }

}
