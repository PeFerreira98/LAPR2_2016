/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import java.io.Serializable;

/**
 *
 * @author zero_
 */
public interface EstadoUtilizador extends Serializable {

    public boolean setPending();

    public boolean setRegistado();

    public boolean isPending();

    public boolean isRegistado();
}
