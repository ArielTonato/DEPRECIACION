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
            System.out.print("Su vehiculo aun no se ha depreciado su precio sigue siendo: ");
            return this.vehiculo.getPrecio();
        }else if (this.getValorDepreciacion() >= this.getValorResidual()){
            System.out.println("El vehiculo se ha depreciado por completo su valor neto es: ");
            return this.vehiculo.getPrecio()*0.1;
        }else if (this.depreciacionFechas.getAnios() > 0 || this.depreciacionFechas.getMeses() > 0 ){
            System.out.print("El valor total del auto es: ");
            return getValorResidual() - getValorDepreciacion();
        }
        return -1;
    }

    public void mostrarDatos(){
        String datos = "";
        datos += "El valor del vehiculo es: "+this.vehiculo.getPrecio()+
                "\nEl valor nominal del vehiculo es: "+this.vehiculo.getPrecio()*0.1+
                "\nEl valor residual del vehiculo es: "+this.getValorResidual();
        if (this.depreciacionFechas.getAnios() > 0){
            datos += "\nEl auto se ha depreciado un: "+this.getValorDepreciacion()+" en " +
                    this.depreciacionFechas.getAnios()+" años ";
        }
        if (this.depreciacionFechas.getMeses() > 0){
            datos+= " y "+ this.depreciacionFechas.getMeses()+
                    " meses ";
        }
        System.out.println(datos);
        System.out.println(getValor());
    }

}
