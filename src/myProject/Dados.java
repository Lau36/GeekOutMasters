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
    private int carasDados;
    private int[] caras;

    /**
     * Method to generate a random value to caraAleatorio
     * @version v.1.0.0 date 11/01/2021
     */
    public int getCara (){
        Random aleatorio = new Random();
        carasDados = aleatorio.nextInt(6) + 1;
        return carasDados;
    }

       public String caras () {
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
        }


    public String getCaraContraria()
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
    }


}
