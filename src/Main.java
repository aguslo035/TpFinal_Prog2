import Controller.JuegoRPG;

/*

Nota post-oral: Este programa no va a poder conectarse a nuestra base de datos.
La persistencia se logra desde una base de datos que cargamos con los personajes y los enemigos. El problema es que esta base de datos local.
El programa lee un .txt donde se ingresa el url, usuario y contraseña. Pero no va a poder conectarse porque la base que es local.
Si se quiere igualmente probar con una base de datos, seguir las instrucciones comentadas en el main.

Como alternativa para verificar la ejecución del programa, en la clase "JuegoRPG" hacer lo siguiente:
1) Comentar las dos lineas debajo de "atributos"
2) Descomentar las dos lineas debajo de "atributos de prueba"
3) Descomentar la primera linea comentada en JuegoRPG.inicioJuego() -> es el método_ de "testJugadoresYEnemigos()"

*/

void main() {

        JuegoRPG.inicioJuego();



    /*

    //El siguiente código es para manualmente agregar a la base de datos que se indique los personajes y los enemigos.
    //En un .txt llamado "jdbc.txt", deben de agregarse los datos de url, user y password de la base de datos
    //Ej de cómo debe ir el archivo:
    //url = (url)
    //user = admin
    //password = 123
    //Una vez se tenga la base de datos correctamente en el .txt, se debe ejecutar lo de debajo antes de ejecutarse la linea de código de JuegoRPG arriba.

    Guerrero clase1 = new Guerrero(1, "Emma el Guerrero", 100, 100, 100, 100, 20, 100, ETipoArma.ESPADA);
    Mago clase2 = new Mago(2, "Lucre la Maga", 100, 100, 100, 100, 15, 100, ETipoArma.BASTON);
    Arquero clase3 = new Arquero(3, "Legolas el Arquero", 100, 100, 100, 100, 20, 80, ETipoArma.ARCO, 0.50);
    Guerrero clase4 = new Guerrero(4, "Goku", 10000, 10000, 10000, 10000, 2000, 10000, ETipoArma.NINGUNA);
    Guerrero clase5 = new Guerrero(4, "Goku2", 10000, 10000, 10000, 10000, 2000, 10000, ETipoArma.NINGUNA);


    Bestia enemigo1 = new Bestia(1, "Firulais la Bestia", 50, 50, 60, 60, 10, 40);
    Orco enemigo2 = new Orco(2, "Bernard el Orco", 60, 60 , 70, 70, 20, 30);
    Demonio enemigo3 = new Demonio(3, "Adrian el Rey Demonio", 70, 70, 80, 80, 25, 40);

    try {
        //ConexionClases.crearTablaClases();
        ConexionClases.importarClase(clase1);
        ConexionClases.importarClase(clase2);
        ConexionClases.importarClase(clase3);
        ConexionClases.importarClase(clase4);
        ConexionClases.importarClase(clase5);

        //ConexionEnemigos.crearTablaEnemigos();
        ConexionEnemigos.importarEnemigo(enemigo1);
        ConexionEnemigos.importarEnemigo(enemigo2);
        ConexionEnemigos.importarEnemigo(enemigo3);
    } catch (ConexionException e) {
        System.out.println(e.getMessage());

    */

}