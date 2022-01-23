package myProject;

public class TestDado {

    public static void main(String[] args) throws InterruptedException {
        Dado dado = new Dado();
        System.out.println("Nuevo dado: " + dado.getCara());
        Thread.sleep(2000);
        System.out.println("Se invierte cara");
        dado.invertirCara();
        System.out.println("Nueva cara: " + dado.getCara());
        Thread.sleep(2000);
        Dado nuevoDado = dado.relanzar();
        System.out.println("Otro dado: " + nuevoDado.getCara());


    }
}
