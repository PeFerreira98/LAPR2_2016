/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.mecanismos.atribuicao;

import java.util.List;
import lapr.project.model.submissions.Atribuicao;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.mecanismos.MecanismoAtribuicao;

/**
 *
 * @author Sara Silva
 */
public class MecanismoExpProfissional implements MecanismoAtribuicao {

    private String descricao;

    public MecanismoExpProfissional() {
        descricao = "Experiência Profissional";
    }

    @Override
    public List<Atribuicao> getListaAtribuicoes(Exposicao exposicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
