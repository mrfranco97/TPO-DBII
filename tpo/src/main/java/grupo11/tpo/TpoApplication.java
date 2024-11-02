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
		Hotel hoteljava = new Hotel("Universal7","Florida 23","2213516","disney@algo.com","Florida");
		hotelService.guardarHotel(hoteljava);
		for (Hotel hotel : hotelRepository.findAll()) {
			System.out.println(hotel.getName()+" "+hotel.getId());
		}
		System.out.println(hotelService.modificarHotel(25L,"Six Flags","Algun lado mas","11526588","sixflags@gmail.com","Orlando"));

	}

}
