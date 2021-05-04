package Packages;

import java.util.Random;

public class Ascensor {

    private int personas = 0;
    private boolean nuevoDia = true;
    private int pisoAscensor = 1;
    private int pisoPersona = 0;
    private int pisoDestino = 0;
    private String direccion = null;
    private static String arriba = "ARRIBA";
    private static String abajo = "ABAJO";
    private static int CAPACIDAD_MAXIMA = 1;
    private static int NUMERO_PISOS = 3;

    public boolean lleno() {
        if(personas==CAPACIDAD_MAXIMA){
            return true;
        }else{
            return false;
        }
    }

    public void nuevoDia() {
        nuevoDia = true;
    }

    public String ascensorPrimerPiso() {
        if(nuevoDia) {
            pisoAscensor = 1;
            return "piso Ascensor 1";
        }else{
            pisoAscensor = pisoPersona;
            return "piso Ascensor es piso Persona";
        }
    }

    public Persona crearPersona() throws Exception {
        if(lleno()){
            throw new Exception("No se puede crear persona si el ascensor ya esta lleno");
        }else {
            Persona persona = new Persona();
            Random aleatorio = new Random();
            Random aleatorio2 = new Random();
            int pisoPersonaAl = aleatorio.nextInt(NUMERO_PISOS) + 1;
            int pisoDestinoAl = aleatorio2.nextInt(NUMERO_PISOS) + 1;
            persona.setPisoPersona(pisoPersonaAl);
            persona.setPisoDestino(pisoDestinoAl);
            pisoDestino = pisoDestinoAl;
            pisoPersona = pisoPersonaAl;

            personas++;
            nuevoDia = false;

            verificarPisosIguales(persona);
            verificarDireccionDelAscensor();

            return persona;
        }
    }

    public void moverAscensor() {
        pisoAscensor = pisoDestino;
        personas--;
    }

    public boolean verificarPisosIguales(Persona persona) throws Exception{
        if(persona.getPisoDestino()==pisoAscensor){
            throw new Exception("El piso destino no puede ser igual al piso del ascensor");
        }else{
            return false;
        }
    }


    public String verificarDireccionDelAscensor(){

        if(pisoPersona>pisoAscensor){
            direccion = arriba;
        }else if(pisoPersona<pisoAscensor){
            direccion = abajo;
        }else

        moverAscensor();

        return direccion;
    }
}
