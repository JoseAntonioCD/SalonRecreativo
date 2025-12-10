package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {
    @Test
    @DisplayName("Primera comprobación del rango correcto")
    void testComprobarRango_valorDentroDelRango1(){
        assertTrue(Utils.comprobarRango(5,1,10));
    }
    @Test
    @DisplayName("Segunda comprobación del rango correcto")
    void testComprobarRango_valorDentroDelRango2(){
        assertTrue(Utils.comprobarRango(9,1,10));
    }
    @Test
    @DisplayName("Primera comprobación del rango incorrecto")
    void testComprobarRango_valorFueraDelRango1(){
        assertTrue(Utils.comprobarRango(0,1,10));
    }
    @Test
    @DisplayName("Segunda comprobación del rango incorrecto")
    void testComprobarRango_valorFueraDelRango2(){
        assertTrue(Utils.comprobarRango(50,1,10));
    }
}