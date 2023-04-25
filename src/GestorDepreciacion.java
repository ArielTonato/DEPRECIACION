public class GestorDepreciacion {
    private double valorResidual;
    private double valorTotal;
    private double valorNeto;
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
        return getValorResidual()*this.depreciacionFechas.getAnios()*0.20+
                getValorResidual()*this.depreciacionFechas.getMeses()*0.0166;
    }

    public double getValorTotal(){
        if(this.depreciacionFechas.getAnios() > 0 || this.depreciacionFechas.getMeses() > 0){
            this.valorTotal = getValorResidual() - getValorDepreciacion();
            return this.valorTotal;
        }else {
            return -1;
        }
    }

    public void prueba(){
        System.out.println("Valor Inicial del auto "+
                this.vehiculo.getPrecio()+" Su auto "+ this.vehiculo.getMarca()+" se ha depreciado un: "+getValorDepreciacion()
                +" ahora vale "+getValorTotal());
    }


}
