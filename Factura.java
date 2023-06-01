import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


public class Factura {
    private Map<Producto, Integer> productosComprados;
    private double precioTotal;
    private double iva;
    private Usuario usuarioCompra;

    public Factura(Map<Producto, Integer> productosComprados, Usuario usuarioCompra, double precioTotal) {
        // Inicialización de los atributos de la factura con los valores proporcionados
        this.productosComprados = productosComprados;
        this.usuarioCompra = usuarioCompra;
        this.precioTotal = precioTotal;
        this.iva = precioTotal * 0.16; // Calcula el IVA como el 16% del precio total
    }

    public void imprimirFactura() {
        // Obtiene la fecha y hora actual
        Date fechaHoraActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaHoraImpresion = formatoFecha.format(fechaHoraActual);

        // Imprime el encabezado de la factura
        System.out.println("|======================================================================|");
        System.out.println("|                           FACTURA                                     |");
        System.out.println("========================================================================|");
        System.out.println("| Fecha de impresión: " + fechaHoraImpresion + "                               |");
        System.out.println("|-----------------------------------------------------------------------|");
        System.out.println("| Producto                                      | Cantidad | Precio     |");
        System.out.println("|-----------------------------------------------+----------+------------|");

        // Itera sobre los productos comprados y los imprime en la factura
        for (Map.Entry<Producto, Integer> entry : productosComprados.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();

            String nombreProducto = producto.getNombre();
            String precio = String.format("%.2f", producto.getPrecio());

            System.out.printf("| %-45s | %-8s | %-10s |%n", nombreProducto, cantidad, precio);
        }

        // Imprime la sección de totales
        System.out.println("|-----------------------------------------------+----------+------------|");
        String subtotal = String.format("%.1f", precioTotal);
        String ivaAmount = String.format("%.1f", iva);
        String totalConIVA = String.format("%.1f", (precioTotal + iva));

        System.out.printf("| Total (sin IVA)                               |          | %-11s|%n", subtotal);
        System.out.printf("| IVA                                           |          | %-11s|%n", ivaAmount);
        System.out.println("=========================================================================");
        System.out.printf("| Total (con IVA)                               |          | %-11s|%n", totalConIVA);
        System.out.println("=========================================================================");

        // Imprime los datos del usuario desde su archivo
        System.out.println("| Datos del usuario:                                                    |");
        System.out.println("|-----------------------------------------------------------------------|");

        try (BufferedReader br = new BufferedReader(new FileReader(usuarioCompra.getArchivo()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.printf("| %-69s |%n", linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Imprime el final de la factura
        System.out.println("=========================================================================");
    }
}
