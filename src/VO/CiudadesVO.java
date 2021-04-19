/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author crist
 */
public class CiudadesVO {

    private int id;
    private int nombre;

    public CiudadesVO() {
    }

    public CiudadesVO(int id, int nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "CiudadesVO{" + "id=" + id + ", nombre=" + nombre + '}';
    }
}
