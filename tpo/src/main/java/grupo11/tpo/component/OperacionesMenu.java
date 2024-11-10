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
import grupo11.tpo.entity.Amenity;
import grupo11.tpo.entity.Habitacion;
import grupo11.tpo.service.AmenityService;
import grupo11.tpo.service.HabitacionService;
import java.util.Optional;
import java.util.Scanner;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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


    public void gestionarHoteles(Scanner scanner) {
        int option;
        do {
            System.out.println("---------------------------Gestión de Hoteles------------------------------");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Alta de Hotel");
            System.out.println("2. Baja de Hotel");
            System.out.println("3. Modificación de Hotel");
            System.out.println("4. Agregar POI");
            System.out.println("5. Listar Hoteles");
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
                    System.out.println("Seleccione el hotel....");
                    for(Hotel hotel_p: hotelService.obtenerHoteles()){
                        System.out.println(hotel_p.getId()+". "+hotel_p.getName());
                    }
                    Long id_hotel = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Seleccione el POI....");
                    for(POI poi:poiService.obtenerPOIs()){
                        System.out.println(poi.getId()+". "+poi.getName());
                    }
                    Long poi_cod = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Ingrese la distancia entre ellos: ");
                    Double distancia = scanner.nextDouble();
                    scanner.nextLine();
                    POI poi=poiService.buscarPOI(poi_cod);
                    Hotel hotel_poi=hotelService.buscarHotelPorId(id_hotel);
                    hotelService.agregarPOIalHotel(poi,hotel_poi,distancia);
                    break;
                case 5: for (Hotel hotel2: hotelService.obtenerHoteles()){
                    System.out.println(hotel2.getId()+" "+hotel2.getName());
                }
                break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (option != 0);
    }

    public void gestionarHuespedesReservas(Scanner scanner) {
        int option;
        do {
            System.out.println("--------------------Gestión de Huespedes y Reservas--------------------------------");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Alta de Huesped");
            System.out.println("2. Generar Reserva");
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

    public void gestionarAmenities(Scanner scanner) {
        int opcion;
        do {
            System.out.println("-------------------Gestión de Amenities:----------------------------");
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
            System.out.println("4. Agregar Amenity");
            System.out.println("0. Volver al menú principal");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Seleccion el hotel al que le dara de alta la habitacion.... ");
                    for(Hotel hotel : hotelService.obtenerHoteles()){
                        System.out.print(hotel.getId()+hotel.getName());
                    }
                    Long seleccion = scanner.nextLong();
                    scanner.nextLine();
                    Hotel hotel_seleccionado=hotelService.buscarHotelPorId(seleccion);
                    System.out.print("Ingrese el tipo de habitación: ");
                    String tipo = scanner.nextLine();
                    Habitacion nuevaHabitacion = new Habitacion(tipo);
                    habitacionService.guardarHabitacion(nuevaHabitacion);
                    hotelService.agregarHabitacionalHotel(hotel_seleccionado,nuevaHabitacion);
                    break;

                case 2:
                    System.out.print("Ingrese el ID de la habitación a modificar: ");
                    Long idModHabitacion = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Ingrese el nuevo tipo: ");
                    String nuevoTipo = scanner.nextLine();
                    Optional<Habitacion> habitacionMod = habitacionService.modificarHabitacion(idModHabitacion, nuevoTipo);
                    if (((java.util.Optional<?>) habitacionMod).isPresent()) {
                        System.out.println("Habitación modificada correctamente.");
                    } else {
                        System.out.println("Habitación no encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el ID de la habitación a eliminar: ");
                    Long idEliminar = scanner.nextLong();
                    scanner.nextLine();
                    habitacionService.eliminarHabitacion(idEliminar);
                    System.out.println("Habitación eliminada correctamente.");
                    break;
                case 4:
                    System.out.println("Seleccione el hotel...");
                    for(Hotel hoteles: hotelService.obtenerHoteles())
                    {
                        System.out.println(hoteles.getId()+". "+hoteles.getName());
                    }
                    Long hotel_sel=scanner.nextLong();
                    Hotel hotel_selec=hotelService.buscarHotelPorId(hotel_sel);
                    for(Habitacion habitaciones:hotel_selec.getHabitaciones()){
                        System.out.println(habitaciones.getId()+". "+habitaciones.getTipo());
                    }
                    Long habitacion_sel=scanner.nextLong();
                    scanner.nextLine();
                    Habitacion habitacion_selec=habitacionService.obtenerHabitacionporId(habitacion_sel);
                    for(Amenity amenities:amenityService.obtenerAmenities()){
                        System.out.println(amenities.getId()+". "+amenities.getName());
                    }
                    Long ameniti_sel=scanner.nextLong();
                    scanner.nextLine();
                    Amenity amenity_selec=amenityService.obtenerAmenitiesporId(ameniti_sel);
                    habitacionService.agregarAmenity(habitacion_selec,amenity_selec);

                    break;

                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    public void consultasEspecificas(Scanner scanner) {
        int opcion;
        do {
            System.out.println("--------------------Consultas Especificas:-------------------------------");
            System.out.println("1. Detalles Hotel");
            System.out.println("2. Amenities de una habitacion");
            System.out.println("0. Volver al menú principal");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Seleccion el hotel... ");
                    for(Hotel hotel : hotelService.obtenerHoteles()){
                        System.out.print(hotel.getId()+". "+hotel.getName());
                        System.out.println();
                    }
                    Long seleccion = scanner.nextLong();
                    scanner.nextLine();
                    Hotel hotel_seleccionado=hotelService.buscarHotelPorId(seleccion);
                    System.out.println("-----------------------Detalles:---------------- ");
                    System.out.println("Nombre: "+hotel_seleccionado.getName());
                    System.out.println("Direccion: "+hotel_seleccionado.getAddress());
                    System.out.println("Mail: "+hotel_seleccionado.getMail());
                    System.out.println("Telefono: "+hotel_seleccionado.getPhone());
                    System.out.println("Ubicacion: "+hotel_seleccionado.getLocation());
                    System.out.println("--------------------------------------------------- ");
                    break;
                case 2:
                    System.out.println("Seleccione el hotel...");
                    for(Hotel hoteles: hotelService.obtenerHoteles())
                    {
                        System.out.print(hoteles.getId()+". "+hoteles.getName());
                        System.out.println();
                    }
                    Long hotel_sel=scanner.nextLong();
                    Hotel hotel_selec=hotelService.buscarHotelPorId(hotel_sel);
                    for(Habitacion habitaciones:hotel_selec.getHabitaciones()){
                        System.out.print(habitaciones.getId()+". "+habitaciones.getTipo());
                        System.out.println();
                    }
                    Long habitacion_sel=scanner.nextLong();
                    scanner.nextLine();
                    Habitacion habitacion_selec=habitacionService.obtenerHabitacionporId(habitacion_sel);
                    System.out.println("-------------------------Amenities--------------------------");
                    for(Amenity amenties : habitacion_selec.getAmenities()){
                        System.out.println("-"+amenties.getName());
                        System.out.println();
                    }
                    System.out.println("------------------------------------------------------------");
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