/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import br.data.entity.Cliente;
import java.util.Arrays;
import java.util.List;
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
public class TestCrudCliente {
    
    public TestCrudCliente() {
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
     * Test of SelectById method, of class CrudTeste.
    */
    
    @Test
    public void testSelectById() {
        System.out.println("Select By Id - Client");
        CrudCliente cli = new CrudCliente();
        List<Cliente> allCli = cli.getAll();
        List<Cliente> result = filtrar(allCli, 1);
        assertEquals(1, result.size());
        result = filtrar(allCli, 2);
        assertEquals(1, result.size());
        result = filtrar(allCli, 3);
        assertEquals(1, result.size());
    }
    
    public List<Cliente> filtrar(List<Cliente> c, int id) {
        List<Cliente> temp = null;
        for(Cliente cli: c) {
            if (cli.getCodCliente() == id)
                temp.add(cli);
        }
        return temp;
    }
    
}
