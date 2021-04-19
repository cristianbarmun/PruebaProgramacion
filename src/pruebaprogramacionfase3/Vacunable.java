/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaprogramacionfase3;

import java.util.Collection;

/**
 *
 * @author crist
 */
interface Vacunable {

    void vacunar(Infectable infectado);

    void vacunar(Collection<Infectable> coleccion);
}
