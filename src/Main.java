import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import static Controles.Controles.*;

public class Main {
    static Scanner ingreso = new Scanner(System.in);
    static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static void main(String[] args) {
        ingresos();
    }

    public static void ingresos(){
        GestorDepreciacion depreciacion;
        do {
            System.out.println("Marca del vehiculo: ");
            String marca = ingreso.next();
            double precio = controlNumeros();
            System.out.println("Ingrese la fecha de compra de su vehiculo Dias/Meses/Años: ");
            String fecha = ingreso.next();
            LocalDate fechaCompra = fechaMayor(fecha,fmt);
            fecha = fechaCompra.format(fmt);
            System.out.println("Ingrese la fecha a depreciar Dias/Meses/Años: ");
            String fecha2 = ingreso.next();
            LocalDate fechaDepreciar = controlFechas(fecha,fecha2,fmt);

            depreciacion = new GestorDepreciacion(new Vehiculo(marca,precio),
                    new DepreciacionFechas(fechaCompra,fechaDepreciar));

            depreciacion.mostrarDatos();
        }while (!opcion().equals("N"));


    }

}
