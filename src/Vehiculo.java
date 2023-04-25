public class Vehiculo {
    private String marca;

    private double precio;

    public Vehiculo(String marca, double precio) {
        this.marca = marca;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }


    public double getPrecio() {
        return precio;
    }
}
