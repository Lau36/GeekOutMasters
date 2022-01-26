package myProject;


import javax.swing.*;
import java.awt.*;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
//import java.awt.event.MouseListenimport javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is used for ...
 * @authors
 * Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 * @version v.1.0.0 date 11/01/2022
 */

public class GUI extends JFrame {

    public static final String MENSAJE_INICIO = "Bienvenido a Geek Out Masters!!\n"
            + "Para iniciar el juego oprime el boton lanzar y se lanzaran los 10 dados de forma aleatoria.\n"
            + "Tres de esos 10 dados se iran a la parte de dados inactivos y 7 quedan en dados activos.\n"
            + "Al tener los dados, tienes que recordar las siguientes reglas:\n"
            + "1. El Meeple permite relanzar otro dado en juego, es decir, de la sección dados activos.\n"
            + "2. El cohete envía un dado no usado (de la sección dados activos) a la sección de dados inanctivos\n"
            + "3. El Superhéroe permite que cualquier dado no usado (sección dados activos) sea volteado y colocando en su cara opuesta.\n"
            + "4. El Corazón permite tomar un dado de la sección de dados inactivos y lanzarlo para que sea un nuevo dado activo.\n"
            + "5. El Dragón es la cara que se quiere evitar, ya que si al final de la ronda es el último dado activo que queda se habrán perdido todos los puntos ganados y acumulados.\n"
            + "6. 42 es la cara que permite sumar puntos al final de la ronda.\n"
            + "Pero tienes que tener en cuenta que cada dado tiene una cara opuesta.\n"
            + "Oprime el boton de Caras para saber mas!!";

    public static final String MENSAJE_CARAS = "Hola!! al parecer quieres conocer cuales son las caras opuestas de los dados, aca te explico.\n"
            + "La cara contraría al Corazón es el 42, ya que tienen el mismo color (rojo)\n"
            + "La cara contraria del Meeple es el Cohete, mismo color (verde).\n"
            + "Y la cara contraria del Superhéroe es el Dragón, mismo color (amarillo).";

    private Header headerProject;
    private JLabel dado1, dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10;
    private JPanel panelPuntaje, panelUtilizados, panelActivos, panelInactivos, mensajePuntaje, mensajeRonda;
    private JButton lanzar, ayuda, salir, carasOpuestas, finalizarRonda;
    private ImageIcon imageDados, imageDado, imageBotonSalir, imageBotonAyuda,imagenfondo, imagenPuntaje;
    //private JTextArea mensajeRonda, mensajePuntaje;
    private Escucha escucha;
    private Partida partida;
    private Zona inactivos;
    private Zona activos;
    private Zona utilizados;
    private Zona puntaje;
    private ModelGeek modelGeek;

    static Scanner scanner =  new Scanner(System.in);



    /**
     * Constructor of GUI class
     */
    public GUI() {
        initGUI();

        //Default JFrame configuration
        this.setTitle("Geek Out Masters");
        this.setSize(900, 900);
        //this.setBackground(new Color(255,255,255,0));
        this.setUndecorated(true);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //Create Listener Object and Control Object
        escucha = new Escucha();
        partida = new Partida();
        modelGeek = new ModelGeek();
        //Set up JComponents
        headerProject = new Header("Geek Out Masters", Color.BLACK);
        headerProject.setFont(new Font("Arial", Font.BOLD, 26));
        headerProject.setBackground(Color.WHITE);
        headerProject.setIcon(new ImageIcon(getClass().getResource("/resources/fondoHeader.jpeg")));
        headerProject.setPreferredSize(new Dimension(200,100));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(headerProject, constraints);

        //Change this line if you change JFrame Container's Layout

       // imagenfondo= new ImageIcon(getClass().getResource("/resources/fondoHeader.jpeg"));

        imageDados = new ImageIcon(getClass().getResource("/resources/dado2.png"));
        dado1 = new JLabel(imageDados);
        dado2 = new JLabel(imageDados);
        dado3 = new JLabel(imageDados);
        dado4 = new JLabel(imageDados);
        dado5 = new JLabel(imageDados);
        dado6 = new JLabel(imageDados);
        dado7 = new JLabel(imageDados);
        dado8 = new JLabel(imageDados);
        dado9 = new JLabel(imageDados);
        dado10 = new JLabel(imageDados);

        dado1.addMouseListener(escucha);
        dado2.addMouseListener(escucha);
        dado3.addMouseListener(escucha);
        dado4.addMouseListener(escucha);
        dado5.addMouseListener(escucha);
        dado6.addMouseListener(escucha);
        dado7.addMouseListener(escucha);
        dado8.addMouseListener(escucha);
        dado9.addMouseListener(escucha);
        dado10.addMouseListener(escucha);


        lanzar = new JButton("Lanzar");
        lanzar.setFont(new Font("times new roman", Font.BOLD, 15));
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(lanzar, constraints);
        lanzar.addActionListener(escucha);
        lanzar.setBackground(Color.darkGray);
        lanzar.setForeground(Color.WHITE);

        salir = new JButton();
        imageBotonSalir = new ImageIcon (getClass().getResource("/resources/salir.jpeg"));
        salir.setPreferredSize(new Dimension(25,25));
        salir.setIcon(imageBotonSalir);
        salir.setBackground(Color.WHITE);
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        this.add(salir, constraints);
        salir.addActionListener(escucha);

        ayuda = new JButton();
        imageBotonAyuda = new ImageIcon (getClass().getResource("/resources/ayuda.jpeg"));
        ayuda.setPreferredSize(new Dimension(25,25));
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        this.add(ayuda, constraints);
        ayuda.addActionListener(escucha);
        ayuda.setBackground(Color.WHITE);
        ayuda.setIcon(imageBotonAyuda);

        carasOpuestas = new JButton("Caras");
        carasOpuestas.setFont(new Font("times new roman", Font.BOLD, 15));
        carasOpuestas.setBackground(Color.darkGray);
        carasOpuestas.setForeground(Color.WHITE);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(carasOpuestas, constraints);
        carasOpuestas.addActionListener(escucha);

        finalizarRonda = new JButton("Finalizar ronda");
        finalizarRonda.setFont(new Font("times new roman", Font.BOLD, 15));
        finalizarRonda.setBackground(Color.darkGray);
        finalizarRonda.setForeground(Color.WHITE);
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(finalizarRonda, constraints);
        finalizarRonda.addActionListener(escucha);

        panelActivos = new JPanel();
        panelActivos.setPreferredSize(new Dimension(400, 180));
        panelActivos.setBorder(BorderFactory.createTitledBorder("Dados activos: "));
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelActivos, constraints);
        panelActivos.setBackground(new Color(255, 255, 255, 0));
        panelActivos.setOpaque(false);

        panelActivos.add(dado1);
        panelActivos.add(dado2);
        panelActivos.add(dado3);
        panelActivos.add(dado4);
        panelActivos.add(dado5);
        panelActivos.add(dado6);
        panelActivos.add(dado7);


        panelActivos.add(lanzar);

        panelInactivos = new JPanel();
        panelInactivos.setBorder(BorderFactory.createTitledBorder("Dados inactivos: "));
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelInactivos, constraints);
        panelInactivos.setPreferredSize(new Dimension(400, 180));
        panelInactivos.setBackground(new Color(255, 255, 255, 0));

        panelInactivos.add(dado8);
        panelInactivos.add(dado9);
        panelInactivos.add(dado10);

        panelUtilizados = new JPanel();
        panelUtilizados.setPreferredSize(new Dimension(400, 180));
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelUtilizados, constraints);
        panelUtilizados.setBorder(BorderFactory.createTitledBorder("Dados utilizados: "));
        panelUtilizados.setBackground(new Color(255, 255, 255, 0));

        panelPuntaje = new JPanel();
        panelPuntaje.setPreferredSize(new Dimension(400, 180));
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        this.add(panelPuntaje, constraints);
        panelPuntaje.setBorder(BorderFactory.createTitledBorder("Tu puntaje: "));
        //imagenPuntaje = new ImageIcon (getClass().getResource("/resources/puntajes.png"));


        mensajeRonda = new JPanel();
        mensajeRonda.setBorder(BorderFactory.createTitledBorder("Ronda:"));
        mensajeRonda.setPreferredSize(new Dimension(110, 50));
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        this.add(mensajeRonda, constraints);

        mensajePuntaje = new JPanel();
        mensajePuntaje.setBorder(BorderFactory.createTitledBorder("Puntaje global:"));
        mensajePuntaje.setPreferredSize(new Dimension(100, 50));
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        this.add(mensajePuntaje, constraints);



    }

    /**
     * Main process of the Java program
     *
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */



    private class Escucha implements ActionListener, MouseListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == ayuda) {
                JOptionPane.showMessageDialog(null, MENSAJE_INICIO);
            } else {
                if (e.getSource() == lanzar) {
                    int[] caraDados = modelGeek.getCaras();
                    modelGeek.calcularCara();
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[0] + ".png"));
                    dado1.setIcon(imageDado);
                    revalidate();
                    repaint();
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[1] + ".png"));
                    dado2.setIcon(imageDado);
                    revalidate();
                    repaint();
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[2] + ".png"));
                    dado3.setIcon(imageDado);
                    revalidate();
                    repaint();
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[3] + ".png"));
                    dado4.setIcon(imageDado);
                    revalidate();
                    repaint();
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[4] + ".png"));
                    dado5.setIcon(imageDado);
                    revalidate();
                    repaint();
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[5] + ".png"));
                    dado6.setIcon(imageDado);
                    revalidate();
                    repaint();
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[6] + ".png"));
                    dado7.setIcon(imageDado);
                    revalidate();
                    repaint();
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[7] + ".png"));
                    dado8.setIcon(imageDado);
                    revalidate();
                    repaint();
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[8] + ".png"));
                    dado9.setIcon(imageDado);
                    revalidate();
                    repaint();
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[9] + ".png"));
                    dado10.setIcon(imageDado);
                    revalidate();
                    repaint();
                    int partida = 1;
                    //mensajeRonda.add();

                } else if (e.getSource() == carasOpuestas) {
                    JOptionPane.showMessageDialog(null, MENSAJE_CARAS);
                } else if (e.getSource() == salir) {
                    System.exit(0);
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {

            ArrayList<Dado> activos = partida.getActivos().getDados();
            ArrayList<Dado> inactivos = partida.getInactivos().getDados();
            ArrayList<Dado> utilizados = partida.getUtilizados().getDados();
            ArrayList<Dado> puntaje = partida.getPuntaje().getDados();
            dado1.addMouseListener(escucha);
            dado2.addMouseListener(escucha);
            dado3.addMouseListener(escucha);
            dado4.addMouseListener(escucha);
            dado5.addMouseListener(escucha);
            dado6.addMouseListener(escucha);
            dado7.addMouseListener(escucha);
            dado8.addMouseListener(escucha);
            dado9.addMouseListener(escucha);
            dado10.addMouseListener(escucha);

            Dado dado1= new Dado();


            Partida partida = new Partida();
            //Se activa el poder del 42

            if (e.getSource() == dado1 && e.getClickCount() == 1 ) {
                if(dado1.getCara()==6){
                    partida.activar42(dado1);
                    Zona puntajeP = new Zona("Zona puntaje:",0);
                    puntajeP.calcularPuntaje();
                }
            } else if(e.getSource() == dado2 && e.getClickCount() == 1 ){
                Dado dado2 = new Dado();
                if(dado2.getCara()==6){
                    partida.activar42(dado2);
                    partida.getPuntaje().calcularPuntaje();
                }
            }
            else if(e.getSource() == dado3 && e.getClickCount() == 1 ){
                Dado dado3 = new Dado();
                if(dado3.getCara()==6){
                    partida.activar42(dado1);
                    partida.getPuntaje().calcularPuntaje();
                }
            }
            else if(e.getSource() == dado4 && e.getClickCount() == 1){
                if(dado1.getCara()==6){
                    partida.activar42(dado1);
                    partida.getPuntaje().calcularPuntaje();
                }

            }
            else if(e.getSource() == dado5 && e.getClickCount() == 1){
                if(dado1.getCara()==6){
                    partida.activar42(dado1);
                    partida.getPuntaje().calcularPuntaje();
                }

            }
            else if(e.getSource() == dado6 && e.getClickCount() == 1){
                if(dado1.getCara()==6){
                    partida.activar42(dado1);
                    partida.getPuntaje().calcularPuntaje();
                }

            }
            else if(e.getSource() == dado6 && e.getClickCount() == 1){
                if(dado1.getCara()==6){
                    partida.activar42(dado1);
                    partida.getPuntaje().calcularPuntaje();
                }

            }
            else if(e.getSource() == dado6 && e.getClickCount() == 1){
                if(dado1.getCara()==6){
                    partida.activar42(dado1);
                    partida.getPuntaje().calcularPuntaje();
                }

            }
            else if(e.getSource() == dado6 && e.getClickCount() == 1){
                if(dado1.getCara()==6){
                    partida.activar42(dado1);
                    partida.getPuntaje().calcularPuntaje();
                }

            }
            else if(e.getSource() == dado6 && e.getClickCount() == 1){
                if(dado1.getCara()==6){
                    partida.activar42(dado1);
                    partida.getPuntaje().calcularPuntaje();
                }

            }



            /*else if(dado1.getCara()==2){
                   partida.activarDragon(dado1);

               }else if(dado1.getCara()==3){
                   Dado dadoPoder= ;
                   Dado dadoPod = inactivos.get(dadoPoder-1);
                   partida.activarMeeple(dado1,dadoPod);

               }else if(dado1.getCara()==4){
                   Dado dadoPod = ;
                   partida.activarCohete(dado1, dadoPod);
               }else if(dado1.getCara()==5){
                   Dado dadoPod = ;
                   partida.activarSuperHeroe(dado1,dadoPod);
               }else if(dado1.getCara()==6){
                   partida.activar42(dado1);
                   partida.getPuntaje().calcularPuntaje();
               }


            }else if (e.getSource() == dado2 && e.getClickCount()==1){
                dado2.addMouseListener(escucha);
                int[] cara = modelGeek.getCaras();
                Dado dado2 = new Dado();
                if(dado2.getCara()==1){
                    Dado dadoPod = ;
                    partida.activarCorazon(dado2,dadoPod);

                }else if(dado2.getCara()==2){
                    partida.activarDragon(dado2);

                }else if(dado2.getCara()==3){
                    Dado dadoPoder= ;
                    Dado dadoPod = inactivos.get(dadoPoder-1);
                    partida.activarMeeple(dado2,dadoPod);

                }else if(dado2.getCara()==4){
                    Dado dadoPod = ;
                    partida.activarCohete(dado1, dadoPod);
                }else if(dado2.getCara()==5){
                    Dado dadoPod = ;
                    partida.activarSuperHeroe(dado2,dadoPod);
                }else if(dado2.getCara()==6){
                    partida.activar42(dado2);
                    partida.getPuntaje().calcularPuntaje();
                }


            } else if (e.getSource() == dado3 && e.getClickCount()==1){
                dado3.addMouseListener(escucha);
                int[] cara = modelGeek.getCaras();
                Dado dado3 = new Dado();
                if(dado3.getCara()==1){
                    Dado dadoPod = ;
                    partida.activarCorazon(dado3,dadoPod);

                }else if(dado3.getCara()==2){
                    partida.activarDragon(dado3);

                }else if(dado3.getCara()==3){
                    Dado dadoPoder= ;
                    Dado dadoPod = inactivos.get(dadoPoder-1);
                    partida.activarMeeple(dado3,dadoPod);

                }else if(dado3.getCara()==4){
                    Dado dadoPod = ;
                    partida.activarCohete(dado3, dadoPod);
                }else if(dado3.getCara()==5){
                    Dado dadoPod = ;
                    partida.activarSuperHeroe(dado3,dadoPod);
                }else if(dado3.getCara()==6){
                    partida.activar42(dado3);
                    partida.getPuntaje().calcularPuntaje();
                }


            } else if (e.getSource() == dado4 && e.getClickCount()==1){
                dado4.addMouseListener(escucha);
                int[] cara = modelGeek.getCaras();
                Dado dado4 = new Dado();
                if(dado4.getCara()==1){
                    Dado dadoPod = ;
                    partida.activarCorazon(dado4,dadoPod);

                }else if(dado4.getCara()==2){
                    partida.activarDragon(dado3);

                }else if(dado4.getCara()==3){
                    Dado dadoPoder= ;
                    Dado dadoPod = inactivos.get(dadoPoder-1);
                    partida.activarMeeple(dado4,dadoPod);

                }else if(dado4.getCara()==4){
                    Dado dadoPod = ;
                    partida.activarCohete(dado4, dadoPod);
                }else if(dado4.getCara()==5){
                    Dado dadoPod = ;
                    partida.activarSuperHeroe(dado4,dadoPod);
                }else if(dado4.getCara()==6){
                    partida.activar42(dado4);
                    partida.getPuntaje().calcularPuntaje();
                }


            }else if (e.getSource() == dado5 && e.getClickCount()==1){
                dado5.addMouseListener(escucha);
                int[] cara = modelGeek.getCaras();
                Dado dado5 = new Dado();
                if(dado5.getCara()==1){
                    Dado dadoPod = ;
                    partida.activarCorazon(dado5,dadoPod);

                }else if(dado5.getCara()==2){
                    partida.activarDragon(dado5);

                }else if(dado5.getCara()==3){
                    Dado dadoPoder= ;
                    Dado dadoPod = inactivos.get(dadoPoder-1);
                    partida.activarMeeple(dado5,dadoPod);

                }else if(dado5.getCara()==4){
                    Dado dadoPod = ;
                    partida.activarCohete(dado5, dadoPod);
                }else if(dado5.getCara()==5){
                    Dado dadoPod = ;
                    partida.activarSuperHeroe(dado5,dadoPod);
                }else if(dado5.getCara()==6){
                    partida.activar42(dado5);
                    partida.getPuntaje().calcularPuntaje();
                }


            }else if (e.getSource() == dado6 && e.getClickCount()==1){
                dado6.addMouseListener(escucha);
                int[] cara = modelGeek.getCaras();
                Dado dado6 = new Dado();
                if(dado6.getCara()==1){
                    Dado dadoPod = ;
                    partida.activarCorazon(dado6,dadoPod);

                }else if(dado6.getCara()==2){
                    partida.activarDragon(dado6);

                }else if(dado6.getCara()==3){
                    Dado dadoPoder= ;
                    Dado dadoPod = inactivos.get(dadoPoder-1);
                    partida.activarMeeple(dado6,dadoPod);

                }else if(dado6.getCara()==4){
                    Dado dadoPod = ;
                    partida.activarCohete(dado6, dadoPod);
                }else if(dado6.getCara()==5){
                    Dado dadoPod = ;
                    partida.activarSuperHeroe(dado6,dadoPod);
                }else if(dado6.getCara()==6){
                    partida.activar42(dado6);
                    partida.getPuntaje().calcularPuntaje();
                }


            }else if (e.getSource() == dado7 && e.getClickCount()==1){
                dado7.addMouseListener(escucha);
                int[] cara = modelGeek.getCaras();
                Dado dado7 = new Dado();
                if(dado7.getCara()==1){
                    Dado dadoPod = ;
                    partida.activarCorazon(dado6,dadoPod);

                }else if(dado7.getCara()==2){
                    partida.activarDragon(dado7);

                }else if(dado7.getCara()==3){
                    Dado dadoPoder= ;
                    Dado dadoPod = inactivos.get(dadoPoder-1);
                    partida.activarMeeple(dado7,dadoPod);

                }else if(dado7.getCara()==4){
                    Dado dadoPod = ;
                    partida.activarCohete(dado7, dadoPod);
                }else if(dado7.getCara()==5){
                    Dado dadoPod = ;
                    partida.activarSuperHeroe(dado7,dadoPod);
                }else if(dado7.getCara()==6){
                    partida.activar42(dado7);
                    partida.getPuntaje().calcularPuntaje();
                }


            }else if (e.getSource() == dado8 && e.getClickCount()==1){
                dado8.addMouseListener(escucha);
                int[] cara = modelGeek.getCaras();
                Dado dado8 = new Dado();
                if(dado8.getCara()==1){
                    Dado dadoPod = ;
                    partida.activarCorazon(dado8,dadoPod);

                }else if(dado8.getCara()==2){
                    partida.activarDragon(dado8);

                }else if(dado8.getCara()==3){
                    Dado dadoPoder= ;
                    Dado dadoPod = inactivos.get(dadoPoder-1);
                    partida.activarMeeple(dado8,dadoPod);

                }else if(dado8.getCara()==4){
                    Dado dadoPod = ;
                    partida.activarCohete(dado8, dadoPod);
                }else if(dado8.getCara()==5){
                    Dado dadoPod = ;
                    partida.activarSuperHeroe(dado8,dadoPod);
                }else if(dado8.getCara()==6){
                    partida.activar42(dado8);
                    partida.getPuntaje().calcularPuntaje();
                }


            }else if (e.getSource() == dado9 && e.getClickCount()==1){
                dado9.addMouseListener(escucha);
                int[] cara = modelGeek.getCaras();
                Dado dado9 = new Dado();
                if(dado9.getCara()==1){
                    Dado dadoPod = ;
                    partida.activarCorazon(dado9,dadoPod);

                }else if(dado9.getCara()==2){
                    partida.activarDragon(dado9);

                }else if(dado9.getCara()==3){
                    Dado dadoPoder= ;
                    Dado dadoPod = inactivos.get(dadoPoder-1);
                    partida.activarMeeple(dado9,dadoPod);

                }else if(dado9.getCara()==4){
                    Dado dadoPod = ;
                    partida.activarCohete(dado9, dadoPod);
                }else if(dado9.getCara()==5){
                    Dado dadoPod = ;
                    partida.activarSuperHeroe(dado9,dadoPod);
                }else if(dado9.getCara()==6){
                    partida.activar42(dado9);
                    partida.getPuntaje().calcularPuntaje();
                }


            }else if (e.getSource() == dado10 && e.getClickCount()==1){
                dado10.addMouseListener(escucha);
                int[] cara = modelGeek.getCaras();
                Dado dado10 = new Dado();
                if(dado10.getCara()==1){
                    Dado dadoPod = ;
                    partida.activarCorazon(dado10,dadoPod);
                }else if(dado10.getCara()==2){
                    partida.activarDragon(dado10);

                }else if(dado10.getCara()==3){
                    Dado dadoPoder= ;
                    Dado dadoPod = inactivos.get(dadoPoder-1);
                    partida.activarMeeple(dado10,dadoPod);

                }else if(dado10.getCara()==4){
                    Dado dadoPod = ;
                    partida.activarCohete(dado10, dadoPod);
                }else if(dado10.getCara()==5){
                    Dado dadoPod = ;
                    partida.activarSuperHeroe(dado10,dadoPod);
                }else if(dado10.getCara()==6){
                    partida.activar42(dado10);
                    partida.getPuntaje().calcularPuntaje();
                }

            }*/


            }



            @Override
            public void mousePressed (MouseEvent e){

            }

            @Override
            public void mouseReleased (MouseEvent e){

            }

            @Override
            public void mouseEntered (MouseEvent e){

            }

            @Override
            public void mouseExited (MouseEvent e){

            }
        }
}








