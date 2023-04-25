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
    public double getValorNeto(){
        return this.vehiculo.getPrecio()*0.1;
    }

    public double getValor(){
        if(this.depreciacionFechas.getAnios() > 0 || this.depreciacionFechas.getMeses() > 0){
            return getValorResidual() - getValorDepreciacion();
        }else {
            return -1;
        }
    }

    public double getValorTotal(){
        if (this.getValor() > 0){
            return this.getValor();
        }
        return getValorNeto();
    }



    public void prueba(){
        System.out.println("Valor Inicial del auto "+
                this.vehiculo.getPrecio()+" Su auto "+ this.vehiculo.getMarca()+" se ha depreciado un: "+getValorDepreciacion()
                +" ahora vale "+getValorTotal());
    }

}
