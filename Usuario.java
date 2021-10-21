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
        if(clave.length()>=8){
            largo = true;
            for (int i =0; i< clave.length() ;i++){
                char caracter = clave.charAt(i);
                if(caracter >=65 && caracter <=90){
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
        if (mayuscula && minuscula && numero && especial && espacio && largo){
            return true;
        }else{
            return false;
        }

    }

    public boolean verificar_usuario(String[][] base, int largo){
        boolean valido = true;
        for (int i = 0; i<largo;i++){
            System.out.print(base[i][0] +"== "+ this.nombre);
            if(base[i][0].equals(nombre)){
                valido = false;
            }
        }
        return valido;
    }

    public boolean verificar_acceso(String[][] base, int largo){
        boolean valido = false;
        for (int i = 0; i<largo;i++){
            if(base[i][0].equals(nombre) && base[i][1].equals(clave)){
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