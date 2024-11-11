package grupo11.tpo.component;

import grupo11.tpo.entity.Hotel;
import grupo11.tpo.entity.Huesped;
import grupo11.tpo.entity.POI;
import grupo11.tpo.entity.Reserva;
import grupo11.tpo.service.HotelService;
import grupo11.tpo.service.HuespedService;
import grupo11.tpo.service.ReservaService;
import grupo11.tpo.service.POIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import grupo11.tpo.entity.Amenity;
import grupo11.tpo.entity.Habitacion;
import grupo11.tpo.service.AmenityService;
import grupo11.tpo.service.HabitacionService;
import java.util.Optional;
import java.util.Scanner;


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
    private POIService poiService;
    @Autowired
    private AmenityService amenityService;
    @Autowired
    private HabitacionService habitacionService;
    @Autowired
    private ReservaService reservaService;


    public void gestionarHoteles(Scanner scanner) {
        int option;
        do {
            System.out.println("---------------------------Gestión de Hoteles------------------------------");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Alta de Hotel");
            System.out.println("2. Baja de Hotel");
            System.out.println("3. Modificación de Hotel");
            System.out.println("4. Agregar POI");
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
                    Hotel hotel = new Hotel(nombre,direccion,telefono,correo,ubicacion);
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
                case 4:
                    System.out.println("Ingrese el nombre del Hotel:");
                    String nombre_hotel = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Ingrese el id del POI:");
                    Long poi_cod = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Ingrese la distancia con el POI:");
                    Double distancia = scanner.nextDouble();
                    scanner.nextLine();
                    POI poi=poiService.buscarPOI(poi_cod);
                    hotelService.agregarPOIalHotel(poi,nombre_hotel,distancia);
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
            System.out.println("--------------------Gestión de Huespedes--------------------------------");
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
                    Reserva reserva = new Reserva(fecha_ini,fecha_fin,id_hab,id_hue);
                    reservaService.guardarReserva(id_hue,reserva);
                case 0:
                    System.out.println("Volviendo al menú de Principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (option != 0);
    }

    public void gestionarPOI(Scanner scanner) {
        int option;
        do {
            System.out.println("-----------------------Gestión de POI-------------------------------");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Alta de POI");
            System.out.println("2. Baja de POI");
            System.out.println("3. Modificar POI");
            System.out.println("0. Volver al menú principal");

            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Ingrese el nombre del POI:");
                    String nombre = scanner.nextLine();
                    POI poi = new POI(nombre);
                    poiService.guardarPOI(poi);
                    break;
                case 2:
                    //Logicas de eliminacion de poi
                    break;
                case 3:
                    //Logica de modificacion de huesped
                case 0:
                    System.out.println("Volviendo al menú de Principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (option != 0);
    }

    public void busquedaConsulta(Scanner scanner) {
        // Implementar lógica para búsqueda y consulta
        int option;
        do {
            System.out.println("Busqueda y Consulta");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ver detalles de Huesped");
            System.out.println("2. Buscar Reservas por Fecha");
            System.out.println("3. Buscar Reservas por ID");
            System.out.println("0. Volver al menú principal");

            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Ingrese el correo del huesped");
                    String correo_hues = scanner.nextLine();
                    huespedService.obtenerHuespedPorCorreo(correo_hues);
                case 2:
                    System.out.println("Ingresar la fecha de reserva (formato: yyyy-MM-dd): ");
                    String inicio = scanner.nextLine();
                    LocalDate fecha_ini = LocalDate.parse(inicio, DateTimeFormatter.ISO_LOCAL_DATE);
                    reservaService.buscarReservaPorFecha(fecha_ini);
                case 3:
                    System.out.println("Ingrese el ID de la Reserva");
                    String id_reserva = scanner.nextLine();
                    reservaService.obtenerReservaPorID(id_reserva);
                case 0:
                    System.out.println("Volviendo al menú de huespedes...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (option != 0);
    }

    ////////////////////////////////7
    public void gestionarAmenities(Scanner scanner) {
        int opcion;
        do {
            System.out.println("Gestión de Amenities:");
            System.out.println("1. Agregar Amenity");
            System.out.println("2. Modificar Amenity");
            System.out.println("3. Eliminar Amenity");
            System.out.println("0. Volver al menú principal");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del amenity: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la descripción del amenity: ");
                    String descripcion = scanner.nextLine();
                    Amenity nuevoAmenity = new Amenity(nombre, descripcion);
                    amenityService.guardarAmenity(nuevoAmenity);
                    break;

                case 2:
                    System.out.print("Ingrese el ID del amenity a modificar: ");
                    Long idModAmenity = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Ingrese la nueva descripción: ");
                    String nuevaDescripcion = scanner.nextLine();
                    Optional<Amenity> amenityMod = amenityService.modificarAmenity(idModAmenity, nuevoNombre, nuevaDescripcion);
                    if (amenityMod.isPresent()) {
                        System.out.println("Amenity modificado correctamente.");
                    } else {
                        System.out.println("Amenity no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el nombre del amenity a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    amenityService.eliminarAmenity(nombreEliminar);
                    System.out.println("Amenity eliminado correctamente.");
                    break;

                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    public void gestionarHabitaciones(Scanner scanner) {
        int opcion;
        do {
            System.out.println("--------------------Gestión de Habitaciones:-------------------------------");
            System.out.println("1. Agregar Habitación");
            System.out.println("2. Modificar Habitación");
            System.out.println("3. Eliminar Habitación");
            System.out.println("0. Volver al menú principal");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el tipo de habitación: ");
                    String tipo = scanner.nextLine();
                    Habitacion nuevaHabitacion = new Habitacion(tipo);
                    habitacionService.guardarHabitacion(nuevaHabitacion);
                    break;

                case 2:
                    System.out.print("Ingrese el ID de la habitación a modificar: ");
                    Long idModHabitacion = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Ingrese el nuevo tipo: ");
                    String nuevoTipo = scanner.nextLine();
                    System.out.print("Ingrese la nueva capacidad: ");
                    int nuevaCapacidad = scanner.nextInt();
                    System.out.print("¿Está disponible? (true/false): ");
                    boolean nuevaDisponibilidad = scanner.nextBoolean();
                    scanner.nextLine();
                    Optional<Habitacion> habitacionMod = habitacionService.modificarHabitacion(idModHabitacion, nuevoTipo, nuevaCapacidad, nuevaDisponibilidad);
                    if (((java.util.Optional<?>) habitacionMod).isPresent()) {
                        System.out.println("Habitación modificada correctamente.");
                    } else {
                        System.out.println("Habitación no encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el ID de la habitación a eliminar: ");
                    Long idEliminar = scanner.nextLong();
                    habitacionService.eliminarHabitacion(idEliminar);
                    System.out.println("Habitación eliminada correctamente.");
                    break;

                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

}