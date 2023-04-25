public class GestorDepreciacion {
    private double valorResidual;
    private double valorDepreciacion;
    private double valorTotal;
    private DepreciacionFechas depreciacionFechas;
    private Vehiculo vehiculo;

    public GestorDepreciacion(Vehiculo vehiculo, DepreciacionFechas depreciacionFechas) {
        this.vehiculo = vehiculo;
        this.depreciacionFechas = depreciacionFechas;
    }

    public double getValorResidual() {
        this.valorResidual = this.vehiculo.getPrecio()-this.vehiculo.getPrecio()*0.1;
        return this.valorResidual;
    }

    public double getValorDepreciacion(){
        this.valorDepreciacion=this.depreciacionFechas.getAnios()*0.20+this.depreciacionFechas.getMeses()*0.0166;
        return this.valorDepreciacion;
    }

    public double getValorTotal(){
        if(this.depreciacionFechas.getAnios() == 0 || this.depreciacionFechas.getMeses() == 0){
            return -1;
        }else {
            this.valorTotal = getValorResidual() - getValorDepreciacion();
            return this.valorTotal;
        }
    }

    


}
