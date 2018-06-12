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
public class Animador extends Persona{
    
    private int añosexperiencia;
    
    public Animador(){
        super();
        this.setAñosexperiencia(6);
    }
    public Animador(String unNombre, int unaCi,int unAñoexperiencia){
        super(unNombre,unaCi);
        this.setAñosexperiencia(unAñoexperiencia);
    }

    public int getAñosexperiencia() {
        return añosexperiencia;
    }

    public void setAñosexperiencia(int unAñosexperiencia) {
        this.añosexperiencia = unAñosexperiencia;
    }

    @Override
    public String toString() {
        return ("Animador de nombre " + this.getNombre() + ", de documento " + this.getCi() + ", con " + this.getAñosexperiencia() +" años de experiencia");
    }
    
}
