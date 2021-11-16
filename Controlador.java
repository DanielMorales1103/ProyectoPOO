
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
        this.listaUsuarios = this.usuarioscsv.lectura();
        return perfil.verificar_acceso(this.listaUsuarios, nombre, contra);
    }

    public boolean verficarUsuario(Usuario perfil, String nombre)
    {
        this.listaUsuarios = this.usuarioscsv.lectura();
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
            String[] centro = centrosTexto.get(i).split(",");
            String nombre = centro[0];
            Double dinero = Double.parseDouble(centro[1]);
            String numero = centro[2];
            String ubicacion = centro[3];
            int tanquesOxigeno = Integer.parseInt(centro[4]);
            int comida = Integer.parseInt(centro[5]);
            int camas = Integer.parseInt(centro[6]);
            int pacientes = Integer.parseInt(centro[7]);
            int doctores = Integer.parseInt(centro[8]);
            int medicina = Integer.parseInt(centro[9]);
            
            centroMedico CM = new centroMedico(nombre, dinero, numero, ubicacion, tanquesOxigeno, comida, camas, pacientes, doctores, medicina);
            centros.add(CM);
        }
    }

    public void agregarCento(centroMedico centro)
    {
        this.centros.add(centro);
    }

    public ArrayList<centroMedico> getCentros()
    {
        return this.centros;
    }

    public String verCentros()
    {
        String info = "";
        int contador = 1;
        for(centroMedico k: this.centros)
        {
            info += "\nCentro medico No. " + contador;
            info += "\n\tNombre del centro: " + k.getNombre();
            info += "\n\tLocalización del centro: " + k.getUbicacion();
            info += "\n\tNumero de telefono del centro: " + k.getNumero();
            info += "\n\tCantidad de doctores del centro: " + k.getDoctores();
            info += "\n\tCantidad de pacientes del centro: " + k.getPacientes();
            info += "\n\tCantidad de camas del centro: " + k.getCamas();
            info += "\n\tCantidad de comida del centro: " + k.getComida();
            info += "\n\tCantidad de tanques del centro: " + k.getTanquesOxigeno();
            info += "\n\tMedicinas del centro: " + k.getMedicina();
            info += "\n\tFondos del centro: Q" + k.getDinero();
            contador++;
        }

        return info;
    }

}
