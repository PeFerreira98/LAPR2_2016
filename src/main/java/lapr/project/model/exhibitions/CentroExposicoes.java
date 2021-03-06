/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.exhibitions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.Stand;
import lapr.project.model.lists.ListaExposicoes;
import lapr.project.model.lists.ListaRecursos;
import lapr.project.model.lists.ListaTipoConflito;
import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.mecanismos.MecanismoAtribuicao;
import lapr.project.utils.Exportable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author zero_
 */
public class CentroExposicoes implements Exportable, Serializable {

    private static final String ROOT_ELEMENT_NAME = "centroExposicoes";
    private static final String MECANISMOS_ELEMENT_NAME = "mecanismos";

    private RegistoUtilizadores registoUtilizadores;
    private ListaExposicoes listaExposicoes;
    private ListaRecursos listaRecursos;
    private ListaTipoConflito listaTipoConflito;

    private List<MecanismoAtribuicao> listaMecanismos;
    private final List<Stand> listaStands;

    /**
     * Construtor de CentroExposicoes
     *
     * @param lstUtilizador a lista de utilizadores
     * @param lstExposicao a lista de exposicoes
     * @param registoExposicao o registo de exposicoes
     * @param registoCandidatura o registo de candidaturas
     * @param registoUtilizador o registo de utilizadores
     */
    public CentroExposicoes(RegistoUtilizadores registoUtilizadores, ListaExposicoes listaExposicoes) {
        this.registoUtilizadores = registoUtilizadores;
        this.listaExposicoes = listaExposicoes;
        this.listaRecursos = new ListaRecursos();
        this.listaTipoConflito = new ListaTipoConflito();
        this.listaMecanismos = new ArrayList<>();
        this.listaStands = new ArrayList<>();

    }

    public CentroExposicoes() {
        this.listaExposicoes = new ListaExposicoes();
        this.registoUtilizadores = new RegistoUtilizadores();
        this.listaRecursos = new ListaRecursos();
        this.listaTipoConflito = new ListaTipoConflito();
        this.listaMecanismos = new ArrayList<>();
        this.listaStands = new ArrayList<>();

    }

    public void addMecanismo(MecanismoAtribuicao mecanismoAtribuicao) {
        listaMecanismos.add(mecanismoAtribuicao);
    }

    public void addStand(Stand stand) {
        getListaStands().add(stand);
    }

    public List<Stand> getListaStands() {
        return listaStands;
    }

    public ListaExposicoes getListaExposicoes() {
        return listaExposicoes;
    }

    public RegistoUtilizadores getRegistoUtilizadores() {
        return registoUtilizadores;
    }

    public ListaRecursos getListaRecursos() {
        return listaRecursos;
    }

    public List<MecanismoAtribuicao> getListaMecanismos() {
        return listaMecanismos;
    }

    public ListaTipoConflito getListaTipoConflito() {
        return listaTipoConflito;
    }

    @Override
    public String toString() {
        return "CentroExposicoes{" + "\nregistoUtilizadores=" + registoUtilizadores + ", \nlistaExposicoes=" + listaExposicoes + '}';
    }

    @Override
    public Node exportContentToXMLNode() {
        Node rootNode = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementCentroExposicoes = document.createElement(ROOT_ELEMENT_NAME);

            //Create a sub-element
            Node registoUtilizadoresNode = this.registoUtilizadores.exportContentToXMLNode();
            elementCentroExposicoes.appendChild(document.importNode(registoUtilizadoresNode, true));

            //Create a sub-element
            Node listaExposicoesNode = this.listaExposicoes.exportContentToXMLNode();
            elementCentroExposicoes.appendChild(document.importNode(listaExposicoesNode, true));

            //Create a sub-element
            Node listaRecursosNode = this.listaRecursos.exportContentToXMLNode();
            elementCentroExposicoes.appendChild(document.importNode(listaRecursosNode, true));

            //Create a sub-element
            Node listaTipoConflitoNode = this.listaTipoConflito.exportContentToXMLNode();
            elementCentroExposicoes.appendChild(document.importNode(listaTipoConflitoNode, true));
            
            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementCentroExposicoes);
            rootNode = elementCentroExposicoes;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return rootNode;
    }
}
