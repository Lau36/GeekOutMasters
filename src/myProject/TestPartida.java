package myProject;


import myProject.Dado;
import myProject.ModelGeek;
import myProject.Partida;
import myProject.GUI;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TestPartida {

    static Scanner scanner =  new Scanner(System.in);

    public int Calcular() {
        Scanner scanner = new Scanner(System.in);
        Partida partida = new Partida();
        ArrayList<Dado> activos = partida.getActivos().getDados();
        ArrayList<Dado> inactivos = partida.getInactivos().getDados();
        ArrayList<Dado> utilizados = partida.getUtilizados().getDados();
        ModelGeek modelGeek = new ModelGeek();
        int suma = 0;
        int[] PUNTAJES = {1, 3, 6, 10, 15, 21, 28, 36, 45, 55};
        int puntaje = 0;
        for (int i = 0; i < activos.size(); i++) {
            if (activos.get(i).getCara() == 6) {
                suma=suma+1;
                System.out.println(activos.get(i).getCara());
                System.out.println(("suma:"+suma));


            }

        }
        for(int i = 0; i<suma; i++){
            puntaje = puntaje + PUNTAJES[i];
            System.out.println(("puntaje:"+puntaje));

        }
        return puntaje;
    }




}
