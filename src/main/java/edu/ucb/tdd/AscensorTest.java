package edu.ucb.tdd;

import Packages.Ascensor;
import Packages.Persona;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class AscensorTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void capacidadParaSoloUnaPersona() throws Exception{

        //Preparacion de la prueba
        Ascensor ascensor=new Ascensor();

        ascensor.crearPersona();

        //Verificacion o Assert
        exception.expect(Exception.class);
        assertEquals(true,ascensor.crearPersona());
    }

    @Test
    public void ascensorEnElPrimerPisoAlEmpezarElDia() throws Exception{

        //Preparacion de la prueba
        Ascensor ascensor=new Ascensor();

        ascensor.nuevoDia();

        //Verificacion o Assert
        assertEquals("piso Ascensor 1",ascensor.ascensorPrimerPiso());
    }

    @Test
    public void pisoDestinoNoEsIgualAPisoAscensor() throws Exception{

        //Preparacion de la prueba
        Ascensor ascensor=new Ascensor();

        Persona persona = new Persona();
        persona = ascensor.crearPersona();

        //Verificacion o Assert
        exception.expect(Exception.class);
        assertEquals(false,ascensor.verificarPisosIguales(persona));
    }

    @Test
    public void elAscensorAlternaDirecciones() throws Exception{

        //Preparacion de la prueba
        Ascensor ascensor=new Ascensor();

        Persona persona = new Persona();
        persona = ascensor.crearPersona();

        //Verificacion o Assert
        assertEquals("ARRIBA",ascensor.verificarDireccionDelAscensor());
    }

}
