package myProject;

import java.awt.*;
import java.util.ArrayList;

public class Zona {
    public int [] PUNTAJES = {1, 3, 6, 10, 15, 21, 28, 36, 45, 55};
    private String nombre;
    private int puntaje;
    private int suma;
    private ModelGeek modelGeek;
    private ArrayList<Dado> dados;
    private int[] carasDados;



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Zona(String nombreZona, int cantidadDados){
        puntaje = 0;
        nombre = nombreZona;
        dados = new ArrayList<Dado>(cantidadDados);
        for (int i = 0; i<cantidadDados; i++){
            Dado dado = new Dado();
            dados.add(dado);

        }
    }

    public ArrayList<Dado> getDados() {
        return dados;
    }

    public String getNombre() {
        return nombre;
    }

    public void moverDado(Dado dado, Zona zonaActual, Zona nuevaZona) {
        zonaActual.getDados().remove(dado);
        nuevaZona.getDados().add(dado);
        calcularPuntaje();
    }

    public int calcularArreglo(){
        for(int i=0;i<modelGeek.getCaras()[i];i++){
            if(modelGeek.getCaras()[i]==6){
                suma = suma + 1 ;
            }
        }
        return suma;
    }

    public int calcularPuntaje(){
        for(int i = 0; i<suma; i++){
            puntaje = puntaje + PUNTAJES[i];
        }
        return puntaje;
    }



    public void reiniciarPuntaje(){
        puntaje = 0;
        dados = new ArrayList<Dado>(0);
    }
    //dados.size()
    /*@Override
    public String toString() {
        return "Zona{" +
                "nombre='" + nombre + '\'' +
                ", dados=" + dados +
                '}';
    }*/
}
