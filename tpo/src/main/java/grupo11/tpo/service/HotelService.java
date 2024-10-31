package grupo11.tpo.service;

import grupo11.tpo.entity.Hotel;
import grupo11.tpo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepo;

    public Hotel guardarHotel(Hotel hotel) {
        return hotelRepo.save(hotel);
    }
}
