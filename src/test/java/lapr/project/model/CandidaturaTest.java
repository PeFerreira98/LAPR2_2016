/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.model.submissions.Produto;
import lapr.project.model.submissions.Candidatura;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zero_
 */
public class CandidaturaTest {

    public CandidaturaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addProduto method, of class Candidatura.
     */
    @Test
    public void testAddProduto() {
        System.out.println("addProduto");

        Produto produto = new Produto("dude");
        Candidatura instance = new Candidatura("EfoCorp", "Rua do queijo", 916658064, 20, 100, new ArrayList<>());

        boolean expResult = true;
        boolean result = instance.addProduto(produto);

        assertEquals(expResult, result);
    }

    /**
     * Test of validaNomeEmpresa method, of class Candidatura.
     */
    @Test
    public void testValidaNomeEmpresa() {
        System.out.println("validaNomeEmpresa");

        String nomeEmpresa = "Something";

        boolean expResult = true;
        boolean result = Candidatura.validaNomeEmpresa(nomeEmpresa);

        assertEquals(expResult, result);
    }

    /**
     * Test of validaMoradaEmpresa method, of class Candidatura.
     */
    @Test
    public void testValidaMoradaEmpresa() {
        System.out.println("validaMoradaEmpresa");

        String moradaEmpresa = "Rua dos pss";

        boolean expResult = true;
        boolean result = Candidatura.validaMoradaEmpresa(moradaEmpresa);

        assertEquals(expResult, result);
    }

    /**
     * Test of validaTelemovel method, of class Candidatura.
     */
    @Test
    public void testValidaTelemovel() {
        System.out.println("validaTelemovel");

        int telemovel = 911999999;

        boolean expResult = true;
        boolean result = Candidatura.validaTelemovel(telemovel);

        assertEquals(expResult, result);
    }

    /**
     * Test of validaAreaPretendida method, of class Candidatura.
     */
    @Test
    public void testValidaAreaPretendida() {
        System.out.println("validaAreaPretendida");

        double areaPretendida = 27.7;

        boolean expResult = true;
        boolean result = Candidatura.validaAreaPretendida(areaPretendida);

        assertEquals(expResult, result);
    }

    /**
     * Test of validaQuantidadeConvites method, of class Candidatura.
     */
    @Test
    public void testValidaQuantidadeConvites() {
        System.out.println("validaQuantidadeConvites");

        int quantidadeConvites = 20;

        boolean expResult = true;
        boolean result = Candidatura.validaQuantidadeConvites(quantidadeConvites);

        assertEquals(expResult, result);
    }

    /**
     * Test of getNomeEmpresa method, of class Candidatura.
     */
    @Test
    public void testGetNomeEmpresa() {
        System.out.println("getNomeEmpresa");

        Candidatura instance = new Candidatura("EfoCorp", "Rua do queijo", 916658064, 20, 100, new ArrayList<>());

        String expResult = "EfoCorp";
        String result = instance.getNomeEmpresa();

        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Candidatura.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");

        Candidatura obj = new Candidatura("EfoCorp", "Rua do queijo", 916658064, 20, 100, new ArrayList<>());
        Candidatura instance = new Candidatura("EfoCorp", "Rua do queijo", 916658064, 20, 100, new ArrayList<>());

        boolean expResult = true;
        boolean result = instance.equals(obj);

        assertEquals(expResult, result);
    }

}
