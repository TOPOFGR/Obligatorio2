/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Obligatorio;

import java.util.Scanner;

/**
 *
 * @author TOPOF
 */
public class Prueba {
    public static void main(String[] args) {
        Sistema lista = new Sistema();
        int opcion=-1;
        Scanner in= new Scanner(System.in);
        do{
            System.out.println("Seleccione opción del Menú \n 1) Registrar "
                    + "Socio\n 2) Registrar Animador\n 3) Registrar Actividad\n "
                    + "4) Registrar Inscripcioón a Actividad\n 5) Consulta por "
                    + "Actividad\n 6) Listado Ordenado de Actividades\n 7) Baja de "
                    + "Actividad\n 8) Actividades Preferidas por los Socios\n "
                    + "9) Animadores sin Actividades asignadas");
            opcion=in.nextInt();
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
                            + " 2) Registrar Animador del Menú");
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
                
                break;
            case 6:
                System.out.println("Listado Ordenado de Actividades");
                System.out.println("La lista de Actividades es :");
                break;
            case 7:
                System.out.println("Baja de Actividad");
                break;
            case 8:
                System.out.println("Actividades Preferidas por los Socios");
                break;
            case 9:
                System.out.println("Animadores sin Actividades asignadas");
                break;
            case 10:
                System.out.println("Terminado");
                break;
            default:
                System.out.println("Ingrese opción correcta (1-9)");
            }
    }while(opcion!=10);
    }
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
        System.out.println("Ingresar Edad (entre 18-99)");
        int edad = input.nextInt();
        while (validarEdad(edad)) {
            System.out.println("Ingrese Edad entre 18 y 99");
            edad = input.nextInt();
        }
        System.out.println("Ingresar Cedula de identidad (sin guiones)");
        int cedula = input.nextInt();
        while (validarPositivo(cedula)){
            System.out.println("Ingrese Cédula válida");
            cedula = input.nextInt();
        }
        System.out.println("Ingresar Dirección");
        String direccion = input.nextLine();
        direccion = input.nextLine();
        while (validarTexto(direccion)){
            System.out.println("Ingresar Dirección válida");
            direccion = input.nextLine();
        }
        Socio socio = new Socio(nombre, edad, cedula, direccion);
        return socio;
    }
    public static Animador ingresarAnimador(){
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese Nombre del Animador");
        String nombre = input.nextLine();
        //Se valida el nombre del Animador
        while (validarTexto(nombre)){
        System.out.println("Ingrese un Nombre");
        nombre = input.nextLine();
        }
        System.out.println("Ingresar Cedula de identidad (sin guiones)");
        int cedula = input.nextInt();
        while (validarPositivo(cedula)){
            System.out.println("Ingrese Cédula válida");
            cedula = input.nextInt();
        }
        System.out.println("Ingrese Años de Experiencia");
        int añosexp = input.nextInt();
        Animador animador= new Animador(nombre,cedula,añosexp);
        return animador;
    }
    public static Actividad ingresarActividad(Sistema unArrayList) {
        //Se hace el método para poder ingresar los datos de la Actividad
        Scanner inp = new Scanner(System.in);
        System.out.println("Ingrese día de la Actividad (entre 1-31)");
        int dia = inp.nextInt();
        while (dia < 1 || dia > 31) {
            //Se valida que el día este entre 1 y 31
            System.out.println("Ingrese día entre 1-31");
            dia = inp.nextInt();
        }
        System.out.println("Ingrese tipo de Actividad \n  1-teatro \n  2-cine \n"
                + "  3-viaje \n  4-paseo local \n  5-paseo interdepartamental \n"
                + "  6- caminata \n  7- otro ");
        int tipo = inp.nextInt();
        while (tipo < 1 || tipo > 7) {
            //Se valida que la actividad este entre 1 y 7
            System.out.println("Ingrese actividad entre 1-7");
            tipo = inp.nextInt();
        }
        System.out.println("Ingrese Capacidad Máxima");
        int capacidadmaxima = inp.nextInt();
        //Se valida que la capacidad no sea negativa
        while (validarPositivo(capacidadmaxima)){
            System.out.println("Ingrese una capacidad válida");
            capacidadmaxima = inp.nextInt();
        }
        System.out.println("Ingrese costo");
        int costo = inp.nextInt();
        while (validarPositivo(costo)){
            System.out.println("Ingrese un costo válido");
            costo = inp.nextInt();
        }
        System.out.println("Ingrese la hora de comienzo (entre 7-21)");
        int horacomienzo = inp.nextInt();
        while (horaActividad(horacomienzo)) {
            System.out.println("Seleccione hora de comienzo válido (entre 7-21)");
            horacomienzo = inp.nextInt();
        }
        System.out.println("Que animador quiere que se le asigne");
                System.out.println("Seleccione número de Animador");
                for(int i=0;i<unArrayList.cantidadAnimadores();i++){
                    System.out.print((i+1)+") ");
                    System.out.println(unArrayList.getListaAnimadores().get(i));
                }
                int ani=inp.nextInt();
                while (ani >unArrayList.cantidadAnimadores()){
                    System.out.println("Ingrese número válido");
                    ani=inp.nextInt();
                }
        Actividad actividad = new Actividad(dia, tipo, capacidadmaxima, costo, horacomienzo,unArrayList.getListaAnimadores().get(ani-1));
        return actividad;
    }
    public static Inscripcion ingresarInscripcion(Sistema unArrayList) {
        //Se crea el método para ingresar el Socio
        Scanner ins = new Scanner(System.in);
        System.out.println("Seleccione número de Socio");
                    for(int i=0;i<=unArrayList.cantidadSocios();i++){
                        System.out.print((i+1)+") ");
                        System.out.println(unArrayList.getListaSocios().get(i));
                    }
                    int soc=ins.nextInt();
                    while (soc >unArrayList.cantidadAnimadores()){
                    System.out.println("Ingrese número válido");
                    soc=ins.nextInt();
                    }
                    System.out.println("Seleccione número de Actividad");
                    for(int i=0;i<unArrayList.cantidadActividades();i++){
                        System.out.print((i+1)+") ");
                        System.out.println(unArrayList.getListaActividades().get(i));
                    }
                    int act=ins.nextInt();
                    while (soc >unArrayList.cantidadAnimadores()){
                    System.out.println("Ingrese número válido");
                    act=ins.nextInt();
                    }
                    System.out.println("Ingrese hora en la que quiere que se lo "
                            + "pase a buscar,\npor lo menos una hora antes de la"
                            + " actividad ("+unArrayList.getListaActividades().get(act).getHoracomienzo()+"hs)"
                                    + " y entre 6-20 hs");
                    int horarecogida = ins.nextInt();
                    //Se valida que la hora de recogida sea una hora antes del comienzo de la actividad y dentro del horario establecido
                    while ((horarecogida + 1 > unArrayList.getListaActividades().get(act).getHoracomienzo()) || (horarecogida < 6)) {
                        System.out.println("Ingrese una hora de Recogida una "
                                + "hora antes del comienzo de la actividad "
                                + "(" + unArrayList.getListaActividades().get(act).getHoracomienzo() + ") y entre "
                                + "6-20hs");
                        horarecogida = ins.nextInt();
                    }
        System.out.println("Ingrese Telefono de Contacto");
        int telefono = ins.nextInt();
        while (validarPositivo(telefono)){
            System.out.println("Ingrese un teléfono correcto");
            telefono = ins.nextInt();
        }
        Inscripcion inscripcion = new Inscripcion(horarecogida, unArrayList.getListaSocios().get(soc-1), unArrayList.getListaActividades().get(act-1), telefono);
        return inscripcion;
    }
    public static Sistema bajaActividad(Sistema unaLista){
        System.out.println("Seleccione la Actividad que se quiere dar de baja");
        for (int i=0;i<unaLista.cantidadActividades();i++){
            System.out.println((i+1)+")"+unaLista.getListaActividades().get(i));
            
        }
    }
    //Boolean para validar que el texto no sea vacío
    public static boolean validarTexto(String texto){
        return texto.trim().isEmpty();
    }
    //Boolean que valide que sea positivo el número
    public static boolean validarPositivo(int numero){
        return numero<0;
    }
    //Boolean que valida la Edad
    public static boolean validarEdad(int edad){
        return (edad <18 || edad>99);
    }
    public static boolean horaActividad(int hora){
        return (hora<7 || hora >21);
    }
    static boolean hayAnimador=false;
    static boolean hayActividad=false;
    static boolean haySocio=false;
}
