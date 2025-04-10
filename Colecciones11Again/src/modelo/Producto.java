package modelo;
public class Producto {
    private String codigo;
    private String nombre;
    private int unidades;

    public Producto(String codigo, String nombre, int unidades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.unidades = unidades;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return codigo + "," + nombre + "," + unidades;
    }
}