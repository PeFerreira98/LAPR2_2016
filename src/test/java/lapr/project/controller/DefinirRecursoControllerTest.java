/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.controller.gestor.DefinirRecursoController;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Recurso;
import lapr.project.model.exhibitions.CentroExposicoes;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sara Silva
 */
public class DefinirRecursoControllerTest {

    public DefinirRecursoControllerTest() {
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
     * Test of addRecurso method, of class DefinirRecursoController.
     */
    @Test
    public void testAddRecurso() {
        System.out.println("addRecurso");
        CentroExposicoes centroExp = new CentroExposicoes();
        Recurso rec = new Recurso("xpto");
        DefinirRecursoController instance = new DefinirRecursoController(centroExp);
        instance.addRecurso("xpto");
        Recurso result = centroExp.getListaRecursos().getListaRecursos().get(0);
        assertEquals(rec, result);
    }

}
