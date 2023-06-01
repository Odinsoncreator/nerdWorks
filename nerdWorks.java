import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class nerdWorks {
    private Usuario usuarioActual;

    public static void main(String[] args) {
        // Impresión de encabezado
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("============================================================");
        System.out.println(" ");
        System.out.println("       ¡Bienvenido al sistema de servicio de Nerdworks!");
        System.out.println(" ");
        System.out.println("            oKl.     .OMN: oWMMO.   ck,   ;XMX;");
        System.out.println("            dMMKo.   .OMN: .kMMWl  ;KWk. .kMWo");
        System.out.println("            dMMMMXo' .OMN:  ;OXMK,,0MMWx.cNMO.");
        System.out.println("            dMM0xXMXoc0MN:   .oWW00MX0NNOKMX:");
        System.out.println("            dMMd.'dXWNWMN:    .OMMMX:.dWMMWd");
        System.out.println("            dMMd   'dXMMN:     :XMNc  .xWM0'");
        System.out.println("            oMMd     .oXX:     .dNl    .kNc");
        System.out.println("            ;xx;       .c'      .:.     .:.");
        System.out.println("===========================================================");

        // Creación de instancia de la clase nerdWorks y ejecución del método run()
        nerdWorks app = new nerdWorks();
        app.run();
    }

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean continuar = true;
            Tienda tienda = new Tienda();

            while (continuar) {
                // Menú principal
                System.out.println("Menú:");
                System.out.println("1. Crear usuario");
                System.out.println("2. Ir al carrito");
                System.out.println("3. Salir");
                System.out.print("<<<====== Ingrese una opción========>>>: ");

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpia el búfer del scanner

                switch (opcion) {
                    case 1:
                        // Llamada al método crearUsuario()
                        crearUsuario(scanner);
                        break;

                    case 2:
                        // Carga de productos, mostrar productos y seleccionar productos en la tienda
                        tienda.cargarProductos("CAMBIA LA RUTA DE TU CARPETA CON EL ARCHIVO .TXT DE PRODUCTOS");
                        tienda.mostrarProductos();
                        tienda.seleccionarProductos();
                        break;
                    case 3:
                        // Salir del programa
                        continuar = false;
                        break;

                    default:
                        System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                }
                
                if (opcion == 1 ) {
                    // Submenú para la opción "Crear usuario"
                    System.out.println(" ");
                    System.out.println("=============================================");
                    System.out.println("1. Ir al carrito");
                    System.out.println("2. Salir");
                    System.out.print("<<<====== Ingrese una opción========>>>: ");
                    
                    int subOpcion = scanner.nextInt();
                    scanner.nextLine(); // Limpia el búfer del scanner
                    
                    switch (subOpcion) {
                        case 1:
                            // Carga de productos, mostrar productos y seleccionar productos en la tienda
                            tienda.cargarProductos("CAMBIA LA RUTA DE TU CARPETA CON EL ARCHIVO .TXT DE PRODUCTOS");
                            tienda.mostrarProductos();
                            tienda.seleccionarProductos();
                            break;
                        case 2:
                            // Salir del programa
                            continuar = false;
                            break;
                        default:
                            System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    }
                }
            }
        }
    }

    private void crearUsuario(Scanner scanner) {
        // Captura de información para crear un nuevo usuario
        System.out.println("=== === === === === === === === === ===");
        System.out.println(" ");
        System.out.println("                  REGISTRO             ");
        System.out.println(" ");
        System.out.println("=== === === === === === === === === ===");
        System.out.println(" ");
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la dirección del usuario: ");
        String direccion = scanner.nextLine();

        System.out.print("Escribe tu correo de contacto: ");
        String correoElectronico = scanner.nextLine();

        System.out.print("Ingrese el RFC del usuario: ");
        String rfc = scanner.nextLine();

        System.out.print("Ingrese el teléfono del usuario: ");
        String telefono = scanner.nextLine();

        // Creación del objeto Usuario con los datos ingresados y almacenamiento en usuarioActual
        usuarioActual = new Usuario(nombre, direccion, correoElectronico);
        usuarioActual.setRfc(rfc);
        usuarioActual.setTelefono(telefono);
        usuarioActual.guardarEnArchivo();

        System.out.println("Usuario creado exitosamente: " + usuarioActual.getNombre());
    }

    public void leerArchivoTxt(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error de archivo: " + e.getMessage());
        }
    }
}
