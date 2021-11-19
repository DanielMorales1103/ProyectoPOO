/**
 * Clase centroMedico, la cual manejara los atributos de los centros méticos
 * Grupo #1. POO
 * 22 de octubre de 2021
 * @version 3
 */


public class centroMedico
{
    private String nombre;
    private Double dinero;
    private String numero;
    private String ubicacion;
    private Integer tanquesOxigeno;
    private Integer comida;
    private Integer camas;
    private Integer pacientes;
    private Integer doctores;
    private Integer medicinas;
    
    public centroMedico(String nombre, double dinero, String numero, String ubicacion, int tanquesOxigeno,
                        int comida, int camas, int pacientes, int doctores, int medicinas)
    {
        this.nombre = nombre;
        this.dinero = dinero;
        this.numero = numero;
        this.ubicacion = ubicacion;
        this.tanquesOxigeno = tanquesOxigeno;
        this.comida = comida;
        this.camas = camas;
        this.pacientes = pacientes;
        this.doctores = doctores;
        this.medicinas = medicinas;
    }   
    
    public String getNombre()
    {
        return nombre;
    }
    
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public Double getDinero()
    {
        return dinero;
    }
    
    
    public void setDinero(Double dinero)
    {
        this.dinero += dinero;
    }
    
    
    public Integer getMedicina()
    {
        return medicinas;
    }
    
    
    public void setMedicina(Integer medicinas)
    {
        this.medicinas += medicinas;
    }
    
    
    public Integer getDoctores()
    {
        return doctores;
    }
    
    public void setDoctores(Integer doctores)
    {
        this.doctores = doctores;
    }
    
    
    public Integer getPacientes()
    {
        return pacientes;
    }
    
    public void setPacientes(Integer pacientes)
    {
        this.pacientes = pacientes;
    }
    
    public Integer getCamas()
    {
        return camas;
    }
    
    
    public void setCamas(Integer camas)
    {
        this.camas += camas;
    }
    
    
    public Integer getComida()
    {
        return comida;
    }
    
    public void setComida(Integer comida)
    {
        this.comida += comida;
    }
    
    
    public Integer getTanquesOxigeno()
    {
        return tanquesOxigeno;
    }
    
    public void setTanquesOxigeno(Integer tanquesOxigeno)
    {
        this.tanquesOxigeno += tanquesOxigeno;
    }
    
    public String getUbicacion()
    {
        return ubicacion;
    }
    
    public void setUbicacion(String ubicacion)
    {
        this.ubicacion = ubicacion;
    }
    
    
    public String getNumero()
    {
        return numero;
    }
    
    public void setNumero(String numero)
    {
        this.numero = numero;
    }
}