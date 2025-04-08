package modelo;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ClubSocio {
    private static final String FICHERO_SOCIOS = "socios.dat";
    private List<Socio> socios;
    private Scanner scanner;


    public ClubSocio() {
        this.socios = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        cargarSocios();
    }

    private void cargarSocios() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO_SOCIOS))) {
            socios = (List<Socio>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo, se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void guardarSocios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO_SOCIOS))) {
            oos.writeObject(socios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void altaSocio() {
        System.out.print("Ingrese DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Ingrese Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese Fecha de Alta (yyyy-MM-dd): ");
        LocalDate fechaAlta = LocalDate.parse(scanner.nextLine());

        Socio nuevoSocio = new Socio(dni, nombre, fechaAlta);
        if (!socios.contains(nuevoSocio)) {
            socios.add(nuevoSocio);
            System.out.println("Socio añadido.");
        } else {
            System.out.println("El socio ya existe.");
        }
    }

    private void bajaSocio() {
        System.out.print("Ingrese DNI del socio a eliminar: ");
        String dni = scanner.nextLine();
        Socio socioABorrar = new Socio(dni, "", LocalDate.now());
        if (socios.remove(socioABorrar)) {
            System.out.println("Socio eliminado.");
        } else {
            System.out.println("Socio no encontrado.");
        }
    }

    private void modificarSocio() {
        System.out.print("Ingrese DNI del socio a modificar: ");
        String dni = scanner.nextLine();
        for (Socio socio : socios) {
            if (socio.getDni().equals(dni)) {
                System.out.print("Ingrese nuevo Nombre: ");
                String nuevoNombre = scanner.nextLine();
                System.out.print("Ingrese nueva Fecha de Alta (yyyy-MM-dd): ");
                LocalDate nuevaFechaAlta = LocalDate.parse(scanner.nextLine());
                
                // Modificar los atributos
                socio.setNombre(nuevoNombre); // Cambiar el nombre
                socio.setFechaAlta(nuevaFechaAlta); // Cambiar la fecha de alta
                System.out.println("Socio modificado.");
                return;
            }
        }
        System.out.println("Socio no encontrado.");
    }

    private void listadoPorDni() {
        Collections.sort(socios);
        System.out.println("Listado de socios por DNI:");
        for (Socio socio : socios) {
            System.out.println(socio);
        }
    }

    private void listadoPorAntiguedad() {
        Collections.sort(socios, (socio1, socio2) -> {
            return Integer.compare(socio1.antiguedad(), socio2.antiguedad());
        });
        System.out.println("Listado de socios por antigüedad:");
        for (Socio socio : socios) {
            System.out.println(socio);
        }
    }

    public void menu() {
        int opcion;
        do {
            System.out.println("\n--- Menú de Gestión de Socios ---");
            System.out.println("1. Alta");
            System.out.println("2. Baja");
            System.out.println("3. Modificación");
            System.out.println("4. Listado por DNI");
            System.out.println("5. Listado por antigüedad");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    altaSocio();
                    break;
                case 2:
                    bajaSocio();
                    break;
                case 3:
                    modificarSocio();
                    break;
                case 4:
                    listadoPorDni();
                    break;
                case 5:
                    listadoPorAntiguedad();
                    break;
                case 6:
                    guardarSocios();
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    public static void main(String[] args) {
        ClubSocio club = new ClubSocio();
        club.menu();
    }
}