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
import org.yaml.snakeyaml.events.StreamEndEvent;

import java.util.Optional;
import java.util.Scanner;
import grupo11.tpo.service.ReservaService;



import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
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
                    System.out.println("Ingrese  ubicacion:");
                    String ubicacion = scanner.nextLine();
                    Hotel hotel = new Hotel(nombre,direccion,telefono,correo,ubicacion);
                    hotelService.guardarHotel(hotel);
                    break;
                case 2:
                    System.out.println("Ingrese el hotel que desea eliminar...");
                    System.out.println();
                    for(Hotel hotel3: hotelService.obtenerHoteles()){
                        System.out.println(hotel3.getId()+". "+hotel3.getName());
                        System.out.println();
                    }
                    Long seleccion = scanner.nextLong();
                    scanner.nextLine();
                    hotelService.eliminarHotel(seleccion);
                    break;
                case 3:
                    System.out.println("Seleccion un Hotel: ");
                    for(Hotel hotel_i : hotelService.obtenerHoteles()){
                        System.out.println(hotel_i.getId()+". "+hotel_i.getName());
                        System.out.println();
                    }
                    Long hotel_mod_cod = scanner.nextLong();
                    scanner.nextLine();
                    Hotel hotel_m = hotelService.buscarHotelPorId(hotel_mod_cod);
                    System.out.println("Ingrese el nombre del hotel:");
                    String nombre_m = scanner.nextLine();
                    System.out.println("Ingrese la dirección del hotel:");
                    String direccion_m = scanner.nextLine();
                    System.out.println("Ingrese el teléfono del hotel:");
                    String telefono_m = scanner.nextLine();
                    System.out.println("Ingrese el correo del hotel:");
                    String correo_m = scanner.nextLine();
                    System.out.println("Ingrese  ubicacion:");
                    String ubicacion_m = scanner.nextLine();
                    hotelService.modificarHotel(hotel_m,nombre_m,direccion_m,correo_m,telefono_m,ubicacion_m);
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
            System.out.println("3. Buscar Habitación Disponible en Fechas");
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
                    Reserva reserva = new Reserva(fecha_ini,fecha_fin,id_hab,id_hue);
                    reservaService.guardarReserva(id_hue,reserva);
                    break;
                case 3:
                    // Buscar habitación disponible en un rango de fechas
                    System.out.println("Ingrese la fecha de inicio (formato: yyyy-MM-dd):");
                    String init = scanner.nextLine();
                    LocalDate fechaInicio = LocalDate.parse(init, DateTimeFormatter.ISO_LOCAL_DATE);
                    System.out.println("Ingrese la fecha de fin (formato: yyyy-MM-dd):");
                    String ult = scanner.nextLine();
                    LocalDate fechaFin = LocalDate.parse(ult, DateTimeFormatter.ISO_LOCAL_DATE);
                    List<Habitacion> habitacionesDisponibles = habitacionService.buscarHabitacionesDisponibles(fechaInicio, fechaFin);
                    habitacionesDisponibles.forEach(System.out::println); // Mostrar habitaciones disponibles
                    break;
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
                    System.out.println("Ingrese el POI que desea elminar....");
                    for(POI pois: poiService.obtenerPOIs()){
                        System.out.println(pois.getId()+". "+pois.getName());
                        System.out.println();
                    }
                    Long poi_cod_d = scanner.nextLong();
                    scanner.nextLine();
                    poiService.eliminarPOI(poi_cod_d);
                    break;
                case 3:
                    System.out.println("Selecione un POI: ");
                    for(POI pois : poiService.obtenerPOIs()){
                        System.out.println(pois.getId()+". "+pois.getName());
                        System.out.println();
                    }
                    Long poi_cod_m = scanner.nextLong();
                    scanner.nextLine();
                    POI poi_m=poiService.buscarPOI(poi_cod_m);
                    System.out.println("Ingrese el nuevo nombre: ");
                    String nombre_m = scanner.nextLine();
                    poiService.modificarPoi(poi_m,nombre_m);
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
            System.out.println("3. Buscar Reservas por Numero de Confirmacion (ID)");
            System.out.println("4. Consultar Reservas por Huesped");
            System.out.println("5. Consultar Detalles de Hotel");
            System.out.println("6. Consultar Amenities de Habitacion");
            System.out.println("0. Volver al menú principal");

            option = scanner.nextInt();
            scanner.nextLine();
            String correo_hues = ""; // Inicializar la variable
            switch (option) {
                case 1:
                    System.out.println("Ingrese el correo del huesped");
                    correo_hues = scanner.nextLine();
                    Huesped huesped_buscado = huespedService.obtenerHuespedPorCorreo(correo_hues);
                    System.out.println("-----------------------Detalles:---------------- ");
                    System.out.println("Nombre: "+huesped_buscado.getName());
                    System.out.println("Correo: "+huesped_buscado.getMail());
                    System.out.println("Direccion: "+huesped_buscado.getAddress());
                    System.out.println("Telefono: "+huesped_buscado.getPhone());
                    System.out.println("--------------------------------------------------- ");
                    break;
                case 2:
                    // Consulta de reservas por fecha
                    System.out.println("Ingrese la fecha de consulta (formato: yyyy-MM-dd):");
                    String fechaConsultaStr = scanner.nextLine();
                    LocalDate fechaConsulta = LocalDate.parse(fechaConsultaStr, DateTimeFormatter.ISO_LOCAL_DATE);
                    List<Reserva> reservas = reservaService.buscarReservaPorFecha(fechaConsulta);
                    if (reservas.isEmpty()) {
                        System.out.println("No se encontraron reservas para esta fecha.");
                    } else {
                        reservas.forEach(System.out::println); // Mostrar reservas
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el ID de la Reserva");
                    String id_reserva = scanner.nextLine();
                    Reserva reserva_buscada = reservaService.obtenerReservaPorID(id_reserva);
                    System.out.println("-----------------------Detalles:---------------- ");
                    System.out.println("Huesped ID: "+reserva_buscada.getId_huesped());
                    System.out.println("Check In: "+reserva_buscada.getFecha_inicio());
                    System.out.println("Check Out: "+reserva_buscada.getFecha_final());
                    System.out.println("Habitacion: "+reserva_buscada.getId_habitacion());
                    System.out.println("--------------------------------------------------- ");
                    break;
                case 4:
                    // Consultar reservas de un huésped por ID o correo
                    System.out.println("Ingrese el ID o correo del huésped:");
                    String idHuesped = scanner.nextLine();
                    List<Reserva> reservasHuesped = reservaService.buscarReservasPorHuesped(idHuesped);
                    reservasHuesped.forEach(System.out::println); // Mostrar reservas del huésped
                    break;
                case 5:
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
                case 6:
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
                    System.out.println("Volviendo al menú de huespedes...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (option != 0);
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
                    System.out.print("Selecciones un amenity: ");
                    for(Amenity amenities : amenityService.obtenerAmenities()){
                        System.out.println(amenities.getId()+". "+amenities.getName());
                        System.out.println();
                    }
                    Long idModAmenity = scanner.nextLong();
                    scanner.nextLine();
                    Amenity amenity_m = amenityService.obtenerAmenitiesporId(idModAmenity);
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Ingrese la nueva descripción: ");
                    String nuevaDescripcion = scanner.nextLine();
                    amenityService.modificarAmenity(amenity_m,nuevoNombre,nuevaDescripcion);
                    break;

                case 3:
                    System.out.print("Ingrese amenity a eliminar: ");
                    for(Amenity amenity: amenityService.obtenerAmenities()){
                        System.out.println(amenity.getId()+". "+amenity.getName());
                        System.out.println();
                    }
                    Long seleccion=scanner.nextLong();
                    amenityService.eliminarAmenity(seleccion);
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
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Seleccion el hotel al que le dara de alta la habitacion.... ");
                    for(Hotel hotel : hotelService.obtenerHoteles()){
                        System.out.print(hotel.getId()+". "+hotel.getName());
                        System.out.println();
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
                    System.out.print("Seleccion el hotel al que pertenece la habitacion.... ");
                    for(Hotel hotel : hotelService.obtenerHoteles()){
                        System.out.print(hotel.getId()+". "+hotel.getName());
                        System.out.println();
                    }
                    Long seleccion_hotel = scanner.nextLong();
                    scanner.nextLine();
                    Hotel hotel = hotelService.buscarHotelPorId(seleccion_hotel);
                    System.out.print("Seleccione la habitacion.... ");
                    System.out.println();
                    for(Habitacion habitacion : hotel.getHabitaciones()){
                        System.out.print(habitacion.getId()+". "+habitacion.getTipo());
                        System.out.println();
                    }
                    Long seleccion_habitacion = scanner.nextLong();
                    scanner.nextLine();
                    Habitacion habitacion_m = habitacionService.obtenerHabitacionporId(seleccion_habitacion);
                    System.out.print("Ingrese nuevo Tipo: ");
                    String nuevoTipo= scanner.nextLine();
                    habitacionService.modificarHabitacion(habitacion_m,nuevoTipo);
                    break;

                case 3:
                    System.out.print("Ingrese el hotel al que le eliminara la habitacion.... ");
                    for(Hotel hotel3 : hotelService.obtenerHoteles()){
                        System.out.print(hotel3.getId()+". "+hotel3.getName());
                        System.out.println();
                    }
                    Long seleccion3 = scanner.nextLong();
                    scanner.nextLine();
                    Hotel hotel3 = hotelService.buscarHotelPorId(seleccion3);
                    System.out.println("Ingrese la habitacion que desea elminar: ");
                    for(Habitacion habitacion3 : hotel3.getHabitaciones()){
                        System.out.println(habitacion3.getId()+". "+habitacion3.getTipo());
                        System.out.println();
                    }
                    Long seleccion3_h=scanner.nextLong();
                    scanner.nextLine();
                    habitacionService.eliminarHabitacion(seleccion3_h);
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