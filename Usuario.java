/**
 * Clase Usuario. Será la encargada de manejar los nombres y contraseñas de los usuarios.
 * Grupo #1. POO
 * 22 de octubre de 2021
 * @version 3
 */
import java.util.*;

public class Usuario{
    private String nombre;
    private String clave;

    Usuario(String nombre, String clave){
        this.nombre = nombre;
        this.clave = clave;
    }



    public boolean verificar_clave(){
        boolean largo = false;
        boolean mayuscula = false;
        boolean minuscula = false;
        boolean numero = false;
        boolean especial = false;
        boolean espacio = true;
        boolean coma = true;
        if(clave.length()>=8){
            largo = true;
            for (int i =0; i< clave.length() ;i++){
                char caracter = clave.charAt(i);
                if(caracter == 44){
                    coma = false;
                }else if(caracter >=65 && caracter <=90){
                    mayuscula = true;
                }else if (caracter >=97 && caracter <=122){
                    minuscula = true;
                }else if (caracter >= 48 && caracter <= 57){
                    numero = true;
                }else if ( (caracter >= 33 && caracter <= 64) || (caracter >= 91 && caracter <= 96) || (caracter >= 123 && caracter <= 126) ){
                    especial = true;
                }else if (caracter == 32){
                    espacio = false;
                }
            }
        }
        if (mayuscula && minuscula && numero && especial && espacio && largo && coma){
            return true;
        }else{
            return false;
        }

    }

    public boolean verificar_usuario(ArrayList<String> usuarios, String nombre){
        boolean valido = true;
        for(String x: usuarios)
        {
            String[] datos = x.split(",");
            String nombreA = datos[0];
            if(nombre.equals(nombreA))
            {
                valido = false;
            }
        }
        return valido;
    }

    public boolean verificar_acceso(ArrayList<String> usuarios, String nombre, String contra){
        boolean valido = false;
        for(String x: usuarios)
        {
            String[] datos = x.split(",");
            String nombreA = datos[0];
            String contraA = datos[1];
            if(nombre.equals(nombreA) && contra.equals(contraA))
            {
                valido = true;
            }
        }
        return valido;
    }

    public int cantidad(String[][] base){
        int cont = 0;
        int cont2=0;
        for (int i = 0; i<base.length;i++){
            if(base[i][0] != null){
                cont++;
            }
        }
        return cont;
    }

}