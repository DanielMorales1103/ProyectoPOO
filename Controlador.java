/**
 * Clase Controlador. Será la encargada de realizar las tareas correspondientes al nuestro programa.
 * Grupo #1. POO
 * 16 de noviembre de 2021
 * @version 1
 */

import java.util.*;

public class Controlador
{
    private Donacion donacion = new Donacion();
    private Usuario perfil;
    private Archivos usuarioscsv = new Archivos("usuarios.csv");
    private ArrayList<String> listaUsuarios = new ArrayList<String>();
    private Archivos centroscsv = new Archivos("centros.csv");
    private ArrayList<centroMedico> cmDinero = new ArrayList<centroMedico>();
    private ArrayList<centroMedico> cmMedicina = new ArrayList<centroMedico>();
    private ArrayList<centroMedico> cmTanques = new ArrayList<centroMedico>();
    private ArrayList<centroMedico> cmComida = new ArrayList<centroMedico>();
    private ArrayList<centroMedico> cmPacientes = new ArrayList<centroMedico>();
    private ArrayList<centroMedico> cmDoctores = new ArrayList<centroMedico>();
    private ArrayList<centroMedico> cmCamas = new ArrayList<centroMedico>();
    
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

    public void leerCentrosMedicos()
    {
        ArrayList<String> centrosTexto = this.centroscsv.lectura();
        for (int i = 0; i < centrosTexto.size(); i++)
        {
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
        ArrayList<String> textoanterior = centroscsv.lectura();
        textoanterior.add(centro.getNombre() + "," + centro.getDinero() + "," +  centro.getNumero() + "," + centro.getUbicacion() + "," + centro.getTanquesOxigeno() + "," + centro.getComida() + "," + centro.getCamas() + "," + centro.getPacientes() + "," + centro.getDoctores() + "," + centro.getMedicina());
        this.centroscsv.escribir_archivo(textoanterior);
        this.centros.add(centro);
    }

    public ArrayList<centroMedico> getCentros()
    {
        return this.centros;
    }

    public String verCentros(ArrayList<centroMedico> centros)
    {
        String info = "";
        int contador = 1;
        for(centroMedico k: centros)
        {
            info += "\nCentro medico No. " + contador;
            info += "\n\tNombre del centro: " + k.getNombre();
            info += "\n\tLocalizacion del centro: " + k.getUbicacion();
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

    public void ordenarDinero()
    {
        this.cmDinero = this.centros;
        Collections.sort(this.cmDinero, new CompararDinero());
    }

    public ArrayList<centroMedico> getCmDinero()
    {
        return this.cmDinero;
    }

    public void ordenarTanques()
    {
        this.cmTanques = this.centros;
        Collections.sort(this.cmTanques, new CompararTanques());
    }

    public ArrayList<centroMedico> getCmTanques()
    {
        return this.cmTanques;
    }

    public void ordenarCamas()
    {
        this.cmCamas = this.centros;
        Collections.sort(this.cmCamas, new CompararCamas());
    }

    public ArrayList<centroMedico> getCmCamas()
    {
        return this.cmCamas;
    }

    public void ordenarComida()
    {
        this.cmComida = this.centros;
        Collections.sort(this.cmComida, new CompararComida());
    }    

    public ArrayList<centroMedico> getCmComida()
    {
        return this.cmComida;
    }

    public void ordenarDoctores()
    {
        this.cmDoctores = this.centros;
        Collections.sort(this.cmDoctores, new CompararDoctores());
    }

    public ArrayList<centroMedico> getCmDoctores()
    {
        return this.cmDoctores;
    }

    public void ordenarMedicina()
    {
        this.cmMedicina = this.centros;
        Collections.sort(this.cmMedicina, new CompararMedicinas());
    }

    public ArrayList<centroMedico> getCmMedicina()
    {
        return this.cmMedicina;
    }

    public void ordenarPaciente()
    {
        this.cmPacientes = this.centros;
        Collections.sort(this.cmPacientes, new CompararPacientes());
    }

    public ArrayList<centroMedico> getCmPacientes()
    {
        return this.cmPacientes;
    }
    public void SobreescribirCentros(){
        //centro.getNombre() + "," + centro.getDinero() + "," +  centro.getNumero() + "," + centro.getUbicacion() + "," + centro.getTanquesOxigeno() + "," + centro.getComida() + "," + centro.getCamas() + "," + centro.getPacientes() + "," + centro.getDoctores() + "," + centro.getMedicina()
        ArrayList<String> escribircentros = new ArrayList<String>();
        String txt;
        for (int i = 0; i<centros.size();i++){
            txt= centros.get(i).getNombre()+","+centros.get(i).getDinero() + "," +  centros.get(i).getNumero() + "," + centros.get(i).getUbicacion() + "," + centros.get(i).getTanquesOxigeno() + "," + centros.get(i).getComida() + "," + centros.get(i).getCamas() + "," + centros.get(i).getPacientes() + "," + centros.get(i).getDoctores() + "," + centros.get(i).getMedicina();
            escribircentros.add(txt);
        }
        centroscsv.escribir_archivo(escribircentros);
    }
}
