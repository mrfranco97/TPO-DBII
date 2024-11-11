package grupo11.tpo.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;

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
    //private List<Reserva> reservas = new ArrayList<Reserva>();

    public Huesped(String name, String address, String phone, String mail) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
    }
    /* public void addReserva(Reserva reserva) {
        this.reservas.add(reserva);
    } */

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }
}
