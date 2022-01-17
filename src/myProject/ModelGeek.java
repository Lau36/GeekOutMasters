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
    private int[] carasDados;
    private int[] dados;

    private int numeroRonda, puntaje, flag;


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

        //dados = new int [10];
        carasDados = new int [10];
        activos = new String[7];
        inactivos = new String[3];

        flag = 0;
    }
    public void calcularCara(){
        carasDados[0]= dado1.getCara();
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


    public int [] getCaras(){
        return carasDados;
    }

    public void meeple(){
        if(carasDados[0]==3){
            //relanza un dado
        }
    }

    public void superHeroe(){
        if(carasDados[0]==5){
            //coloca la cara opuesta de un dado de la seccion de activos
        }

    }
    public void num42(){
        if(carasDados[0]==6){
            //suma puntos al final de la ronda
        }

    }
    public void dragon(){
        if(carasDados[0]==3){
            //si al final de la ronda es el ultimo dado activo, se pierdenn todos los puntos
        }

    }
    public void cohete(){
        if(carasDados[0]==4){
            //envia un dado de la seccion de dados activos a la de dados inanctivos
            //(lo podemos hacer con un panelActivos.add(dado) y panelInactivos.remove(dado))
        }

    }
    public void calcularPunto(){

    }
    public void calcularRonda(){

    }
}

    /*public void eliminar() {
    }
        public static void main(String[] args) {
            // declares an array of integers
            Scanner teclado = new Scanner(System.in);
            String [] arreglo;
            int posicion;
            // allocates memory for 10 integers
            arreglo = new String[10];
            // initialize first element
            /*arreglo[0] = dado1.getCaras();
            arreglo[1] = dado2.getCaras();
            arreglo[2] = dado3.getCaras();
            arreglo[3] = dado4.getCara();
            arreglo[4] = dado5.getCara();
            arreglo[5] = dado6.getCara();
            arreglo[6] = dado7.getCara();
            arreglo[7] = dado8.getCara();
            arreglo[8] = dado9.getCara();
            arreglo[9] = dado10.getCara();*/

            /*System.out.println("Tus dados son: ");
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
    }*/







