/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.submissions;

import java.io.Serializable;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author Sara Silva
 */
public class Keyword implements Exportable, Importable<Keyword>, Serializable {

    private static final String ROOT_ELEMENT_NAME = "keyword";
    private static final String VALUE_ELEMENT_NAME = "value";

    /**
     * Keyword representation.
     */
    private String value = "";

    /**
     * Constructor for Keyword Class.
     *
     * @param keyword Keyword being used.
     */
    public Keyword(String keyword) {
        this.value = keyword;
    }

    /**
     * Obtain keyword value.
     *
     * @return Keyword Value
     */
    private String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            //Obtain a new document
            Document document = builder.newDocument();

            //Create root element
            Element elementKeyword = document.createElement(ROOT_ELEMENT_NAME);

            //Create a sub-element
            Element elementValue = document.createElement(VALUE_ELEMENT_NAME);

            //Set the sub-element value
            elementValue.setTextContent(getValue());

            //Add sub-element to root element
            elementKeyword.appendChild(elementValue);

            //Add root element to document
            document.appendChild(elementKeyword);

            node = elementKeyword;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return node;
    }

    @Override
    public Keyword importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory
                    = DocumentBuilderFactory.newInstance();
            //Create document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            //Obtain a new document
            Document document = builder.newDocument();

            document.appendChild(document.importNode(node, true));

            NodeList elementsKeyword = document.getElementsByTagName(VALUE_ELEMENT_NAME);

            Node elementKeyword = elementsKeyword.item(0);

            //Get value
            this.value = elementKeyword.getFirstChild().getNodeValue();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Keyword)) {
            return false;
        }

        Keyword that = (Keyword) o;

        return getValue().equals(that.getValue());

    }

    @Override
    public int hashCode() {
        return getValue().hashCode();
    }
}
