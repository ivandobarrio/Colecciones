package modelo;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorInventario {
    private List<Producto> productos;
    private String archivo;

    public GestorInventario(String archivo) {
        this.archivo = archivo;
        this.productos = new ArrayList<>();
        cargarProductos();
    }

    private void cargarProductos() {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    String codigo = datos[0];
                    String nombre = datos[1];
                    int unidades = Integer.parseInt(datos[2]);
                    productos.add(new Producto(codigo, nombre, unidades));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar productos: " + e.getMessage());
        }
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(String codigo) {
        productos.removeIf(p -> p.getCodigo().equals(codigo));
    }

    public void actualizarStock(String codigo, int unidades) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                producto.setUnidades(unidades);
                break;
            }
        }
    }

    public void guardarProductos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Producto producto : productos) {
                bw.write(producto.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar productos: " + e.getMessage());
        }
    }

    public List<Producto> getProductos() {
        return productos;
    }
}