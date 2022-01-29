package myProject.testClases;


import myProject.Dado;
import myProject.Partida;

import java.util.ArrayList;
import java.util.Scanner;

public class TestPartida {

    static Scanner scanner = new Scanner(System.in);
    static Partida partida = new Partida();
    static ArrayList<Dado> activos = partida.getActivos().getDados();
    static ArrayList<Dado> inactivos = partida.getInactivos().getDados();
    static ArrayList<Dado> utilizados = partida.getUtilizados().getDados();
    static ArrayList<Dado> puntaje = partida.getPuntaje().getDados();

    public static void main(String[] args) {

        System.out.println(("suma:"));
        int dados = scanner.nextInt();
        if (dados == 1) {
            String dadosIn = "1";
            System.out.println("Tus dados : " + dadosIn);
        } else if (dados == 2) {
            int dadosIn = 4;
            System.out.println("Tus dados : " + dadosIn);
        }
    }
}


