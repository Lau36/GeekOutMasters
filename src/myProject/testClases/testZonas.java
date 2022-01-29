package myProject.testClases;


import myProject.Dado;
import myProject.Zona;

import java.util.ArrayList;

public class testZonas {
    public static void main(String[] args) throws InterruptedException {
        Zona activos = new Zona("Activos", 7);
        Zona inactivos = new Zona("Inactivos", 3);
        System.out.println("Nombre zona:" + activos.getNombre());
        Thread.sleep(2000);
        ArrayList<Dado> dadosActivos = activos.getDados();
        for (int i = 0; i < dadosActivos.size(); i++) {
            System.out.println("Dado " + (i + 1) + ":" + dadosActivos.get(i).getCara());
        }
        Thread.sleep(2000);
        System.out.println("Nombre zona:" + inactivos.getNombre());
        ArrayList<Dado> dadosInactivos = inactivos.getDados();
        for (int i = 0; i < dadosInactivos.size(); i++) {
            System.out.println("Dado " + (i + 1) + ":" + dadosInactivos.get(i).getCara());
        }
        Thread.sleep(2000);

        System.out.println("Se mueve el primer dado de la zona activos para la zona inactivos");
        activos.moverDado(dadosActivos.get(0), activos, inactivos);
        System.out.println("Nombre zona:" + activos.getNombre());
        for (int i = 0; i < dadosActivos.size(); i++) {
            System.out.println("Dado " + (i + 1) + ":" + dadosActivos.get(i).getCara());
        }
        Thread.sleep(2000);
        System.out.println("Nombre zona:" + inactivos.getNombre());
        for (int i = 0; i < dadosInactivos.size(); i++) {
            System.out.println("Dado " + (i + 1) + ":" + dadosInactivos.get(i).getCara());
        }


    }
}
