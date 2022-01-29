package myProject;

/**
 * ModelGeek
 *
 * @version v.1.0.0 date 11/01/2022
 * @authors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */
public class ModelGeek {
    private static Dado dado1;
    private static Dado dado2;
    private static Dado dado3;
    private static Dado dado4;
    private static Dado dado5;
    private static Dado dado6;
    private static Dado dado7;
    private static Dado dado8;
    private static Dado dado9;
    private static Dado dado10;


    private int[] carasDados;

    /**
     * * Class Constructor
     */
    public ModelGeek() {
        dado1 = new Dado();
        dado2 = new Dado();
        dado3 = new Dado();
        dado4 = new Dado();
        dado5 = new Dado();
        dado6 = new Dado();
        dado7 = new Dado();
        dado8 = new Dado();
        dado9 = new Dado();
        dado10 = new Dado();

        carasDados = new int[10];
    }

    /**
     * Calcula el valor de una cara y se lo añade al arreglo
     */
    public void calcularCara() {
        carasDados[0] = dado1.getCara();
        carasDados[1] = dado2.getCara();
        carasDados[2] = dado3.getCara();
        carasDados[3] = dado4.getCara();
        carasDados[4] = dado5.getCara();
        carasDados[5] = dado6.getCara();
        carasDados[6] = dado7.getCara();
        carasDados[7] = dado8.getCara();
        carasDados[8] = dado9.getCara();
        carasDados[9] = dado10.getCara();

    }

    /**
     * Establece el valor de la cara en el arreglo
     *
     * @return cara del dado
     */
    public int[] getCaras() {
        return carasDados;
    }

}









