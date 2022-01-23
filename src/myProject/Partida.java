package myProject;

public class Partida {
    private Zona activos;
    private Zona inactivos;
    private Zona utilizados;
    private Zona puntaje;
    private int puntajeGlobal;
    private int ronda;

    private Partida(){
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
        dadoSeleccionado.relanzar();
    }

    public void activarSuperHeroe(Dado dadoSuperHeroe, Dado dadoSeleccionado){
        activos.moverDado(dadoSuperHeroe, activos, utilizados);
        dadoSeleccionado.invertirCara();
    }
    public void activarCorazon(Dado dadoCorazon, Dado dadoSeleccionado){
        activos.moverDado(dadoCorazon, activos, utilizados);
        inactivos.moverDado(dadoSeleccionado, inactivos, activos);
        dadoSeleccionado.relanzar();
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
}
