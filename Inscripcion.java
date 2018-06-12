/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Obligatorio;

/**
 *
 * @author Franco Galeano y Felipe Estrella
 */
public class Inscripcion {

    //variables de instancia 
    private int horarecogida;
    private Socio socio;
    private Actividad actividad;
    private int telefono;
    
    //Constructores
    public Inscripcion(){
        this.setHorarecogida (12);
        this.setSocio (new Socio());
        this.setActividad (new Actividad());
        this.setTelefono (27072345);
    }

    public Inscripcion(int unaHorarecogida, Socio unSocio, Actividad unaActividad, int unTelefono) {
        this.setHorarecogida (unaHorarecogida);
        this.setSocio (unSocio);
        this.setActividad  (unaActividad);
        this.setTelefono (unTelefono);
    }

    //métodos de acceso y modificación
    public int getHorarecogida() {
        return horarecogida;
    }

    public void setHorarecogida(int unaHorarecogida) {
        this.horarecogida = unaHorarecogida;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio unSocio) {
        this.socio = unSocio;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return ("Inscripción en la hora de recogida " + this.getHorarecogida() + ", del socio " + this.getSocio() + ", a la actividad " + this.getActividad() + ", con el telefono de contacto " + this.getTelefono()  );
    }
    
}
