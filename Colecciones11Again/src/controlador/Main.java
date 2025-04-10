package controlador;
import java.util.Scanner;

import modelo.GestorInventario;
import modelo.Producto;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorInventario gestor = new GestorInventario("inventario.txt");

        while (true) {
            System.out.println("\n--- Gestión de Inventario ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Actualizar stock");
            System.out.println("4. Mostrar productos");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Código del producto: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Unidades en stock: ");
                    int unidades = scanner.nextInt();
                    gestor.agregarProducto(new Producto(codigo, nombre, unidades));
                    System.out.println("Producto agregado.");
                    break;
                case 2:
                    System.out.print("Código del producto a eliminar: ");
                    String codigoEliminar = scanner.nextLine();
                    gestor.eliminarProducto(codigoEliminar);
                    System.out.println("Producto eliminado.");
                    break;
                case 3:
                    System.out.print("Código del producto a actualizar: ");
                    String codigoActualizar = scanner.nextLine();
                    System.out.print("Nuevas unidades en stock: ");
                    int nuevasUnidades = scanner.nextInt();
                    gestor.actualizarStock(codigoActualizar, nuevasUnidades);
                    System.out.println("Stock actualizado.");
                    break;
                case 4:
                    System.out.println("\n--- Productos en Inventario ---");
                    for (Producto producto : gestor.getProductos()) {
                        System.out.println(producto);
                    }
                    break;
                case 5:
                    gestor.guardarProductos();
                    System.out.println("Cambios guardados. Saliendo...");
                    scanner.close();
                    return; // Salir del programa
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }
}