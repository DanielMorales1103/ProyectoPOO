/**
 * Clase Archivos. Será la encargada de generar/manejar las bases de datos en formato CSV.
 * Grupo #1. POO
 * 22 de octubre de 2021
 * @version 3
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class Archivos
{
    private String nombre;
    File archivo;
    FileWriter fw;
    private Scanner sw;
    
    public Archivos(String nombre)
    {
        this.nombre=nombre;
        archivo= new File(nombre);        
    }

    public void crear_archivo()
    {
        try {
            if (archivo.createNewFile()){

                }else {
                
            }
        } catch (IOException e) {
            
        }
        
    }

    public void escribir_archivo(ArrayList<String> texto)        //hacer una lectura y agregar el texto al final luego rrenviar todo el texto
    {
        try {
            fw = new FileWriter(nombre);
            for (int i =0; i<texto.size();i++){
                fw.write(texto.get(i)+"\n");
            }
            fw.close();
        } catch (IOException e) {
            
        }
    }

    public ArrayList<String> lectura()
    {
        ArrayList<String> lista = new ArrayList<String>();
        try {
            sw = new Scanner(archivo);
            while (sw.hasNextLine()){
                lista.add(sw.nextLine());
            }
            sw.close();
        } catch (IOException e) {
            
        }
        
        return (lista);
    }

}