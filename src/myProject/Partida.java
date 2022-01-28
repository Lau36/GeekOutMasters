package myProject;

import javax.swing.*;

public class Partida {
    private Zona activos;
    private Zona inactivos;
    private Zona utilizados;
    private Zona puntaje;
    private int puntajeGlobal;
    private int ronda;

    public Partida(){
        activos = new Zona("Dados activos",7);
        inactivos = new Zona("Dados inactivos",3);
        utilizados = new Zona("Dados utilizados",0);
        puntaje = new Zona("Puntaje",0);
        ronda = 1;
    }

    public Zona getActivos() {
        return activos;
    }

    public Zona getInactivos() {
        return inactivos;
    }

    public Zona getUtilizados() {
        return utilizados;
    }

    public Zona getPuntaje() {
        return puntaje;
    }

    public int getRonda() {
        return ronda;
    }
    public void aumentarRonda(){
        ronda = ronda + 1;
    }
    public void activarMeeple(Dado dadoMeeple, Dado dadoSeleccionado){
        activos.moverDado(dadoMeeple,activos, utilizados);
        int pos = activos.getDados().indexOf(dadoSeleccionado);
        dadoSeleccionado = dadoSeleccionado.relanzar();
        activos.getDados().set(pos, dadoSeleccionado);
    }
    public void activarSuperHeroe(Dado dadoSuperHeroe, Dado dadoSeleccionado){
        activos.moverDado(dadoSuperHeroe, activos, utilizados);
        dadoSeleccionado.invertirCara();
    }
    public void activarCorazon(Dado dadoCorazon, Dado dadoSeleccionado){
        activos.moverDado(dadoCorazon, activos, utilizados);
        inactivos.moverDado(dadoSeleccionado, inactivos, activos);
        activos.getDados().remove(dadoSeleccionado);
        dadoSeleccionado = dadoSeleccionado.relanzar();
        activos.getDados().add(dadoSeleccionado);
    }
    public void activarDragon(Dado dadoDragon){
        activos.moverDado(dadoDragon, activos, utilizados);
        puntaje.reiniciarPuntaje();
    }
    public void activarCohete(Dado dadoCohete, Dado dadoSeleccionado){
        activos.moverDado(dadoCohete, activos, utilizados);
        activos.moverDado(dadoSeleccionado, activos, inactivos);
    }
    public void activar42(Dado dado42){
        activos.moverDado(dado42, activos, puntaje);
        puntaje.calcularPuntaje();
    }

    public void finalizarRonda(){
        if (ronda<=5) {
            puntajeGlobal = puntajeGlobal + puntaje.calcularPuntaje();
            activos = new Zona("Dados activos", 7);
            inactivos = new Zona("Dados inactivos", 3);
            utilizados = new Zona("Dados utilizados", 0);
            puntaje = new Zona("Puntaje", 0);
            aumentarRonda();
        }
    }
    public String calculoP(){
        int numero = Integer.parseInt( JOptionPane.showInputDialog(null,"Introduzca la cantiadad de dados 42 que tiene en la zona utilizados", "Puntaje",JOptionPane.QUESTION_MESSAGE) );
        if(numero==0){
            int resultado = 0;
            JOptionPane.showMessageDialog(null,"Tu puntaje es: "+resultado);
        }else if(numero==1){
            int resultado = 1;
            JOptionPane.showMessageDialog(null,"Tu puntaje es: "+resultado);
        }else if(numero==2){
            int resultado = 4;
            JOptionPane.showMessageDialog(null,"Tu puntaje es: "+resultado);


        }else if(numero==3){
            int resultado = 10;
            JOptionPane.showMessageDialog(null,"Tu puntaje es: "+resultado);


        }else if(numero==4){
            int resultado = 20;
            JOptionPane.showMessageDialog(null,"Tu puntaje es: "+resultado);

        }else if(numero==5){
            int resultado = 35;
            JOptionPane.showMessageDialog(null,"Tu puntaje es: "+resultado);

        }else if(numero==6){
            int resultado = 56;
            JOptionPane.showMessageDialog(null,"Tu puntaje es: "+resultado);

        }else if(numero==7){
            int resultado = 84;
            JOptionPane.showMessageDialog(null,"Tu puntaje es: "+resultado);

        }else if(numero==8){
            int resultado = 120;
            JOptionPane.showMessageDialog(null,"Tu puntaje es: "+resultado);

        }else if(numero==9){
            int resultado = 165;
            JOptionPane.showMessageDialog(null,"Tu puntaje es: "+resultado);

        }else if(numero==10){
            int resultado = 220;
            JOptionPane.showMessageDialog(null,"Tu puntaje es: "+resultado);
        }
        return "calculado";
    }
}
