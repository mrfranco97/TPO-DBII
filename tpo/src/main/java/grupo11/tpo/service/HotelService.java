package grupo11.tpo.service;

import grupo11.tpo.entity.Hotel;
import grupo11.tpo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepo;

    public void guardarHotel(Hotel hotel) {
        hotelRepo.save(hotel);
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

}
