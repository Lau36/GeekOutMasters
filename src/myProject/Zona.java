package myProject;

import java.util.ArrayList;
/**
 * Clase que calcula las distintas zonas del juego, ya sea activos, inactivos, utilizados o puntaje
 * @authors
 * Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 * @version v.1.0.0 date 22/01/2022
 */

public class Zona {
    public int[] PUNTAJES = {1, 3, 6, 10, 15, 21, 28, 36, 45, 55};
    private String nombre;
    private int puntaje;
    private int suma;
    private ModelGeek modelGeek;
    private ArrayList<Dado> dados;
    private int[] carasDados;

    /**
     * Class Constructor
     */
    public Zona(String nombreZona, int cantidadDados) {
        puntaje = 0;
        nombre = nombreZona;
        dados = new ArrayList<Dado>(cantidadDados);
        for (int i = 0; i < cantidadDados; i++) {
            Dado dado = new Dado();
            dados.add(dado);

        }
    }

    /**
     * Establece el nombre
     * @version v.1.0.0 date 23/01/2021
     * @return el nombre que se establece
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Es un arreglo de dados
     * @version v.1.0.0 date 23/01/2021
     * @return los dados
     */
    public ArrayList<Dado> getDados() {
        return dados;
    }

    /**
     * Getter del nombre
     * @version v.1.0.0 date 23/01/2021
     * @return el nombre que se establece
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Mueve los dados de la zona donde se encuentran para una nueva y a su vez calcula el puntaje
     * @version v.1.0.0 date 23/01/2021
     */
    public void moverDado(Dado dado, Zona zonaActual, Zona nuevaZona) {
        zonaActual.getDados().remove(dado);
        nuevaZona.getDados().add(dado);
        calcularPuntaje();
    }

    /**
     *
     * @version v.1.0.0 date 23/01/2021
     */
    public int calcularArreglo() {
        for (int i = 0; i < modelGeek.getCaras()[i]; i++) {
            if (modelGeek.getCaras()[i] == 6) {
                suma = suma + 1;
            }
        }
        return suma;
    }

    /**
     *
     * @version v.1.0.0 date 24/01/2021
     */
    public int calcularPuntaje() {
        for (int i = 0; i < suma; i++) {
            puntaje = puntaje + PUNTAJES[i];
        }
        return puntaje;
    }

    /**
     * Reinicia el puntaje cuando no hay dados en el array
     * @version v.1.0.0 date 24/01/2021
     */
    public void reiniciarPuntaje() {
        puntaje = 0;
        dados = new ArrayList<Dado>(0);
    }

}
