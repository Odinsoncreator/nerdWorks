public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        // Constructor que inicializa los atributos del producto
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        // Método para obtener el nombre del producto
        return nombre;
    }

    public double getPrecio() {
        // Método para obtener el precio del producto
        return precio;
    }
}
