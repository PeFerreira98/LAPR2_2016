/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;

/**
 *
 * @author Sara Silva
 */
public class Stand implements Serializable{

    private String designacao;

    public Stand(String des) {
        designacao = des;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public String getDesignacao() {
        return designacao;
    }

}
