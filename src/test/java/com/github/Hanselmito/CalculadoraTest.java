package com.github.Hanselmito;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

    // Definimos el objeto para usarlo en todos los tests
    static Calculadora miCalculadora;

    @BeforeAll
    public static void setUpClass() {
        miCalculadora = new Calculadora();
    }

    @Test
    @DisplayName("sumar dos números")
    void testSuma() {
        assertEquals(12, miCalculadora.suma(9, 3));
        assertEquals(6, miCalculadora.suma(3, 3));
        assertEquals(20, miCalculadora.suma(11, 9));
        assertEquals(0, miCalculadora.suma(-5, 5));
    }

    @Test
    @DisplayName("resta dos números")
    void testResta() {
        assertEquals(3, miCalculadora.resta(6, 3));
        assertEquals(1, miCalculadora.resta(99, 98));
        assertEquals(2, miCalculadora.resta(4, 2));
        assertEquals(5, miCalculadora.resta(10, 5));
    }

    @Test
    @DisplayName("Multiplica dos números")
    void testMultiplicar() {
        assertEquals(6, miCalculadora.multiplica(2, 3));
        assertEquals(0, miCalculadora.multiplica(5, 0));
        assertEquals(16, miCalculadora.multiplica(4, 4));
        assertEquals(-5, miCalculadora.multiplica(-5, 1));
    }

    @Test
    @DisplayName("Divisiones enteras y reales")
    void testDivisionesEnterasYReales() throws Exception {
        assertEquals(2, miCalculadora.divide(4, 2));
        assertEquals(2.5, miCalculadora.divide(10, 4));
        assertEquals(4, miCalculadora.divide(10, 2.5));
        assertEquals(3.2, miCalculadora.divide(8, 2.5));
        assertEquals(0.5, miCalculadora.divide(2, 4));
    }

    @Test
    @DisplayName("Divisiones positivos y negativos")
    void testDivisionesPositivosYNegativos() throws Exception {
        assertTrue(miCalculadora.divide(4, 2) > 0);
        assertTrue(miCalculadora.divide(4, -2) < 0);
        assertTrue(miCalculadora.divide(-4, 2) < 0);
        assertTrue(miCalculadora.divide(-4, -2) > 0);
    }

    @Test
    @DisplayName("División por cero causa excepción")
    void testDivisionPorCero() {
        Exception thrown = assertThrows(Exception.class, () -> {
            miCalculadora.divide(5, 0);
        });

        assertEquals("El divisor es 0", thrown.getMessage());
    }

    @Test
    @DisplayName("potencia dos números")
    void testPotencia() {
        assertEquals(4, miCalculadora.potencia(2, 2));
        assertEquals(256, miCalculadora.potencia(2, 8));
        assertEquals(27, miCalculadora.potencia(3, 3));
        assertEquals(25, miCalculadora.potencia(5, 2));
    }

    @Test
    @DisplayName("Raíz Cuadrada")
    void testRaizCuadrada1() {
        double radicando = 1.0;
        double esperado = 1.0;
        double resultado = miCalculadora.raizCuadrada(radicando);
        assertEquals(esperado, resultado, radicando);
    }

    @Test
    void testRaizCuadrada0() {
        double radicando = 0.0;
        double esperando = 0.0;
        double resultado = miCalculadora.raizCuadrada(radicando);
        assertEquals(esperando, resultado, radicando);
    }

    @Test
    void testRaizCuadrada4() {
        double radicando = 4.0;
        double esperando = 2.0;
        double resultado = miCalculadora.raizCuadrada(radicando);
        assertEquals(esperando, resultado, radicando);
    }
}