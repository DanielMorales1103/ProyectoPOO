/**
 * Clase Donacion, la cual realizará los procesos para el distinto tipo de donacion que haga el usuario
 * Grupo #1. POO
 * 22 de octubre de 2021
 * @version 4
 */

public class Donacion 
{
    private double dinero = 0;
    private int medicinas = 0;
    private int camas = 0;
    private int comida = 0;
    private int tanquesOxigeno = 0;
    
    /** 
     * @return int
     */
    public int getTanques()
    {
        return this.tanquesOxigeno;
    }
    
    /** 
     * @return int
     */
    public int getComida()
    {
        return this.comida;
    }
    
    /** 
     * @return int
     */
    public int getCama()
    {
        return this.camas;
    }
    
    /** 
     * @return int
     */
    public int getMedicinas()
    {
        return this.medicinas;
    }
    
    /** 
     * @return double
     */
    public double getDinero()
    {
        return this.dinero;
    }
    
    public Donacion()
    {

    }
    
    /** 
     * @param medicinas
     * @param camas
     * @param comida
     * @param tanquesOxigeno
     * @return String
     */
    public String suministros(int medicinas, int camas, int comida, int tanquesOxigeno)
    {
        String mensaje = "";
        //Codigo para agregar suministros a los hospitales.
        this.medicinas = medicinas;
        this.camas = camas;
        this.comida = comida;
        this.tanquesOxigeno = tanquesOxigeno;

        mensaje = "Se ha donado:\nCamas: " + this.camas + "\nMedicinas: " + this.medicinas + "\nRopa para hombres: " + "\nComida: " + this.comida + "\nTanques de oxigeno: " + this.tanquesOxigeno;
        return mensaje;
    }
    
    /** 
     * @param dinero
     * @return String
     */
    public String monetaria(Double dinero)
    {
        String mensaje = "";
        this.dinero = dinero;

        mensaje = "Se han donado: Q" + this.dinero;
        return mensaje;
    }
}




