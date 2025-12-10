package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaRecreativaTest {
@BeforeEach
    void resetear(){
    try{
        var fieldJug = SalaRecreativa.class.getDeclaredField("jugadores");
        fieldJug.setAccessible(true);
        fieldJug.set(null,null);

        var fieldMaq = SalaRecreativa.class.getDeclaredField("maquinas");
        fieldMaq.setAccessible(true);
        fieldMaq.set(null,null);
    }catch (Exception e) { e.printStackTrace();}

    }

    @Test
    @DisplayName("La partida no empieza en caso de que el jugador no tenga créditos")
            public void testNoPermiteJugarSinCreditos(){
        Jugador j = new Jugador("Nerea",100);
        MaquinaArcade m = new MaquinaArcade("MaquinaTest","Horror",5,true);

        SalaRecreativa.agregarJugador(j);
        SalaRecreativa.agregarMaquina(m);

        int creditosActuales = j.getCreditosDisponibles();

        SalaRecreativa.gestionarPartida(j,m);

        assertEquals(creditosActuales,j.getCreditosDisponibles());
    }

    @Test
    @DisplayName("La partida no empieza en caso de que la máquina esté en mantenimiento")
    public void testNoPermiteJugarMaquinaInactiva(){
    Jugador j = new Jugador("Mateo",8213);
    MaquinaArcade m = new MaquinaArcade("Pinball","Casual",5,false);

    SalaRecreativa.agregarJugador(j);
    SalaRecreativa.agregarMaquina(m);

    SalaRecreativa.gestionarPartida(j,m);

    assertFalse(m.isActiva());
    }

    @Test
    @DisplayName("Los créditos de un jugador disminuyen al jugar")
    public void testCreditoDisminuyeAlJugar(){
    Jugador j = new Jugador("Casti",1111);
    j.gastarCreditos(-10);

    MaquinaArcade m = new MaquinaArcade("MaquinaTest","Shooter",5,true);

    int creditosActuales = j.getCreditosDisponibles();

    SalaRecreativa.gestionarPartida(j,m);

    assertEquals(creditosActuales - 5, j.getCreditosDisponibles());
    }

    @Test
    @DisplayName("Las partidas jugadas de un jugador aumentan al realizar una partida")
    public void testIncrementoPartidasAlJugar(){
    Jugador j = new Jugador("A",111);
    j.gastarCreditos(-10);

    MaquinaArcade m = new MaquinaArcade("MaquinaTest","Género",1,true);

    int partidasIniciales = j.getPartidasJugadas();

    SalaRecreativa.gestionarPartida(j,m);
    assertEquals(partidasIniciales + 1, j.getPartidasJugadas());
    }

}