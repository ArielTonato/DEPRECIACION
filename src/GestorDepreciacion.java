public class GestorDepreciacion {
    private DepreciacionFechas depreciacionFechas;
    private Vehiculo vehiculo;

    public GestorDepreciacion(Vehiculo vehiculo, DepreciacionFechas depreciacionFechas) {
        this.vehiculo = vehiculo;
        this.depreciacionFechas = depreciacionFechas;
    }

    public double getValorResidual() {
        return this.vehiculo.getPrecio()-this.vehiculo.getPrecio()*0.1;
    }

    public double getValorDepreciacion(){
        return getValorResidual()*this.depreciacionFechas.getAnios()*0.20+
                getValorResidual()*this.depreciacionFechas.getMeses()*0.0166;
    }

    public double getValor(){
        if( this.getValorDepreciacion() == 0){
            System.out.println(" Su auto aun no se ha depreciado ");
            return this.vehiculo.getPrecio();
        }else if (this.getValorDepreciacion() >= this.getValorResidual()){
            System.out.println(" El auto se ha depreciado por completo su valor neto es: ");
            return this.vehiculo.getPrecio()*0.1;
        }else if (this.depreciacionFechas.getAnios() > 0 || this.depreciacionFechas.getMeses() > 0 ){
            System.out.print(" El valor total del auto es: ");
            return getValorResidual() - getValorDepreciacion();
        }
        return -1;
    }

    public void prueba(){
        System.out.println("Valor actual del coche: "+this.getValorResidual());
        System.out.println("El vehiculo se ha depreciado: "+this.getValorDepreciacion());
        System.out.println(getValor());
    }

}
