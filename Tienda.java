import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tienda {
    private ArrayList<Producto> productos;
    private Usuario usuarioActual;
    private Map<Producto, Integer> productosSeleccionados;
    private double precioTotal;

    public Tienda() {
        productos = new ArrayList<>();
    }

    public void cargarProductos(String ruta) {
        File directorio = new File(ruta);
        File[] archivos = directorio.listFiles();
        productos = new ArrayList<>();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile() && archivo.getName().endsWith(".txt")) {
                    leerArchivo(archivo);
                }
            }
        }
    }

    private void leerArchivo(File archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    String nombre = datos[0].trim();
                    int precio = Integer.parseInt(datos[1].trim());
                    Producto producto = new Producto(nombre, precio);
                    productos.add(producto);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarProductos() {
        System.out.println("                                            ");
        System.out.println("*==*==*==*==*== PRODUCTOS ==*==*==*==*==*");
        System.out.println(" ");
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            System.out.println((i + 1) + ". " + producto.getNombre() + " - $" + producto.getPrecio());
        }
        System.out.println(" ");
        System.out.println("==========================================");
    }

    public void seleccionarProductos() {
        productosSeleccionados = new HashMap<>();
        precioTotal = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese el número de producto que desea seleccionar (0 para finalizar):");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el búfer del scanner

            while (opcion != 0) {
                if (opcion < 1 || opcion > productos.size()) {
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                } else {
                    Producto productoSeleccionado = productos.get(opcion - 1);

                    System.out.print("Ingrese la cantidad deseada: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine(); // Limpia el búfer del scanner

                    productosSeleccionados.put(productoSeleccionado, cantidad);
                    precioTotal += productoSeleccionado.getPrecio() * cantidad;
                }

                System.out.println("Ingrese el número de producto que desea seleccionar (0 para finalizar):");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpia el búfer del scanner
            }

            if (productosSeleccionados.isEmpty()) {
                System.out.println("No se ha seleccionado ningún producto.");
            } else {
                Factura factura = new Factura(productosSeleccionados, usuarioActual, precioTotal);
                factura.imprimirFactura();
            }
        }
    }
}
