package grupo11.tpo;

import grupo11.tpo.entity.Hotel;
import grupo11.tpo.repository.HotelRepository;
import grupo11.tpo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpoApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(TpoApplication.class, args);
	}

	@Autowired
	private HotelService hotelService;
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public void run(String... args) throws Exception {
		for (Hotel hotel : hotelRepository.findAll()) {
			System.out.println(hotel.getNombre());
		}
	}

}
