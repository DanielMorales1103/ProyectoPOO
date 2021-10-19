import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Archivo{
    private String nombre;
    private File myFile;
    public Archivo(String nombre){
        this.nombre = nombre;
        myFile = new File(nombre);
    }

    public void crear_archivo(){
        if (myObj.createNewFile()) {
            System.out.println("Archivo creado: " + myFile.getName());
          } else {
            System.out.println("Este archivo ya existe");
          }
    }
    
}