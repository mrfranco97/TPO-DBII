package grupo11.tpo;

import grupo11.tpo.component.OperacionesMenu;
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
	private OperacionesMenu operacionesMenu;

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int option;

		do {
			System.out.println("-----------------Bienvenido al Sistema de Gestión Hotelera-------------------------");
			System.out.println("Seleccione una opción:");
			System.out.println("1. Gestión de Hoteles");
			System.out.println("2. Gestión de Huéspedes");
			System.out.println("3. Gestion de POIs");
			System.out.println("4. Búsqueda y Consulta");
			System.out.println("0. Salir");

			option = scanner.nextInt();

			switch (option) {
				case 1:
					operacionesMenu.gestionarHoteles(scanner);
					break;
				case 2:
					operacionesMenu.gestionarHuespedes(scanner);
					break;
				case 3:
					operacionesMenu.gestionarPOI(scanner);
					break;
				case 4:
					operacionesMenu.busquedaConsulta(scanner);
					break;
				case 0:
					System.out.println("Saliendo del sistema...");
					break;
				default:
					System.out.println("Opción no válida. Intente nuevamente.");
			}
		} while (option != 0);
		scanner.close();
	}

}
