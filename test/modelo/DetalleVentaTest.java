package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DetalleVentaTest {

    private DetalleVenta detalleVenta;

    @BeforeEach
    public void setUp() {
        // Inicializa el objeto antes de cada prueba
        detalleVenta = new DetalleVenta();
    }

    @Test
    public void testGetIdDetalleVenta() {
        int expResult = 0;
        int result = detalleVenta.getIdDetalleVenta();
        assertEquals(expResult, result, "El ID inicial debería ser 0");
    }

    @Test
    public void testSetIdDetalleVenta() {
        int idDetalleVenta = 1;
        detalleVenta.setIdDetalleVenta(idDetalleVenta);
        assertEquals(idDetalleVenta, detalleVenta.getIdDetalleVenta(), "El ID debería actualizarse correctamente");
    }

    @Test
    public void testGetIdVentas() {
        int expResult = 0;
        int result = detalleVenta.getIdVentas();
        assertEquals(expResult, result, "El ID de ventas inicial debería ser 0");
    }

    @Test
    public void testSetIdVentas() {
        int idVentas = 101;
        detalleVenta.setIdVentas(idVentas);
        assertEquals(idVentas, detalleVenta.getIdVentas(), "El ID de ventas debería actualizarse correctamente");
    }

    @Test
    public void testGetIdProducto() {
        int expResult = 0;
        int result = detalleVenta.getIdProducto();
        assertEquals(expResult, result, "El ID de producto inicial debería ser 0");
    }

    @Test
    public void testSetIdProducto() {
        int idProducto = 202;
        detalleVenta.setIdProducto(idProducto);
        assertEquals(idProducto, detalleVenta.getIdProducto(), "El ID de producto debería actualizarse correctamente");
    }

    @Test
    public void testGetNombre() {
        String expResult = "";
        String result = detalleVenta.getNombre();
        assertEquals(expResult, result, "El nombre inicial debería ser una cadena vacía");
    }

    @Test
    public void testSetNombre() {
        String nombre = "Producto A";
        detalleVenta.setNombre(nombre);
        assertEquals(nombre, detalleVenta.getNombre(), "El nombre debería actualizarse correctamente");
    }

    @Test
    public void testGetCantidad() {
        int expResult = 0;
        int result = detalleVenta.getCantidad();
        assertEquals(expResult, result, "La cantidad inicial debería ser 0");
    }

    @Test
    public void testSetCantidad() {
        int cantidad = 10;
        detalleVenta.setCantidad(cantidad);
        assertEquals(cantidad, detalleVenta.getCantidad(), "La cantidad debería actualizarse correctamente");
    }

    @Test
    public void testGetPrecioUnitario() {
        double expResult = 0.0;
        double result = detalleVenta.getPrecioUnitario();
        assertEquals(expResult, result, 0.01, "El precio unitario inicial debería ser 0.0");
    }

    @Test
    public void testSetPrecioUnitario() {
        double precioUnitario = 15.5;
        detalleVenta.setPrecioUnitario(precioUnitario);
        assertEquals(precioUnitario, detalleVenta.getPrecioUnitario(), 0.01, "El precio unitario debería actualizarse correctamente");
    }

    @Test
    public void testGetSubTotal() {
        double expResult = 0.0;
        double result = detalleVenta.getSubTotal();
        assertEquals(expResult, result, 0.01, "El subtotal inicial debería ser 0.0");
    }

    @Test
    public void testSetSubTotal() {
        double subTotal = 150.0;
        detalleVenta.setSubTotal(subTotal);
        assertEquals(subTotal, detalleVenta.getSubTotal(), 0.01, "El subtotal debería actualizarse correctamente");
    }

    @Test
    public void testGetDescuento() {
        double expResult = 0.0;
        double result = detalleVenta.getDescuento();
        assertEquals(expResult, result, 0.01, "El descuento inicial debería ser 0.0");
    }

    @Test
    public void testSetDescuento() {
        double descuento = 10.0;
        detalleVenta.setDescuento(descuento);
        assertEquals(descuento, detalleVenta.getDescuento(), 0.01, "El descuento debería actualizarse correctamente");
    }

    @Test
    public void testGetTotalPagar() {
        double expResult = 0.0;
        double result = detalleVenta.getTotalPagar();
        assertEquals(expResult, result, 0.01, "El total a pagar inicial debería ser 0.0");
    }

    @Test
    public void testSetTotalPagar() {
        double totalPagar = 140.0;
        detalleVenta.setTotalPagar(totalPagar);
        assertEquals(totalPagar, detalleVenta.getTotalPagar(), 0.01, "El total a pagar debería actualizarse correctamente");
    }

    @Test
    public void testGetEstado() {
        int expResult = 0;
        int result = detalleVenta.getEstado();
        assertEquals(expResult, result, "El estado inicial debería ser 0");
    }

    @Test
    public void testSetEstado() {
        int estado = 1;
        detalleVenta.setEstado(estado);
        assertEquals(estado, detalleVenta.getEstado(), "El estado debería actualizarse correctamente");
    }

    @Test
    public void testToString() {
        detalleVenta.setIdDetalleVenta(1);
        detalleVenta.setIdVentas(101);
        detalleVenta.setIdProducto(202);
        detalleVenta.setNombre("Producto A");
        detalleVenta.setCantidad(2);
        detalleVenta.setPrecioUnitario(15.0);
        detalleVenta.setSubTotal(30.0);
        detalleVenta.setDescuento(5.0);
        detalleVenta.setTotalPagar(25.0);
        detalleVenta.setEstado(1);

        String expected = "DetalleVenta{idDetalleVenta=1, idVentas=101, idProducto=202, nombre=Producto A, cantidad=2, precioUnitario=15.0, subTotal=30.0, descuento=5.0, totalPagar=25.0, estado=1}";
        assertEquals(expected, detalleVenta.toString(), "La representación en cadena no coincide con lo esperado");
    }
}
