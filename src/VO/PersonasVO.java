package VO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author crist
 */
public class PersonasVO {

    private int id;
    private int id_ciudad;
    private String nombre;
    private String tipo;
    private int infectado;

    public PersonasVO() {
    }

    public PersonasVO(int id, int id_ciudad, String nombre, String tipo, int infectado) {
        this.id = id;
        this.id_ciudad = id_ciudad;
        this.nombre = nombre;
        this.tipo = tipo;
        this.infectado = infectado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getInfectado() {
        return infectado;
    }

    public void setInfectado(int infectado) {
        this.infectado = infectado;
    }

    @Override
    public String toString() {
        return "PersonasDAO{" + "id=" + id + ", id_ciudad=" + id_ciudad + ", nombre=" + nombre + ", tipo=" + tipo + ", infectado=" + infectado + '}';
    }
}
