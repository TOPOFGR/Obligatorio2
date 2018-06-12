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
public class Actividad {

    //variables de instancia
    private int dia;
    private int tipo;
    private int capacidadmaxima;
    private int costo;
    private int horacomienzo;
    private Animador animador;

    //constructores
    public Actividad() {
        this.setDia(4);
        this.setTipo(1);
        this.setCapacidadmaxima(28);
        this.setCosto(200);
        this.setHoracomienzo(18);
        this.setAnimador(new Animador());
    }

    public Actividad(int unDia, int unTipo, int unaCapacidadmaxima, int unCosto, int unaHoracomienzo, Animador unAnimador) {
        this.setDia(unDia);
        this.setTipo(unTipo);
        this.setCapacidadmaxima(unaCapacidadmaxima);
        this.setCosto(unCosto);
        this.setHoracomienzo(unaHoracomienzo);
        this.setAnimador(unAnimador);
    }

    //metodos de acceso y modificación
    public int getDia() {
        return dia;
    }
        
    public void setDia(int unDia) {
        this.dia = unDia;
    }
    
    public int getTipo() {
        return tipo;
    }    
    
    public void setTipo(int unTipo) {
        this.tipo = unTipo;
    }

    public int getCapacidadmaxima() {
        return capacidadmaxima;
    }

    public void setCapacidadmaxima(int unaCapacidadmaxima) {
        this.capacidadmaxima = unaCapacidadmaxima;
    }

    public int getCosto() {
        return costo;
    }

        public void setCosto(int unCosto) {
        this.costo = unCosto;
    }

    public int getHoracomienzo() {
        return horacomienzo;
    }
            
    public void setHoracomienzo(int unaHoracomienzo) {
        this.horacomienzo = unaHoracomienzo;
    }

    public Animador getAnimador() {
        return animador;
    }

    public void setAnimador(Animador unAnimador) {
        this.animador = unAnimador;
    }

    @Override
    public String toString() {
        return ("Actividad el dia "  + this.getDia() + ", de tipo "
                + "" + this.getTipo() + ", con la capacidad máxima de "
                + "" + this.getCapacidadmaxima() + " personas, con el costo "
                + "" + this.getCosto() + ", con la hora de comienzo "
                + "" + this.getHoracomienzo()+ " y a cargo de "+this.getAnimador() );
    }    
}
