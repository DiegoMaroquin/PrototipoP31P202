/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author DELL
 */
public class maestro {
   
    int id_maestro;
    String nombre;
    int edad;
    int grado ;

    public maestro() {
    }

    public maestro(int id_mestro) {
        this.id_maestro= id_maestro;
    }

    public maestro(String nombre, int edad , int grado) {
        this.nombre= nombre;
        this.edad= edad;
    }

    public int getId_maestro() {
        return id_maestro;
    }

    public void setId_maestro(int id_maestro) {
        this.id_maestro = id_maestro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getgrado() {
        return grado;
    }

    public void setgrado(int grado) {
        this.grado = grado;
    }

    public int getedad() {
        return edad;
    }

    public void setedad(int edad) {
        this.edad = edad;
    
    }

    @Override
    public String toString() {
        return "maestro{" + "id_maestro=" + id_maestro + ", nombre=" + nombre+ ", edad=" + edad +", grado=" + grado + '}';
    }
    
    }

