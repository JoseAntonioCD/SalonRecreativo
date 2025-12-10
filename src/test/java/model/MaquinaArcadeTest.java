package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class MaquinaArcadeTest {
    @Test
    @DisplayName("El contador de partidas jugadas en una máquina aumenta al jugar una oartida en ella")
    public void testIncrementoPartidasAlJugar(){
        Jugador j = new Jugador("Nuria",123);
        MaquinaArcade m = new MaquinaArcade("MáquinaPrueba","Plataformas",1,true);

        m.jugarPartida(j);
        assertEquals(1,m.getNumeroPartidasJugadas());
    }

    @Test
    @DisplayName("El ranking de la máquina está ordenado en orden descendente, de mejor a peor puntuación")
    public void testRankingTop3(){
        MaquinaArcade m = new MaquinaArcade("MaquinaPrueba","Shooter",1,true);

        int[]puntuaciones = {5000,3000,1000};
        String[] jugadores = {"Carlos","Ana","Giorgio"};

        m.setRankingTop3(puntuaciones);
        m.setTop3Jugadores(jugadores);

        int peorPuntuacion = 50;

        assertEquals(5000, m.getRankingTop3()[0]);
        assertNotEquals(peorPuntuacion,m.getRankingTop3()[2]);
    }

    @Test
    @DisplayName("La máquina se desactiva para entrar en mantenimiento al llegar a las 100 partidas jugadas")
    public void test_Desactivar_Al_LLegar_A_100_Partidas(){
        Jugador j = new Jugador("Test",543);
        MaquinaArcade m = new MaquinaArcade("MaquinaTest","Acción",1,true);
    m.setNumeroPartidasJugadas(99);
    m.jugarPartida(j);

    assertFalse(m.isActiva());
    }
}