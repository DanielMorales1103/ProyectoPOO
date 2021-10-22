/**
 * Clase Principal. Será la encargada de interactuar con el usuario, conectará los distintos métodos con este.
 * Grupo #1. POO
 * 22 de octubre de 2021
 * @version 3
 */
import java.util.Scanner;
import java.util.*;
public class Principal
{

    
    /** 
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Donacion donacion = new Donacion();
        ArrayList<centroMedico> centros = new ArrayList<centroMedico>();
        Usuario perfil;
        String[][] perfiles = new String[1000][2]; 
        Archivos archivo = new Archivos("prueba.csv");
        ArrayList<String> usuarios = archivo.lectura();
        boolean hayArchivo = false;

        String nombre = "";
        String ubicacion = "";
        int capacidadAtencion = 0;
        int pacientes = 0;
        String numero = "";
        int doctores = 0;
        
        double dinero = 0;
        int medicinas = 0;
        int ropaH = 0;
        int ropaM = 0;
        int camas = 0;
        int sabanas = 0;
        int comida = 0;
        int tanquesOxigeno = 0;


        int respuesta;
        int x;
        boolean buclePrincipal = false;
        boolean sesion = true;
        boolean bucle = true;

        String usuario="";
        String contra="";
        int largo = 0;

        boolean perfilvalido = true;
        boolean usuariovalido = false;
        boolean clavevalida= false;

        if(!hayArchivo)
        {
            archivo.crear_archivo(); 
            hayArchivo = true;
        }
        System.out.println("\nBienvenido, este programa está orientado para poder suministrar a los centros de salud más necesitados de\nGuatemala en estos tiempos de pandemia. Se buscará abastecer a los centros de salud más afectados, buscando de una\nforma equitativa distribuir los recursos con los que se cuenta.\n");


        //Código para iniciar sesión, siempre antes de entrar a cualquier otro proceso.
        while(sesion)
        {
            respuesta = pregunta("\nMenu:\n1. Iniciar sesion.\n2. Crear usuario.\n3. Cancelar.\nRespuesta: ", 3);
            switch (respuesta) {
                case 1:
                    System.out.println("Ingrese su nombre de usuario");
                    usuario = scanner.nextLine();
                    System.out.println("Ingrese su contraseña");
                    contra = scanner.nextLine();
                    perfil = new Usuario(usuario, contra);
                    //perfiles[0][0] = "Admin";
                    //perfiles[0][1] = "Hola1234+";
                    //largo = perfil.cantidad(perfiles);                    
                    perfilvalido =  perfil.verificar_acceso(usuarios, usuario, contra);
                    if(perfilvalido){
                        System.out.println("Bienvenido: "+usuario);
                        sesion = false;
                        buclePrincipal = true;
                    }else{
                        System.out.println("Perfil no valido");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese su nombre de usuario");
                    usuario = scanner.nextLine();
                    System.out.println("Ingrese su contraseña");
                    contra = scanner.nextLine();
                    perfil = new Usuario(usuario, contra);
                    usuariovalido = perfil.verificar_usuario(usuarios, usuario);
                    clavevalida = perfil.verificar_clave();
                    //hacer el ingreso al archivo si los dos son true
                    if (usuariovalido && clavevalida){
                        System.out.println("Usuario valido");
                        archivo.escribir_archivo(usuario + "," + contra);
                        System.out.println("Bienvenido: "+ usuario);
                    }else{
                        System.out.println("Usuario invalido");
                    }
                    break;

                case 3:
                buclePrincipal = false;
                sesion = false;
                    break;
                default:
                    break;
            }
        }

        while(buclePrincipal)
        {
                respuesta = pregunta("\nMenu:\n1. Agregar nuevo centro médico.\n2. Donacion.\n3. Mostrar datos de los centros medicos. \n4. Cerrar sesion.\nRespuesta: ", 4);
                switch(respuesta)
                {
                    case 1:
                    //Codigo para agregar centro medico
                    System.out.println("\n---Agregar nuevo centro medico.---\n");

                    System.out.println("\nIngrese el nombre del centro médico: ");
                    nombre = scanner.nextLine();
                    System.out.println("\nIngrese la dirección del centro médico: ");
                    ubicacion = scanner.nextLine();
                    System.out.println("\nIngrese el número telefónico del centro médico: ");
                    numero = scanner.nextLine();

                    bucle = true;
                    while(bucle)
                    {
                        try {
                            System.out.println("\nIngrese la cantidad de pacientes que se encuentran en este centro médico: ");
                            pacientes= scanner.nextInt();
                            scanner.nextLine();
                            bucle = false;
                            if(pacientes <= 0)
                            {
                                System.out.println("\nRespuesta no valida.");
                                bucle = true;
                            }else{
                                bucle =false;
                            }
                            
                        } catch (Exception e) {
                            System.out.println("\nPor favor, ingrese solamente numeros.");
                            scanner.nextLine();
                            bucle = true;
                        }
                    }
                    
                    bucle = true;
                    while(bucle)
                    {
                        try {
                            System.out.println("\nIngrese la cantidad de camas con las que cuenta este centro médico: ");
                            camas= scanner.nextInt();
                            scanner.nextLine();
                            bucle = false;
                            if(camas <= 0)
                            {
                                System.out.println("\nRespuesta no valida.");
                                bucle = true;
                            }                            
                        } catch (Exception e) {
                            System.out.println("\nPor favor, ingrese solamente numeros.");
                            scanner.nextLine();
                            bucle = true;
                        }
                    }

                    bucle = true;
                    while(bucle)
                    {
                        try {
                            System.out.println("\nIngrese la cantidad de medicina con la que cuenta este centro médico (en general, cual es la suma de medicina): ");
                            medicinas= scanner.nextInt();
                            scanner.nextLine();
                            bucle = false;
                            if(medicinas <= 0)
                            {
                                System.out.println("\nRespuesta no valida.");
                                bucle = true;
                            }                           
                        } catch (Exception e) {
                            System.out.println("\nPor favor, ingrese solamente numeros.");
                            scanner.nextLine();
                            bucle = true;
                        }
                    }

                    bucle = true;
                    while(bucle)
                    {
                        try {
                            System.out.println("\nIngrese la cantidad de médicos con los que cuenta este centro médico: ");
                            doctores = scanner.nextInt();
                            scanner.nextLine();
                            bucle = false;
                            if(doctores <= 0)
                            {
                                System.out.println("\nRespuesta no valida.");
                                bucle = true;
                            }                          
                        } catch (Exception e) {
                            System.out.println("\nPor favor, ingrese solamente numeros.");
                            scanner.nextLine();
                            bucle = true;
                        }
                    }

                    bucle = true;
                    while(bucle)
                    {
                        try {
                            System.out.println("\nIngrese la cantidad de tanques de oxígeno con los que cuenta este centro médico: ");
                            tanquesOxigeno = scanner.nextInt();
                            scanner.nextLine();
                            bucle = false;
                            if(tanquesOxigeno <= 0)
                            {
                                System.out.println("\nRespuesta no valida.");
                                bucle = true;
                            }                          
                        } catch (Exception e) {
                            System.out.println("\nPor favor, ingrese solamente numeros.");
                            scanner.nextLine();
                            bucle = true;
                        }
                    }

                    bucle = true;
                    while(bucle)
                    {
                        try {
                            System.out.println("\nIngrese la cantidad de comida con la que cuenta este centro médico (cantidad de platos de comida): ");
                            comida= scanner.nextInt();
                            scanner.nextLine();
                            bucle = false;
                            if(comida <= 0)
                            {
                                System.out.println("\nRespuesta no valida.");
                                bucle = true;
                            }                          
                        } catch (Exception e) {
                            System.out.println("\nPor favor, ingrese solamente numeros.");
                            scanner.nextLine();
                            bucle = true;
                        }
                    }

                    bucle = true;
                    while(bucle)
                    {
                        try {
                            System.out.println("\nIngrese la cantidad de fondos con los que cuenta el hospital ");
                            dinero= scanner.nextDouble();
                            scanner.nextLine();
                            bucle = false;
                            if(dinero <= 0)
                            {
                                System.out.println("\nRespuesta no valida.");
                                bucle = true;
                            }                         
                        } catch (Exception e) {
                            System.out.println("\nPor favor, ingrese solamente numeros.");
                            scanner.nextLine();
                            bucle = true;
                        }
                    }
                    centroMedico centro = new centroMedico(nombre, dinero, numero, ubicacion, tanquesOxigeno, comida, camas, pacientes, doctores, medicinas);
                    centros.add(centro);
                    //centroMedico.agregarCentro(nombre, unbicacion, capacidadAtencion, medicos, camas, medicinas, ropaH, ropaM, savanas, comida, tanquesOxigeno, pacientes, dinero);
                        break;

                    case 2:
                    x = pregunta("\n¿Que tipo de donacion desea realizar?\n1. Monetaria\n\t-Cantidad Q.\n2. Suministros:\n\t-Medicinas.\n\t-Ropa hombre.\n\t-Ropa mujer.\n\t-Camas.\n\t-Comida.\n\t-Tanques de oxigeno.\nRespuesta: ", 2);
                    switch(x)
                    {
                        case 1:
                        bucle = true;
                        while(bucle)
                        {
                            try {
                                System.out.println("\nPor favor, ingrese el monto a donar en Quetzales\nRepuesta: ");
                                dinero = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println(donacion.monetaria(dinero));
                                bucle = false;                        
                            } catch (Exception e) {
                                System.out.println("\nPor favor, ingrese solamente numeros.");
                                scanner.nextLine();
                                bucle = true;
                            }
                        }
                            break;
                        
                        case 2:
                        bucle = true;
                        while(bucle)
                        {
                            try {
                                System.out.println("\nIngrese la cantidad de camas que donara: ");
                                camas= scanner.nextInt();
                                scanner.nextLine();
                                bucle = false;
                                if(camas <= 0)
                                {
                                    System.out.println("\nRespuesta no valida.");
                                    bucle = true;
                                }                       
                            } catch (Exception e) {
                                System.out.println("\nPor favor, ingrese solamente numeros.");
                                scanner.nextLine();
                                bucle = true;
                            }
                        }

                        bucle = true;
                        while(bucle)
                        {
                            try {
                                System.out.println("\nIngrese la cantidad de medicina que donara: ");
                                medicinas= scanner.nextInt();
                                scanner.nextLine();
                                bucle = false;
                                if(medicinas <= 0)
                                {
                                    System.out.println("\nRespuesta no valida.");
                                    bucle = true;
                                }                      
                            } catch (Exception e) {
                                System.out.println("\nPor favor, ingrese solamente numeros.");
                                scanner.nextLine();
                                bucle = true;
                            }
                        }

                        bucle = true;
                        while(bucle)
                        {
                            try {
                                System.out.println("\nIngrese la cantidad ropa para hombre que donara: ");
                                ropaH = scanner.nextInt();
                                scanner.nextLine();
                                bucle = false;
                                if(ropaH <= 0)
                                {
                                    System.out.println("\nRespuesta no valida.");
                                    bucle = true;
                                }                      
                            } catch (Exception e) {
                                System.out.println("\nPor favor, ingrese solamente numeros.");
                                scanner.nextLine();
                                bucle = true;
                            }
                        }

                        bucle = true;
                        while(bucle)
                        {
                            try {
                                System.out.println("\nIngrese la cantidad ropa para mujer que donara: ");
                                ropaM = scanner.nextInt();
                                scanner.nextLine();
                                bucle = false;
                                if(ropaM <= 0)
                                {
                                    System.out.println("\nRespuesta no valida.");
                                    bucle = true;
                                }                     
                            } catch (Exception e) {
                                System.out.println("\nPor favor, ingrese solamente numeros.");
                                scanner.nextLine();
                                bucle = true;
                            }
                        }
                        
                        bucle = true;
                        while(bucle)
                        {
                            try {
                                System.out.println("\nIngrese la cantidad de tanques de oxigeno que donara: ");
                                tanquesOxigeno = scanner.nextInt();
                                scanner.nextLine();
                                bucle = false;
                                if(tanquesOxigeno <= 0)
                                {
                                    System.out.println("\nRespuesta no valida.");
                                    bucle = true;
                                }                     
                            } catch (Exception e) {
                                System.out.println("\nPor favor, ingrese solamente numeros.");
                                scanner.nextLine();
                                bucle = true;
                            }
                        }

                        bucle = true;
                        while(bucle)
                        {
                            try {
                                System.out.println("\nIngrese la cantidad de comida que donara (cantidad de platos de comida): ");
                                comida = scanner.nextInt();
                                scanner.nextLine();
                                bucle = false;
                                if(comida <= 0)
                                {
                                    System.out.println("\nRespuesta no valida.");
                                    bucle = true;
                                }                    
                            } catch (Exception e) {
                                System.out.println("\nPor favor, ingrese solamente numeros.");
                                scanner.nextLine();
                                bucle = true;
                            }
                        }

                        bucle = true;
                        while(bucle)
                        {
                            try {
                                System.out.println("\nIngrese la cantidad de savanas que donara: ");
                                sabanas = scanner.nextInt();
                                scanner.nextLine();
                                bucle = false;
                                if(sabanas <= 0)
                                {
                                    System.out.println("\nRespuesta no valida.");
                                    bucle = true;
                                }                    
                            } catch (Exception e) {
                                System.out.println("\nPor favor, ingrese solamente numeros.");
                                scanner.nextLine();
                                bucle = true;
                            }
                        }
                        System.out.println(donacion.suministros(medicinas, ropaH, ropaM, camas, sabanas, comida, tanquesOxigeno));
                            break;
                    }
                    
                    case 3:
                    for(centroMedico k: centros)
                    {
                        System.out.print("\nNombre del centro: " + k.getNombre());
                        System.out.print("\nLocalización del centro: " + k.getUbicacion());
                        System.out.print("\nNumero de telefono del centro: " + k.getNumero());
                        System.out.print("\nCantidad de doctores del centro: " + k.getDoctores());
                        System.out.print("\nCantidad de pacientes del centro: " + k.getPacientes());
                        System.out.print("\nCantidad de camas del centro: " + k.getCamas());
                        System.out.print("\nCantidad de comida del centro: " + k.getComida());
                        System.out.print("\nCantidad de tanques del centro: " + k.getTanquesOxigeno());
                    }
                        
                        
                        break;

                    case 4:
                            buclePrincipal=false;
                        break;
                    
                    default:
                    System.out.println("Ingrese una opcion valida.\n");
                }
        }   
        
        scanner.close();
        System.out.println("\n¡Agradecemos muchisimo tu donacion. Sera de gran ayuda para muchas personas!");
        System.out.println("Recuerda cuidarte a ti y a tus seres queridos. Utiliza la mascarilla todo el tiempo");
    }

    
    /** 
     * @param pregunta
     * @param opciones
     * @return int
     */
    public static int pregunta(String pregunta, int opciones)
    {
        boolean bucle = true;
        int respuesta = 0;
        Scanner scanner = new Scanner(System.in);
        try 
        {
            while(bucle)
            {
                System.out.println(pregunta);
                respuesta = scanner.nextInt();
                scanner.nextLine();
                if(respuesta > 0 && respuesta <= opciones) bucle = false;
                else System.out.println("Repusta no valida.\n");
            }    
        } catch (Exception e) {
            System.out.println("Repuesta no valida. Ingrese solamente numeros.\n");
            respuesta = pregunta(pregunta, opciones);
        }
        return respuesta;
    }
}