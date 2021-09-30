/*
Clase Donacion, la cual realizará los procesos para el distinto tipo de donacion que haga el usuario.
*/


public class Donacion 
{
    private double dinero = 0;
    private int medicinas = 0;
    private int ropaH = 0;
    private int ropaM = 0;
    private int camas = 0;
    private int savanas = 0;
    private int comida = 0;
    private int tanquesOxigeno = 0;
    
    public Donacion()
    {

    }

    
    /** 
     * @param medicinas
     * @param ropaH
     * @param ropaM
     * @param camas
     * @param savanas
     * @param comida
     * @param tanquesOxigeno
     * @return String
     */
    public String suministros(int medicinas, int ropaH, int ropaM, int camas, int savanas, int comida, int tanquesOxigeno)
    {
        String mensaje = "";
        //Codigo para agregar suministros a los hospitales.
        this.medicinas = medicinas;
        this.ropaH = ropaH;
        this.ropaM = ropaM;
        this.camas = camas;
        this.savanas = savanas;
        this.comida = comida;
        this.tanquesOxigeno = tanquesOxigeno;

        mensaje = "Se ha donado:\nCamas: " + this.camas + "\nMedicinas: " + this.medicinas + "\nRopa para hombres: " + this.ropaH + "\nRopa para mujeres: " + this.ropaM + "\nSavanas: " + this.savanas + "\nComida: " + this.comida + "\nTanques de oxigeno: " + this.tanquesOxigeno;
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
