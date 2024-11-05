package grupo11.tpo.service;

import grupo11.tpo.entity.Reserva;
import grupo11.tpo.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@EnableMongoRepositories
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepo;

    public Huesped obtenerReservaporID(int id) {
        System.out.println("Obteniendo detalles de Reserva Nº" + id);
        return reservaRepo.findReservaById(id);
    }

    public List<Reserva> buscarReservaPorFecha(LocalDate fecha_inicio){
        System.out.println("Buscando reservas por la fecha ingresada: " + fecha_inicio);
        return findReservesByDate(fecha_inicio);
    }

}
