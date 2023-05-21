import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Factura {
    private Map<Producto, Integer> productosComprados;
    private Usuario usuarioCompra;
    private double precioTotal;
    private double iva;

    public Factura(Map<Producto, Integer> productosComprados, Usuario usuarioCompra, double precioTotal) {
        this.productosComprados = productosComprados;
        this.usuarioCompra = usuarioCompra;
        this.precioTotal = precioTotal;
        this.iva = precioTotal * 0.16; // Calcula el IVA como el 16% del precio total
    }

    public void imprimirFactura() {
        System.out.println("=========================================================================");
        System.out.println("|                           FACTURA                                     |");
        System.out.println("=========================================================================");
        System.out.println("| Producto                                      | Cantidad | Precio     |");
        System.out.println("|-----------------------------------------------+----------+------------|");
    
        for (Map.Entry<Producto, Integer> entry : productosComprados.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
    
            String nombreProducto = producto.getNombre();
            String precio = String.format("%.2f", producto.getPrecio());
    
            System.out.printf("| %-45s | %-8s | %-10s |%n", nombreProducto, cantidad, precio);
        }
    
        System.out.println("|-----------------------------------------------+----------+------------|");
        String subtotal = String.format("%.1f", precioTotal);
        String ivaAmount = String.format("%.1f", iva);
        String totalConIVA = String.format("%.1f", (precioTotal + iva));
    
        System.out.printf("| Total (sin IVA)                               |          | %-11s|%n", subtotal);
        System.out.printf("| IVA                                           |          | %-11s|%n", ivaAmount);
        System.out.println("=========================================================================");
        System.out.printf("| Total (con IVA)                               |          | %-11s|%n", totalConIVA);
        System.out.println("=========================================================================");
        System.out.println("| Datos del usuario:                                                    |");
        try (BufferedReader br = new BufferedReader(new FileReader(usuarioCompra.getArchivo()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo del usuario " + usuarioCompra.getNombre());
            e.printStackTrace();
        }
    }
}