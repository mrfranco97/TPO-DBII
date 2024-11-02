package grupo11.tpo.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Huesped")
public class Huesped {
    @MongoId
    private String id;

    private String name;
    private String address;
    private String phone;
    private String mail;

    public Huesped(String nombre, String direccion, String telefono, String correo) {
        this.name = nombre;
        this.address = direccion;
        this.phone = telefono;
        this.mail = correo;
    }
}
