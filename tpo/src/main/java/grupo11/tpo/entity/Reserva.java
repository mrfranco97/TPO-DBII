package grupo11.tpo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Reserva")
public class Reserva {
    @MongoId
    private String id;

    private String id_huesped;
    private LocalDate fecha_inicio;
    private LocalDate fecha_final;
    private Long id_habitacion;
    private boolean confirmacion;

    public Reserva(LocalDate fecha_inicio,LocalDate fecha_final,Long id_habitacion, String id_huesped){
        this.fecha_inicio=fecha_inicio;
        this.fecha_final=fecha_final;
        this.id_habitacion=id_habitacion;
        this.confirmacion=false;
        this.id_huesped=id_huesped;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public LocalDate getFecha_final() {
        return fecha_final;
    }

    public Long getId_habitacion() {
        return id_habitacion;
    }

    public String getId_huesped() {
        return id_huesped;
    }

    public String getId() {
        return id;
    }
}
