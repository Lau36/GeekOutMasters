package myProject;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ModelGeek
 * @authors
 * Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 * @version v.1.0.0 date 11/01/2022
 */
public class ModelGeek {
    private static Dados dado1;
    private static Dados dado2;
    private static Dados dado3;
    private static Dados dado4;
    private static Dados dado5;
    private static Dados dado6;
    private static Dados dado7;
    private static Dados dado8;
    private static Dados dado9;
    private static Dados dado10;



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



        activos = new String[7];
        inactivos = new String[3];

        flag = 0;

    }

    public void añadir() {
    }

        public static void main(String[] args) {
            // declares an array of integers
            Scanner teclado = new Scanner(System.in);
            String [] arreglo;
            int posicion;
            // allocates memory for 10 integers
            arreglo = new String[10];
            // initialize first element
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


            System.out.println("Tus dados son: ");
            for (int i = 0; i < 9; i++)
            {
                System.out.println(arreglo[i] + "en la posicion" + i);

            }

            System.out.print("Que dado desea eliminar:");
            posicion = teclado.nextInt();
            for (int i = posicion; i < 9; i++) {
                arreglo[i] = arreglo[i + 1];
            }
            System.out.println("Tus dados ahora son");
            for (int i = 0; i < 9; i++)
            {
                System.out.println(arreglo[i] + "en la posicion" + i);

            }
        }
    }






