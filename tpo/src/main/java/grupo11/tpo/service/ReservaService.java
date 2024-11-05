package grupo11.tpo.service;

import grupo11.tpo.entity.Huesped;
import grupo11.tpo.entity.Reserva;
import grupo11.tpo.repository.HuespedRepository;
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

}
