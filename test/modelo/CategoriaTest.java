/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Andres
 */
public class CategoriaTest {
    
    public CategoriaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getIdCategoria method, of class Categoria.
     */
    @Test
    public void testGetIdCategoria() {
        System.out.println("getIdCategoria");
        Categoria instance = new Categoria();
        int expResult = 0;
        int result = instance.getIdCategoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdCategoria method, of class Categoria.
     */
    @Test
    public void testSetIdCategoria() {
        System.out.println("setIdCategoria");
        int idCategoria = 0;
        Categoria instance = new Categoria();
        instance.setIdCategoria(idCategoria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescripcion method, of class Categoria.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        Categoria instance = new Categoria();
        String expResult = "";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescripcion method, of class Categoria.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        Categoria instance = new Categoria();
        instance.setDescripcion(descripcion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class Categoria.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Categoria instance = new Categoria();
        int expResult = 0;
        int result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class Categoria.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        int estado = 0;
        Categoria instance = new Categoria();
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
