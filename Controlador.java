
import java.util.*;

public class Controlador
{
    private Donacion donacion = new Donacion();
    private Usuario perfil;
    private Archivos usuarioscsv = new Archivos("prueba.csv");
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
    
    public void agregarUsuario(Usuario perfil) //Linea 100
    {
        ArrayList<String> textoanterior = usuarioscsv.lectura();
        textoanterior.add(perfil.getNombre() + "," + perfil.getClave());
        this.usuarioscsv.escribir_archivo(textoanterior);
    }

    public void leerCentrosMedicos(){
        ArrayList<String> centrosTexto = centroscsv.lectura();	
        for (int i = 0; i<centrosTexto.size(); i++){
            String[] centro = centrosTexto.split(",");
            String nombre = centro[0];
            Double dinero = centro[1];
            String numero = centro[2];
            String ubicacion = centro[3];
            int tanquesOxigeno = centro[4];
            int comida = centro[5];
            int camas = centro[6];
            int pacientes = centro[7];
            int doctores = centro[8];
            int medicina s= centro[9];
            
            centroMedico CM = new centroMedico(nombre, dinero, numero, ubicacion, tanquesOxigeno, comida, camas, pacientes, doctores, medicina);
            centros.add(CM);
        }
    }

}
