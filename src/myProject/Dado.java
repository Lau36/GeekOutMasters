package myProject;

import java.util.Random;

/**
 * Class Dado generate a Randow value between 1 and 6
 *
 * @version v.1.0.0 date 22/01/2022
 * @authors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */

public class Dado {
    private int cara;

    /**
     * Class Constructor
     */
    public Dado() {
        cara = generarCara();
    }

    /**
     * Establece un valor aleatorio entre 0 y 6
     *
     * @return el valor de la cara
     * @version v.1.0.0 date 22/01/2021
     */
    public int generarCara() {
        Random aleatorio = new Random();
        cara = aleatorio.nextInt(6) + 1;
        return cara;
    }

    /**
     * Invierte la cara de un dado
     *
     * @version v.1.0.0 date 22/01/2021
     */
    public void invertirCara() {
        if (cara == 1) {
            cara = 6;
        } else if (cara == 2) {
            cara = 5;
        } else if (cara == 3) {
            cara = 4;
        } else if (cara == 6) {
            cara = 1;
        } else if (cara == 5) {
            cara = 2;
        } else if (cara == 4) {
            cara = 3;
        }

    }

    /**
     * Genere un nuevo dado
     *
     * @return un nuevo dado
     * @version v.1.0.0 date 22/01/2021
     */
    public Dado relanzar() {
        return new Dado();
    }

    /**
     * Establece el valor de la cara
     *
     * @return en valor de la cara
     * @version v.1.0.0 date 22/01/2021
     */
    public int getCara() {
        return cara;
    }

}

