package modelo;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class GestionClub {
    private static final String NOMBRE_ARCHIVO = "club.dat";
    private static Map<String, Socio> socios = new HashMap<>();
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        cargarDatos();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Gestión del Club ---");
            System.out.println("1. Alta socio");
            System.out.println("2. Baja socio");
            System.out.println("3. Modificación socio");
            System.out.println("4. Listar socios por apodo");
            System.out.println("5. Listar socios por antigüedad");
            System.out.println("6. Listar los socios con alta anterior a un año determinado");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    altaSocio(scanner);
                    break;
                case 2:
                    bajaSocio(scanner);
                    break;
                case 3:
                    modificarSocio(scanner);
                    break;
                case 4:
                    listarSociosPorApodo();
                    break;
                case 5:
                    listarSociosPorAntiguedad();
                    break;
                case 6:
                    listarSociosPorAntiguedadAnterior(scanner);
                    break;
                case 7:
                    guardarDatos();
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 7);

        scanner.close();
    }

    private static void altaSocio(Scanner scanner) {
        System.out.print("Introduce el apodo: ");
        String apodo = scanner.nextLine();
        if (socios.containsKey(apodo)) {
            System.out.println("El apodo ya existe.");
            return;
        }
        System.out.print("Introduce el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce la fecha de ingreso (yyyy-MM-dd): ");
        LocalDate fechaIngreso = LocalDate.parse(scanner.nextLine(), DATE_FORMATTER);
        socios.put(apodo, new Socio(apodo, nombre, fechaIngreso));
        System.out.println("Socio añadido.");
    }

    private static void bajaSocio(Scanner scanner) {
        System.out.print("Introduce el apodo del socio a eliminar: ");
        String apodo = scanner.nextLine();
        if (socios.remove(apodo) != null) {
            System.out.println("Socio eliminado.");
        } else {
            System.out.println("No se encontró un socio con ese apodo.");
        }
    }

    private static void modificarSocio(Scanner scanner) {
        System.out.print("Introduce el apodo del socio a modificar: ");
        String apodo = scanner.nextLine();
        Socio socio = socios.get(apodo);
        if (socio == null) {
            System.out.println("No se encontró un socio con ese apodo.");
            return;
        }
        System.out.print("Introduce el nuevo nombre (dejar vacío para no modificar): ");
        String nuevoNombre = scanner.nextLine();
        if (!nuevoNombre.isEmpty()) {
            socio = new Socio(apodo, nuevoNombre, socio.getFechaIngreso());
            socios.put(apodo, socio);
        }
        System.out.print("Introduce la nueva fecha de ingreso (yyyy-MM-dd, dejar vacío para no modificar): ");
        String nuevaFecha = scanner.nextLine();
        if (!nuevaFecha.isEmpty()) {
            LocalDate nuevaFechaIngreso = LocalDate.parse(nuevaFecha, DATE_FORMATTER);
            socio = new Socio(apodo, socio.getNombre(), nuevaFechaIngreso);
            socios.put(apodo, socio);
        }
        System.out.println("Socio modificado.");
    }

    private static void listarSociosPorApodo() {
        System.out.println("\n--- Listado de Socios por Apodo ---");
        for (Socio socio : socios.values()) {
            System.out.println(socio);
        }
    }

    private static void listarSociosPorAntiguedad() {
        System.out.println("\n--- Listado de Socios por Antigüedad ---");
        List<Socio> listaSocios = new ArrayList<>(socios.values());
        listaSocios.sort(Comparator.comparing(Socio::getFechaIngreso));
        for (Socio socio : listaSocios) {
            System.out.println(socio);
        }
    }

    private static void listarSociosPorAntiguedadAnterior(Scanner scanner) {
        System.out.print("Introduce el año: ");
        int anio = scanner.nextInt();
        LocalDate fechaLimite = LocalDate.of(anio, 1, 1);
        System.out.println("\n--- Socios con alta anterior a " + anio + " ---");
        for (Socio socio : socios.values()) {
            if (socio.getFechaIngreso().isBefore(fechaLimite)) {
                System.out.println(socio);
            }
        }
    }

    private static void cargarDatos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOMBRE_ARCHIVO))) {
            socios = (Map<String, Socio>) ois.readObject();
            System.out.println("Datos cargados desde " + NOMBRE_ARCHIVO);
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo. Se iniciará una nueva lista de socios.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }

    private static void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO))) {
            oos.writeObject(socios);
            System.out.println("Datos guardados en " + NOMBRE_ARCHIVO);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }
}