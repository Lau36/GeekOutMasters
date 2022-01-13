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
    public int dados () {
        caraAleatorio=0;
        Random aleatorio = new Random();
        caraAleatorio = aleatorio.nextInt(6) + 1;
        return caraAleatorio;
    }

       public String getCara () {
            switch (caraAleatorio) {
                case 1:
                    caraAleatorio = 1;
                    return "cohete";

                case 2:
                    caraAleatorio = 2;
                    return "superheroe";

                case 3:
                    caraAleatorio = 3;
                    return "42";

                case 4:
                    caraAleatorio = 4;
                    return "corazon";


                case 5:
                    caraAleatorio = 5;
                    return "dragon";


                case 6:
                    caraAleatorio = 6;
                    return "meeple";

            }
            return "error";
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
