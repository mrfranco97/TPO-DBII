package grupo11.tpo;

import grupo11.tpo.entity.Hotel;
import grupo11.tpo.entity.Huesped;
import grupo11.tpo.repository.HotelRepository;
import grupo11.tpo.service.HotelService;
import grupo11.tpo.service.HuespedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TpoApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(TpoApplication.class, args);
	}

	@Autowired
	private HotelService hotelService;
	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	HuespedService huespedService;

	@Override
	public void run(String... args) throws Exception {
		Huesped huespedjava = new Huesped("Juan23","Monroe 123","45564455","juan@algo.com");
		huespedService.guardarHuesped(huespedjava);
		for (Huesped huesped : huespedService.obtenerHuespedes()) {
			System.out.println(huesped.getName()+" "+huesped.getId());
		}
		System.out.println(huespedService.modificarHuesped("67266104452d354a468c8583","Carlos","","123456","Carlos@gmail.com"));

	}

}
