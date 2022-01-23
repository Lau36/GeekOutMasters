package myProject;


import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
//import java.awt.event.MouseListenimport javax.swing.*;
import java.awt.event.*;

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
    private JPanel panelPuntaje, panelUtilizados, panelActivos, panelInactivos;
    private JButton lanzar, ayuda, salir, carasOpuestas;
    private ImageIcon imageDado1, imageDado2, imageDado, imageBoton;
    private JTextArea mensajeRonda;
    private Escucha escucha;
    private ModelGeek modelGeek;

    /**
     * Constructor of GUI class
     */
    public GUI() {
        initGUI();

        //Default JFrame configuration
        this.setTitle("Geek Out Masters");
        this.setSize(500, 500);
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
        modelGeek = new ModelGeek();
        //Set up JComponents
        headerProject = new Header("Geek Out Masters", Color.BLACK);
        headerProject.setFont(new Font("Arial", Font.BOLD, 26));
        headerProject.setBackground(Color.gray);

        //headerProject.setPreferredSize(new Dimension(400,550));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(headerProject, constraints);

        //Change this line if you change JFrame Container's Layout

        imageDado1 = new ImageIcon(getClass().getResource("/resources/dado2.png"));
        imageDado2 = new ImageIcon(getClass().getResource("/resources/dado2.png"));
        dado1 = new JLabel(imageDado1);
        dado2 = new JLabel(imageDado2);
        dado3 = new JLabel(imageDado1);
        dado4 = new JLabel(imageDado2);
        dado5 = new JLabel(imageDado2);
        dado6 = new JLabel(imageDado1);
        dado7 = new JLabel(imageDado2);
        dado8 = new JLabel(imageDado1);
        dado9 = new JLabel(imageDado2);
        dado10 = new JLabel(imageDado1);


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
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(lanzar, constraints);
        lanzar.addActionListener(escucha);
        lanzar.setBackground(Color.darkGray);
        lanzar.setForeground(Color.WHITE);

        salir = new JButton();
        imageBoton = new ImageIcon (getClass().getResource("/resources/botonSalir.png"));
        salir.setIcon(imageBoton);
        salir.setBackground(Color.WHITE);
        //salir.setFont(new Font("times new roman", Font.BOLD, 15));
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        this.add(salir, constraints);
        salir.addActionListener(escucha);

        ayuda = new JButton();
        imageBoton = new ImageIcon (getClass().getResource("/resources/boton.png"));
        //ayuda.setFont(new Font("times new roman", Font.BOLD, 15));
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        this.add(ayuda, constraints);
        ayuda.addActionListener(escucha);
        ayuda.setBackground(Color.WHITE);
        ayuda.setIcon(imageBoton);
        //ayuda.setIcon(new ImageIcon(imageBoton.getImage().getScaledInstance(ayuda.getWidth(), ayuda.getHeight(),Image.SCALE_SMOOTH)));


        carasOpuestas = new JButton("Caras");
        carasOpuestas.setFont(new Font("times new roman", Font.BOLD, 15));
        carasOpuestas.setBackground(Color.darkGray);
        carasOpuestas.setForeground(Color.WHITE);
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(carasOpuestas, constraints);
        carasOpuestas.addActionListener(escucha);


        panelActivos = new JPanel();
        panelActivos.setPreferredSize(new Dimension(700, 200));
        panelActivos.setBorder(BorderFactory.createTitledBorder("Dados activos: "));
        constraints.gridx = 1;
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
        panelActivos.add(dado8);
        panelActivos.add(dado9);
        panelActivos.add(dado10);

        panelActivos.add(lanzar);

        panelInactivos = new JPanel();
        panelInactivos.setBorder(BorderFactory.createTitledBorder("Dados inactivos: "));
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelInactivos, constraints);
        panelInactivos.setPreferredSize(new Dimension(400, 180));
        panelInactivos.setBackground(new Color(255, 255, 255, 0));

        /*panelInactivos.add(dado1);
        panelInactivos.add(dado2);
        panelInactivos.add(dado3);*/


        panelUtilizados = new JPanel();
        panelUtilizados.setPreferredSize(new Dimension(400, 180));
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelUtilizados, constraints);
        panelUtilizados.setBorder(BorderFactory.createTitledBorder("Dados utilizados: "));
        panelUtilizados.setBackground(new Color(255, 255, 255, 0));

        panelPuntaje = new JPanel();
        panelPuntaje.setPreferredSize(new Dimension(90, 90));
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        this.add(panelPuntaje, constraints);
        panelPuntaje.setBorder(BorderFactory.createTitledBorder("Tu puntaje: "));

        mensajeRonda = new JTextArea();
        mensajeRonda.setBorder(BorderFactory.createTitledBorder("Ronda"));
        panelPuntaje.setPreferredSize(new Dimension(90, 30));
        mensajeRonda.setEditable(false);
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        //constraints.anchor = GridBagConstraints.CENTER;
        this.add(mensajeRonda, constraints);


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
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[1] + ".png"));
                    dado2.setIcon(imageDado);
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[2] + ".png"));
                    dado3.setIcon(imageDado);
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[3] + ".png"));
                    dado4.setIcon(imageDado);
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[4] + ".png"));
                    dado5.setIcon(imageDado);
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[5] + ".png"));
                    dado6.setIcon(imageDado);
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[6] + ".png"));
                    dado7.setIcon(imageDado);
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[7] + ".png"));
                    dado8.setIcon(imageDado);
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[8] + ".png"));
                    dado9.setIcon(imageDado);
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caraDados[9] + ".png"));
                    dado10.setIcon(imageDado);
                } else{
                    if (e.getSource() == carasOpuestas) {
                        JOptionPane.showMessageDialog(null, MENSAJE_CARAS);
                    } else {
                        if (e.getSource() == salir) {
                            System.exit(0);
                        }
                    }
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {

            if (e.getSource() == dado1) {
                //dado1.addMouseListener(escucha);
                panelActivos.remove(dado1);
                panelInactivos.add(dado1);
                panelInactivos.removeAll();
                revalidate();
                repaint();
            }
            else{
                if (e.getSource() == dado2 && e.getClickCount() == 2) {
                    dado1.addMouseListener(escucha);
                    panelActivos.remove(dado2);
                    panelInactivos.add(dado2);

                    revalidate();
                    repaint();
                }else{
                    if(e.getSource() == dado3 && e.getClickCount() == 2){
                        dado1.addMouseListener(escucha);
                        panelActivos.remove(dado3);
                        panelInactivos.add(dado3);
                        revalidate();
                        repaint();
                    }else{
                        if(e.getSource() == dado4 && e.getClickCount() == 2){
                            dado1.addMouseListener(escucha);
                            panelActivos.remove(dado4);
                            panelInactivos.add(dado4);

                            revalidate();
                            repaint();
                        }else{
                            if(e.getSource() == dado5 && e.getClickCount() == 2){
                                dado1.addMouseListener(escucha);
                                panelActivos.remove(dado5);
                                panelInactivos.add(dado5);

                                revalidate();
                                repaint();

                            }else{
                                if(e.getSource() == dado6 && e.getClickCount() == 2){
                                    dado1.addMouseListener(escucha);
                                    panelActivos.remove(dado6);
                                    panelInactivos.add(dado6);

                                    revalidate();
                                    repaint();

                                }else{
                                    if(e.getSource() == dado7 && e.getClickCount() == 2){
                                        dado1.addMouseListener(escucha);
                                        panelActivos.remove(dado7);
                                        panelInactivos.add(dado7);
                                        revalidate();
                                        repaint();

                                    }else{
                                        if(e.getSource() == dado8 && e.getClickCount() == 2){
                                            dado1.addMouseListener(escucha);
                                            panelActivos.remove(dado8);
                                            panelInactivos.add(dado8);

                                            revalidate();
                                            repaint();

                                        }else{
                                            if(e.getSource() == dado9 && e.getClickCount() == 2){
                                                dado1.addMouseListener(escucha);
                                                panelActivos.remove(dado9);
                                                panelInactivos.add(dado9);

                                                revalidate();
                                                repaint();

                                            }else{
                                                if(e.getSource() == dado10 && e.getClickCount() == 2){
                                                    dado1.addMouseListener(escucha);
                                                    panelActivos.remove(dado10);
                                                    panelInactivos.add(dado10);

                                                    revalidate();
                                                    repaint();
                                                }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
            revalidate();
            repaint();
        }



        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}







