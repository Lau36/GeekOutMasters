package myProject;
import java.util.ArrayList;

/**
 * ModelGeek
 * @authors
 * Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 * @version v.1.0.0 date 11/01/2022
 */
public class ModelGeek {
    private static Dados dado1;
    private Dados dado2;
    private Dados dado3;
    private Dados dado4;
    private Dados dado5;
    private Dados dado6;
    private Dados dado7;
    private Dados dado8;
    private Dados dado9;
    private Dados dado10;
    private static String[] arreglo;
    private String[] activos;
    private String[] inactivos;
    private String[] usados;

    private int numeroRonda, puntaje, flag;
    //private String[] estadoToString;


    /**
     * Class Constructor
     */
    public ModelGeek() {
        dado1 = new Dados();
        dado2 = new Dados();
        dado3 = new Dados();
        dado4 = new Dados();
        dado5 = new Dados();
        dado6 = new Dados();
        dado7 = new Dados();
        dado8 = new Dados();
        dado9 = new Dados();
        dado10 = new Dados();
        ArrayList arreglo = new ArrayList();
        activos = new String[7];
        inactivos = new String[3];

        flag = 0;

    }

    public void añadir() {
        arreglo[0] = dado1.getCara();
        arreglo[1] = dado2.getCara();
        arreglo[2] = dado3.getCara();
        arreglo[3] = dado4.getCara();
        arreglo[4] = dado5.getCara();
        arreglo[5] = dado6.getCara();
        arreglo[6] = dado7.getCara();
        arreglo[7] = dado8.getCara();
        arreglo[8] = dado9.getCara();
        arreglo[9] = dado10.getCara();
    }

    public static void eliminar1(String[] args) {
        String[] arreglo = new String[10];

        int[] newArr = null;
        int elementToBeDeleted = 5;


        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] == elementToBeDeleted){
                newArr = new int[arr.length - 1];
                for(int index = 0; index < i; index++){
                    newArr[index] = arr[index];
                }
                for(int j = i; j < arr.length - 1; j++){
                    newArr[j] = arr[j+1];
                }
                break;
            }
        }
        arreglo.(2);

    }

}

