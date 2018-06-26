//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Obligatorio;

import java.util.*;

/**
 *
 * @author Franco Galeano
 */
public class Prueba {

    public static void main(String[] args) {
        Sistema lista = new Sistema();
        int opcion = -1;
        do {
            opcion = validarNumero("Seleccione opción del Menú \n 1) Registrar "
                    + "Socio\n 2) Registrar Animador\n 3) Registrar Actividad\n "
                    + "4) Registrar Inscripcioón a Actividad\n 5) Consulta por "
                    + "Actividad\n 6) Listado Ordenado de Actividades\n 7) Baja de "
                    + "Actividad\n 8) Actividades Preferidas por los Socios\n "
                    + "9) Animadores sin Actividades asignadas\n 10) Terminado");
            switch (opcion) {
                case 1:
                    System.out.println("Registrar Socio");
                    lista.agregarSocio(ingresarSocio());
                    break;
                case 2:
                    System.out.println("Registrar Animador");
                    lista.agregarAnimador(ingresarAnimador());
                    break;
                case 3:
                    if (lista.cantidadAnimadores() > 0) {
                        lista.agregarActividad(ingresarActividad(lista));
                    } else {
                        System.out.println("No hay animador, ingrese a la opción"
                                + " Registrar Animador del Menú");
                    }
                    break;
                case 4:
                    if (lista.cantidadSocios() > 0 && lista.cantidadActividades() > 0) {
                        if (hayCupo(lista)) {
                            lista.agregarInscripciones(ingresarInscripcion(lista));
                        } else {
                            System.out.println("No hay Cupos Disponibles");
                        }
                    } else {
                        System.out.println("Debe primero ingresar por lo menos"
                                + " un Socio (Primera opción del Menú) y una "
                                + "Actividad (Tercera opción del Menú)");

                    }
                    break;
                case 5:
                    System.out.println("Consulta por Actividad");
                    if (lista.cantidadActividades() > 0) {
                        consultaActividad(lista);
                    } else {
                        System.out.println("Ingrese a la opción Registrar Actividad"
                                + " del Menú previamente");
                    }

                    break;
                case 6:
                    if (lista.cantidadActividades() > 0) {
                        System.out.println("Listado Ordenado de Actividades");
                        System.out.println("La lista de Actividades es :");
                        ordenarActividad(lista);
                    } else {
                        System.out.println("Ingrese a la opción Registrar Actividad"
                                + " del Menú previamente");
                    }
                    break;
                case 7:
                    if (lista.cantidadActividades() > 0) {
                        System.out.println("Baja de Actividad");
                        lista.eliminarActividad(bajaActividad(lista));
                    } else {
                        System.out.println("Ingrese a la opción Registrar Actividad"
                                + " del Menú previamente");
                    }
                    break;
                case 8:
                    if (lista.cantidadActividades() > 0) {
                        System.out.println("Actividades Preferidas por los Socios");
                        actividadPreferida(lista);
                    } else {
                        System.out.println("Ingrese a la opción Registrar Actividad"
                                + " del Menú previamente");
                    }
                    break;
                case 9:
                    if (lista.cantidadAnimadores() > 0) {
                        System.out.println("Animadores sin Actividades asignadas");
                        consultaAnimador(lista);
                    } else {
                        System.out.println("No hay animador, ingrese a la opción"
                                + " Registrar Animador del Menú");
                    }
                    break;
                case 10:
                    System.out.println("Terminado");
                    break;
                default:
                    System.out.println("Ingrese opción correcta (1-10)");
            }
        } while (opcion != 10);
    }

    //case 1
    public static Socio ingresarSocio() {
        //Se hace el método para poder ingresar los datos de los Socios 
        String nombre = validarTexto("Ingrese Nombre del Socio");
        int edad = validarNumeroEntre("Ingresar Edad (entre 18-99)", 18, 99);
        int cedula = validarNumero("Ingresar Cedula de identidad (sin guiones)");
        String direccion = validarTexto("Ingresar Dirección");
        Socio socio = new Socio(nombre, edad, cedula, direccion);
        return socio;
    }

    //Case 2
    public static Animador ingresarAnimador() {
        String nombre = validarTexto("Ingrese Nombre del Animador");
        int cedula = validarNumero("Ingresar Cedula de identidad (sin guiones)");
        int añosexperiencia = validarNumero("Ingrese Años de Experiencia");
        Animador animador = new Animador(nombre, cedula, añosexperiencia);
        return animador;
    }

    //Case 3
    public static Actividad ingresarActividad(Sistema unaLista) {
        //Se valida el dia
        int dia = validarNumeroEntre("Ingrese día de la Actividad (entre 1-31)", 1, 31);
        // Se valida que el tipo de Actividad este entre 1-7
        int tipo = validarNumeroEntre("Ingrese tipo de Actividad \n  1-teatro \n  2-cine \n"
                + "  3-viaje \n  4-paseo local \n  5-paseo interdepartamental \n"
                + "  6- caminata \n  7- otro ", 1, 7);
        int capacidadmaxima = validarNumero("Ingrese Capacidad Máxima");
        int costo = validarNumero("Ingrese costo");
        int horacomienzo = validarNumeroEntre("Ingrese la hora de comienzo (entre 7-21)", 7, 21);
        //Se valida que el usuario ingrese un número válido
        System.out.println("Que animador quiere que se le asigne");
        for (int i = 0; i < unaLista.cantidadAnimadores(); i++) {
            System.out.println((i + 1) + ") " + unaLista.getListaAnimadores().get(i));
        }
        int animador = validarNumeroEntre("Seleccione número de Animador", 1, unaLista.cantidadAnimadores());
        Actividad actividad = new Actividad(dia, tipo, capacidadmaxima, costo, horacomienzo, unaLista.getListaAnimadores().get(animador - 1));
        return actividad;
    }

    //Case 4
    public static Inscripcion ingresarInscripcion(Sistema unaLista) {
        //Se crea el método para ingresar el Socio
        System.out.println("Que socio quiere que se le asigne");
        for (int i = 0; i < unaLista.cantidadSocios(); i++) {
            System.out.println((i + 1) + ")" + unaLista.getListaSocios().get(i));
        }
        //Se valida que el socio sea valido
        int socio = validarNumeroEntre("Seleccione número de Socio", 1, unaLista.cantidadSocios());
        System.out.println("Que Actividad quiere que se le asigne");
        for (int i = 0; i < unaLista.cantidadActividades(); i++) {
            System.out.println((i + 1) + ")" + unaLista.getListaActividades().get(i));
        }
        //Se valida que la actividad sea valida
        int actividad = validarNumeroEntre("Seleccione número de Actividad", 1, unaLista.cantidadActividades());
        int horarecogida = validarNumeroEntre("Ingrese hora en la que "
                + "quiere que se lo pase a buscar entre "
                + "6-" + (unaLista.getListaActividades().get(actividad - 1).getHoracomienzo() - 1) + "hs", 6, (unaLista.getListaActividades().get(actividad - 1).getHoracomienzo() - 1));
        int telefono = validarNumero("Ingrese Telefono de Contacto");
        Inscripcion inscripcion = new Inscripcion(horarecogida, unaLista.getListaSocios().get(socio - 1), unaLista.getListaActividades().get(actividad - 1), telefono);
        unaLista.getListaActividades().get(actividad - 1).agregarInscripcion(inscripcion);
        return inscripcion;
    }

    // Case 5
    public static void consultaActividad(Sistema unaLista) {
        //Se crea un Array con los tipos de Actividades
        int[] tipo = new int[8];
        int aux = 0;
        int dia = validarNumeroEntre("Seleccione el día ", 1, 31);
        //Se le suma al array tipo, para saber que tipo de 
        for (int i = 0; i < unaLista.cantidadActividades(); i++) {
            if (unaLista.getListaActividades().get(i).getDia() == dia) {
                tipo[unaLista.getListaActividades().get(i).getTipo()] += 1;
                aux++;
            }
        }//Se fija si el dia tiene inscripciones
        if (aux == 0) {
            System.out.println("No se Registraron Inscripciones el dia " + dia);
        } else {
            System.out.println("Dia " + dia);//Se Recorre el array y muestra los tipos de actividad con inscripciones
            for (int o = 1; o < tipo.length; o++) {
                if (tipo[o] > 0) {
                    System.out.print(o + " ");
                    for (int f = 0; f < tipo[o]; f++) {
                        System.out.print("*");
                    }
                    System.out.println("");
                }
            }
        }
    }

    // Case 6
    public static void ordenarActividad(Sistema unaLista) {
        int opcion = validarNumero("Ingrese si Quiere su lista ordena por orden\n"
                + " 1) Ascendente o 2) Descendente");
        switch (opcion) {
            case 1:
                System.out.println("Orden Ascendente");
                unaLista.ordenarAscendente();
                for (int i = 0; i < unaLista.cantidadActividades(); i++) {
                    System.out.println((i + 1) + ")" + unaLista.getListaActividades().get(i));
                }
                break;
            case 2:
                System.out.println("Orden Descendente");
                unaLista.ordenarDescendente();
                for (int i = 0; i < unaLista.cantidadActividades(); i++) {
                    System.out.println((i + 1) + ")" + unaLista.getListaActividades().get(i));
                }
                break;
            default:
                System.out.println("Ingrese una opción entre 1 y 2");
                break;
        }
    }

    // Case 7
    public static Actividad bajaActividad(Sistema unaLista) {
        System.out.println("Lista de Actividades");

        for (int i = 0; i < unaLista.cantidadActividades(); i++) {
            System.out.println((i + 1) + ")" + unaLista.getListaActividades().get(i));
        }
        int baja = validarNumeroEntre("Seleccione el número Actividad que se quiere dar de baja", 1, unaLista.cantidadActividades() + 1);
        for (int o = 0; o < unaLista.cantidadInscripciones(); o++) {
            if (unaLista.getListaInscripciones().get(o).getActividad() == unaLista.getListaActividades().get(baja - 1)) {
                unaLista.agregarSinSocio(unaLista.getListaInscripciones().get(o).getSocio());
                unaLista.getListaInscripciones().remove(o);
            }
        }
        int opcion = validarNumero("Ingrese si quiere la lista de Socios a llamar en "
                + "orden \n 1) Ascendente o 2) Descendente");
        switch (opcion) {
            case 1:
                System.out.println("Criterio Ascendente");
                unaLista.ordenarPorNombreAscendente();
                break;
            case 2:
                System.out.println("Criterio Descendente");
                unaLista.ordenarPorNombreDescendente();
                break;
            default:
                System.out.println("Ingrese 1 o 2");
                break;
        }
        Actividad bajaActividad = unaLista.getListaActividades().get(baja - 1);
        return bajaActividad;
    }

    //Case 8
    public static String actividadPreferida(Sistema unaLista) {
        //Se crea un Array con los tipos de Actividades
        int[] preferida = new int[8];
        //Se recorre la cantidad de inscriptos y se agrega de a uno en el Array
        for (int i = 0; i < unaLista.cantidadInscripciones(); i++) {
            int aux = unaLista.getListaInscripciones().get(i).getActividad().getTipo();
            preferida[aux] = preferida[aux] + 1;
        }
        int favorita = -1;
        //Se fija cual es la actividad preferida
        for (int o = 0; o < preferida.length; o++) {
            if (preferida[o] > favorita) {
                favorita = preferida[o];
            }
        }
        String favorito = "la Actividad favorita es " + favorita;
        return favorito;
    }

    //Case 9
    public static void consultaAnimador(Sistema unaLista) {
        int[] animador = new int[unaLista.cantidadAnimadores()];
        int falta = 0;
        for (int i = 0; i < unaLista.cantidadAnimadores(); i++) {
            for (int o = 0; o < unaLista.cantidadActividades(); o++) {
                if (unaLista.getListaAnimadores().get(i) == unaLista.getListaActividades().get(o).getAnimador()) {
                    falta++;
                }
            }
            animador[i] = falta;
            falta = 0;
        }
        for (int f = 0; f < animador.length; f++) {
            if (animador[f] == 0) {
                System.out.println(unaLista.getListaAnimadores().get(f).getNombre() + " No esta asignado en ninguna Actividad");
            }
        }
    }

    //Boolean para validar que el texto no sea vacío
    public static String validarTexto(String mensaje) {
        System.out.println(mensaje);
        Scanner in = new Scanner(System.in);
        String texto = in.nextLine();
        while (texto.trim().isEmpty()) {
            System.out.println("Ingrese un texto válido");
            texto = in.nextLine();
        }
        return texto;
    }

    //Se valida que el numero sea mayor a 0
    public static int validarNumero(String mensaje) {
        System.out.println(mensaje);
        Scanner in = new Scanner(System.in);
        int numero = 0;
        boolean error = false;
        while (!error) {
            try {
                numero = in.nextInt();
                while (numero < 0) {
                    System.out.println("Ingrese un valor positivo");
                    numero = in.nextInt();
                }
                error = true;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un valor número y además positivo");
                in.nextLine();
            }
        }
        return numero;
    }

    //Se crea un método que valide que un numero se encuentre entre un maximo y un minimo
    public static int validarNumeroEntre(String mensaje, int min, int max) {
        System.out.println(mensaje);
        Scanner input = new Scanner(System.in);
        int numero = 0;
        boolean error = false;
        while (!error) {
            try {
                numero = input.nextInt();
                while (numero < min || numero > max) {
                    System.out.println("Ingrese un valor entre " + min + " y " + max);
                    numero = input.nextInt();
                }
                error = true;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un valor numérico correcto");
                input.nextLine();
            }
        }
        return numero;
    }

    //Lista de Las Actividades con Cupo
    public static Actividad ActividadConCupo(Sistema unaLista) {
        ArrayList<Actividad> lista = unaLista.getListaActividadesConCupo();
        System.out.println("Lista de Actividades");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ")" + lista.get(i));
        }
        int actividad = validarNumeroEntre("Seleccione Actividad: ", 1, unaLista.cantidadActividades());
        return lista.get(actividad - 1);
    }

    //Boolean para saber si hay o no cupo
    public static boolean hayCupo(Sistema unaLista) {
        boolean hay = false;
        for (int i = 0; i < unaLista.cantidadActividades(); i++) {
            Actividad actividad = unaLista.getListaActividades().get(i);
            if (actividad.cuposDisponibles()) {
                hay = true;
            }
        }
        return hay;
    }
}
