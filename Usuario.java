import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Usuario {
    private String nombre;
    private String direccion;
    private String correoElectronico;
    private String rfc;
    private String telefono;
    private String archivo;

    public Usuario(String nombre, String direccion, String correoElectronico) {
        // Constructor que inicializa los atributos del usuario
        this.nombre = nombre;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.archivo = "INGRESA TU CARPETA QUE ALMACENARA TUS USUARIOS" + this.nombre + ".txt";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public void guardarEnArchivo() {
        // Guarda los datos del usuario en un archivo de texto
        try {
            FileWriter fileWriter = new FileWriter(this.archivo);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Nombre: " + this.nombre);
            bufferedWriter.newLine();
            bufferedWriter.write("Direccion: " + this.direccion);
            bufferedWriter.newLine();
            bufferedWriter.write("Correo electronico: " + this.correoElectronico);
            bufferedWriter.newLine();
            bufferedWriter.write("RFC: " + this.rfc);
            bufferedWriter.newLine();
            bufferedWriter.write("Telefono: " + this.telefono);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
            System.out.println("El usuario " + this.nombre + " se ha guardado en el archivo " + this.archivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo del usuario " + this.nombre);
            e.printStackTrace();
        }
    }
}
