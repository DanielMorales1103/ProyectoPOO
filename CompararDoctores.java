/**
 * Clase CompararDoctores. Será la encargada ordenar por la cantidad de doctores del centro medico, utilizando compare  en el ArrayList de centroMedico
 * Grupo #1. POO
 * 17 de noviembre de 2021
 * @version 1
 */

import java.util.Comparator;

public class CompararDoctores implements Comparator<centroMedico>
{
    /** 
     * @param o1
     * @param o2
     * @return int
     */
    @Override
    public int compare(centroMedico o1, centroMedico o2) {
        if(o2.getDoctores() > o1.getDoctores()) return -1;
        else if(o2.getDoctores() > o1.getDoctores()) return 0;
        else return 1;
    }
}