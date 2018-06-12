package Obligatorio;

import java.util.ArrayList;

/**
 *
 * @author Franco Galeano y Felipe Estrella
 */
public class Sistema {

    private ArrayList<Inscripcion> listaInscripciones;
    private ArrayList<Socio> listaSocios;
    private ArrayList<Actividad> listaActividades;
    private ArrayList<Animador> listaAnimadores;

    public ArrayList<Inscripcion> getListaInscripciones() {
        return listaInscripciones;
    }

    public void agregarInscripciones(Inscripcion unaInscripcion) {
        this.getListaInscripciones().add(unaInscripcion);
    }

    public void eliminarInscripcion(Inscripcion unaInscripcion) {
        this.getListaInscripciones().remove(unaInscripcion);
    }

    public int cantidadInscripciones() {
        return this.getListaInscripciones().size();
    }

    public ArrayList<Socio> getListaSocios() {
        return listaSocios;
    }

    public void agregarSocio(Socio unSocio) {
        this.getListaSocios().add(unSocio);
    }

    public void eliminarSocio(Socio unSocio) {
        this.getListaSocios().remove(unSocio);
    }

    public int cantidadSocios() {
        return this.getListaSocios().size();
    }

    public ArrayList<Actividad> getListaActividades() {
        return listaActividades;
    }

    public void agregarActividad(Actividad unaActividad) {
        this.getListaActividades().add(unaActividad);
    }

    public void eliminarActividad(Actividad unaActividad) {
        this.getListaActividades().remove(unaActividad);
    }

    public int cantidadActividades() {
        return this.getListaSocios().size();
    }

    public ArrayList<Animador> getListaAnimadores() {
        return listaAnimadores;
    }

    public void agregarAnimador(Animador unAnimador) {
        this.getListaAnimadores().add(unAnimador);
    }

    public void eliminarAnimador(Animador unAnimador) {
        this.getListaAnimadores().remove(unAnimador);
    }

    public int cantidadAnimadores() {
        return this.getListaAnimadores().size();
    }

    public Sistema() {
        listaInscripciones = new ArrayList<>();
        listaSocios = new ArrayList<>();
        listaAnimadores = new ArrayList<>();
        listaActividades = new ArrayList<>();
    }

}
