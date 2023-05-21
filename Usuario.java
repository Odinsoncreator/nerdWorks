import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Usuario {
    private String nombre;
    private String direccion;
    private String correoElectronico;
    private String archivo;

    public Usuario(String nombre, String direccion, String correoElectronico) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.archivo = "C:\\Users\\baeza\\Documents\\NerdWorks\\Usuarios\\" + this.nombre + ".txt";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public String getArchivo() {
        return archivo;
    }
    

    public void guardarEnArchivo() {
        try {
            FileWriter archivo = new FileWriter(this.archivo);
            BufferedWriter escritor = new BufferedWriter(archivo);
            escritor.write("Nombre: " + this.nombre);
            escritor.newLine();
            escritor.write("Direccion: " + this.direccion);
            escritor.newLine();
            escritor.write("Correo electronico: " + this.correoElectronico);
            escritor.newLine();
            escritor.close();
            archivo.close();
            System.out.println("El usuario " + this.nombre + " se ha guardado en el archivo " + this.archivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo del usuario " + this.nombre);
            e.printStackTrace();
            }
        }
    }