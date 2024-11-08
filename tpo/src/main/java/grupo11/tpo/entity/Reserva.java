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

    private LocalDate fecha_inicio;
    private LocalDate fecha_final;
    private Long id_habitacion;
    private boolean confirmacion;

    public Reserva(LocalDate fecha_inicio,LocalDate fecha_final,Long id_habitacion){
        this.fecha_inicio=fecha_inicio;
        this.fecha_final=fecha_final;
        this.id_habitacion=id_habitacion;
        this.confirmacion=false;
    }
}
