package grupo11.tpo.service;

import grupo11.tpo.entity.Hotel;
import grupo11.tpo.entity.POI;
import grupo11.tpo.relations.SeEncuentraA;
import grupo11.tpo.repository.HotelRepository;
import grupo11.tpo.repository.POIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepo;
    @Autowired
    private POIRepository poiRepository;

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

    public void agregarPOI(Long id_hotel,Long id_poi, double distancia) {
        Optional<Hotel>aux=hotelRepo.findById(id_hotel);
        Optional<POI>aux2=poiRepository.findById(id_poi);
        if (aux.isPresent() && aux2.isPresent()){
            Hotel hotel=aux.get();
            POI poi=aux2.get();
            hotel.agregarPoi(poi,distancia);
            System.out.println("Se agrego POI correctamente");
        }
        else{
            if (!aux.isPresent()){
                System.out.println("No existe Hotel con dicho ID");
            }
            else {
                System.out.println("No existe POI con dicho ID");
            }
        }

    }

}
