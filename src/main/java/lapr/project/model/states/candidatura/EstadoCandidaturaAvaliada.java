/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states.candidatura;

import lapr.project.model.submissions.Candidatura;
import lapr.project.model.states.EstadoCandidatura;

/**
 *
 * @author zero_
 */
public class EstadoCandidaturaAvaliada implements EstadoCandidatura{
    
    private Candidatura candidatura;

    public EstadoCandidaturaAvaliada(Candidatura candidatura) {
        this.candidatura = candidatura;
    }

    @Override
    public boolean setRetirada() {
        return false;
    }

    @Override
    public boolean setEmSubmissao() {
        return false;
    }

    @Override
    public boolean setEmAvaliacao() {
        return false;
    }

    @Override
    public boolean setAvaliada() {
        return false;
    }

    @Override
    public boolean setNaoAvaliada() {
        return false;
    }

    @Override
    public boolean setAceite() {
        if (this.candidatura.getEstado().isAvaliada()) {
            EstadoCandidatura ec = new EstadoCandidaturaAceite(this.candidatura);
            this.candidatura.setEstado(ec);
            return true;
        }
        return false;
    }

    @Override
    public boolean setRejeitada() {
        if (this.candidatura.getEstado().isAvaliada()) {
            EstadoCandidatura ec = new EstadoCandidaturaRejeitada(this.candidatura);
            this.candidatura.setEstado(ec);
            return true;
        }
        return false;
    }

    @Override
    public boolean isRetirada() {
        return false;
    }

    @Override
    public boolean isEmSubmissao() {
        return false;
    }

    @Override
    public boolean isEmAvaliacao() {
        return false;
    }

    @Override
    public boolean isAvaliada() {
        return true;
    }

    @Override
    public boolean isNaoAvaliada() {
        return false;
    }

    @Override
    public boolean isAceite() {
        return false;
    }

    @Override
    public boolean isRejeitada() {
        return false;
    }
}
