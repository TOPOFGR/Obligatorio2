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
abstract class Persona {
   private String nombre;
   private int ci;
   
   public Persona(){
       this.setNombre("Pepe");
       this.setCi(0);
   }
   public Persona(String unNombre, int unaCi){
       this.setNombre(unNombre);
       this.setCi(unaCi);
   }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int unaCi) {
        this.ci = unaCi;
    }

    @Override
    public String toString() {
        return ("Persona de nombre" + this.getNombre() + " de documento " + ci + '}');
    }
   
}
