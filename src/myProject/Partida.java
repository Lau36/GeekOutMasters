package myProject;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase partida donde aplica todas las reglas del juego y zonas
 *
 * @version v.1.0.0 date 23/01/2022
 * @authors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */

public class Partida {
    private Zona activos;
    private Zona inactivos;
    private Zona utilizados;
    private Zona puntaje;
    private int puntajeGlobal;
    private int ronda;


    /**
     * Class Constructor
     */
    public Partida() {
        activos = new Zona("Dados activos", 7);
        inactivos = new Zona("Dados inactivos", 3);
        utilizados = new Zona("Dados utilizados", 0);
        puntaje = new Zona("Puntaje", 0);
        ronda = 0;
    }

    /**
     * Getter de la zona activos
     *
     * @version v.1.0.0 date 23/01/2021
     */
    public Zona getActivos() {
        return activos;
    }

    /**
     * Getter de la zona inactivos
     * @return inactivos
     * @version v.1.0.0 date 23/01/2021
     */
    public Zona getInactivos() {
        return inactivos;
    }

    /**
     * Getter de la zona utilizados
     * @return utilizados
     * @version v.1.0.0 date 23/01/2021
     */
    public Zona getUtilizados() {
        return utilizados;
    }

    /**
     * Getter del puntaje
     * @return puntaje
     * @version v.1.0.0 date 23/01/2021
     */
    public Zona getPuntaje() {
        return puntaje;
    }

    /**
     * Getter de la ronda
     * @return ronda
     * @version v.1.0.0 date 23/01/2021
     */
    public int getRonda() {

        return ronda;
    }

    /**
     * Aumenta la ronda a partir de la ronda
     * @version v.1.0.0 date 23/01/2021
     */
    public int aumentarRonda() {
        ronda = ronda + 1;
        return ronda;
    }

    /**
     *
     * @version v.1.0.0 date 23/01/2021

    public void activarMeeple(Dado dadoMeeple, Dado dadoSeleccionado) {
    activos.moverDado(dadoMeeple, activos, utilizados);
    int pos = activos.getDados().indexOf(dadoSeleccionado);
    dadoSeleccionado = dadoSeleccionado.relanzar();
    activos.getDados().set(pos, dadoSeleccionado);
    }*/

    /**
     * @version v.1.0.0 date 23/01/2021
     */
    public void activarSuperHeroe(Dado dadoSuperHeroe, Dado dadoSeleccionado) {
        activos.moverDado(dadoSuperHeroe, activos, utilizados);
        dadoSeleccionado.invertirCara();
    }

    /**
     * @version v.1.0.0 date 23/01/2021
     */
    public void activarCorazon(Dado dadoCorazon, Dado dadoSeleccionado) {
        activos.moverDado(dadoCorazon, activos, utilizados);
        inactivos.moverDado(dadoSeleccionado, inactivos, activos);
        activos.getDados().remove(dadoSeleccionado);
        dadoSeleccionado = dadoSeleccionado.relanzar();
        activos.getDados().add(dadoSeleccionado);
    }

    /**
     * Establece el poder de la cara 42
     *
     * @version v.1.0.0 date 23/01/2021
     */
    public void activar42(Dado dado42) {
        activos.moverDado(dado42, activos, puntaje);
        puntaje.calcularPuntaje();
    }

    /**
     * Establece los valores iniciales a las diferentes zonas y aumenta la ronda
     *
     * @version v.1.0.0 date 23/01/2021
     */
    public void finalizarRonda() {
        if (ronda <= 5) {
            puntajeGlobal = puntajeGlobal + puntaje.calcularPuntaje();
            activos = new Zona("Dados activos", 7);
            inactivos = new Zona("Dados inactivos", 3);
            utilizados = new Zona("Dados utilizados", 0);
            puntaje = new Zona("Puntaje", 0);
            aumentarRonda();
        }
    }


    /**
     * Establece el valor que le da el usuario de la cantidad de dados 42 y calcula el puntaje
     *
     * @return frase de terminado
     * @version v.1.0.0 date 23/01/2021
     */
    public String calculoP() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca la cantiadad de dados 42 que tiene en la zona utilizados", "Puntaje", JOptionPane.QUESTION_MESSAGE));
        if (numero == 0) {
            int resultado = 0;
            JOptionPane.showMessageDialog(null, "Tu puntaje es: " + resultado);
            return "0";

        } else if (numero == 1) {
            int resultado = 1;
            JOptionPane.showMessageDialog(null, "Tu puntaje es: " + resultado);
            return "1";
        } else if (numero == 2) {
            int resultado = 4;
            JOptionPane.showMessageDialog(null, "Tu puntaje es: " + resultado);
            return "4";


        } else if (numero == 3) {
            int resultado = 10;
            JOptionPane.showMessageDialog(null, "Tu puntaje es: " + resultado);
            return "10";


        } else if (numero == 4) {
            int resultado = 20;
            JOptionPane.showMessageDialog(null, "Tu puntaje es: " + resultado);
            return "20";

        } else if (numero == 5) {
            int resultado = 35;
            JOptionPane.showMessageDialog(null, "Tu puntaje es: " + resultado);
            return "35";

        } else if (numero == 6) {
            int resultado = 56;
            JOptionPane.showMessageDialog(null, "Tu puntaje es: " + resultado);
            return "56";

        } else if (numero == 7) {
            int resultado = 84;
            JOptionPane.showMessageDialog(null, "Tu puntaje es: " + resultado);
            return "84";

        } else if (numero == 8) {
            int resultado = 120;
            JOptionPane.showMessageDialog(null, "Tu puntaje es: " + resultado);
            return "120";

        } else if (numero == 9) {
            int resultado = 165;
            JOptionPane.showMessageDialog(null, "Tu puntaje es: " + resultado);
            return "165";

        } else if (numero == 10) {
            int resultado = 220;
            JOptionPane.showMessageDialog(null, "Tu puntaje es: " + resultado);
            return "220";
        }
        return "calculado";
    }

    /**
     * Establece que dado quiere seleccionar el usuario para relanzar
     *
     * @return el dado seleccionado por el usuario
     * @version v.1.0.0 date 23/01/2021
     */
    public int dadoSelec() {
        int dadosele = Integer.parseInt(JOptionPane.showInputDialog(null, "Dado a relanzar", "", JOptionPane.QUESTION_MESSAGE));
        return dadosele;

    }

    /**
     * Establece que dado quiere seleccionar el usuario para cambiar de zona
     *
     * @return el dado seleccionado por el usuario
     * @version v.1.0.0 date 23/01/2021
     */
    public int dadoSelecS() {
        int dadosele = Integer.parseInt(JOptionPane.showInputDialog(null, "Dado a cambiar", "", JOptionPane.QUESTION_MESSAGE));
        return dadosele;
    }


}
