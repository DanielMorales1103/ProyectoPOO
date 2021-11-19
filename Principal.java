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
        Controlador controlador = new Controlador();

        Usuario perfil;
        
        boolean hayArchivoU = false;
        boolean hayArchivoC = false;

        String nombre = "";
        String ubicacion = "";
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

        String usuario = "";
        String contra = "";

        boolean perfilvalido = false;
        boolean usuariovalido = false;
        boolean clavevalida = false;

        if(!hayArchivoU)
        {
            controlador.crearArchivo(new Archivos("usuarios.csv"));
            hayArchivoU = true;
        }

        if(!hayArchivoC)
        {
            controlador.crearArchivo(new Archivos("centros.csv"));
            hayArchivoC = true;
        }

        System.out.println("\nBienvenido, este programa esta orientado para poder suministrar a los centros de salud mas necesitados de\nGuatemala en estos tiempos de pandemia. Se buscara abastecer a los centros de salud mas afectados, buscando de una\nforma equitativa distribuir los recursos con los que se cuenta.\n");

        controlador.leerCentrosMedicos();

        //Código para iniciar sesión, siempre antes de entrar a cualquier otro proceso.
        while(sesion)
        {
            respuesta = pregunta("\nMenu:\n1. Iniciar sesion.\n2. Crear usuario.\n3. Cancelar.\nRespuesta: ", 3);
            switch (respuesta) {
                case 1:
                    System.out.println("\nIngrese su nombre de usuario: ");
                    usuario = scanner.nextLine();
                    System.out.println("\nIngrese su contrasena: ");
                    contra = scanner.nextLine();
                    perfil = new Usuario(usuario, contra);                 
                    perfilvalido = controlador.verificarAcceso(perfil, usuario, contra);
                    if(perfilvalido){
                        System.out.println("\nBienvenido: " + usuario);
                        sesion = false;
                        buclePrincipal = true;
                    }else{
                        System.out.println("\nUsuario o contrasena no valido.");
                    }
                    break;

                case 2:
                    System.out.println("\nIngrese su nombre de usuario: ");
                    usuario = scanner.nextLine();
                    System.out.println("\nIngrese su contrasena: ");
                    contra = scanner.nextLine();
                    perfil = new Usuario(usuario, contra);
                    usuariovalido = controlador.verficarUsuario(perfil, usuario);
                    clavevalida = controlador.verificarClave(perfil);
                    if (usuariovalido && clavevalida){
                        System.out.println("\nUsuario valido.");
                        controlador.agregarUsuario(perfil);
                        System.out.println("\nBienvenido: "+ usuario);
                    }else{
                        System.out.println("\nUsuario o contrasena invalido.");
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
                respuesta = pregunta("\nMenu:\n1. Agregar nuevo centro medico.\n2. Donacion.\n3. Mostrar datos de los centros medicos. \n4. Cerrar sesion.\nRespuesta: ", 4);
                switch(respuesta)
                {
                    case 1:
                    //Codigo para agregar centro medico
                    System.out.println("\n---Agregar nuevo centro medico.---\n");

                    System.out.println("\nIngrese el nombre del centro medico: ");
                    nombre = scanner.nextLine();
                    System.out.println("\nIngrese la direccion del centro medico: ");
                    ubicacion = scanner.nextLine();
                    System.out.println("\nIngrese el numero telefonico del centro medico: ");
                    numero = scanner.nextLine();

                    bucle = true;
                    while(bucle)
                    {
                        try {
                            System.out.println("\nIngrese la cantidad de pacientes que se encuentran en este centro medico: ");
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
                            System.out.println("\nIngrese la cantidad de camas con las que cuenta este centro medico: ");
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
                            System.out.println("\nIngrese la cantidad de medicina con la que cuenta este centro medico (en general, cual es la suma de medicina): ");
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
                            System.out.println("\nIngrese la cantidad de medicos con los que cuenta este centro medico: ");
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
                            System.out.println("\nIngrese la cantidad de tanques de oxigeno con los que cuenta este centro medico: ");
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
                            System.out.println("\nIngrese la cantidad de comida con la que cuenta este centro medico (cantidad de platos de comida): ");
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
                    controlador.agregarCento(centro);
                    
                        break;

                    case 2:
                    x = pregunta("\n¿Que tipo de donacion desea realizar?\n1. Monetaria\n\t-Cantidad Q.\n2. Suministros:\n\t-Medicinas.\n\t-Camas.\n\t-Comida.\n\t-Tanques de oxigeno.\nRespuesta: ", 2);
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
                                System.out.println(controlador.donarDinero(dinero));
                                
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
                                System.out.println("\nIngrese la cantidad de medicina que donara: ");
                                medicinas = scanner.nextInt();
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

                        System.out.println(controlador.donarMedicina(medicinas));
                        System.out.println(controlador.donarCamas(camas));
                        System.out.println(controlador.donarComida(comida));
                        System.out.println(controlador.donarTanques(tanquesOxigeno));
                        controlador.SobreescribirCentros();
                            break;
                    }
                        break;
                    
                    case 3:
                    if(controlador.getCentros().size() > 0)
                    {
                        x = pregunta("\n¿Desea ordenar los centros medicos de forma descendente?\n1. Si.\n2. No.\nRespuesta: ", 2);
                        if(x == 1)
                        {
                            respuesta = pregunta("\n¿Como desea ordenarlos? Por la cantidad de:\n1. Fondos.\n2. Medicina.\n3. Tanques de oxigeno.\n4. Platos de comida.\n5. Pacientes.\n6. Doctores.\n7. Camas.\nRespuesta: ", 7);
                            switch (respuesta) {
                                case 1:
                                    controlador.ordenarDinero(); //funciona
                                    System.out.println(controlador.verCentros(controlador.getCmDinero()));
                                    break;

                                case 2:
                                    controlador.ordenarMedicina();  //funciona
                                    System.out.println(controlador.verCentros(controlador.getCmMedicina()));
                                    break;
                            
                                case 3:
                                    controlador.ordenarTanques(); //funciona
                                    System.out.println(controlador.verCentros(controlador.getCmTanques()));
                                    break;

                                case 4:
                                    controlador.ordenarComida(); //funciona
                                    System.out.println(controlador.verCentros(controlador.getCmComida()));
                                    break;
                                
                                case 5:
                                    controlador.ordenarPaciente(); //funciona
                                    System.out.println(controlador.verCentros(controlador.getCmPacientes()));
                                    break;

                            
                                case 6:
                                    controlador.ordenarDoctores(); //funciona
                                    System.out.println(controlador.verCentros(controlador.getCmDoctores()));
                                    break;

                                case 7:
                                    controlador.ordenarCamas(); //funciona
                                    System.out.println(controlador.verCentros(controlador.getCmCamas()));
                                    break;


                                default:
                                    break;
                            }
                        }
                        else System.out.println(controlador.verCentros(controlador.getCentros()));
                        
                    }
                    else System.out.println("\nNo se cuenta con centros medicos aun.\n");
                        
                        break;

                    case 4:
                            buclePrincipal=false;
                        break;
                    
                    default:
                    System.out.println("\nIngrese una opcion valida.\n");
                }
        }
        
        scanner.close();
        System.out.println("\n¡Agradecemos muchisimo tu donacion. Sera de gran ayuda para muchas personas!");
        System.out.println("\nRecuerda cuidarte a ti y a tus seres queridos. Utiliza la mascarilla todo el tiempo.");
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
                else System.out.println("\nRepuesta no valida.");
            }    
        } catch (Exception e) {
            System.out.println("\nRepuesta no valida. Ingrese solamente numeros.");
            respuesta = pregunta(pregunta, opciones);
        }
        return respuesta;
    }
}