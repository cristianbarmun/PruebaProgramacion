/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaprogramacionfase3;

/**
 *
 * @author crist
 */
public class Paciente implements Infectable, Moveable {

    static final int CONTAGIO_SUPERMERCADO = 10;
    static final int CONTAGIO_TRABAJO = 12;
    static final int CONTAGIO_TRANSPORTE = 16;

    @Override
    public void infectar(boolean infectado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean visitarSuper() {
        boolean contagiado = false;
        //numeros aleatorios entre 0 y 100
        double infeccion = Math.random() * 100 + 1;

        //si el numero de la infeccion es igual al contagio, se ha infectado
        if (infeccion <= CONTAGIO_SUPERMERCADO) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean visitarTrabajo() {
        boolean contagiado = false;
        //numeros aleatorios entre 0 y 100
        double infeccion = Math.random() * 100 + 1;

        //si el numero de la infeccion es igual al contagio, se ha infectado
        if (infeccion <= CONTAGIO_TRABAJO) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean cogerTransporte() {
        boolean contagiado = false;
        //numeros aleatorios entre 0 y 100
        double infeccion = Math.random() * 100 + 1;

        //si el numero de la infeccion es igual al contagio, se ha infectado
        if (infeccion <= CONTAGIO_TRANSPORTE) {
            return true;
        } else {
            return false;
        }
    }

}
