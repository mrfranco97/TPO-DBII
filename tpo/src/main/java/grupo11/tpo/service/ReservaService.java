package grupo11.tpo.service;

import grupo11.tpo.entity.Huesped;
import grupo11.tpo.entity.Reserva;
import grupo11.tpo.repository.HuespedRepository;
import grupo11.tpo.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@EnableMongoRepositories
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepo;
    @Autowired
    private HuespedRepository huespedRepo;

    public void guardarReserva(String huespedId, Reserva nuevaReserva) {
        Optional<Huesped> optionalHuesped = huespedRepo.findById(huespedId);
        if (optionalHuesped.isPresent()) {
            // Reserva reserva = optionalHuesped.get();
            // huesped.addReserva(nuevaReserva);
            reservaRepo.save(nuevaReserva);
            System.out.println("Se agrego correctamente");
        } else {
            System.out.println("No existe huesped con ese ID");
        }
    }

    public Huesped obtenerReservaPorID(String id) {
        System.out.println("Obteniendo detalles de Reserva Nº" + id);
        return reservaRepo.findReservaById(id);
    }

    public List<Reserva> buscarReservaPorFecha(LocalDate fecha_inicio){
        System.out.println("Buscando reservas por la fecha ingresada: " + fecha_inicio);
        return reservaRepo.findReservesByDate(fecha_inicio);
    }

}
