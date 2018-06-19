/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Obligatorio;
import java.util.*;

/**
 *
 * @author TOPOF
 */
public class Prueba {
    public static void main(String[] args) {
        Sistema lista = new Sistema();
        int opcion=-1;
        do{
            opcion=validarNumero("Seleccione opción del Menú \n 1) Registrar "
                    + "Socio\n 2) Registrar Animador\n 3) Registrar Actividad\n "
                    + "4) Registrar Inscripcioón a Actividad\n 5) Consulta por "
                    + "Actividad\n 6) Listado Ordenado de Actividades\n 7) Baja de "
                    + "Actividad\n 8) Actividades Preferidas por los Socios\n "
                    + "9) Animadores sin Actividades asignadas");
        switch(opcion){
            case 1:
                System.out.println("Registrar Socio");
                lista.agregarSocio(ingresarSocio());
                haySocio=true;
                break;
            case 2:
                System.out.println("Registrar Animador");
                lista.agregarAnimador(ingresarAnimador());
                hayAnimador=true;
                break;
            case 3:
                if (hayAnimador){
                    lista.agregarActividad(ingresarActividad(lista));
                }else{
                    System.out.println("No hay animador, ingrese a la opción"
                            + " Registrar Animador del Menú");
                }
                hayActividad=true;
                break;
            case 4:
                if(haySocio && hayActividad){
                    lista.agregarInscripciones(ingresarInscripcion(lista));  
                }else{
                    System.out.println("Debe primero ingresar por lo menos"
                            + " un Socio (Primera opción del Menú) y una "
                            + "Actividad (Tercera opción del Menú)");
                }
                break;
            case 5:
                System.out.println("Consulta por Actividad");
                if (hayActividad){
                    
                }else{
                    System.out.println("Ingrese a la opción Registrar Actividad"
                            + " del Menú previamente");
                }
                
                break;
            case 6:
                if(hayActividad){
                System.out.println("Listado Ordenado de Actividades");
                System.out.println("La lista de Actividades es :");
                OrdenarActividad(lista);
                }else{
                    System.out.println("Ingrese a la opción Registrar Actividad"
                            + " del Menú previamente");
                }
                break;
            case 7:
                if(hayActividad){
                System.out.println("Baja de Actividad");
                lista.eliminarActividad(bajaActividad(lista));
                
                
                //Esta por la mitad, falta la lista ordenada por nombre y la lista de Inscriptos a llamar por telefono
                }else{
                    System.out.println("Ingrese a la opción Registrar Actividad"
                            + " del Menú previamente");
                }
                break;
            case 8:
                if(hayActividad){
                System.out.println("Actividades Preferidas por los Socios");
                actividadPreferida(lista);
                }else{
                    System.out.println("Ingrese a la opción Registrar Actividad"
                            + " del Menú previamente");
                }
                break;
            case 9:
                if (hayAnimador){
                System.out.println("Animadores sin Actividades asignadas");
                
                }else{
                    System.out.println("No hay animador, ingrese a la opción"
                            + " Registrar Animador del Menú");
                }
                break;
            case 10:
                System.out.println("Terminado");
                break;
            default:
                System.out.println("Ingrese opción correcta (1-9)");
            }
    }while(opcion!=10);
    }
    //case 1
    public static Socio ingresarSocio() {
        //Se hace el método para poder ingresar los datos de los Socios 
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese Nombre del Socio");
        String nombre = input.nextLine();
        //Se valida el nombre del Socio
        while (validarTexto(nombre)){
        System.out.println("Ingrese un Nombre");
        nombre = input.nextLine();
        }
        int edad=validarNumeroEntre("Ingresar Edad (entre 18-99)",18,99);
        int cedula=validarNumero("Ingresar Cedula de identidad (sin guiones)");
        System.out.println("Ingresar Dirección");
        String direccion = input.nextLine();
        while (validarTexto(direccion)){
            System.out.println("Ingresar Dirección válida");
            direccion = input.nextLine();
        }
        Socio socio = new Socio(nombre, edad, cedula, direccion);
        return socio;
    }
    //Case 2
    public static Animador ingresarAnimador(){
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese Nombre del Animador");
        String nombre = input.nextLine();
        //Se valida el nombre del Animador
        while (validarTexto(nombre)){
        System.out.println("Ingrese un Nombre");
        nombre = input.nextLine();
        }
        int cedula = validarNumero("Ingresar Cedula de identidad (sin guiones)");
        int añosexperiencia = validarNumero("Ingrese Años de Experiencia");
        Animador animador= new Animador(nombre,cedula,añosexperiencia);
        return animador;
    }
    //Case 3
    public static Actividad ingresarActividad(Sistema unaLista) {
        //Se hace el método para poder ingresar los datos de la Actividad
        //Se valida el dia
        int dia =validarNumeroEntre("Ingrese día de la Actividad (entre 1-31)",1,31);
        // Se valida que el tipo de Actividad este entre 1-7
        int tipo=validarNumeroEntre("Ingrese tipo de Actividad \n  1-teatro \n  2-cine \n"
                + "  3-viaje \n  4-paseo local \n  5-paseo interdepartamental \n"
                + "  6- caminata \n  7- otro ",1,7);
        //Se valida que la capacidad no sea negativa
        int capacidadmaxima=validarNumero("Ingrese Capacidad Máxima");
        int costo =validarNumero("Ingrese costo");
        int horacomienzo =validarNumeroEntre("Ingrese la hora de comienzo (entre 7-21)",7,21);
        //Se valida que exista el animador
        System.out.println("Que animador quiere que se le asigne");
                for(int i=0;i<unaLista.cantidadAnimadores();i++){
                    System.out.println((i+1)+") "+unaLista.getListaAnimadores().get(i));
                }
                int animador= validarNumeroEntre("Seleccione número de Animador",1,unaLista.cantidadAnimadores());
        Actividad actividad = new Actividad(dia, tipo, capacidadmaxima, costo, horacomienzo,unaLista.getListaAnimadores().get(animador-1));
        return actividad;
    }
    //Case 4
    public static Inscripcion ingresarInscripcion(Sistema unaLista) {
        //Se crea el método para ingresar el Socio
        System.out.println("Que socio quiere que se le asigne");
                    for(int i=0;i<unaLista.cantidadSocios();i++){
                        System.out.println((i+1)+")"+unaLista.getListaSocios().get(i));
                    }
                    //Se valida que el socio sea valido
                    int socio=validarNumeroEntre("Seleccione número de Socio",1,unaLista.cantidadSocios()+1);
                    System.out.println("Que Actividad quiere que se le asigne");
                    for(int i=0;i<unaLista.cantidadActividades();i++){
                        System.out.print((i+1)+")"+unaLista.getListaActividades().get(i));
                    }
                    //Se valida que la actividad sea valida
                    int actividad =validarNumeroEntre("Seleccione número de Actividad",0,unaLista.cantidadActividades());
                    //Se valida que la hora de recogida sea una hora antes del comienzo de la actividad y dentro del horario establecido
                    int horarecogida=validarNumeroEntre("Ingrese hora en la que "
                            + "quiere que se lo pase a buscar,\npor lo menos una"
                            + " hora antes de la actividad "
                            + "("+unaLista.getListaActividades().get(actividad).getHoracomienzo()+"hs)"
                            + " y  entre 6-20 hs",6,(unaLista.getListaActividades().get(actividad).getHoracomienzo())-1);
        int telefono=validarNumero("Ingrese Telefono de Contacto");
        Inscripcion inscripcion = new Inscripcion(horarecogida, unaLista.getListaSocios().get(socio-1), unaLista.getListaActividades().get(actividad-1), telefono);
        return inscripcion;
    }
    // Case 5
    public static void consultaActividad(Sistema unaLista){
        //Se crea una Array con los 31 días del mes
    int [] lista = new int [32];
    //Se crea un Array con los tipos de Actividades
    int [] tipo  = new int [8];
    /*for (int i= 0;i<unaLista.cantidadActividades();i++){
        int auxiliar;
        auxiliar=unaLista.getListaActividades().get(i).getTipo();
        tipo[auxiliar]=tipo[auxiliar]+1;
    }
*/
    //Se tiene que hacer un Array, que devuelva un Array y el Array que te devuelve se tiene le tiene que agregar de a uno 
    }
    // Case 6
    public static void OrdenarActividad(Sistema unaLista){
        System.out.println(unaLista.ordenarAscendente());
        for(int i=0;i<unaLista.cantidadActividades();i++){
                        System.out.print((i+1)+")"+unaLista.getListaActividades().get(i));
                    }               
    }
    // Case 7
    public static Actividad bajaActividad(Sistema unaLista){
        System.out.println("Lista de Actividades");
        for (int i=0;i<unaLista.cantidadActividades();i++){
            System.out.println((i+1)+")"+unaLista.getListaActividades().get(i));
        }
        int baja=validarNumeroEntre("Seleccione el número Actividad que se quiere dar de baja",1,unaLista.cantidadActividades()+1);
        for (int o=0;o<unaLista.cantidadInscripciones();o++){
            if(unaLista.getListaInscripciones().get(o).getActividad()==unaLista.getListaActividades().get(baja-1)){
                System.out.println("Se tiene que llamar a "+unaLista.getListaInscripciones().get(o).getSocio());
                unaLista.getListaInscripciones().remove(o);
            }
        }
        Actividad bajaActividad = unaLista.getListaActividades().get(baja-1);
        return bajaActividad;
    }
    //Case 8
    public static String actividadPreferida(Sistema unaLista){
        //Se crea un Array con los tipos de Actividades
        int [] preferida = new int [8];
        //Se recorre la cantidad de inscriptos y se agrega de a uno en el Array
        for (int i=0;i<unaLista.cantidadInscripciones();i++){
            int aux =unaLista.getListaInscripciones().get(i).getActividad().getTipo();
            preferida [aux]=preferida[aux]+1;
        }
        int favorita=-1;
        //Se fija cual es la actividad preferida
        for (int o=0;o<preferida.length;o++){
            if(preferida[o]>favorita){
                favorita = preferida[o];
            }
        }
        String favorito="la Actividad favorita es"+favorita;
        return favorito;
    }
    //Case 9
   public static void consultaAnimador(Sistema unaLista){
       int falta=0;
       /*
        for(int i =0;i<unaLista.cantidadAnimadores();i++){
            for(int o =0;o<unaLista.cantidadActividades();o++){
                if (unaLista.getListaAnimadores().get(i)==unaLista.getListaActividades().get(o).getAnimador()){
                   falta=falta+1;
                }
            }
            if (falta==0){
                System.out.println(unaLista.getListaAnimadores().get(i)+" no tiene actividad asignada");
            }
            falta=0;
        }
*/
       
        //Mal, rehacer
        //Se puede hacer con un iterator
    }
    static boolean hayAnimador=false;
    static boolean hayActividad=false;
    static boolean haySocio=false;
    
    //Boolean para validar que el texto no sea vacío
    public static boolean validarTexto(String texto){
        return texto.trim().isEmpty();
    }
    //Se valida que el numero sea mayor a 0
    public static int validarNumero(String mensaje){
        System.out.println(mensaje);
        Scanner in = new Scanner (System.in);
        int numero=in.nextInt();
        while  (numero<0){
            System.out.println("Ingrese un valor positivo");
            numero=in.nextInt();
        }
        return numero;
    }
    //Se crea un método que valide que un numero se encuentre entre un amximo y un minimo
    public static int validarNumeroEntre(String mensaje,int min, int max){
        System.out.println(mensaje);
        Scanner in = new Scanner (System.in);
        int numero=in.nextInt();
        while  (numero<min||numero>max){
            System.out.println("Ingrese un valor entre "+min+" y "+max);
            numero=in.nextInt();
        }
        return numero;
    }
}
