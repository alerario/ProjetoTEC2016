/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import br.data.entity.Teste;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexandrelerario
 */
public class CrudTesteTest {
    
    public CrudTesteTest() {
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
     * Test of SelectByNome method, of class CrudTeste.
    */
    
    @Test
    public void testSelectByNome() {
        System.out("SelectByNome");
        CrudTeste instance = new CrudTeste();
        List<Teste> result = instance.SelectByNome("i");
        assertEquals(4, result.size());
        result = instance.SelectByNome("o");
        assertEquals(2, result.size());
        result = instance.SelectByNome("O");
        assertEquals(2, result.size());
        result = instance.SelectByNome("");
        assertEquals(6, result.size());
    }
    
    
}
