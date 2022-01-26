package myProject;


import java.util.ArrayList;
import java.util.Scanner;

public class TestPartida {

    static Scanner scanner =  new Scanner(System.in);
    static Partida partida = new Partida();
    static ArrayList<Dado> activos = partida.getActivos().getDados();
    static ArrayList<Dado> inactivos = partida.getInactivos().getDados();
    static ArrayList<Dado> utilizados = partida.getUtilizados().getDados();
    static ArrayList<Dado> puntaje = partida.getPuntaje().getDados();

    public static void main(String[] args) {
        System.out.println("Numero ronda: " + partida.getRonda());
        System.out.println("Puntaje global: " + partida.getPuntaje().calcularPuntaje());
        System.out.println("Puntaje ronda: " + partida.getPuntaje().calcularPuntaje());
        imprimirEstado();
        System.out.println("Selecione una dado activo:");
        int dadoSelecionado = scanner.nextInt();
        Dado dadoSeleccionado = activos.get(dadoSelecionado-1);
        partida.activar42(dadoSeleccionado);
        System.out.println("Puntaje ronda: " + partida.getPuntaje().calcularPuntaje());
        imprimirEstado();
        int dadoSelecionado2 = scanner.nextInt();
        Dado dadoSeleccionado2 = activos.get(dadoSelecionado2-1);
        partida.activar42(dadoSeleccionado2);
        
        /*System.out.println("Selecione para activar poder:");
        int dadoPoder = scanner.nextInt();
            System.out.println("Activa poder");
            Dado dadoSeleccionado = activos.get(dadoSelecionado-1);
            Dado dadoPod = inactivos.get(dadoPoder-1);
            partida.activarCorazon(dadoSeleccionado,dadoPod);*/
            
        imprimirEstado();
        System.out.println("Puntaje ronda: " + partida.getPuntaje().calcularPuntaje());
    }

    public static void imprimirEstado(){
        System.out.println("Nombre zona: "+ partida.getActivos().getNombre());
        for (int i=0; i<activos.size();i++){
            System.out.println("Dado" + ": " + activos.get(i).getCara());
        }

        System.out.println("Nombre zona: "+ partida.getInactivos().getNombre());
        for (int i=0; i<inactivos.size();i++){
            System.out.println("Dado" + ": " + inactivos.get(i).getCara());
        }

        System.out.println("Nombre zona: "+ partida.getUtilizados().getNombre());
        for (int i=0; i<utilizados.size();i++){
            System.out.println("Dado" + ": " + utilizados.get(i).getCara());
        }

        System.out.println("Nombre zona: "+ partida.getPuntaje().getNombre());
        for (int i=0; i<puntaje.size();i++){
            System.out.println("Dado" + ": " + puntaje.get(i).getCara());
        }
    }
}
