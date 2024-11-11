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
public class HuespedService {
    @Autowired
    private HuespedRepository huespedRepo;

    public void guardarHuesped(Huesped huesped){
        huespedRepo.save(huesped);
    }

    public void eliminarHuesped(String id){
        huespedRepo.deleteById(id);
    }

    public List<Huesped> obtenerHuespedes(){
        return huespedRepo.findAll();
    }

    public Object modificarHuesped(String id,String name,String address, String phone, String mail){
        Optional<Huesped>aux = huespedRepo.findById(id);
        if(aux.isPresent()){
            Huesped huesped = aux.get();
            huesped.setName(name);
            huesped.setAddress(address);
            huesped.setPhone(phone);
            huesped.setMail(mail);
            huespedRepo.save(huesped);
            return huesped;
        }
        else
            return "No existe huesped con ese id";
    }

    /*
    public void agregarReservaAlHuesped(String huespedId, Reserva nuevaReserva) {
        // Buscar al huésped por su ID
        Optional<Huesped> optionalHuesped = huespedRepo.findById(huespedId);
        if (optionalHuesped.isPresent()) {
            Huesped huesped = optionalHuesped.get();
            huesped.addReserva(nuevaReserva);
            huespedRepo.save(huesped);
            System.out.println("Se agrego correctamente");
        } else {
            System.out.println("No existe huesped con ese ID");
        }
    }
    */


    public Huesped obtenerHuespedPorCorreo(String mail) {
        System.out.println("Obteniendo detalles de Huesped: " + mail);
        return huespedRepo.findHuespedByEmail(mail);
    }

}
