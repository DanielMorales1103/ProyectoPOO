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
public class Archivos{
    private String nombre;
    File archivo;
    FileWriter fw;
    private Scanner sw;
    public Archivos(String nombre){
        this.nombre=nombre;
        archivo= new File(nombre);        
    }

    public void crear_archivo(){
        try {
            if (archivo.createNewFile()){
                System.out.println("Archivo creado: " + archivo.getName());
                }else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
        
    }

    public String escribir_archivo(String texto){        //hacer una lectura y agregar el texto al final luego rrenviar todo el texto
        try {
            fw = new FileWriter(nombre);
            fw.append(texto+"\n");
            fw.close();
            return "Escrito correctamente";
        } catch (IOException e) {
            return "Error en la escritura";
        }
    }

    public ArrayList<String> lectura(){
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