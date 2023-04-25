public class Vehiculo {
    private String marca;
    private String color;
    private double precio;

    public Vehiculo(String marca, String color, double precio) {
        this.marca = marca;
        this.color = color;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public double getPrecio() {
        return precio;
    }
}
