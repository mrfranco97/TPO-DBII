package grupo11.tpo;

import grupo11.tpo.component.OperacionesMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

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
			System.out.println("2. Gestion de Habitaciones");
			System.out.println("3. Gestion de Amenities");
			System.out.println("4. Gestion de POIs");
			System.out.println("5. Alta de huesped y Reserva");
			System.out.println("6. Búsqueda y Consulta");
			System.out.println("0. Salir");

			option = scanner.nextInt();

			switch (option) {
				case 1:
					operacionesMenu.gestionarHoteles(scanner);
					break;
				case 2:
					operacionesMenu.gestionarHabitaciones(scanner);
					break;
				case 3:
					operacionesMenu.gestionarAmenities(scanner);
					break;
				case 4:
					operacionesMenu.gestionarPOI(scanner);
					break;
				case 5:
					operacionesMenu.gestionarHuespedesReservas(scanner);
					break;
				case 6:
					operacionesMenu.consultasEspecificas(scanner);
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
