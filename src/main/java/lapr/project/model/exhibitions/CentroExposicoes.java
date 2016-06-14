/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.exhibitions;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.TipoConflito;
import lapr.project.model.lists.ListaExposicoes;
import lapr.project.model.lists.ListaRecursos;
import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.mecanismos.MecanismoAtribuicao;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author zero_
 */
public class CentroExposicoes implements Exportable, Importable<CentroExposicoes> {

    private static final String ROOT_ELEMENT_NAME = "centroExposicoes";

    private RegistoUtilizadores registoUtilizadores;
    private ListaExposicoes listaExposicoes;

    private List<MecanismoAtribuicao> listaMecanismos;
    private ListaRecursos listaRecursos;
    private List<TipoConflito> listaTipoConflito;

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

        listaMecanismos = new ArrayList<>();
        listaRecursos = new ListaRecursos();
        listaTipoConflito = new ArrayList<>();
    }

    public CentroExposicoes() {

        listaExposicoes = new ListaExposicoes();
        registoUtilizadores = new RegistoUtilizadores();

        listaMecanismos = new ArrayList<>();
        listaRecursos = new ListaRecursos();
        listaTipoConflito = new ArrayList<>();
    }

    public void addMecanismo(MecanismoAtribuicao mecanismoAtribuicao) {
        listaMecanismos.add(mecanismoAtribuicao);
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

    public List<TipoConflito> getListaTipoConflito() {
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

            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementCentroExposicoes);
            rootNode = elementCentroExposicoes;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return rootNode;
    }

    @Override
    public CentroExposicoes importContentFromXMLNode(Node node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
