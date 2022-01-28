package myProject.testClases;

import myProject.Zona;

public class TestPuntaje {
    public static void main(String[] args) {
        Zona puntaje = new Zona("Zona puntaje:",0);
        System.out.println("Puntaje inicial:" + puntaje.calcularPuntaje());
        puntaje.calcularPuntaje();




        System.out.println("Puntaje final:" + puntaje.calcularPuntaje());
    }

}
