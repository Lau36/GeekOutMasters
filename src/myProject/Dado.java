package myProject;

import java.util.Random;
/**
 * Class Dado generate a Randow value between 1 and 6
 * @authors
 * Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 * @version v.1.0.0 date 11/01/2022
 */

public class Dado {
    private int cara;

    public Dado(){
        cara = generarCara();
    }
    /**
     * Method to generate a random value to caraAleatorio
     * @version v.1.0.0 date 11/01/2021
     */
    public int generarCara (){
        Random aleatorio = new Random();
        cara = aleatorio.nextInt(6) + 1;
        return cara;
    }

    public void invertirCara(){
        if (cara == 1){
            cara = 6;
        } else if(cara == 2){
            cara = 5;
        }else if (cara == 3){
            cara = 4;
        }else if (cara == 6){
            cara = 1;
        }else if (cara == 5){
            cara = 2;
        }else if (cara == 4){
            cara = 3;
        }

        }
        public Dado relanzar(){
            return new Dado();
        }

    public int getCara(){
        return cara;
    }

    }







       /*public String caras () {
            switch (carasDados) {
                case 1:
                    carasDados = 1;
                    return "cohete";

                case 2:
                    carasDados = 2;
                    return "superheroe";

                case 3:
                    carasDados = 3;
                    return "42";

                case 4:
                    carasDados = 4;
                    return "corazon";


                case 5:
                    carasDados = 5;
                    return "dragon";


                case 6:
                    carasDados = 6;
                    return "meeple";
            }
            return "error";
        }*/


    /*public String getCaraContraria()
    {
        if (carasDados==1)
        {
            return "meeple";
        }
        if(carasDados==2){
            return "dragon";
        }
        if (carasDados==3){
            return "corazon";
        }
        if (carasDados==4){
            return "42";
        }
        if (carasDados==5){
            return "superheroe";
        }
        else{
            return "cohete";
        }
    }*/
