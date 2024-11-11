package grupo11.tpo.service;

import grupo11.tpo.entity.Amenity;
import grupo11.tpo.repository.AmenityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AmenityService {
    @Autowired
    private AmenityRepository amenityRepo;

    public void guardarAmenity(Amenity amenity) {
        amenityRepo.save(amenity);
        System.out.println("Amenity agregado correctamente.");
    }

    public void eliminarAmenity(Long id) {
        amenityRepo.deleteById(id);
        System.out.println("Se elimino satisfactoriamente.");
    }

    public void modificarAmenity(Amenity amenity, String nombre, String descripcion) {
        amenity.setName(nombre);
        amenity.setDescription(descripcion);
        amenityRepo.save(amenity);
        System.out.println("Se guardo correctamente");
    }

    public List<Amenity> obtenerAmenities(){return amenityRepo.findAll();}

    public Amenity obtenerAmenitiesporId(Long id){
        Optional<Amenity> aux = amenityRepo.findById(id);
        if (aux.isPresent()){
            return aux.get();
        }
        else return null;
    }
}
