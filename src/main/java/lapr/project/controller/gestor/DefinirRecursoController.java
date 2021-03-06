/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.gestor;

import java.io.Serializable;
import lapr.project.model.Recurso;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.lists.ListaRecursos;

/**
 *
 * @author Sara Silva
 */
public class DefinirRecursoController implements Serializable{

    private ListaRecursos listaRecursos;

    public DefinirRecursoController(CentroExposicoes centroExp) {
        listaRecursos = centroExp.getListaRecursos();
    }

    public boolean addRecurso(String rec) {
        return listaRecursos.addRecurso(new Recurso(rec));
    }

}
