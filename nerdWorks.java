import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class nerdWorks {
    private static final String RUTA_USUARIOS = "C:\\Users\\baeza\\Documents\\NerdWorks\\Usuarios\\";
    private Usuario usuarioActual;

    public static void main(String[] args) {
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
        nerdWorks app = new nerdWorks();
        app.run();
    }

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean continuar = true;
            Tienda tienda = new Tienda();

            while (continuar) {
                System.out.println("Menú:");
                System.out.println("1. Crear usuario");
                System.out.println("2. Ingresar Usuario");
                System.out.println("4. Salir");
                System.out.print("<<<====== Ingrese una opción========>>>: ");

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpia el búfer del scanner

                switch (opcion) {
                    case 1:
                        crearUsuario(scanner);
                        break;

                    case 2:
                        System.out.print("Nombre de usuario: ");
                        String nombreArchivo = scanner.nextLine();
                        String rutaArchivo = RUTA_USUARIOS + nombreArchivo + ".txt";
                        leerArchivoTxt(rutaArchivo);
                        break;
                    case 3:
                        continuar = false;
                        break;

                    default:
                        System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                }
                
                if (opcion == 1 || opcion == 2) {
                    System.out.println(" ");
                    System.out.println("=============================================");
                    System.out.println("1. Seleccionar productos");
                    System.out.println("2. Salir");
                    System.out.print("<<<====== Ingrese una opción========>>>: ");
                    
                    int subOpcion = scanner.nextInt();
                    scanner.nextLine(); // Limpia el búfer del scanner
                    
                    switch (subOpcion) {
                        case 1:
                            tienda.cargarProductos("C:/Users/baeza/Documents/NerdWorks/Producto");
                            tienda.mostrarProductos();
                            tienda.seleccionarProductos();
                            break;
                        case 2:
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
        System.out.println("Creación de usuario");
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la dirección del usuario: ");
        String direccion = scanner.nextLine();

        System.out.println("Escribe tu correo de contacto");
        String correoElectronico = scanner.nextLine();

        usuarioActual = new Usuario(nombre, direccion, correoElectronico);
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
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}