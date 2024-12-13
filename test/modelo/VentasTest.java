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
public class VentasTest {
    
    public VentasTest() {
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
     * Test of getTdVentas method, of class Ventas.
     */
    @Test
    public void testGetTdVentas() {
        System.out.println("getTdVentas");
        Ventas instance = new Ventas();
        int expResult = 0;
        int result = instance.getTdVentas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdVentas method, of class Ventas.
     */
    @Test
    public void testSetIdVentas() {
        System.out.println("setIdVentas");
        int idVentas = 0;
        Ventas instance = new Ventas();
        instance.setIdVentas(idVentas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdCliente method, of class Ventas.
     */
    @Test
    public void testGetIdCliente() {
        System.out.println("getIdCliente");
        Ventas instance = new Ventas();
        int expResult = 0;
        int result = instance.getIdCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdCliente method, of class Ventas.
     */
    @Test
    public void testSetIdCliente() {
        System.out.println("setIdCliente");
        int idCliente = 0;
        Ventas instance = new Ventas();
        instance.setIdCliente(idCliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValorPagar method, of class Ventas.
     */
    @Test
    public void testGetValorPagar() {
        System.out.println("getValorPagar");
        Ventas instance = new Ventas();
        double expResult = 0.0;
        double result = instance.getValorPagar();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValorPagar method, of class Ventas.
     */
    @Test
    public void testSetValorPagar() {
        System.out.println("setValorPagar");
        double valorPagar = 0.0;
        Ventas instance = new Ventas();
        instance.setValorPagar(valorPagar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaVenta method, of class Ventas.
     */
    @Test
    public void testGetFechaVenta() {
        System.out.println("getFechaVenta");
        Ventas instance = new Ventas();
        String expResult = "";
        String result = instance.getFechaVenta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaVenta method, of class Ventas.
     */
    @Test
    public void testSetFechaVenta() {
        System.out.println("setFechaVenta");
        String fechaVenta = "";
        Ventas instance = new Ventas();
        instance.setFechaVenta(fechaVenta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class Ventas.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Ventas instance = new Ventas();
        int expResult = 0;
        int result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class Ventas.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        int estado = 0;
        Ventas instance = new Ventas();
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Ventas.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Ventas instance = new Ventas();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
