package grupo11.tpo.component;

import grupo11.tpo.entity.Huesped;
import grupo11.tpo.service.HotelService;
import grupo11.tpo.service.HuespedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class OperacionesMenu {
    @Autowired
    private HuespedService huespedService;
    @Autowired
    private HotelService hotelService;
    public void gestionarHoteles(Scanner scanner) {
        int option;
        do {
            System.out.println("Gestión de Hoteles");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Alta de Hotel");
            System.out.println("2. Baja de Hotel");
            System.out.println("3. Modificación de Hotel");
            System.out.println("0. Volver al menú principal");

            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    // Lógica para alta de hotel
                    break;
                case 2:
                    // Lógica para baja de hotel
                    break;
                case 3:
                    // Lógica para modificación de hotel
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (option != 0);
    }

    public void gestionarHuespedes(Scanner scanner) {
        int option;
        do {
            System.out.println("Gestión de Huespedes");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Alta de Huesped");
            System.out.println("2. Baja de Huesped");
            System.out.println("3. Modificar Huesped");
            System.out.println("4. Generar Reserva");
            System.out.println("0. Volver al menú principal");

            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Ingrese el nombre del huésped:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese la dirección del huésped:");
                    String direccion = scanner.nextLine();
                    System.out.println("Ingrese el teléfono del huésped:");
                    String telefono = scanner.nextLine();
                    System.out.println("Ingrese el correo del huésped:");
                    String correo = scanner.nextLine();
                    Huesped huesped = new Huesped(nombre, direccion, telefono, correo);
                    huespedService.guardarHuesped(huesped);
                    break;
                case 2:
                    // Lógica para baja de hotel
                    break;
                case 3:
                    // Lógica para modificación de hotel
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (option != 0);
    }

    public void busquedaConsulta(Scanner scanner) {
        // Implementar lógica para búsqueda y consulta
    }

}
