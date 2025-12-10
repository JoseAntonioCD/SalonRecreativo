package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {
    @Test
    @DisplayName("Al crear un jugador, no tiene créditos")
    public void al_crear_jugador_no_tiene_creditos() {
        Jugador jugador = new Jugador("Paco",1);
        assertEquals(0, jugador.getCreditosDisponibles());
    }

    @Test
    @DisplayName("Al recargar los créditos de un jugador, el valor de los créditos cambia")
    public void tesRecargarCreditos(){
        Jugador j = new Jugador("Casti",11);

        int saldoInicial = j.getCreditosDisponibles();
        j.recargarCreditos();

        assertTrue(j.getCreditosDisponibles()>saldoInicial);
    }

    @Test
    @DisplayName("Al jugar una partida se gastarán créditos del jugador")
            public void testGastarCreditos(){
        Jugador j = new Jugador("Casti",111);
        j.gastarCreditos(0);
        j.gastarCreditos(0);
        j.gastarCreditos(-5);
        j.gastarCreditos(10);
    }

    @Test
    @DisplayName("Al gastar créditos no se gastarán más créditos de los que hay disponibles")
    public void testNoGastarMasCreditos(){
        Jugador j = new Jugador("Casti",111);

        assertFalse(j.comprobacionCreditos(10));
    }

    @Test
    @DisplayName("Al jugar una partida se incrementará el número de partidas jugadas del jugador en cuestión")
    public void testIncrementarPartidasJugadas(){
        Jugador j = new Jugador("Casti",111);
        j.incrementarPartidasJugadas();
        assertEquals(1,j.getPartidasJugadas());
    }

}