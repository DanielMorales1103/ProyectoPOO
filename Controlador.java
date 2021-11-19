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
        this.centros.add(centro);
        this.centroscsv.escribir_archivo(textoanterior);
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
        ArrayList<String> escribircentros = new ArrayList<String>();
        String txt;
        for (int i = 0; i<centros.size();i++){
            txt= centros.get(i).getNombre()+","+centros.get(i).getDinero() + "," +  centros.get(i).getNumero() + "," + centros.get(i).getUbicacion() + "," + centros.get(i).getTanquesOxigeno() + "," + centros.get(i).getComida() + "," + centros.get(i).getCamas() + "," + centros.get(i).getPacientes() + "," + centros.get(i).getDoctores() + "," + centros.get(i).getMedicina();
            escribircentros.add(txt);
        }
        centroscsv.escribir_archivo(escribircentros);
    }

    public String donarDinero(double donacion)
    {
        String info = "";
        this.ordenarDinero();
        this.cmDinero.get(0).setDinero(donacion * 0.40);
        this.cmDinero.get(1).setDinero(donacion * 0.30);
        this.cmDinero.get(2).setDinero(donacion * 0.20);
        this.cmDinero.get(3).setDinero(donacion * 0.10);
        info += this.donacion.monetaria(donacion);
        info += "\nResumen: ";
        info += "\n\tHospital:\t\t\t\tDonacion";
        info += "\n\t" +  this.cmDinero.get(0).getNombre() + "\t\t" + donacion * 0.40;
        info += "\n\t" +  this.cmDinero.get(1).getNombre() + "\t\t" + donacion * 0.30;
        info += "\n\t" +  this.cmDinero.get(2).getNombre() + "\t\t" + donacion * 0.20;
        info += "\n\t" +  this.cmDinero.get(3).getNombre() + "\t\t" + donacion * 0.10;

        this.centros = this.cmDinero;
        return info;
    }

    public String donarMedicina(int medicinas)
    {
        String info = "";
        this.ordenarMedicina();
        int medicina1 = (int) Math.round(medicinas * 0.40);
        int medicina2 = (int) Math.round(medicinas * 0.30);
        int medicina3 = (int) Math.round(medicinas * 0.20);
        int medicina4 = (int) Math.round(medicinas * 0.10);

        this.cmMedicina.get(0).setMedicina(medicina1);
        this.cmMedicina.get(1).setMedicina(medicina2);
        this.cmMedicina.get(2).setMedicina(medicina3);
        this.cmMedicina.get(3).setMedicina(medicina4);

        info += "\nResumen: ";
        info += "\n\tHospital:\t\t\t\tMedicinas donadas";
        info += "\n\t" +  this.cmMedicina.get(0).getNombre() + "\t\t" + medicina1;
        info += "\n\t" +  this.cmMedicina.get(1).getNombre() + "\t\t" + medicina2;
        info += "\n\t" +  this.cmMedicina.get(2).getNombre() + "\t\t" + medicina3;
        info += "\n\t" +  this.cmMedicina.get(3).getNombre() + "\t\t" + medicina4;

        this.centros = this.cmMedicina;
        return info;
    }

    public String donarTanques(int tanques)
    {
        String info = "";
        this.ordenarTanques();
        int tanques1 = (int) Math.round(tanques * 0.40);
        int tanques2 = (int) Math.round(tanques * 0.30);
        int tanques3 = (int) Math.round(tanques * 0.20);
        int tanques4 = (int) Math.round(tanques * 0.10);

        this.cmTanques.get(0).setTanquesOxigeno(tanques1);
        this.cmTanques.get(1).setTanquesOxigeno(tanques2);
        this.cmTanques.get(2).setTanquesOxigeno(tanques3);
        this.cmTanques.get(3).setTanquesOxigeno(tanques4);

        info += "\nResumen: ";
        info += "\n\tHospital:\t\t\t\tTanques de oxigeno donados";
        info += "\n\t" +  this.cmTanques.get(0).getNombre() + "\t\t" + tanques1;
        info += "\n\t" +  this.cmTanques.get(1).getNombre() + "\t\t" + tanques2;
        info += "\n\t" +  this.cmTanques.get(2).getNombre() + "\t\t" + tanques3;
        info += "\n\t" +  this.cmTanques.get(3).getNombre() + "\t\t" + tanques4;

        this.centros = this.cmTanques;
        return info;
    }

    public String donarCamas(int camas)
    {
        String info = "";
        this.ordenarCamas();
        int cama1 = (int) Math.round(camas * 0.40);
        int cama2 = (int) Math.round(camas * 0.30);
        int cama3 = (int) Math.round(camas * 0.20);
        int cama4 = (int) Math.round(camas * 0.10);

        this.cmCamas.get(0).setCamas(cama1);
        this.cmCamas.get(1).setCamas(cama2);
        this.cmCamas.get(2).setCamas(cama3);
        this.cmCamas.get(3).setCamas(cama4);

        info += "\nResumen: ";
        info += "\n\tHospital:\t\t\t\tCamas donados";
        info += "\n\t" +  this.cmCamas.get(0).getNombre() + "\t\t" + cama1;
        info += "\n\t" +  this.cmCamas.get(1).getNombre() + "\t\t" + cama2;
        info += "\n\t" +  this.cmCamas.get(2).getNombre() + "\t\t" + cama3;
        info += "\n\t" +  this.cmCamas.get(3).getNombre() + "\t\t" + cama4;

        this.centros = this.cmCamas;
        return info;
    }

    public String donarComida(int comida)
    {
        String info = "";
        this.ordenarComida();
        int comida1 = (int) Math.round(comida * 0.40);
        int comida2 = (int) Math.round(comida * 0.40);
        int comida3 = (int) Math.round(comida * 0.40);
        int comida4 = (int) Math.round(comida * 0.40);

        this.cmComida.get(0).setComida(comida1);
        this.cmComida.get(1).setComida(comida2);
        this.cmComida.get(2).setComida(comida3);
        this.cmComida.get(3).setComida(comida4);

        info += "\nResumen: ";
        info += "\n\tHospital:\t\t\t\tComida donada";
        info += "\n\t" +  this.cmComida.get(0).getNombre() + "\t\t" + comida1;
        info += "\n\t" +  this.cmComida.get(1).getNombre() + "\t\t" + comida2;
        info += "\n\t" +  this.cmComida.get(2).getNombre() + "\t\t" + comida3;
        info += "\n\t" +  this.cmComida.get(3).getNombre() + "\t\t" + comida4;

        this.centros = this.cmComida;
        return info;
    }
}
