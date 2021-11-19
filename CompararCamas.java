/**
 * Clase CompararCamas. Será la encargada ordenar por el numero de camas del centro medico, utilizando compare el ArrayList de centroMedico
 * Grupo #1. POO
 * 17 de noviembre de 2021
 * @version 1
 */

import java.util.Comparator;

public class CompararCamas implements Comparator<centroMedico>
{
    /** 
     * @param o1
     * @param o2
     * @return int
     */
    @Override
    public int compare(centroMedico o1, centroMedico o2) {
        if(o2.getCamas() > o1.getCamas()) return -1;
        else if(o2.getCamas() > o1.getCamas()) return 0;
        else return 1;
    }
}