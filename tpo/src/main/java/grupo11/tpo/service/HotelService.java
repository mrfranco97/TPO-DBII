package grupo11.tpo.service;

import grupo11.tpo.entity.Habitacion;
import grupo11.tpo.entity.Hotel;
import grupo11.tpo.entity.POI;
import grupo11.tpo.relations.SeEncuentraA;
import grupo11.tpo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepo;


    public void guardarHotel(Hotel hotel) {
        hotelRepo.save(hotel);
        System.out.println("Se agrego correctamente");
    }

    public void eliminarHotel(String name) {
        hotelRepo.deleteByName(name);
    }//Habria que meterle comprobaciones

    public Object modificarHotel(Long id,String name, String address,String phone,String mail, String location){
        Optional<Hotel> aux=hotelRepo.findById(id);
        if(aux.isPresent()){
            Hotel hotel= aux.get();
            hotel.setName(name);
            hotel.setAddress(address);
            hotel.setMail(mail);
            hotel.setPhone(phone);
            hotel.setLocation(location);
            hotelRepo.save(hotel);
            return hotel;
        }
        else
            return "No existe hotel con esa id";
    }

    public void agregarPOIalHotel(POI poi, Hotel hotel,Double distancia){
        hotel.agregarPOI(new SeEncuentraA(poi,distancia));
        hotelRepo.save(hotel);
        System.out.println("Se guardo correctamente.");
    }

    public void agregarHabitacionalHotel(Hotel hotel,Habitacion habitacion){
        hotel.agregarHabitacion(habitacion);
        hotelRepo.save(hotel);
    }
    public List<Hotel> obtenerHoteles(){
        return hotelRepo.findAll();
    }

    public Hotel buscarHotelPorId(Long id){
        Optional<Hotel> aux=hotelRepo.findById(id);
        if (aux.isPresent()){
            return aux.get();
        }
        else
        {
            return null;
        }
    }

}
