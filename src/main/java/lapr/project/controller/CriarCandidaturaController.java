/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Candidatura;
import lapr.project.model.Demonstracao;
import lapr.project.model.Produto;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.ListaDemonstracoes;

/**
 *
 * @author zero_
 */
public class CriarCandidaturaController {

    private Exposicao exposicao;
    
    private Candidatura candidatura;
    private ListaDemonstracoes listaDemonstracoes;
    private List<Produto> listaProdutos;

    public CriarCandidaturaController(Exposicao exposicao) {
        this.exposicao = exposicao;
        this.listaDemonstracoes = new ListaDemonstracoes();
        this.listaProdutos = new ArrayList<>();
    }

    public boolean createCandidatura(String nomeEmpresa, String moradaEmpresa, int telemovel, double areaPretendida, int quantidadeConvites) {
        System.out.println(nomeEmpresa + " - " + moradaEmpresa + " - " + telemovel
                + " - " + areaPretendida + " - " + quantidadeConvites);

        if (validate(nomeEmpresa, moradaEmpresa, telemovel, areaPretendida, quantidadeConvites)) {
            this.candidatura = new Candidatura(nomeEmpresa, moradaEmpresa, telemovel, areaPretendida, quantidadeConvites);
            return true;
        }
        return false;
    }

    private boolean validate(String nomeEmpresa, String moradaEmpresa, int telemovel, double areaPretendida, int quantidadeConvites) {
        if (Candidatura.validaNomeEmpresa(nomeEmpresa)) {
            if (Candidatura.validaMoradaEmpresa(moradaEmpresa)) {
                if (Candidatura.validaTelemovel(telemovel)) {
                    if (Candidatura.validaAreaPretendida(areaPretendida)) {
                        if (Candidatura.validaQuantidadeConvites(quantidadeConvites)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean addProduto(String designacao) {
        final Produto prod;

        if (Produto.validaDesignacao(designacao)) {
            prod = new Produto(designacao);
            return this.listaProdutos.add(prod);
        }

        return false;
    }

    public boolean addDemonstracao(Demonstracao demonstracao) {
        if (demonstracao != null) {
            return this.listaDemonstracoes.addDemonstracao(demonstracao);
        }
        return false;
    }

    public List<Demonstracao> getListaDemonstracoesExposicao() {
        return this.exposicao.getListaDemonstracoes().getListaDemonstracoes();
    }

    private void addProdutosToCandidatura() {
        this.listaProdutos.stream().forEach((p) -> {
            this.candidatura.addProduto(p);
        });
    }

    private void addDemonstracoesToCandidatura() {
        this.listaDemonstracoes.getListaDemonstracoes().stream().forEach((d) -> {
            this.candidatura.addDemonstracao(d);
        });
    }

    public boolean addCandidaturaToExposicao() {
        if (this.candidatura != null) {
            //adiciona as demonstraçoes da lista temporária na lista dentro da candidatura
            if (!this.listaDemonstracoes.getListaDemonstracoes().isEmpty()) {
                addDemonstracoesToCandidatura();
            }

            //adiciona os produtos da lista temporaria a lista dentro da candidatura
            if (!this.listaProdutos.isEmpty()) {
                addProdutosToCandidatura();
            }

            return exposicao.addCandidatura(this.candidatura);
        }

        return false;

    }

}