package grupo11.tpo.component;

import grupo11.tpo.entity.Hotel;
import grupo11.tpo.entity.Huesped;
import grupo11.tpo.entity.Reserva;
import grupo11.tpo.service.HotelService;
import grupo11.tpo.service.HuespedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import grupo11.tpo.entity.Amenity;
import grupo11.tpo.entity.Habitacion;
import grupo11.tpo.service.AmenityService;
import grupo11.tpo.service.HabitacionService;


import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Component
public class OperacionesMenu {
    @Autowired
    private HuespedService huespedService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private AmenityService amenityService;
    @Autowired
    private HabitacionService habitacionService;


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
                    System.out.println("Ingrese el nombre del hotel:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese la dirección del hotel:");
                    String direccion = scanner.nextLine();
                    System.out.println("Ingrese el teléfono del hotel:");
                    String telefono = scanner.nextLine();
                    System.out.println("Ingrese el correo del hotel:");
                    String correo = scanner.nextLine();
                    System.out.println("Ingrese el correo la zona del ubicacion:");
                    String ubicacion = scanner.nextLine();
                    Hotel hotel = new Hotel(nombre, direccion, telefono, correo, ubicacion);
                    hotelService.guardarHotel(hotel);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del hotel:");
                    String nombre_h = scanner.nextLine();
                    hotelService.eliminarHotel(nombre_h);
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
                    System.out.println("Ingrese el Id del huésped:");
                    String id = scanner.nextLine();
                    huespedService.eliminarHuesped(id);
                    break;
                case 3:
                    //Logica de modificacion de huesped
                case 4:
                    System.out.println("Ingrese Id del huesped");
                    String id_hue = scanner.nextLine();
                    System.out.println("Ingrese fecha inicio (formato: yyyy-MM-dd):");
                    String inicio = scanner.nextLine();
                    LocalDate fecha_ini = LocalDate.parse(inicio, DateTimeFormatter.ISO_LOCAL_DATE);
                    System.out.println("Ingrese fecha fin (formato: yyyy-MM-dd):");
                    String fin = scanner.nextLine();
                    LocalDate fecha_fin = LocalDate.parse(fin, DateTimeFormatter.ISO_LOCAL_DATE);
                    System.out.println("Ingrese Id de habitacion");
                    Long id_hab = scanner.nextLong();
                    Reserva reserva = new Reserva(fecha_ini, fecha_fin, id_hab);
                    huespedService.agregarReservaAlHuesped(id_hue, reserva);
                case 0:
                    System.out.println("Volviendo al menú de huespedes...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (option != 0);
    }

    public void busquedaConsulta(Scanner scanner) {
        // Implementar lógica para búsqueda y consulta
        this.scanner = scanner;
    }


    public void gestionarAmenities(Scanner scanner) {
        int option;
        do {
            System.out.println("Gestión de Amenities");
            System.out.println("1. Alta de Amenity");
            System.out.println("2. Baja de Amenity");
            System.out.println("3. Modificar Amenity");
            System.out.println("4. Consultar Amenity");
            System.out.println("0. Volver al menú principal");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Ingrese el nombre del amenity:");
                    String name = scanner.nextLine();
                    System.out.println("Ingrese la descripcion del amenity:");
                    String description = scanner.nextLine();
                    Amenity amenity = new Amenity(name, description);
                    amenityService.guardarAmenity(amenity);
                    System.out.println("Amenity guardado.");
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del amenity a eliminar:");
                    String nameToDelete = scanner.nextLine();
                    amenityService.eliminarAmenity(nameToDelete);
                    System.out.println("Amenity eliminado.");
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del amenity a modificar:");
                    String nameToUpdate = scanner.nextLine();
                    System.out.println("Ingrese la nueva descripcion:");
                    String newDescription = scanner.nextLine();
                    amenityService.actualizarAmenity(nameToUpdate, newDescription);
                    System.out.println("Amenity actualizado.");
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del amenity a consultar:");
                    String nameToConsult = scanner.nextLine();
                    amenityService.obtenerAmenityPorNombre(nameToConsult)
                            .ifPresentOrElse(
                                    a -> System.out.println("Amenity encontrado: " + a),
                                    () -> System.out.println("Amenity no encontrado.")
                            );
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }
        } while (option != 0);
    }
    public void gestionarHabitaciones() {
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            System.out.println("Gestión de Habitaciones");
            System.out.println("1. Alta de Habitación");
            System.out.println("2. Baja de Habitación");
            System.out.println("3. Modificar Disponibilidad de Habitación");
            System.out.println("4. Buscar Habitaciones Disponibles");
            System.out.println("0. Volver al menú principal");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Ingrese el ID de la habitación:");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Ingrese el tipo de habitación:");
                    String tipo = scanner.nextLine();
                    System.out.println("Ingrese la capacidad de la habitación:");
                    int capacidad = scanner.nextInt();
                    scanner.nextLine();
                    Habitacion habitacion = new Habitacion(id, tipo, capacidad, true);
                    habitacionService.guardarHabitacion(habitacion);
                    System.out.println("Habitación guardada.");
                    break;
                case 2:
                    System.out.println("Ingrese el ID de la habitación a eliminar:");
                    Long idToDelete = scanner.nextLong();
                    habitacionService.eliminarHabitacion(idToDelete);
                    System.out.println("Habitación eliminada.");
                    break;
                case 3:
                    System.out.println("Ingrese el ID de la habitación a modificar:");
                    Long idToUpdate = scanner.nextLong();
                    System.out.println("Ingrese la nueva disponibilidad (true/false):");
                    boolean disponibilidad = scanner.nextBoolean();
                    habitacionService.actualizarDisponibilidad(idToUpdate, disponibilidad);
                    System.out.println("Disponibilidad actualizada.");
                    break;

                case 0:
                    System.out.println("Volviendo al menú principal");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (option != 0);

        scanner.close();
    }
}

