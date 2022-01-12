package myProject;

import java.util.Random;
/**
 * Class Dado generate a Randow value between 1 and 6
 * @authors
 * Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 * @version v.1.0.0 date 11/01/2022
 */

public class Dados {
    private int caraAleatorio;

    /**
     * Method to generate a random value to caraAleatorio
     * @version v.1.0.0 date 11/01/2021
     */
    public int dados() {

        Random aleatorio = new Random();
        caraAleatorio = aleatorio.nextInt(6) + 1;
        return caraAleatorio;
    }

    public String getCara(){
        if (caraAleatorio==1)
        {
            return "cohete";
        }
        if(caraAleatorio==2){
            return "superheroe";
        }
        if (caraAleatorio==3){
            return "42";
        }
        if (caraAleatorio==4){
            return "corazon";
        }
        if (caraAleatorio==5){
            return "dragon";
        }
        else{
            return "meeple";
        }
    }

    public String getCaraContraria()
    {
        if (caraAleatorio==1)
        {
            return "meeple";
        }
        if(caraAleatorio==2){
            return "dragon";
        }
        if (caraAleatorio==3){
            return "corazon";
        }
        if (caraAleatorio==4){
            return "42";
        }
        if (caraAleatorio==5){
            return "superheroe";
        }
        else{
            return "cohete";
        }
    }
}
