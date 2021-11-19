/**
 * Clase centroMedico, la cual manejara los atributos de los centros méticos
 * Grupo #1. POO
 * 22 de octubre de 2021
 * @version 4
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
    
    /** 
     * @return String
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /** 
     * @param nombre
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    /** 
     * @return Double
     */
    public Double getDinero()
    {
        return dinero;
    }
    
    /** 
     * @param dinero
     */
    public void setDinero(Double dinero)
    {
        this.dinero += dinero;
    }
    
    /** 
     * @return Integer
     */
    public Integer getMedicina()
    {
        return medicinas;
    }
    
    /** 
     * @param medicinas
     */
    public void setMedicina(Integer medicinas)
    {
        this.medicinas += medicinas;
    }
    
    /** 
     * @return Integer
     */
    public Integer getDoctores()
    {
        return doctores;
    }
    
    /** 
     * @param doctores
     */
    public void setDoctores(Integer doctores)
    {
        this.doctores = doctores;
    }
    
    /** 
     * @return Integer
     */
    public Integer getPacientes()
    {
        return pacientes;
    }
    
    /** 
     * @param pacientes
     */
    public void setPacientes(Integer pacientes)
    {
        this.pacientes = pacientes;
    }
    
    /** 
     * @return Integer
     */
    public Integer getCamas()
    {
        return camas;
    }
    
    /** 
     * @param camas
     */
    public void setCamas(Integer camas)
    {
        this.camas += camas;
    }
    
    /** 
     * @return Integer
     */
    public Integer getComida()
    {
        return comida;
    }
    
    /** 
     * @param comida
     */
    public void setComida(Integer comida)
    {
        this.comida += comida;
    }
    
    /** 
     * @return Integer
     */
    public Integer getTanquesOxigeno()
    {
        return tanquesOxigeno;
    }
        
    /** 
     * @param tanquesOxigeno
     */
    public void setTanquesOxigeno(Integer tanquesOxigeno)
    {
        this.tanquesOxigeno += tanquesOxigeno;
    }
     
    /** 
     * @return String
     */
    public String getUbicacion()
    {
        return ubicacion;
    }
    
    /** 
     * @param ubicacion
     */
    public void setUbicacion(String ubicacion)
    {
        this.ubicacion = ubicacion;
    }
    
    /** 
     * @return String
     */
    public String getNumero()
    {
        return numero;
    }
    
    /** 
     * @param numero
     */
    public void setNumero(String numero)
    {
        this.numero = numero;
    }
}