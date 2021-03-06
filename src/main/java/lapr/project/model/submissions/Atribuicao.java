/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.submissions;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.users.FAE;
import lapr.project.utils.Exportable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author Sara Silva
 */
public class Atribuicao implements Exportable, Serializable {

    private static final String ROOT_ELEMENT_NAME = "atribuicao";
    
    private FAE fae;
    private Candidatura candidatura;

    public Atribuicao(FAE f, Candidatura c) {
        this.fae = f;
        this.candidatura = c;
    }
    
    public Atribuicao(FAE fae){
        this.fae = fae;
        //used in XML Don't know about candidatura
    }

    /**
     * @return the fae
     */
    public FAE getFae() {
        return fae;
    }

    public Candidatura getCandidatura() {
        return this.candidatura;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.fae);
        hash = 61 * hash + Objects.hashCode(this.candidatura);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Atribuicao other = (Atribuicao) obj;
        if (!Objects.equals(this.fae, other.fae)) {
            return false;
        }
        if (!Objects.equals(this.candidatura, other.candidatura)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\n Atribuicao{" + "fae=" + fae + ", candidatura=" + candidatura + '}';
    }

    @Override
    public Node exportContentToXMLNode() {
       Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementAtribuicao = document.createElement(ROOT_ELEMENT_NAME);

            //Create a sub-element
            Node faeNode = this.fae.exportContentToXMLNode();
            elementAtribuicao.appendChild(document.importNode(faeNode, true));

            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementAtribuicao);
            node = elementAtribuicao;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return node;
    }

}
