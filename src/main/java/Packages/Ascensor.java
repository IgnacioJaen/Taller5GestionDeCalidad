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

    //Funcion para verificar que las personas que
    //ingresen al ascensor no sobre pase su capacidad maxima
    //true cuando sobrepasa la capacidad maxima y false cuando ya paso el limite
    public boolean lleno() {
        if(personas==CAPACIDAD_MAXIMA){
            return true;
        }else{
            return false;
        }
    }

    //Funcion para que al comenzar un nuevo dia lo inicialice en True
    public void nuevoDia() {
        nuevoDia = true;
    }

    //Funcion que si es nuevo dia el ascensor este en el piso 1
    public String ascensorPrimerPiso() {
        if(nuevoDia) {
            //Si es nuevo dia el piso del ascensor sera 1
            pisoAscensor = 1;
            return "piso Ascensor 1";
        }else{
            //Si no es un nuevo dia el ascensor se encontrara
            //en la posicion de la ultima persona que llevo a su destino
            pisoAscensor = pisoPersona;
            return "piso Ascensor es piso Persona";
        }
    }

    //Funcion para crear una persona es decir que una persona ingrese al ascensor
    public Persona crearPersona() throws Exception {

        //Si el ascensor ya esta en su capacidad maxima le lanzara una excepcion
        if(lleno()){
            throw new Exception("No se puede crear persona si el ascensor ya esta lleno");
        }else { //Si no esta en su capacidad maxima podra subir al ascensor
            Persona persona = new Persona();

            //Generando numeros aleatorios para determinar el piso en que se encuentra la persona
            //y al destino que quiere dirigirse
            Random aleatorio = new Random();
            Random aleatorio2 = new Random();
            int pisoPersonaAl = aleatorio.nextInt(NUMERO_PISOS) + 1;
            int pisoDestinoAl = aleatorio2.nextInt(NUMERO_PISOS) + 1;

            //Guardando esta informacion del lugar y destino en el objeto persona
            persona.setPisoPersona(pisoPersonaAl);
            persona.setPisoDestino(pisoDestinoAl);

            /*Guardando la informacion del lugar y destino en las variables del ascensor
            para cumplir la condicion de que el ascensor siempre sabe en que piso
            esta y cual es su piso de destino.*/
            pisoDestino = pisoDestinoAl;
            pisoPersona = pisoPersonaAl;

            //variable que aumenta en 1 el numero de personas que estan en el ascensor
            personas++;
            nuevoDia = false;

            verificarPisosIguales(persona);
            verificarDireccionDelAscensor();

            return persona;
        }
    }

    //Funcion que verifica que los pisos no sean iguales
    public boolean verificarPisosIguales(Persona persona) throws Exception{
        //Si los pisos son iguales lanzara una excepcion
        if(persona.getPisoDestino()==pisoAscensor){
            throw new Exception("El piso destino no puede ser igual al piso del ascensor");
        }else{
            //Caso contrario validara que no son iguales por lo que puede llevarlo a su destino en la siguiente funcion
            return false;
        }
    }

    //Funcion que permite al ascensor llevar a la persona a su destino
    public void moverAscensor() {
        //Se asigna al ascensor el piso del ultimo destino en el que estuvo
        pisoAscensor = pisoDestino;
        //Al dejar a la persona en el piso destino, la cantidad de personas en el ascensor disminuye
        personas--;
    }

    //Funcion que permite devolver en un String la direccion en la que se mueve el ascensor
    public String verificarDireccionDelAscensor(){

        if(pisoPersona>pisoAscensor){
            direccion = arriba;
        }else if(pisoPersona<pisoAscensor){
            direccion = abajo;
        }

        //una vez que se asigna la direccion del ascensor, este se mueve
        moverAscensor();

        return direccion;
    }
}
