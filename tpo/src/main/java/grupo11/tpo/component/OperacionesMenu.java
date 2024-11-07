package grupo11.tpo.component;

import grupo11.tpo.entity.Hotel;
import grupo11.tpo.entity.Huesped;
import grupo11.tpo.entity.POI;
import grupo11.tpo.entity.Reserva;
import grupo11.tpo.service.HotelService;
import grupo11.tpo.service.HuespedService;
import grupo11.tpo.service.POIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
                    Reserva reserva = new Reserva(fecha_ini,fecha_fin,id_hab);
                    huespedService.agregarReservaAlHuesped(id_hue,reserva);
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
    }

}
