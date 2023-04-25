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
        Period anios = Period.between(this.fechaCompra , this.fechaDepreciacion);
        return anios.getYears();
    }

    public int getMeses(){
        Period meses = Period.between(this.fechaCompra , this.fechaDepreciacion);
        return meses.getMonths();
    }


}
