package grupo11.tpo;

import grupo11.tpo.entity.Hotel;
import grupo11.tpo.entity.Huesped;
import grupo11.tpo.entity.Reserva;
import grupo11.tpo.repository.HotelRepository;
import grupo11.tpo.service.HotelService;
import grupo11.tpo.service.HuespedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

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
		/*Huesped huespedjava = new Huesped("Juan23","Monroe 123","45564455","juan@algo.com");
		huespedService.guardarHuesped(huespedjava);
		for (Huesped huesped : huespedService.obtenerHuespedes()) {
			System.out.println(huesped.getName()+" "+huesped.getId());
		}
		System.out.println(huespedService.modificarHuesped("67266104452d354a468c8583","Carlos","","123456","Carlos@gmail.com"));*/

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese fecha inicio (formato: yyyy-MM-dd):");
		String inicio = scanner.nextLine();
		LocalDate fecha_ini = LocalDate.parse(inicio, DateTimeFormatter.ISO_LOCAL_DATE);
		System.out.println("Fecha ingresada: " + fecha_ini);
		System.out.println("Ingrese fecha fin (formato: yyyy-MM-dd):");
		String fin = scanner.nextLine();
			// Convierte la cadena a LocalDate
		LocalDate fecha_fin = LocalDate.parse(fin, DateTimeFormatter.ISO_LOCAL_DATE);
		System.out.println("Fecha ingresada: " + fecha_fin);
		Reserva reserva = new Reserva(fecha_ini,fecha_fin,666L);
		huespedService.agregarReservaAlHuesped("672661fb8d993413df08456a",reserva);

	}

}
