import java.time.LocalDate;
import java.time.Period;

public class DepreciacionFechas {
    private LocalDate fechaCompra;
    private LocalDate fechaDepreciacion;

    public DepreciacionFechas(LocalDate fechaCompra, LocalDate fechaDepreciacion) {
        this.fechaCompra = fechaCompra;
        this.fechaDepreciacion = fechaDepreciacion;
    }

    public int getAnios(){
        int aniosCompra;
        Period anios = Period.between(this.fechaCompra , this.fechaDepreciacion);
        aniosCompra = anios.getYears();
        if (aniosCompra > 5){
            aniosCompra = 5;
            return aniosCompra;
        }else {
            return anios.getYears();
        }

    }

    public int getMeses(){
        Period meses = Period.between(this.fechaCompra , this.fechaDepreciacion);
        return meses.getMonths();
    }


}
