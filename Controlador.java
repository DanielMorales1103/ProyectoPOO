
import java.util.*;

public class Controlador
{
    private Donacion donacion = new Donacion();
    private Usuario perfil;
    private Archivos usuarioscsv = new Archivos("usuarios.csv");
    private ArrayList<String> listaUsuarios = new ArrayList<String>();
    private Archivos centroscsv = new Archivos("centros.csv");
    
    private ArrayList<centroMedico> centros = new ArrayList<centroMedico>();
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public void crearArchivo(Archivos archivo)
    {
        archivo.crear_archivo();
    }

    public boolean verificarAcceso(Usuario perfil, String nombre, String contra)
    {
        return perfil.verificar_acceso(this.listaUsuarios, nombre, contra);
    }

    public boolean verficarUsuario(Usuario perfil, String nombre)
    {
        return perfil.verificar_usuario(this.listaUsuarios, nombre);
    }

    public boolean verificarClave(Usuario perfil)
    {
        return perfil.verificar_clave();
    }
    
}
