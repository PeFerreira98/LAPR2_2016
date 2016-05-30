/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.exhibitions;

import lapr.project.model.users.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lapr.project.model.lists.ListaExposicoes;

/**
 *
 * @author zero_
 */
public class CentroExposicoes {

    //TODO: trocar estas listas pelas respetivas classes de lista
    private List<Utilizador> listaUtilizador;
    private ListaExposicoes listaExposicoes;

    /**
     * Construtor de CentroExposicoes
     *
     * @param lstUtilizador a lista de utilizadores
     * @param lstExposicao a lista de exposicoes
     * @param registoExposicao o registo de exposicoes
     * @param registoCandidatura o registo de candidaturas
     * @param registoUtilizador o registo de utilizadores
     */
    public CentroExposicoes(List<Utilizador> listaUtilizador, ListaExposicoes listaExposicoes) {
        this.listaUtilizador = listaUtilizador;
        this.listaExposicoes = listaExposicoes;
    }

    /**
     * Construtor vazio de CentroExposicoes
     */
    public CentroExposicoes() {
        this.listaUtilizador = new ArrayList<>();
        listaExposicoes = new ListaExposicoes();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final CentroExposicoes other = (CentroExposicoes) obj;
        if (!Objects.equals(this.listaUtilizador, other.listaUtilizador)) {
            return false;
        }
        if (!Objects.equals(this.listaExposicoes, other.listaExposicoes)) {
            return false;
        }
        return true;
    }
}